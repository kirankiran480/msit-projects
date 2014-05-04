-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 23, 2013 at 08:53 AM
-- Server version: 5.5.32
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `enb1`
--
CREATE DATABASE IF NOT EXISTS `enb1` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `enb1`;

-- --------------------------------------------------------

--
-- Table structure for table `cenb1`
--

CREATE TABLE IF NOT EXISTS `cenb1` (
  `username` varchar(30) NOT NULL,
  `enbname` varchar(30) NOT NULL,
  `description` text NOT NULL,
  UNIQUE KEY `enbname` (`enbname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cenb1`
--

INSERT INTO `cenb1` (`username`, `enbname`, `description`) VALUES
('nagapavan', 'dfsdf1', 'saaddda\n---last saved at23/08/2013 08:18:27'),
('nagapavan', 'dsfs', '<p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p>fdsfsf</p>\n---last saved at23/08/2013 08:14:59'),
('nagapavan', 'enb12', 'sdfdsf<p>sdf</p><p>dsf</p><p>s</p><p>f</p><p>sf</p><p>s</p>');

-- --------------------------------------------------------

--
-- Table structure for table `cenb2`
--

CREATE TABLE IF NOT EXISTS `cenb2` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `enbname` varchar(30) NOT NULL,
  `deliverables` text NOT NULL,
  `plan` text NOT NULL,
  `actual` text NOT NULL,
  `size` varchar(30) NOT NULL,
  `effort` text NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `cenb2`
--

INSERT INTO `cenb2` (`sno`, `username`, `enbname`, `deliverables`, `plan`, `actual`, `size`, `effort`) VALUES
(6, 'nagapavan', 'enb11', 'efa', 'dsf', 'sdf', 'sdf', 'sdfsf'),
(7, 'nagapavan', 'enb11', 'sdf', 'sdf', 'sdf', 'sdf', 'dsf'),
(8, 'nagapavan', 'dfsdf1', '  sdsf', '  sfdssdf', '  dsfs', '  dfd', '  dfgd'),
(9, 'nagapavan', 'enb12', '  sd', '  sdf', '  dfsd', '  sdf', '  sfd');

-- --------------------------------------------------------

--
-- Table structure for table `cenb3`
--

CREATE TABLE IF NOT EXISTS `cenb3` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `enbname` varchar(30) NOT NULL,
  `context` text NOT NULL,
  `lesson` text NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `cenb3`
--

INSERT INTO `cenb3` (`sno`, `username`, `enbname`, `context`, `lesson`) VALUES
(6, 'nagapavan', 'dfsdf1', '  sdf', '  sdf'),
(7, 'nagapavan', 'enb12', 'sdfsf', 'sdfsfsfsdf');

-- --------------------------------------------------------

--
-- Table structure for table `cenb4`
--

CREATE TABLE IF NOT EXISTS `cenb4` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `enbname` varchar(30) NOT NULL,
  `deliverable` text NOT NULL,
  `what` text NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `cenb4`
--

INSERT INTO `cenb4` (`sno`, `username`, `enbname`, `deliverable`, `what`) VALUES
(3, 'nagapavan', 'dfsdf1', '  sdf', '  sdf'),
(4, 'nagapavan', 'enb12', 'dfgdfg', 'dfgdfgdfg');

-- --------------------------------------------------------

--
-- Table structure for table `createenb`
--

CREATE TABLE IF NOT EXISTS `createenb` (
  `username` varchar(30) NOT NULL,
  `enbname` varchar(30) NOT NULL,
  `fromdate` date NOT NULL,
  `todate` date NOT NULL,
  `description` text NOT NULL,
  UNIQUE KEY `enbname` (`enbname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `createenb`
--

INSERT INTO `createenb` (`username`, `enbname`, `fromdate`, `todate`, `description`) VALUES
('nagapavan', 'abcde', '2013-08-23', '2013-08-24', 'czxcz'),
('nagapavan', 'dfsdf', '2013-08-23', '2013-08-23', 'ghghjhj'),
('nagapavan', 'dfsdf1', '2013-08-23', '2013-08-24', 'sdfsdf'),
('nagapavan', 'dsfs', '2013-08-23', '2013-08-24', 'dsfsf'),
('nagapavan', 'enb12', '2013-08-22', '2013-08-23', 'enb12'),
('nagapavan', 'sdsdas', '2013-08-23', '2013-08-31', 'vxcvxv');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `emailid` varchar(30) NOT NULL,
  `status` int(11) NOT NULL,
  UNIQUE KEY `emailid` (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`, `emailid`, `status`) VALUES
('nagapavan', '12345', 'nagapavan97@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE IF NOT EXISTS `register` (
  `username` varchar(30) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `emailid` varchar(50) NOT NULL,
  `dob` varchar(30) NOT NULL,
  `sex` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `status` int(11) NOT NULL,
  `code` varchar(30) NOT NULL,
  UNIQUE KEY `emailid` (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`username`, `firstname`, `lastname`, `password`, `emailid`, `dob`, `sex`, `address`, `status`, `code`) VALUES
('nagapavan', 'tnaga', 'pavan', '12345', 'nagapavan97@gmail.com', '2013-08-21', 'male', 'hyderabad', 1, 'hj96b');

-- --------------------------------------------------------

--
-- Table structure for table `viewlogs`
--

CREATE TABLE IF NOT EXISTS `viewlogs` (
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(30) NOT NULL,
  `action` text NOT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=53 ;

--
-- Dumping data for table `viewlogs`
--

INSERT INTO `viewlogs` (`sno`, `username`, `date`, `time`, `action`) VALUES
(30, 'nagapavan', '2013-08-22', '01:06:56 PM', 'LOGIN INTO THE APPLICATION'),
(31, 'nagapavan', '2013-08-22', '01:19:26 PM', 'created an ENB.enb12'),
(32, 'nagapavan', '2013-08-22', '01:33:36 PM', 'EDITED AN ENB.enb12'),
(33, 'nagapavan', '2013-08-22', '01:47:55 PM', 'DOWNLOADED AN ENB.Select'),
(34, 'nagapavan', '2013-08-22', '01:48:06 PM', 'DOWNLOADED AN ENB.enb12'),
(35, 'nagapavan', '2013-08-22', '01:50:36 PM', 'DOWNLOADED AN ENB.enb12'),
(36, 'nagapavan', '2013-08-22', '01:55:19 PM', 'LOGOUT FROM THE APPLICATION'),
(37, 'nagapavan', '2013-08-23', '10:02:33 PM', 'LOGIN INTO THE APPLICATION'),
(38, 'nagapavan', '2013-08-23', '10:11:42 PM', 'CREATED AN ENB.dfsdf'),
(39, 'nagapavan', '2013-08-23', '10:12:41 PM', 'CREATED AN ENB.abcde'),
(40, 'nagapavan', '2013-08-23', '10:12:58 PM', 'LOGOUT FROM THE APPLICATION'),
(41, 'nagapavan', '2013-08-23', '10:13:05 PM', 'LOGIN INTO THE APPLICATION'),
(42, 'nagapavan', '2013-08-23', '10:13:17 PM', 'CREATED AN ENB.sdsdas'),
(43, 'nagapavan', '2013-08-23', '10:13:38 PM', 'LOGOUT FROM THE APPLICATION'),
(44, 'nagapavan', '2013-08-23', '10:13:44 PM', 'LOGIN INTO THE APPLICATION'),
(45, 'nagapavan', '2013-08-23', '10:13:59 PM', 'CREATED AN ENB.dsfs'),
(46, 'nagapavan', '2013-08-23', '10:16:47 PM', 'CREATED AN ENB.dfsdf1'),
(47, 'nagapavan', '2013-08-23', '10:26:00 PM', 'EDITED AN ENB.enb12'),
(48, '', '2013-08-23', '10:38:55 PM', 'LOGOUT FROM THE APPLICATION'),
(49, 'nagapavan', '2013-08-23', '10:39:05 PM', 'LOGIN INTO THE APPLICATION'),
(50, 'nagapavan', '2013-08-23', '10:41:33 PM', 'EDITED AN ENB.enb12'),
(51, 'nagapavan', '2013-08-23', '10:45:23 PM', 'LOGIN INTO THE APPLICATION'),
(52, 'nagapavan', '2013-08-23', '10:46:51 PM', 'LOGIN INTO THE APPLICATION');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
