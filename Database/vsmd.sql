-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 09, 2015 at 09:14 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `vsmd`
--

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE IF NOT EXISTS `class` (
  `Class_ID` int(20) NOT NULL,
  `Class_name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`Class_ID`, `Class_name`) VALUES
(1, 'One'),
(2, 'Two');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE IF NOT EXISTS `courses` (
  `Course_ID` int(20) NOT NULL,
  `Course_name` varchar(30) NOT NULL,
  `T_ID` int(20) NOT NULL,
  `Sub_ID` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`Course_ID`, `Course_name`, `T_ID`, `Sub_ID`) VALUES
(1001, 'Bangla_1_A', 1, 1),
(1002, 'English_1_a', 2, 2),
(1003, 'math_1_A', 3, 3),
(1004, 'Religion_1_A', 4, 4),
(1005, 'Social_Science_1', 5, 5),
(1006, 'Drawing_1_A', 6, 6),
(1007, 'Science_1_A', 7, 7),
(1008, 'GK_1_A', 8, 8);

-- --------------------------------------------------------

--
-- Table structure for table `grades`
--

CREATE TABLE IF NOT EXISTS `grades` (
  `grade_ID` int(20) NOT NULL,
  `course_ID` int(20) NOT NULL,
  `S_ID` int(20) NOT NULL,
  `mark` int(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grades`
--

INSERT INTO `grades` (`grade_ID`, `course_ID`, `S_ID`, `mark`) VALUES
(1, 1001, 101, 94),
(2, 1002, 102, 90),
(3, 1001, 102, 80),
(4, 1002, 101, 70),
(5, 1001, 103, 60),
(6, 1002, 104, 78),
(7, 1003, 101, 75),
(8, 1004, 101, 84),
(9, 1005, 101, 78),
(11, 1006, 101, 82),
(12, 1007, 101, 80),
(13, 1008, 101, 95);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `S_ID` int(20) NOT NULL,
  `S_name` varchar(30) NOT NULL,
  `S_pass` varchar(30) NOT NULL,
  `Class_ID` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`S_ID`, `S_name`, `S_pass`, `Class_ID`) VALUES
(101, 'Timu', '123', 1),
(102, 'Faisal', '123', 1),
(103, 'Tom', '123', 1),
(104, 'David', '123', 1),
(105, 'Paul', '123', 1),
(106, 'rahul', '123', 1),
(107, 'Mamun', '123', 1),
(108, 'Mina', '123', 1),
(109, 'Raju', '123', 1),
(110, 'Mithu', '123', 1);

-- --------------------------------------------------------

--
-- Table structure for table `subjects`
--

CREATE TABLE IF NOT EXISTS `subjects` (
  `sub_ID` int(20) NOT NULL,
  `Sub_name` varchar(30) NOT NULL,
  `class_ID` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

INSERT INTO `subjects` (`sub_ID`, `Sub_name`, `class_ID`) VALUES
(1, 'bangla_1', 1),
(2, 'English_1', 1),
(3, 'Math_1', 1),
(4, 'Religion_1', 1),
(5, 'Social_Science_1', 1),
(6, 'Drawing_1', 1),
(7, 'Science_1', 1),
(8, 'General_knowlwdge_1', 1);

-- --------------------------------------------------------

--
-- Table structure for table `teachers`
--

CREATE TABLE IF NOT EXISTS `teachers` (
  `T_ID` int(15) NOT NULL,
  `T_name` varchar(30) NOT NULL,
  `T_pass` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teachers`
--

INSERT INTO `teachers` (`T_ID`, `T_name`, `T_pass`) VALUES
(1, 'Alam', '1234'),
(2, 'Akash', '123'),
(3, 'Kamal', '123'),
(4, 'Jamal', '123'),
(5, 'Rahim', '123'),
(6, 'Selim', '123'),
(7, 'Ahmed', '123'),
(8, 'Rahman', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`Class_ID`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`Course_ID`);

--
-- Indexes for table `grades`
--
ALTER TABLE `grades`
  ADD PRIMARY KEY (`grade_ID`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`S_ID`);

--
-- Indexes for table `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`sub_ID`), ADD KEY `class` (`class_ID`), ADD KEY `class_ID` (`class_ID`);

--
-- Indexes for table `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`T_ID`), ADD UNIQUE KEY `T_ID` (`T_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `grades`
--
ALTER TABLE `grades`
  MODIFY `grade_ID` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
