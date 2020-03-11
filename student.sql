CREATE SCHEMA `school` DEFAULT CHARACTER SET utf8mb4 ;

DROP TABLE if exists `school`.`homework`;
CREATE TABLE `school`.`homework` (
  `hw_id` BIGINT NOT NULL AUTO_INCREMENT,
  `hw_title` VARCHAR(20) NULL,
  `hw_content` TEXT NULL,
  `hw_create_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`hw_id`));


DROP TABLE if exists `school`.`student`;
CREATE TABLE `school`.`student` (
  `st_id` BIGINT NOT NULL,
  `st_name` VARCHAR(20) NOT NULL,
  `st_create_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`st_id`));


DROP TABLE if exists `school`.`student_homework`;
CREATE TABLE `school`.`student_homework` (
  `st_hw_id` BIGINT NOT NULL AUTO_INCREMENT,
  `st_id` BIGINT NOT NULL REFERENCES student(st_id),
  `hw_id` BIGINT NOT NULL REFERENCES homework(hw_id),
  `hw_title` VARCHAR(45) NOT NULL,
  `hw_content` TEXT NULL,
  `submit_content` TEXT NULL,
  `st_hw_create_time` TIMESTAMP NOT NULL,
  PRIMARY KEY (`st_hw_id`));