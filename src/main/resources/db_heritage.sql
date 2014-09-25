-------------------------------------- Table Per Class Hierarchy : SINGLE_TABLE ---------------------------------------------------
-- Dans cette strat�gie, qui est celle par d�faut, le mod�le relationnel est fait d'une seule table pour toute la hi�rarchie de classes. 
-- Toutes les classes sont stock�s dans une m�me table. Celle-ci est constitu�e de l'ensemble des colonnes de la hi�rarchie de classes, 
-- auquel vient s'ajouter une colonne technique appel�e discriminant (nomm�e DTYPE par d�faut), qui permet � Hibernate de d�terminer le type de v�hicule et donc la classe � instancier.
-- L'avantage de cette strat�gie est de proposer de bonnes performances quel que soit le sc�nario. Par contre, dans les hi�rarchies de classes importantes, 

-- Ce mod�le relationnel a des limitations :
-- Le nombre de colonnes peut rapidement devenir cons�quent et l'espace se retrouver gaspill�. 
-- Les colonnes d�clar�es par les classes filles, telles que DEPARTMENTNAME,  ne peuvent pas avoir de contrainte NOT NULL. Ou alors il faut passer par 
-- une contrainte "check" plus �volu�e qui ne s'active que lorsque DISCRIMINATOR vaut "Employee".

-- Cette solution est tr�s adapt�e lorsque les classes diff�rent surtout par leur comportement (m�thodes) et peu par leurs donn�es (attributs) ou que la hi�rarchie de classes est de petite taille.
-- Chaque requ�te sur une classe fille introduit une condition sur la colonne discriminator (DTYPE).  Placer un index sur cette colonne afin d'optimiser ce genre de requ�te.


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
--  chaque type de personnes est stock� dans sa propre table. Chaque table reprend les colonnes de la classe m�re, grand-m�re, etc... Par contre les classes abstraites comme Vehicule ne sont pas repr�sent�es.
--  Chaque type d'objets est inscrit dans sa propre table. Pourtant les identifiants sont communs
--  Si votre classe m�re est abstraite, mappez la avec abstract="true". Bien s�r, si elle n'est pas abstraite, une table suppl�mentaire 
--  (par d�faut, PERSON comme ici) est requise pour contenir des instances de la classe m�re.

--  Ce mod�le relationnel ne permet pas :
--  De cl� �trang�re sur la colonne PERSON_ID car elle peut pointer sur plusieurs tables
--  De contrainte d'unicit� sur la colonne FIRSTNAME parce qu'elle est r�partie sur plusieurs tables
--  De champ de type IDENTITY (i.e. auto-g�n�r�s) pour les colonnes PERSON_ID des tables EMPLOYEE et OWNER parce que les identifiants ne doivent pas se chevaucher
--  Chaque requ�te sur la classe m�re se traduit par une union sur l'ensemble des tables qui en descendent :

--  Cette strat�gie est int�ressante lorsque la classe m�re ne sert qu'� partager des donn�es entre plusieurs classes et qu'au final ce ne sont que ces classes filles 
--  qui sont utilis�es. Les principaux inconv�nients sont : le co�t des requ�tes polymorphiques (union) et l'impossibilit� d'exprimer des contraintes d'unicit�.
--  A noter que cette strat�gie n'est pas impos�e par la sp�cification JPA, son utilisation peut mettre en d�faut la portabilit�.


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
--  A chaque classe, qu'elle soit concr�te ou abstraite, correspond une table. Autrement dit, les informations concernant une instance de Person sont r�parties 
--  sur plusieurs tables. La seule colonne commune entre les tables est la colonne ID qui permet de faire les jointures table m�re et table fille.
-- Contrairement aux pr�c�dentes strat�gies, on peut cr�er � peu pr�s tous les types de contraintes relationnelles.  Pour enregistrer un simple objet, il faut faire plusieurs �critures. 
--  Ce genre de sc�nario est �videmment couteux. D�s qu'il s'agit de faire une lecture, l� aussi il faut parcourir plusieurs tables et effectuer des jointures. 
--  Dans le cas d'une requ�te sur une classe m�re, Hibernate doit faire des jointures sur l'ensemble des tables filles
--  Que ce soit en lecture ou en �criture, cette strat�gie n'est gu�re performante. Ce qui fait sa force, 
--  c'est sa propret� en termes de mod�lisation relationnelle et la possibilit� d'exprimer des contraintes d'int�grit�s relationnelles claires.

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

