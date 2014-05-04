/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.0.27-community-nt : Database - predict_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`predict_db` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `predict_db`;

/*Table structure for table `user_details` */

DROP TABLE IF EXISTS `user_details`;

CREATE TABLE `user_details` (
  `firstname` varchar(50) default NULL,
  `lastname` varchar(50) default NULL,
  `username` varchar(50) NOT NULL,
  `dob` date default NULL,
  `gender` varchar(50) default NULL,
  `email` varchar(100) default NULL,
  `password` varchar(50) default NULL,
  `secret` varchar(100) default NULL,
  `answer` varchar(100) default NULL,
  `altmail` varchar(50) default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_details` */

insert  into `user_details`(`firstname`,`lastname`,`username`,`dob`,`gender`,`email`,`password`,`secret`,`answer`,`altmail`) values ('sujit','sujith','buddiga','1990-12-02','male','suzzz@gmail.com','123456','home','vjywda','suuzz@gmail.com'),('gowtham','ganguri','gowga','1994-03-12','male','gow@gmail.com','123456','home','vizag','goow@gmail.com'),('kaushik','kalyan','kalyan','1999-12-20','male','kkkau@gmail.com','123456','home','gachibowli','kaushik@gmail.com'),('kareem','khalid','kareemk','1990-12-12','male','kareem.k@gmail.com','123456','home','nidadaa','kkkk@gmail.com'),('kiran','kittu','kirankittu','1990-03-23','male','kkkj@gmail.com','123456','home','hyderabad','goodfdw@gmail.com'),('kiran','kittuk','kittukiran','1998-05-22','male','kirankiran480@gmail.com','123456','school','qwerty','santhoshkiranjune2@gmail.com'),('mahesh','mahish','mahimahi','1992-03-23','male','mahi@gmail.com','123456','home','dgfgf','santhoshkiran@gmail.com'),('meghana','jagruthi','meghana','1978-03-23','male','meghu@gmail.com','123456','home','hyderabad','megh@gmail.com'),('naveen','nallap','nallanav','1990-12-02','male','nav@gmail.com','123456','home','vjywda','nalla@gmail.com'),('nikil','nikki','nikkinik','1990-03-21','male','nik@gmail.com','123456','home','vizag','santhoshkiranjun2@gmail.com'),('rajii','ramiii','rajram','1990-02-02','male','ram@gmail.com','123456','home','qwertyh','rajram@gmail.com'),('rashmi','sycho','rashmi','1993-04-23','female','rashmi@gmail.com','123456','home','nellore','rashnfe@gmail.com'),('rashmii','sychoi','rashmisy','1990-03-23','female','rashmi2@gmail.com','123456','home','nellore','rashnfsdffe@gmail.com'),('seshu','sesha','seshureddy','1992-02-01','male','sesds@gmail.com','123456','home','hyder','srsf@gmail.com'),('vishn','vardg','vishvard','1992-02-12','male','vsaw@gmail.com','123456','home','hyd','vsa@gmail.com'),('vishnu','kittuk','vissuvis','1990-02-12','male','santhoshkiranjune2@outlook.com','123456','home','vizag','vishnu@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
