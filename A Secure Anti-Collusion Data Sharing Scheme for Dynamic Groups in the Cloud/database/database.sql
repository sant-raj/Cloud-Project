/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.36-community : Database - ci16cc029
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ci16cc029` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ci16cc029`;

/*Table structure for table `cloud` */

DROP TABLE IF EXISTS `cloud`;

CREATE TABLE `cloud` (
  `USERNAME` varchar(15) DEFAULT NULL,
  `PASSWORD` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `cloud` */

insert  into `cloud`(`USERNAME`,`PASSWORD`) values ('cloud','cloud');

/*Table structure for table `file` */

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
  `s_no` int(11) NOT NULL AUTO_INCREMENT,
  `uploadby` varchar(50) NOT NULL,
  `group_name` varchar(50) NOT NULL,
  `filename` varchar(50) NOT NULL,
  `content` blob,
  `publickey` varchar(50) NOT NULL,
  `upload_date` datetime DEFAULT NULL,
  `rank` int(11) NOT NULL,
  PRIMARY KEY (`s_no`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `file` */

insert  into `file`(`s_no`,`uploadby`,`group_name`,`filename`,`content`,`publickey`,`upload_date`,`rank`) values (2,'gm','Group5','ray-ban.txt','UmF5LUJhbiB0b3Agc2FsbGluZyBicmFuZCANCmluIGluZGlhLCByb3VuZCBzdW5nbGFzc2VzIGFy\r\nZQ0KbGF0ZXN0IGluIG1hcmNrZXQ=','2c61fc77a6fb664b49e13bb7d5cb162dc2430496','2017-03-23 11:35:16',0),(3,'gm','Group4','example1.txt','aSBhbSBzYWdhcg0Kd29ya2luZyBpbiBjbHVzdGVy','-1d427b72c3fd2df1c448151a7637bd4c6587f85f','2017-03-23 11:35:33',1),(4,'gm','Group1','demo2.txt','aSBhbSBzaGFyYW4NCmFuZCBpIGFtIHdvcmtpbmcgaW4gbmVvcmF5cyANCmZvciBjbHVzdGVyIGlu\r\nZm8gc29sdXRpb24=','-225bcd34280f3b39949d9715d4106fe3104697e6','2017-03-23 11:35:40',0),(6,'gm','Group1','demo3.txt','aGVsbG8gTmVvUmF5cw0KaSBhbSBzaGFyYW4=','-2d9de28ec0539f73420cb3165b6e4ac7508e5646','2017-03-23 17:25:50',0),(7,'omsaisharan19@gmail.com','Group4','sahar.txt','DQoJCS8qZWxzZSBpZiAocGF0aC5lcXVhbHMoIi9sb2dpbi5kbyIpKSB7DQoJCQlTdHJpbmcgc3Ry\r\nbG5tZSA9IHJlcXVlc3QuZ2V0UGFyYW1ldGVyKCJ1bm1lIik7DQoJCQlTdHJpbmcgc3RybHBhc3Mg\r\nPSByZXF1ZXN0LmdldFBhcmFtZXRlcigicHdkIik7DQoNCgkJCXNlc3Npb24uc2V0QXR0cmlidXRl\r\nKCJVU0VSTkFNRSIsIHN0cmxubWUpOw0KCQkJU3lzdGVtLm91dC5wcmludGxuKHNlc3Npb24uZ2V0\r\nQXR0cmlidXRlKCJVU0VSTkFNRSIpKTsNCgkJCXVuYW1lID0gc2Vzc2lvbi5nZXRBdHRyaWJ1dGUo\r\nIlVTRVJOQU1FIikudG9TdHJpbmcoKTsNCgkJCVN5c3RlbS5vdXQucHJpbnRsbigiVVNFUk5BTUUg\r\nSU5TSURFIExPR0lOLi4uLi4uLi4uIiArIHVuYW1lKTsNCgkJCUN1c3RvbWVyVE8gY3VzdG9tZXJU\r\nbyA9IG5ldyBDdXN0b21lclRPKCk7DQoJCQljdXN0b21lclRvLnNldFVzZXJuYW1lKHN0cmxubWUp\r\nOw0KCQkJY3VzdG9tZXJUby5zZXRQYXNzd29yZChzdHJscGFzcyk7DQoNCgkJCXRyeSB7DQoJCQkJ\r\nU3lzdGVtLm91dC5wcmludGxuKCJpbnNpZGUgdHJ5IGJsb2NrIik7DQoJCQkJYiA9IGxvZ2luVXNl\r\nclNlcnZpY2VJbXBsLmxvZ2luKGN1c3RvbWVyVG8pOw0KCQkJCVN5c3RlbS5vdXQucHJpbnRsbihi\r\nKTsNCgkJCQlTeXN0ZW0ub3V0LnByaW50bG4oIkVuZCBvZiB0cnkgYmxvY2siKTsNCg0KCQkJCWlm\r\nIChiKSB7DQoJCQkJCVN5c3RlbS5vdXQucHJpbnRsbigiY3VzdG9tZXIgc3RhcnQgZ290IHN1Y2Nl\r\nc3MiKTsNCgkJCQkJUmVxdWVzdERpc3BhdGNoZXIgcmVxdWVzdERpc3BhdGNoZXIgPSByZXF1ZXN0\r\nDQoJCQkJCQkJLmdldFJlcXVlc3REaXNwYXRjaGVyKCIuL2pzcC9jdXN0b21lcmhvbWUuanNwIik7\r\nDQoJCQkJCXJlcXVlc3REaXNwYXRjaGVyLmZvcndhcmQocmVxdWVzdCwgcmVzcG9uc2UpOw0KCQkJ\r\nCQlTeXN0ZW0ub3V0LnByaW50bG4oImN1c3RvbWVyIGVuZCBnb3Qgc3VjY2VzcyIpOw0KCQkJCX0g\r\nZWxzZSB7DQoJCQkJCVN5c3RlbS5vdXQucHJpbnRsbigiY3VzdG9tZXIgc3RhcnQgZmFpbHVyZSIp\r\nOw0KCQkJCQlSZXF1ZXN0RGlzcGF0Y2hlciByZXF1ZXN0RGlzcGF0Y2hlciA9IHJlcXVlc3QNCgkJ\r\nCQkJCQkuZ2V0UmVxdWVzdERpc3BhdGNoZXIoIi4vanNwL2N1c3RvbWVybG9naW5mYWlsLmpzcCIp\r\nOw0KCQkJCQlyZXF1ZXN0RGlzcGF0Y2hlci5mb3J3YXJkKHJlcXVlc3QsIHJlc3BvbnNlKTsNCgkJ\r\nCQkJU3lzdGVtLm91dC5wcmludGxuKCJjdXN0b21lciBlbmQgZmFpbHVyZSIpOw0KCQkJCX0NCg0K\r\nCQkJfSBjYXRjaCAoRXhjZXB0aW9uIGUpIHsNCgkJCQllLnByaW50U3RhY2tUcmFjZSgpOw0KCQkJ\r\nCVN5c3RlbS5vdXQucHJpbnRsbigiZXhjZXB0aW9uIGNhdWdodCBpbiBsb2dpbiBwYWdlICIpOw0K\r\nCQkJfQ0KCQl9Ki8=','18bf4836c69a2ce9764aa0a019c2522ba83c9383','2017-03-24 16:28:47',0);

/*Table structure for table `group_manager` */

DROP TABLE IF EXISTS `group_manager`;

CREATE TABLE `group_manager` (
  `USERNAME` varchar(15) DEFAULT NULL,
  `PASSWORD` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `group_manager` */

insert  into `group_manager`(`USERNAME`,`PASSWORD`) values ('gm','gm');

/*Table structure for table `groups` */

DROP TABLE IF EXISTS `groups`;

CREATE TABLE `groups` (
  `SI_NO` int(11) NOT NULL AUTO_INCREMENT,
  `groupname` varchar(50) NOT NULL,
  PRIMARY KEY (`SI_NO`),
  UNIQUE KEY `groupname` (`groupname`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `groups` */

insert  into `groups`(`SI_NO`,`groupname`) values (1,'Group1'),(3,'Group2'),(5,'Group3'),(6,'Group4'),(7,'Group5'),(8,'Group6');

/*Table structure for table `request` */

DROP TABLE IF EXISTS `request`;

CREATE TABLE `request` (
  `file_id` int(11) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `request_date` datetime DEFAULT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `request` */

insert  into `request`(`file_id`,`user_email`,`request_date`,`status`) values (3,'omsaisharan19@gmail.com','2017-03-24 18:00:59','downloaded'),(7,'omsaisharan19@gmail.com','2017-03-24 18:01:05','[B@1d881e2');

/*Table structure for table `revokeduser` */

DROP TABLE IF EXISTS `revokeduser`;

CREATE TABLE `revokeduser` (
  `user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `groupname` varchar(50) NOT NULL,
  `revokeddate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `revokeduser` */

insert  into `revokeduser`(`user_id`,`username`,`groupname`,`revokeddate`) values (1,'sharan','Group2','2017-03-24 13:51:30');

/*Table structure for table `transaction` */

DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `USER` varchar(50) NOT NULL,
  `group_name` varchar(50) NOT NULL,
  `filename` varchar(50) NOT NULL,
  `date_time` datetime DEFAULT NULL,
  `TRANSACTION` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `transaction` */

insert  into `transaction`(`id`,`USER`,`group_name`,`filename`,`date_time`,`TRANSACTION`) values (1,'gm','Group1','demo3.txt','2017-03-23 17:25:50','Upload'),(2,'omsaisharan19@gmail.com','Group4','sahar.txt','2017-03-24 16:28:47','Upload'),(3,'omsaisharan19@gmail.com','Group4','example1.txt','2017-03-25 12:41:30','Download');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `date_of_birth` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `location` varchar(30) NOT NULL,
  `PASSWORD` varchar(10) NOT NULL,
  `STATUS` varchar(30) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `PASSWORD` (`PASSWORD`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`user_id`,`first_name`,`last_name`,`date_of_birth`,`email`,`location`,`PASSWORD`,`STATUS`) values (1,'sharan','shas...3','1992-01-11','omsaisharan19@gmail.com','VijayanagarBangalore','shas...3','Group4');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
