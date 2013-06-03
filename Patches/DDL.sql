CREATE DATABASE  WebESS;


CREATE TABLE Eserve_WAM_Items (
     itemID BIGINT   NOT NULL AUTO_INCREMENT,
     Name CHAR(150) NOT NULL,
	 Code CHAR(150) NULL,
	 Alias CHAR(150) NULL,
	 Des TEXT NULL,
	 hasImpactOnStock TINYINT(1) NOT NULL, 
	 valuationType TINYINT NOT NULL,
	 createdDate DATETIME ,
	 availableDate DATETIME,
	 grupID mediumInt,
	 PRIMARY KEY (itemID)
) ENGINE=MyISAM;



CREATE TABLE Eserve_WAM_Items (
     itemID mediumint   NOT NULL AUTO_INCREMENT,
     Name CHAR(150) NOT NULL,
	 Code CHAR(150) NULL,
	 Alias CHAR(150) NULL,
	 Des TEXT NULL,
	 groupID mediumInt not null, 
	 hasImpactOnStock TINYINT(1) NOT NULL, 
	 CostingType TINYINT NOT NULL,
	 createdBy mediumInt not null  ,
	 createdOn DateTime not null ,
	 PRIMARY KEY (itemID)
) ENGINE=MyISAM;








create Table Eserve_WAM_StockIn
(
	 StockInID mediumint   NOT NULL AUTO_INCREMENT,
	 itemid mediumint not null,
     billedquantity float null,
     actualquantity float not null,	 
     unitType TINYINT(1) NOT NULL,
	 Unit mediumInt not null,
	 unitprice float not null,
	 markedprice float null,
	 totalprice float not null,
	 vendor mediumint null,
	 dutyfee float null,
	 stockInON dateTime not null,
	 createdBy mediumInt not null, 
	 PRIMARY KEY (StockInID)
)ENGINE=MyISAM;



create Table Eserve_WAM_StockOut
(
	 StockOutID mediumint   NOT NULL AUTO_INCREMENT,
	 itemid mediumint not null,
    
     unitType TINYINT(1) NOT NULL,
	 Unit mediumInt not null,
    quantity float not null,	 
	 rate float not null,
	 totalprice float null,
	
	 vat float null,
	 tax float null,
    discount float null,
	 actualtotalprice float not null,
	 stockOutON dateTime not null,
	 createdBy mediumInt not null, 
	 PRIMARY KEY (StockOutID)
)ENGINE=MyISAM;


create table Eserve_WAM_StockOut_Summary
(
	 stockoutSummaryID mediumint   NOT NULL AUTO_INCREMENT,
	 actualtotalprice float not null,
	 stockOutON dateTime not null,
	 createdBy mediumInt not null, 
	 PRIMARY KEY (stockoutSummaryID)
)ENGINE=MyISAM;











CREATE TABLE Eserve_WAM_units (
    unitID mediumInt NOT NULL AUTO_INCREMENT,
	Name CHAR(150) NOT NULL,
	des  TEXT NULL,
	PRIMARY KEY (unitID)
) ENGINE=MyISAM;


CREATE TABLE Eserve_WAM_compoundunits (
    cunitID mediumInt NOT NULL AUTO_INCREMENT,
	primaryunit mediumInt not null ,
	relator float  not null ,
	secondaryunit mediumInt not null ,
	Name CHAR(250) NOT NULL,
	des  TEXT NULL,
	PRIMARY KEY (cunitID)
) ENGINE=MyISAM;



CREATE TABLE Eserve_WAM_locations (
    locationID mediumInt NOT NULL AUTO_INCREMENT,
	name CHAR(250) NOT NULL,
    alias  CHAR(250) NULL,
	code CHAR(150) NOT NULL,
	address CHAR(250) NULL,
    inuse smallInt(1) Not Null,
    createdon dateTime not null,
	PRIMARY KEY (locationID)
) ENGINE=MyISAM;


CREATE TABLE Eserve_WAM_groups (
    groupID mediumInt NOT NULL AUTO_INCREMENT,
	name CHAR(250) NOT NULL,
    alias  CHAR(250) NULL,
	des CHAR(250) NOT NULL,
	parentID mediumInt NULL,
    createdon dateTime not null,
	PRIMARY KEY (groupID)
) ENGINE=MyISAM;




DELIMITER $$
DROP FUNCTION IF EXISTS `webess`.`GetAncestry` $$
CREATE FUNCTION `webess`.`GetAncestry` (GivenID INT) RETURNS VARCHAR(1024)
DETERMINISTIC
BEGIN
    DECLARE rv VARCHAR(1024);
    DECLARE cm CHAR(3);
    DECLARE ch INT;
    DECLARE vname VARCHAR(1024);

    SET rv = '';
    SET cm = '';
    SET ch = GivenID;
    WHILE ch > 0 DO
  select name into vname from 
 (SELECT parentID, name  FROM Eserve_WAM_groups WHERE groupID = ch) B;
        SELECT IFNULL(parentID,-1) INTO ch  FROM
        (SELECT parentID, name  FROM Eserve_WAM_groups WHERE groupID = ch) A;
     
        
            SET rv = CONCAT(rv,cm,vname);
            SET cm = ' ->';
      
    END WHILE;
    RETURN rv;
END $$
DELIMITER ;





DELIMITER $$
DROP FUNCTION IF EXISTS `Webess`.`GetParentIDByID` $$
CREATE FUNCTION `webess`.`GetParentIDByID` (GivenID INT) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE rv INT;

    SELECT IFNULL(parentID,-1) INTO rv FROM
    (SELECT parentID FROM Eserve_WAM_groups WHERE groupID = GivenID) A;
    RETURN rv;
END $$
DELIMITER ;

SELECT groupID,GetParentIDByID(groupID) as parentid ,
GetAncestry(groupID) as name  FROM Eserve_WAM_groups;




