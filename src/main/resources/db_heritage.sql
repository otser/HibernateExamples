-------------------------------------- Table Per Class Hierarchy : SINGLE_TABLE ---------------------------------------------------
-- Dans cette stratégie, qui est celle par défaut, le modèle relationnel est fait d'une seule table pour toute la hiérarchie de classes. 
-- Toutes les classes sont stockés dans une même table. Celle-ci est constituée de l'ensemble des colonnes de la hiérarchie de classes, 
-- auquel vient s'ajouter une colonne technique appelée discriminant (nommée DTYPE par défaut), qui permet à Hibernate de déterminer le type de véhicule et donc la classe à instancier.
-- L'avantage de cette stratégie est de proposer de bonnes performances quel que soit le scénario. Par contre, dans les hiérarchies de classes importantes, 

-- Ce modèle relationnel a des limitations :
-- Le nombre de colonnes peut rapidement devenir conséquent et l'espace se retrouver gaspillé. 
-- Les colonnes déclarées par les classes filles, telles que DEPARTMENTNAME,  ne peuvent pas avoir de contrainte NOT NULL. Ou alors il faut passer par 
-- une contrainte "check" plus évoluée qui ne s'active que lorsque DISCRIMINATOR vaut "Employee".

-- Cette solution est très adaptée lorsque les classes diffèrent surtout par leur comportement (méthodes) et peu par leurs données (attributs) ou que la hiérarchie de classes est de petite taille.
-- Chaque requête sur une classe fille introduit une condition sur la colonne discriminator (DTYPE).  Placer un index sur cette colonne afin d'optimiser ce genre de requête.


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
--  chaque type de personnes est stocké dans sa propre table. Chaque table reprend les colonnes de la classe mère, grand-mère, etc... Par contre les classes abstraites comme Vehicule ne sont pas représentées.
--  Chaque type d'objets est inscrit dans sa propre table. Pourtant les identifiants sont communs
--  Si votre classe mère est abstraite, mappez la avec abstract="true". Bien sûr, si elle n'est pas abstraite, une table supplémentaire 
--  (par défaut, PERSON comme ici) est requise pour contenir des instances de la classe mère.

--  Ce modèle relationnel ne permet pas :
--  De clé étrangère sur la colonne PERSON_ID car elle peut pointer sur plusieurs tables
--  De contrainte d'unicité sur la colonne FIRSTNAME parce qu'elle est répartie sur plusieurs tables
--  De champ de type IDENTITY (i.e. auto-générés) pour les colonnes PERSON_ID des tables EMPLOYEE et OWNER parce que les identifiants ne doivent pas se chevaucher
--  Chaque requête sur la classe mère se traduit par une union sur l'ensemble des tables qui en descendent :

--  Cette stratégie est intéressante lorsque la classe mère ne sert qu'à partager des données entre plusieurs classes et qu'au final ce ne sont que ces classes filles 
--  qui sont utilisées. Les principaux inconvénients sont : le coût des requêtes polymorphiques (union) et l'impossibilité d'exprimer des contraintes d'unicité.
--  A noter que cette stratégie n'est pas imposée par la spécification JPA, son utilisation peut mettre en défaut la portabilité.


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
--  A chaque classe, qu'elle soit concrète ou abstraite, correspond une table. Autrement dit, les informations concernant une instance de Person sont réparties 
--  sur plusieurs tables. La seule colonne commune entre les tables est la colonne ID qui permet de faire les jointures table mère et table fille.
-- Contrairement aux précédentes stratégies, on peut créer à peu près tous les types de contraintes relationnelles.  Pour enregistrer un simple objet, il faut faire plusieurs écritures. 
--  Ce genre de scénario est évidemment couteux. Dès qu'il s'agit de faire une lecture, là aussi il faut parcourir plusieurs tables et effectuer des jointures. 
--  Dans le cas d'une requête sur une classe mère, Hibernate doit faire des jointures sur l'ensemble des tables filles
--  Que ce soit en lecture ou en écriture, cette stratégie n'est guère performante. Ce qui fait sa force, 
--  c'est sa propreté en termes de modélisation relationnelle et la possibilité d'exprimer des contraintes d'intégrités relationnelles claires.

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

