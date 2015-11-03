CREATE SCHEMA `lvory` DEFAULT CHARACTER SET utf8 ;
CREATE  TABLE `lvory`.`user` (

  `userId` INT NOT NULL COMMENT 'id, primary key' ,

  `username` VARCHAR(45) NULL COMMENT 'username, used for login.' ,

  `password` VARCHAR(45) NULL COMMENT 'password used for login.' ,

  `birthday` INT(8) NULL COMMENT 'users birthday data format is \'yyyyMMdd\'' ,

  `idNumber` VARCHAR(45) NULL COMMENT 'id card number' ,

  `idCardPhotoPath` VARCHAR(45) NULL COMMENT 'id card photo path' ,

  `realName` VARCHAR(40) NULL COMMENT 'real name' ,

  `schoolId` INT NULL COMMENT 'College id ' ,

  `departmentId` INT NULL COMMENT 'department id' ,

  `photoPath` VARCHAR(45) NULL COMMENT 'personal photo path' ,

  `registerDate` DATETIME NULL COMMENT 'register date' ,

  PRIMARY KEY (`userId`) ,

  UNIQUE INDEX `idNumber_UNIQUE` (`idNumber` ASC) ,

  UNIQUE INDEX `username_UNIQUE` (`username` ASC) );