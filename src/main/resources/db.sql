CREATE TABLE `department` (
    `department_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `dept_name` VARCHAR(50) NOT NULL DEFAULT '0',
    PRIMARY KEY (`department_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;


/* EMPLOYEE table */
CREATE TABLE `employe` (
    `employe_id` BIGINT(10) NOT NULL AUTO_INCREMENT,
    `firstname` VARCHAR(50) NULL DEFAULT NULL,
    `lastname` VARCHAR(50) NULL DEFAULT NULL,
    `birth_date` DATE NULL DEFAULT NULL,
    `cell_phone` VARCHAR(15) NULL DEFAULT NULL,
     `idx` INT(11) NOT NULL DEFAULT '0',
    PRIMARY KEY (`employe_id`),
    `department_id` BIGINT(20) NULL DEFAULT NULL,
    INDEX `FK_DEPT` (`department_id`),
    CONSTRAINT `FK_DEPT` FOREIGN KEY (`department_id`) REFERENCES `department` (`department_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;


/* Adresse table */
CREATE TABLE `Adresse` (
    `adresse_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `employe_id` BIGINT(20) NOT NULL,
    `street` VARCHAR(50) NULL DEFAULT NULL,
    `city` VARCHAR(50) NULL DEFAULT NULL,
    `state` VARCHAR(50) NULL DEFAULT NULL,
    `country` VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (`adresse_id`),
    CONSTRAINT `FKEMPLADR` FOREIGN KEY (`employe_id`) REFERENCES `employe` (`employe_id`)
) COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;
  
/* EMPLOYEEDETAIL table */
CREATE TABLE `employe_detail` (
    `employe_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `street` VARCHAR(50) NULL DEFAULT NULL,
    `city` VARCHAR(50) NULL DEFAULT NULL,
    `state` VARCHAR(50) NULL DEFAULT NULL,
    `country` VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (`employe_id`),
    CONSTRAINT `FKEMPL` FOREIGN KEY (`employe_id`) REFERENCES `employe` (`employe_id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;




CREATE TABLE `meeting` (
    `meeting_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `subject` VARCHAR(50) NOT NULL,
    `meeting_date` DATE NOT NULL,
    `categorie` INT(4) NULL DEFAULT NULL,
    PRIMARY KEY (`meeting_id`)
);
 
 
CREATE TABLE `employe_meeting` (
    `employe_id` BIGINT(20) NOT NULL,
    `meeting_id` BIGINT(20) NOT NULL,
    PRIMARY KEY (`employe_id`, `meeting_id`),
    INDEX `FK_MEETING` (`meeting_id`),
    CONSTRAINT `FK_EMPLOYEE` FOREIGN KEY (`employe_id`) REFERENCES `employe` (`employe_id`),
    CONSTRAINT `FK_MEETING` FOREIGN KEY (`meeting_id`) REFERENCES `meeting` (`meeting_id`)
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;




CREATE TABLE `poste` (
    `poste_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `rem_base` FLOAT NULL,
    `categorie` CHAR(1) NULL DEFAULT NULL,
    `description` VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (`poste_id`)
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;


CREATE TABLE `employe_poste` (
    `employe_id` BIGINT(20) NOT NULL,
    `poste_id` BIGINT(20) NOT NULL,
    `remuneration` FLOAT NULL,
    `date_embauche` DATE NULL DEFAULT NULL,
    `date_debut` DATE NULL DEFAULT NULL,
    `date_fin` DATE NULL DEFAULT NULL,
    PRIMARY KEY (`employe_id`, `poste_id`),
    INDEX `FK_POSTE1` (`poste_id`),
    CONSTRAINT `FK_EMPLOYE1` FOREIGN KEY (`employe_id`) REFERENCES `employe` (`employe_id`),
    CONSTRAINT `FK_POSTE1` FOREIGN KEY (`poste_id`) REFERENCES `poste` (`poste_id`)
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;



CREATE TABLE `postexml` (
    `postexml_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `rem_base` FLOAT NULL,
    `categorie` CHAR(1) NULL DEFAULT NULL,
    `description` VARCHAR(50) NULL DEFAULT NULL,
    PRIMARY KEY (`postexml_id`)
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;


CREATE TABLE `employe_postexml` (
	`employe_postexml_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `employe_id` BIGINT(20) NOT NULL,
    `postexml_id` BIGINT(20) NOT NULL,
    `remuneration` FLOAT NULL,
    `date_embauche` DATE NULL DEFAULT NULL,
    `date_debut` DATE NULL DEFAULT NULL,
    `date_fin` DATE NULL DEFAULT NULL,
    PRIMARY KEY (`employe_postexml_id`),
    INDEX `FK_POSTE2` (`postexml_id`),
    CONSTRAINT `FK_EMPLOYE2` FOREIGN KEY (`employe_id`) REFERENCES `employe` (`employe_id`),
    CONSTRAINT `FK_POSTEXML2` FOREIGN KEY (`postexml_id`) REFERENCES `postexml` (`postexml_id`)
)COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT
AUTO_INCREMENT=1;
-----------------------------------------------------------------------------------------------------------------------------------------

drop table employe_poste;
drop table employe_postexml;
drop table poste;
drop table postexml;
drop table Adresse;
drop table employe_detail cascade;
drop table employe_meeting cascade;
drop table employe cascade;
drop table meeting cascade;
drop table department cascade;

truncate table employe_meeting;
truncate table employe;
truncate table meeting;

SET SQL_SAFE_UPDATES = 0;
truncate table employe_meeting;
commit;
delete from employe;
delete from meeting;