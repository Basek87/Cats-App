CATS-WEB-APP

Photo organizer with rate and sort system.  

List Of core technologies:<br />

**Java 		<br />
**Spring 		4.3.3(mvc,web,orm,test,tx)**	- 	Without the "Spring boot" for a better understanding of the configuration.<br />
**Javax.servlet 	3.1.0**<br />
**Hibernate 		5.2.4.Final**<br />
**MySQL Connector 	5.1.38**<br />
**Junit 		4.12**<br />
**HTML5**<br />
**CSS3**<br />

SQL SCRIPT:

	CREATE TABLE `dbcats`.`cats` 
	(`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(45) NULL,
	`ownerName` VARCHAR(45) NULL,
	`age` INT NULL,
	PRIMARY KEY (`id`));
	
DB CONNECTION INFO:
	
	user: root
	password: root
	db.name: dbcats
