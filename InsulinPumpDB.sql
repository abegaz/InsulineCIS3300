-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 28, 2018 at 03:30 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `InsulinPumpDB`
--

-- --------------------------------------------------------

--
-- Table structure for table `emergencycontact`
--

CREATE TABLE `emergencycontact` (
  `contactID` int(11) NOT NULL,
  `FirstName` varchar(40) NOT NULL,
  `LastName` varchar(40) NOT NULL,
  `PhoneNumber` int(10) NOT NULL,
  `Relationship` varchar(20) NOT NULL,
  `patientID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `insulin`
--

CREATE TABLE `insulin` (
  `insulinID` int(11) NOT NULL,
  `InsulinType` varchar(20) NOT NULL,
  `patientID` int(11) NOT NULL,
  `BasalInsulin` int(11) NOT NULL,
  `BolusInsulin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `patientID` int(11) NOT NULL,
  `FirstName` varchar(40) NOT NULL,
  `LastName` varchar(40) NOT NULL,
  `DiabeticType` varchar(20) NOT NULL,
  `insulinID` int(11) NOT NULL,
  `doctorID` int(11) NOT NULL,
  `contactID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `primarydoctor`
--

CREATE TABLE `primarydoctor` (
  `doctorID` int(11) NOT NULL,
  `FirstName` varchar(40) NOT NULL,
  `LastName` varchar(40) NOT NULL,
  `PhoneNumber` int(10) NOT NULL,
  `patientID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `emergencycontact`
--
ALTER TABLE `emergencycontact`
  ADD PRIMARY KEY (`contactID`),
  ADD KEY `contactID` (`contactID`),
  ADD KEY `patientID` (`patientID`);

--
-- Indexes for table `insulin`
--
ALTER TABLE `insulin`
  ADD PRIMARY KEY (`insulinID`),
  ADD KEY `insulinID` (`insulinID`),
  ADD KEY `patientID` (`patientID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`patientID`),
  ADD UNIQUE KEY `patientID_2` (`patientID`),
  ADD UNIQUE KEY `patientID_3` (`patientID`),
  ADD KEY `patientID` (`patientID`),
  ADD KEY `insulinID` (`insulinID`),
  ADD KEY `doctorID` (`doctorID`),
  ADD KEY `contactID` (`contactID`);

--
-- Indexes for table `primarydoctor`
--
ALTER TABLE `primarydoctor`
  ADD PRIMARY KEY (`doctorID`),
  ADD KEY `doctorID` (`doctorID`),
  ADD KEY `patientID` (`patientID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `emergencycontact`
--
ALTER TABLE `emergencycontact`
  MODIFY `contactID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `insulin`
--
ALTER TABLE `insulin`
  MODIFY `insulinID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `patientID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `primarydoctor`
--
ALTER TABLE `primarydoctor`
  MODIFY `doctorID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `emergencycontact`
--
ALTER TABLE `emergencycontact`
  ADD CONSTRAINT `emergencycontact_ibfk_1` FOREIGN KEY (`contactID`) REFERENCES `patient` (`contactID`);

--
-- Constraints for table `insulin`
--
ALTER TABLE `insulin`
  ADD CONSTRAINT `insulin_ibfk_1` FOREIGN KEY (`insulinID`) REFERENCES `patient` (`insulinID`);

--
-- Constraints for table `primarydoctor`
--
ALTER TABLE `primarydoctor`
  ADD CONSTRAINT `primarydoctor_ibfk_2` FOREIGN KEY (`doctorID`) REFERENCES `patient` (`doctorID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
