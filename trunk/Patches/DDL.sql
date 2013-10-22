



drop table Eserve_WAM_Items;
CREATE TABLE Eserve_WAM_Items (
     itemID mediumint   NOT NULL AUTO_INCREMENT,
     Name CHAR(150) NOT NULL,
	 Code CHAR(150) NULL,
	 Alias CHAR(150) NULL,
	 Des TEXT NULL,
	 groupID mediumInt not null, 	
	 CostingType TINYINT NOT NULL,
	 createdBy mediumInt not null  ,
	 createdOn DateTime not null ,
	 PRIMARY KEY (itemID)
) ENGINE=MyISAM;






drop table Eserve_WAM_StockIn;

create table Eserve_WAM_StockIn
(
	 StockInID mediumint   NOT NULL AUTO_INCREMENT,
	 itemid mediumint not null,
     billedquantity float null,
       actualquantity float not null,
     markedPriceUnit TINYINT(1)  NULL, 
     markedPrice float  null,
     
    
     hasImpactOnStock TINYINT(1) NOT NULL, 
	 Unit mediumInt not null,
	 
	 unitprice float not null,
	 totalprice float not null,
	 storeid smallint null,
	 vendor mediumint null,
	 dutyfee float null,
	 stockInON dateTime not null,
	 createdBy mediumInt not null, 
	 PRIMARY KEY (StockInID)
)ENGINE=MyISAM;


drop table Eserve_WAM_currentStock;
create table Eserve_WAM_currentStock
(
	 currentStockID mediumint   NOT NULL AUTO_INCREMENT,
	 itemid mediumint not null,
	 quantity float not null, 
     markedPriceUnit TINYINT(1)  NULL, 
     markedPrice float  null,
     
    
     hasImpactOnStock TINYINT(1) NOT NULL, 
	 Unitid mediumInt not null,
	 
	 unitprice float not null,
	 totalprice float not null,
	 vendor mediumint null,
     storeid smallint null,
	 dutyfee float null,
	 stockOn dateTime not null,
	 createdBy mediumInt not null, 
	 PRIMARY KEY (currentStockID)
)ENGINE=MyISAM;


drop table Eserve_WAM_StockOut;
create table Eserve_WAM_StockOut
(
	 StockOutID mediumint   NOT NULL AUTO_INCREMENT,
	 itemid mediumint not null,
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


drop table Eserve_WAM_StockOut_Summary;
create table Eserve_WAM_StockOut_Summary
(
	 stockoutSummaryID mediumint   NOT NULL AUTO_INCREMENT,
     totalprice float not null,
     vat float  null,
     tax float null,
     discount float null,
	 actualtotalprice float not null,
	 stockOutON dateTime not null,
	 createdBy mediumInt not null, 
	 PRIMARY KEY (stockoutSummaryID)
)ENGINE=MyISAM;









drop table Eserve_WAM_units;

CREATE TABLE Eserve_WAM_units (
    unitID mediumInt NOT NULL AUTO_INCREMENT,
    parentid int not null ,
    relator int not null default 1,
	Name CHAR(150) NOT NULL,
	des  TEXT NULL,
   PRIMARY KEY (unitID)
) ENGINE=MyISAM;


drop table Eserve_WAM_locations;

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


drop table Eserve_WAM_groups;

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




DELIMITER $$
DROP FUNCTION IF EXISTS `webess`.`GetAncestryUnit` $$
CREATE FUNCTION `webess`.`GetAncestryUnit` (GivenID INT) RETURNS VARCHAR(1024)
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
  select CONCAT(relator,'::',name,'#',unitid,'#') into vname from 
 (SELECT parentID, unitid, name ,relator FROM Eserve_WAM_units WHERE unitid = ch) B;
        SELECT IFNULL(parentID,-1) INTO ch  FROM
        (SELECT parentID, unitid, name ,relator  FROM Eserve_WAM_units WHERE unitid = ch) A;
     
        
            SET rv = CONCAT(rv,cm,vname);
            SET cm = ' ->';
      
    END WHILE;
    RETURN rv;
END $$
DELIMITER ;



DELIMITER $$
DROP FUNCTION IF EXISTS `webess`.`getTwoUnitRelator` $$
CREATE FUNCTION `webess`.`getTwoUnitRelator` (GivenID INT) RETURNS VARCHAR(1024)
DETERMINISTIC
BEGIN
    DECLARE rv float;
    DECLARE cm CHAR(3);
    DECLARE ch INT;
    DECLARE vrelator float;

    SET rv = 1;
    SET cm = '';
     SET vrelator=1;
    SET ch = GivenID;
    WHILE ch > 0 DO
  select relator into vrelator from 
 (SELECT parentID, name,relator  FROM Eserve_WAM_units WHERE unitid = ch) B;
        SELECT IFNULL(parentID,-1) INTO ch  FROM
        (SELECT parentID, name,relator  FROM Eserve_WAM_units WHERE unitid = ch) A;
     
        
            SET rv =rv*vrelator;
           
      
    END WHILE;
    RETURN rv;
END $$
DELIMITER ;

DELIMITER $$
DROP FUNCTION IF EXISTS `webess`.`getRelation` $$
CREATE FUNCTION `webess`.`getRelation` (GivenID INT) RETURNS VARCHAR(1024)
DETERMINISTIC
BEGIN
	DECLARE rv VARCHAR(1024);
    DECLARE cm CHAR(3);
    DECLARE ch INT;
    DECLARE vrelator float;

    SET rv = '';
    SET cm = '';
     SET vrelator=1;
    SET ch = GivenID;
    WHILE ch > 0 DO
  select unitid into vrelator from 
 (SELECT parentID, unitid,name,relator  FROM Eserve_WAM_units WHERE unitid = ch) B;
        SELECT IFNULL(parentID,-1) INTO ch  FROM
        (SELECT parentID, unitid, name, relator  FROM Eserve_WAM_units WHERE unitid = ch) A;
     
        
           
            SET rv = CONCAT(rv,cm,vrelator);
            SET cm = ' ->';
           
      
    END WHILE;
    RETURN rv;
END $$
DELIMITER ;



DELIMITER $$
DROP FUNCTION IF EXISTS `Webess`.`GetParentUnitIDByID` $$
CREATE FUNCTION `webess`.`GetParentUnitIDByID` (GivenID INT) RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE rv INT;

    SELECT IFNULL(parentID,-1) INTO rv FROM
    (SELECT parentID FROM Eserve_WAM_units WHERE unitid = GivenID) A;
    RETURN rv;
END $$
DELIMITER ;


SELECT unitid,GetParentUnitIDByID(unitid) as parentid ,
getTwoUnitRelator(unitid) as relator , getRelation(unitid) as relation ,
GetAncestryUnit(unitid) as allnames   FROM Eserve_WAM_Units;

SELECT groupID,GetParentIDByID(groupID) as parentid ,
GetAncestry(groupID) as name  FROM Eserve_WAM_groups;




