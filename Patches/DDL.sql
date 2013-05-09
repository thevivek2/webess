CREATE DATABASE  WebESS;


CREATE TABLE Eserve_WAM_Items (
     itemID BIGINT   NOT NULL AUTO_INCREMENT,
     Name CHAR(150) NOT NULL,
	 Code CHAR(150) NULL,
	 Alias CHAR(150) NULL,
	 Des TEXT NULL,
	 hasImpactOnStock TINYINT(1) NOT NULL, 
	 valuationType TINYINT NOT NULL,
	 procssedDate DATETIME ,
	 availableDate DATETIME,
	 grupID mediumInt,
	 PRIMARY KEY (itemID)
) ENGINE=MyISAM;


CREATE TABLE Eserve_WAM_units (
    unitID mediumInt NOT NULL AUTO_INCREMENT,
	Name CHAR(150) NOT NULL,
	des  TEXT NULL,
	PRIMARY KEY (unitID)
) ENGINE=MyISAM;
