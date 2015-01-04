CREATE TABLE `conan`.`user_info` (
  `id` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `age` INT NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
ALTER TABLE `conan`.`user_info` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;
INSERT INTO `conan`.`user_info` (`id`, `username`, `age`, `password`) VALUES ('1', 'conan', '28', 'conan');
INSERT INTO `conan`.`user_info` (`id`, `username`, `age`, `password`) VALUES ('2', 'admin', '100', 'admin');