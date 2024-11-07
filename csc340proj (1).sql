-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 07, 2024 at 05:41 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `csc340proj`
--

-- --------------------------------------------------------

--
-- Table structure for table `listing`
--

CREATE TABLE `listing` (
  `listing_id` int(11) NOT NULL,
  `created_by` int(11) NOT NULL,
  `listed_at` datetime(6) NOT NULL,
  `listing_des` varchar(255) NOT NULL,
  `listing_name` varchar(255) NOT NULL,
  `listing_status` varchar(255) NOT NULL,
  `sold_to` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `listing`
--

INSERT INTO `listing` (`listing_id`, `created_by`, `listed_at`, `listing_des`, `listing_name`, `listing_status`, `sold_to`) VALUES
(0, 1, '2024-11-07 11:25:42.000000', 'description', 'Name', 'Sold', 3);

-- --------------------------------------------------------

--
-- Table structure for table `listing_seq`
--

CREATE TABLE `listing_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `listing_seq`
--

INSERT INTO `listing_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `message_id` int(11) NOT NULL,
  `buyer_id` int(11) NOT NULL,
  `message_body` varchar(255) DEFAULT NULL,
  `seller_id` int(11) NOT NULL,
  `sold_to` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`message_id`, `buyer_id`, `message_body`, `seller_id`, `sold_to`) VALUES
(0, 1, 'body', 2, b'0'),
(1, 2, 'body2', 1, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `message_seq`
--

CREATE TABLE `message_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `message_seq`
--

INSERT INTO `message_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `report_id` int(11) NOT NULL,
  `listing_id` int(11) NOT NULL,
  `report_des` varchar(255) DEFAULT NULL,
  `report_heading` varchar(255) DEFAULT NULL,
  `report_status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`report_id`, `listing_id`, `report_des`, `report_heading`, `report_status`) VALUES
(0, 0, 'Fake Listing', 'Bad behavior', 'Unfulfilled'),
(1, 1, 'False Advertisement ', 'Help!!', 'Fulfilled'),
(2, 3, 'Money Back?', 'Heading', 'Fulfilled');

-- --------------------------------------------------------

--
-- Table structure for table `report_seq`
--

CREATE TABLE `report_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `report_seq`
--

INSERT INTO `report_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `review_id` int(11) NOT NULL,
  `listing_id` int(11) NOT NULL,
  `rating` double NOT NULL,
  `review_des` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`review_id`, `listing_id`, `rating`, `review_des`) VALUES
(0, 1, 4.3, 'Great Stuff'),
(1, 2, 2, 'could be better'),
(2, 3, 0, 'The WORST!!!!');

-- --------------------------------------------------------

--
-- Table structure for table `review_seq`
--

CREATE TABLE `review_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review_seq`
--

INSERT INTO `review_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `statistic`
--

CREATE TABLE `statistic` (
  `total_tickets` int(11) NOT NULL,
  `active_tickets` int(11) NOT NULL,
  `fulfiled_tickets` int(11) NOT NULL,
  `sold_listings` int(11) NOT NULL,
  `total_listings` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `statistic`
--

INSERT INTO `statistic` (`total_tickets`, `active_tickets`, `fulfiled_tickets`, `sold_listings`, `total_listings`) VALUES
(50, 20, 30, 200, 1200);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `account_status` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rating` double NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `account_status`, `email`, `name`, `password`, `rating`, `role`) VALUES
(2, 'Banned', 'satorres@uncg.edu', 'Steven T', '1212', 5, 'SysAdmin'),
(10, 'Active', '123@gmail.com', 'John Doe', '1234', 4.3, 'User'),
(11, 'Warned', '321@gmail.com', 'Bill Nolastname', '54321', 3, 'Seller');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `listing`
--
ALTER TABLE `listing`
  ADD PRIMARY KEY (`listing_id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`message_id`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`report_id`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`review_id`);

--
-- Indexes for table `statistic`
--
ALTER TABLE `statistic`
  ADD PRIMARY KEY (`total_tickets`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
