-------------------------------------- Table Per Class Hierarchy : SINGLE_TABLE ---------------------------------------------------
CREATE TABLE `person` (
    `person_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(50) NULL DEFAULT NULL,
    `lastname` VARCHAR(50) NULL DEFAULT NULL,
    `joining_date` DATE NULL DEFAULT NULL,
    `department_name` VARCHAR(50) NULL DEFAULT NULL,
    `discriminator` VARCHAR(20) NOT NULL,
    PRIMARY KEY (`person_id`)
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;

-------------------------------------- Table Per Concrete Class : TABLE_PER_CLASS ----------------------------------------------------
CREATE TABLE `person` (
    `person_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(50) NOT NULL DEFAULT '0',
    `lastname` VARCHAR(50) NOT NULL DEFAULT '0',
    PRIMARY KEY (`person_id`)
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;
 
CREATE TABLE `employee` (
    `person_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(50) NOT NULL,
    `lastname` VARCHAR(50) NOT NULL,
    `joining_date` DATE NULL DEFAULT NULL,
    `department_name` VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (`person_id`)
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;
 
CREATE TABLE `owner` (
    `person_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(50) NOT NULL DEFAULT '0',
    `lastname` VARCHAR(50) NOT NULL DEFAULT '0',
    `stocks` BIGINT(11) NULL DEFAULT NULL,
    `partnership_stake` BIGINT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`person_id`)
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;


-------------------------------------- Table Per Subclass : JOINED ---------------------------------------------------

CREATE TABLE `person` (
    `person_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(50) NOT NULL DEFAULT '0',
    `lastname` VARCHAR(50) NOT NULL DEFAULT '0',
    PRIMARY KEY (`person_id`)
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;
 
CREATE TABLE `employee` (
    `person_id` BIGINT(10) NOT NULL,
    `joining_date` DATE NULL DEFAULT NULL,
    `department_name` VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (`person_id`),
    CONSTRAINT `FK_PERSON` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;
 
CREATE TABLE `owner` (
    `person_id` BIGINT(20) NOT NULL DEFAULT '0',
    `stocks` BIGINT(11) NULL DEFAULT NULL,
    `partnership_stake` BIGINT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`person_id`),
    CONSTRAINT `FK_PERSON2` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`)
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;
--------------------------------------------------------------------------------------------------------------------------


drop table employee;
drop table owner;
drop table person;

