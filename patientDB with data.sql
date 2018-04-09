-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 09, 2018 at 07:37 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `insulinpumpdb`
--

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

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`patientID`, `FirstName`, `LastName`, `DiabeticType`, `insulinID`, `doctorID`, `contactID`) VALUES
(1, 'Axel', 'Mccall', 'Donec', 5, 1, 9),
(2, 'Dana', 'Horne', 'odio', 10, 6, 6),
(3, 'Mona', 'Holder', 'malesuada.', 5, 8, 9),
(4, 'Uta', 'Hanson', 'montes,', 10, 4, 10),
(5, 'Zoe', 'Woods', 'accumsan', 8, 9, 1),
(6, 'Abbot', 'Roth', 'bibendum', 1, 7, 7),
(7, 'Robert', 'Hyde', 'ac', 4, 7, 9),
(8, 'Jessica', 'Hardy', 'ipsum', 7, 3, 8),
(9, 'Chiquita', 'Wall', 'non', 4, 6, 9),
(10, 'Mannix', 'Potter', 'turpis.', 1, 7, 4),
(11, 'Casey', 'Mckinney', 'quis', 5, 10, 10),
(12, 'Jane', 'Dickson', 'ut', 8, 4, 5),
(13, 'Sybill', 'Morrow', 'In', 9, 8, 4),
(14, 'Germane', 'Nieves', 'suscipit', 10, 8, 7),
(15, 'Lyle', 'Owens', 'leo,', 10, 3, 5),
(16, 'Jasper', 'Burke', 'velit', 2, 5, 6),
(17, 'Merrill', 'Conrad', 'ipsum', 2, 2, 3),
(18, 'Jelani', 'Vasquez', 'feugiat', 9, 1, 9),
(19, 'Stone', 'Gray', 'ipsum', 5, 6, 8),
(20, 'Callie', 'Blankenship', 'ut', 4, 5, 8),
(21, 'Rina', 'Rivas', 'mi', 4, 4, 5),
(22, 'Tad', 'Hale', 'arcu', 7, 1, 9),
(23, 'Zenaida', 'Hodge', 'Ut', 1, 10, 3),
(24, 'Anthony', 'Vargas', 'Donec', 4, 8, 7),
(25, 'Flynn', 'Hyde', 'Fusce', 6, 6, 4),
(26, 'Selma', 'Myers', 'hymenaeos.', 2, 3, 1),
(27, 'Chadwick', 'Ross', 'nulla.', 5, 10, 5),
(28, 'Phyllis', 'Burnett', 'ipsum.', 5, 3, 4),
(29, 'Denton', 'Wilkins', 'neque', 2, 3, 10),
(30, 'Jameson', 'Hodge', 'dictum.', 8, 10, 2),
(31, 'Mohammad', 'Rowland', 'Aliquam', 6, 6, 3),
(32, 'Jeremy', 'Mckenzie', 'ipsum.', 1, 3, 2),
(33, 'Gregory', 'Hinton', 'Aenean', 6, 6, 7),
(34, 'Karly', 'Bowen', 'sit', 4, 1, 3),
(35, 'Angelica', 'Chaney', 'mauris', 4, 10, 1),
(36, 'Paki', 'Griffin', 'nec', 1, 1, 7),
(37, 'Wade', 'Gordon', 'malesuada', 10, 5, 5),
(38, 'Ulysses', 'Peterson', 'lectus.', 8, 7, 2),
(39, 'Holmes', 'Giles', 'Etiam', 1, 4, 1),
(40, 'Maggy', 'Porter', 'laoreet', 9, 7, 8),
(41, 'Zelenia', 'Boyer', 'augue', 6, 2, 2),
(42, 'Daquan', 'Riley', 'a,', 3, 5, 7),
(43, 'Courtney', 'Crane', 'dis', 2, 3, 5),
(44, 'Riley', 'Stokes', 'non', 2, 5, 1),
(45, 'Ima', 'Short', 'aliquam,', 5, 6, 6),
(46, 'Erich', 'Boone', 'eget', 2, 7, 6),
(47, 'Uma', 'Collier', 'libero.', 5, 8, 3),
(48, 'Silas', 'Hayden', 'at', 1, 10, 3),
(49, 'Allen', 'Alston', 'enim,', 4, 10, 10),
(50, 'Nora', 'Gilmore', 'quis', 5, 10, 10),
(51, 'Nolan', 'Pace', 'ac', 9, 2, 3),
(52, 'Nicole', 'Hogan', 'lectus', 4, 9, 9),
(53, 'Thomas', 'Gray', 'non', 1, 9, 8),
(54, 'Edan', 'Ferrell', 'eu', 4, 10, 5),
(55, 'Roth', 'Randolph', 'orci', 2, 2, 3),
(56, 'Mason', 'Mccormick', 'orci', 3, 7, 5),
(57, 'Ulric', 'Marshall', 'rhoncus', 5, 9, 5),
(58, 'Dalton', 'Stuart', 'et', 9, 3, 9),
(59, 'Evelyn', 'Woodard', 'arcu.', 5, 10, 2),
(60, 'Hop', 'Levy', 'vitae,', 6, 4, 3),
(61, 'Callie', 'Rosales', 'id', 2, 2, 3),
(62, 'Brian', 'Ayers', 'euismod', 5, 7, 6),
(63, 'Plato', 'Heath', 'aliquet', 3, 6, 3),
(64, 'Indira', 'Baldwin', 'ornare,', 9, 5, 6),
(65, 'Ezra', 'Randall', 'tincidunt', 9, 10, 4),
(66, 'Macaulay', 'Scott', 'vulputate', 3, 3, 1),
(67, 'Tyrone', 'Nicholson', 'penatibus', 10, 3, 9),
(68, 'Alice', 'Beck', 'elementum,', 1, 3, 10),
(69, 'Brooke', 'Burton', 'velit', 7, 10, 10),
(70, 'Benjamin', 'Holmes', 'non,', 1, 10, 5),
(71, 'Joel', 'Morris', 'enim', 10, 6, 8),
(72, 'Calvin', 'Arnold', 'luctus', 9, 2, 5),
(73, 'Bradley', 'Holman', 'dictum', 10, 8, 5),
(74, 'Althea', 'Hawkins', 'quis', 9, 4, 1),
(75, 'Plato', 'Hopkins', 'nec', 3, 5, 1),
(76, 'Kevyn', 'Gray', 'interdum', 3, 8, 3),
(77, 'Lila', 'Abbott', 'eget', 4, 9, 9),
(78, 'Barrett', 'Simmons', 'a', 8, 6, 4),
(79, 'Kibo', 'Carter', 'pede', 8, 5, 6),
(80, 'Zelda', 'Herrera', 'blandit', 1, 4, 5),
(81, 'Lucas', 'Mack', 'mollis', 4, 7, 3),
(82, 'Zoe', 'Dunn', 'dolor', 10, 8, 2),
(83, 'Carson', 'Berg', 'arcu.', 9, 7, 10),
(84, 'Alisa', 'Nolan', 'Phasellus', 10, 10, 3),
(85, 'Kibo', 'Graves', 'laoreet,', 2, 5, 5),
(86, 'Selma', 'Wheeler', 'at,', 1, 1, 5),
(87, 'Sarah', 'Ellison', 'sollicitudin', 8, 8, 3),
(88, 'Blythe', 'Holman', 'ullamcorper', 4, 3, 1),
(89, 'Zelda', 'Weeks', 'rutrum', 9, 3, 6),
(90, 'Basia', 'Smith', 'Proin', 5, 2, 1),
(91, 'Ivor', 'Bowman', 'Sed', 2, 2, 9),
(92, 'Destiny', 'Joyner', 'erat.', 4, 3, 2),
(93, 'Jameson', 'Charles', 'ridiculus', 6, 5, 6),
(94, 'Britanni', 'Key', 'semper', 3, 7, 2),
(95, 'Candice', 'Garza', 'blandit', 7, 8, 5),
(96, 'Maite', 'Harvey', 'Phasellus', 6, 6, 2),
(97, 'Kato', 'Hartman', 'velit', 9, 4, 3),
(98, 'Channing', 'Gonzales', 'a,', 5, 1, 10),
(99, 'Candice', 'Bolton', 'Morbi', 3, 8, 10),
(100, 'Davis', 'Mcleod', 'dui', 2, 3, 10);

--
-- Indexes for dumped tables
--

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `patientID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
