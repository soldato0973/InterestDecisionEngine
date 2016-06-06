DROP TABLE IF EXISTS `voyage`.`user`;

CREATE TABLE `voyage`.user (
  userName VARCHAR(50) NOT NULL,
  lastName VARCHAR(50) NULL,
  firstName VARCHAR(50) NULL,
  emailAddress VARCHAR(50) NULL,
  password VARCHAR(50) NOT NULL,
  dayTimePhone VARCHAR(50) NULL,
  eveningTimePhone VARCHAR(50) NULL
  );

INSERT INTO voyage.user (userName,lastName,firstName,emailAddress,password,dayTimePhone,eveningTimePhone) VALUES(
"jcanney", "Canney", "Jason", "j@canney.com", "canney", "303.555.1212", "303.555.1212");

INSERT INTO voyage.user (userName,lastName,firstName,emailAddress,password,dayTimePhone,eveningTimePhone) VALUES(
"hsimpson", "Simpson", "Homer", "h@simpson.com", "simpson", "303.555.1515", "303.555.1515");

DROP TABLE IF EXISTS `voyage`.`application`;

CREATE TABLE `voyage`.application (
  appID INTEGER UNSIGNED NOT NULL,
  appName VARCHAR(50) NULL,
  appVendor VARCHAR(50) NULL,
  applicationType VARCHAR(50) NULL,
  appVers VARCHAR(20) NULL,
  appState VARCHAR(20) NULL,
  appProdName VARCHAR(50) NULL,
  appFileSize VARCHAR(20) NULL,
  appCheckSum VARCHAR(20) NULL,
  appDescription VARCHAR(50) NULL,
  appURL VARCHAR(40) NULL,
  appContactName VARCHAR(40) NULL,
  appContactEmail VARCHAR(40) NULL
  );

INSERT INTO voyage.application (appID,appName,appVendor,applicationType,appVers,appState,appProdName,appFileSize,appCheckSum,appDescription,appURL,appContactName,appContactEmail) VALUES(
123413, "TV Guide Voyage", "TV Guide", "User Experience", "12.32", "Draft", "Guide", "124553.23", "23423","TV Guide Voyage User Experience", "http://www.tvguide.com", "ted bundy", "ted.bundy@tvguide.com"); 

INSERT INTO voyage.application (appID,appName,appVendor,applicationType,appVers,appState,appProdName,appFileSize,appCheckSum,appDescription,appURL,appContactName,appContactEmail) VALUES(
1346346, "TV Guide Voyage", "TV Guide", "User Experience", "12.35", "Draft", "Guide", "124553.85","35234","TV Guide Voyage User Experience", "http://www.tvguide.com", "ted bundy", "ted.bundy@tvguide.com"); 

INSERT INTO voyage.application (appID,appName,appVendor,applicationType,appVers,appState,appProdName,appFileSize,appCheckSum,appDescription,appURL,appContactName,appContactEmail) VALUES(
12324567, "TV Guide Voyage", "TV Guide", "User Experience", "12.36", "Draft", "Guide", "124553.34","234235","TV Guide Voyage User Experience", "http://www.tvguide.com", "ted bundy", "ted.bundy@tvguide.com"); 

DROP TABLE IF EXISTS `voyage`.`releases`;

CREATE TABLE `voyage`.releases (
  relName VARCHAR(50) NULL,
  relNumber VARCHAR(40) NULL,
  relType VARCHAR(50) NULL
  );

INSERT INTO voyage.releases (relName,relNumber,relType) VALUES(
"Reference Design Shorter","12.35", "Custom"); 

INSERT INTO voyage.releases (relName,relNumber,relType) VALUES(
"Reference Design Kit","15.23", "Consumer"); 

INSERT INTO voyage.releases (relName,relNumber,relType) VALUES(
"Reference Design Kit","11.34", "Mobile"); 