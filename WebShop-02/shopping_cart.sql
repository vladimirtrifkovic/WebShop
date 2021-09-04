-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 02, 2021 at 10:59 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopping_cart`
--

-- --------------------------------------------------------

--
-- Table structure for table `actor`
--

CREATE TABLE `actor` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `actor`
--

INSERT INTO `actor` (`id`, `name`) VALUES
(4, 'Actor1'),
(5, 'Actor2'),
(6, 'Actor3'),
(8, 'Actor4');

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`id`, `name`) VALUES
(1, ' Book  Author1'),
(2, ' Book Author2'),
(3, 'Book Author3'),
(9, ' Music  Author1'),
(10, 'Music Author2'),
(11, 'Music Author3');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double NOT NULL,
  `publish_date` datetime DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `page_numbers` int(11) NOT NULL,
  `publishing_house` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `description`, `price`, `publish_date`, `title`, `page_numbers`, `publishing_house`) VALUES
(1, 'Book description5', 200, '2020-01-15 00:00:00', 'Book5', 489, 'Laguna'),
(2, 'Book description1', 777, '2017-02-26 00:00:00', 'Book1', 400, 'Vulkan'),
(3, 'Book descritpion3', 255, '2019-07-25 00:00:00', 'Book3', 654, 'Prometej'),
(4, 'Book description4', 575, '2021-08-04 00:00:00', 'Book4', 753, 'Logos'),
(6, 'Descritpion 6', 850, '2021-08-19 00:00:00', 'Book6', 400, 'Delfi'),
(7, 'Description 7', 789, '2021-08-19 00:00:00', 'Book7', 569, 'Laguna');

-- --------------------------------------------------------

--
-- Table structure for table `book_author_link`
--

CREATE TABLE `book_author_link` (
  `author_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `book_author_link`
--

INSERT INTO `book_author_link` (`author_id`, `book_id`) VALUES
(1, 1),
(1, 6),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 7),
(3, 2),
(3, 3),
(9, 2);

-- --------------------------------------------------------

--
-- Table structure for table `buyer`
--

CREATE TABLE `buyer` (
  `id` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `buyer`
--

INSERT INTO `buyer` (`id`, `address`, `email`, `enabled`, `first_name`, `last_name`, `password`, `phone`) VALUES
(43, 'User2 bb', 'user@user.com', b'1', 'User2', 'User2FName', '$2a$10$TGrHqBdCNaRisVNN7HtB/ebpU9jT/avZ1j0Mt66m8ptbe8tOdY/Ti', '53453453'),
(46, 'User2 bb', 'user2@user2.com', b'1', 'User2', 'User2FName', '$2a$10$ibjx.hyZRkgtdVWelp4ln.fYQK5HpyFixUsoOMaiKioKMNIaPdLeu', '986532'),
(64, 'User2 bb', 'user1@user1.com', b'1', 'User2', 'User2 LName', '$2a$10$7reKtaOobaKm6f8r6EFQ2O9af2QG7pAOGmKb751yfT4VWXUf.gwZi', '789654'),
(65, 'Address bb', 'pera@pera.com', b'1', 'Pera', 'Peric', '$2a$10$Cn7q7WEx6GMz8Bp3vIuotOTj1JaC.jZ64hR0HazaHTZky4ju.v9zi', '789456'),
(66, 'Admin bb', 'admin@admin.com', b'1', 'Admin', 'AdminLname', '$2a$10$M/gMe7ZGLF0RaYL4TWBHd.6cySjYYEc8MtttKYHWCowY0rYKZonda', '789321');

-- --------------------------------------------------------

--
-- Table structure for table `buyer_roles`
--

CREATE TABLE `buyer_roles` (
  `buyer_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `buyer_roles`
--

INSERT INTO `buyer_roles` (`buyer_id`, `role_id`) VALUES
(43, 3),
(46, 3),
(64, 3),
(65, 3),
(66, 2),
(66, 3);

-- --------------------------------------------------------

--
-- Table structure for table `carts`
--

CREATE TABLE `carts` (
  `id` int(11) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `submitted` bit(1) NOT NULL,
  `buyer_id` int(11) DEFAULT NULL,
  `submitted_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `carts`
--

INSERT INTO `carts` (`id`, `created_date`, `submitted`, `buyer_id`, `submitted_date`) VALUES
(9, '2021-08-23 20:54:33', b'1', 47, '2021-08-23 20:56:39'),
(10, '2021-08-24 21:57:26', b'0', 47, NULL),
(11, '2021-08-25 00:59:35', b'1', 65, '2021-08-26 23:24:01'),
(12, '2021-08-26 23:13:36', b'1', 43, '2021-08-26 23:15:44'),
(13, '2021-08-26 23:16:39', b'1', 43, '2021-08-26 23:18:40'),
(14, '2021-08-26 23:19:27', b'0', 43, NULL),
(15, '2021-08-26 23:24:14', b'0', 65, NULL),
(16, '2021-09-02 22:22:01', b'1', 66, '2021-09-02 22:22:34'),
(17, '2021-09-02 22:22:59', b'0', 66, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `cart_book_link`
--

CREATE TABLE `cart_book_link` (
  `book_id` int(11) NOT NULL,
  `cart_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cart_book_link`
--

INSERT INTO `cart_book_link` (`book_id`, `cart_id`, `quantity`) VALUES
(1, 9, 5),
(1, 11, 2),
(1, 12, 1),
(1, 13, 1),
(1, 16, 1),
(1, 17, 1),
(2, 9, 3),
(2, 10, 2),
(2, 11, 8),
(2, 16, 2),
(2, 17, 2),
(3, 9, 1),
(3, 10, 5),
(3, 12, 3),
(3, 13, 2),
(3, 14, 1),
(3, 15, 3),
(4, 9, 1),
(4, 11, 3),
(4, 13, 2),
(4, 14, 4),
(4, 15, 4),
(6, 12, 1),
(6, 15, 1),
(7, 9, 7),
(7, 11, 4),
(7, 13, 1),
(7, 14, 1),
(7, 15, 2);

-- --------------------------------------------------------

--
-- Table structure for table `cart_items`
--

CREATE TABLE `cart_items` (
  `id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `buyer_id` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `cart_music_link`
--

CREATE TABLE `cart_music_link` (
  `cart_id` int(11) NOT NULL,
  `music_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cart_music_link`
--

INSERT INTO `cart_music_link` (`cart_id`, `music_id`, `quantity`) VALUES
(9, 1, 1),
(9, 4, 6),
(10, 2, 1),
(10, 3, 6),
(11, 1, 4),
(12, 1, 1),
(12, 3, 3),
(12, 4, 2),
(13, 1, 1),
(13, 3, 5),
(13, 4, 2),
(14, 1, 2),
(14, 2, 3),
(14, 4, 2),
(15, 2, 1),
(15, 3, 6),
(15, 4, 1),
(16, 1, 2),
(17, 3, 1),
(17, 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `cart_video_link`
--

CREATE TABLE `cart_video_link` (
  `cart_id` int(11) NOT NULL,
  `video_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `cart_video_link`
--

INSERT INTO `cart_video_link` (`cart_id`, `video_id`, `quantity`) VALUES
(9, 3, 1),
(9, 4, 5),
(10, 3, 4),
(10, 4, 4),
(10, 6, 2),
(11, 1, 2),
(11, 3, 4),
(12, 1, 2),
(12, 3, 3),
(12, 6, 4),
(13, 3, 2),
(13, 4, 4),
(13, 6, 1),
(14, 3, 1),
(14, 4, 2),
(14, 6, 1),
(15, 3, 5),
(15, 4, 5),
(15, 6, 1),
(16, 3, 2),
(17, 3, 1),
(17, 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `example`
--

CREATE TABLE `example` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(67);

-- --------------------------------------------------------

--
-- Table structure for table `music`
--

CREATE TABLE `music` (
  `id` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double NOT NULL,
  `publish_date` datetime DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cd_number` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `publishing_house` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `music`
--

INSERT INTO `music` (`id`, `description`, `price`, `publish_date`, `title`, `cd_number`, `duration`, `publishing_house`) VALUES
(1, 'Short Description 1', 654, '2021-08-02 00:00:00', 'Music1', 2, 8520, 'Records'),
(2, 'Short Description 2', 874, '1985-06-12 00:00:00', 'Music2', 5, 8410, 'Acord'),
(3, 'Short Description 3', 489, '2021-08-11 00:00:00', 'Music3', 1, 7562, 'Studio'),
(4, 'Short Description 4', 551, '2021-08-17 00:00:00', 'Music4', 2, 654, 'CityR');

-- --------------------------------------------------------

--
-- Table structure for table `music_author_link`
--

CREATE TABLE `music_author_link` (
  `author_id` int(11) NOT NULL,
  `music_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `music_author_link`
--

INSERT INTO `music_author_link` (`author_id`, `music_id`) VALUES
(9, 1),
(9, 3),
(9, 4),
(10, 2),
(10, 3),
(10, 4),
(11, 2),
(11, 3),
(11, 4);

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `name`) VALUES
(1, 'USER'),
(2, 'ADMIN'),
(3, 'BUYER'),
(4, 'EDITOR');

-- --------------------------------------------------------

--
-- Table structure for table `video`
--

CREATE TABLE `video` (
  `id` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double NOT NULL,
  `publish_date` datetime DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `director` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `duration` int(11) NOT NULL,
  `dvd_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `video`
--

INSERT INTO `video` (`id`, `description`, `price`, `publish_date`, `title`, `director`, `duration`, `dvd_number`) VALUES
(1, 'Short Description 1', 654, '2021-08-02 00:00:00', 'Video1', 'Director1', 8520, 2),
(3, 'Short Description 3', 897, '2021-08-05 00:00:00', 'Video3', 'Director3', 7350, 2),
(4, 'Short Description 4', 1200, '2021-08-04 00:00:00', 'Video4', 'Director4', 7201, 2),
(6, 'Short Description 1', 587, '2014-01-24 00:00:00', 'Video1', 'Director1', 8420, 3);

-- --------------------------------------------------------

--
-- Table structure for table `video_actor_link`
--

CREATE TABLE `video_actor_link` (
  `actor_id` int(11) NOT NULL,
  `video_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `video_actor_link`
--

INSERT INTO `video_actor_link` (`actor_id`, `video_id`) VALUES
(4, 6),
(5, 1),
(5, 3),
(5, 4),
(5, 6),
(6, 1),
(6, 3),
(6, 4),
(6, 6),
(8, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `actor`
--
ALTER TABLE `actor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_author_link`
--
ALTER TABLE `book_author_link`
  ADD PRIMARY KEY (`author_id`,`book_id`),
  ADD KEY `FK2hjlkx2an08aa2n05ntw47ng5` (`book_id`);

--
-- Indexes for table `buyer`
--
ALTER TABLE `buyer`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_su1kgh6nfis1ne524jy1vobm5` (`email`);

--
-- Indexes for table `buyer_roles`
--
ALTER TABLE `buyer_roles`
  ADD PRIMARY KEY (`buyer_id`,`role_id`),
  ADD KEY `FKdl4u8xxhgoes05jma70m75luo` (`role_id`);

--
-- Indexes for table `carts`
--
ALTER TABLE `carts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3ks0pitgarpbkkvghdgidrmxe` (`buyer_id`);

--
-- Indexes for table `cart_book_link`
--
ALTER TABLE `cart_book_link`
  ADD PRIMARY KEY (`book_id`,`cart_id`),
  ADD KEY `FK3w30ajw7k0txwxnlbpt2kxxsq` (`cart_id`);

--
-- Indexes for table `cart_items`
--
ALTER TABLE `cart_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKd5p1jgglnj3gl89odc95hurot` (`book_id`),
  ADD KEY `FKedryofpdu4slsh36ilpb5y5a4` (`buyer_id`);

--
-- Indexes for table `cart_music_link`
--
ALTER TABLE `cart_music_link`
  ADD PRIMARY KEY (`cart_id`,`music_id`),
  ADD KEY `FKgphe5twg4wrhrjn0cncph89ll` (`music_id`);

--
-- Indexes for table `cart_video_link`
--
ALTER TABLE `cart_video_link`
  ADD PRIMARY KEY (`cart_id`,`video_id`),
  ADD KEY `FKnugfa1l8rv6k4dcnxk408vo2w` (`video_id`);

--
-- Indexes for table `example`
--
ALTER TABLE `example`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `music`
--
ALTER TABLE `music`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `music_author_link`
--
ALTER TABLE `music_author_link`
  ADD PRIMARY KEY (`author_id`,`music_id`),
  ADD KEY `FKdynpqok0sxep6wvilwqd0aiw` (`music_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `video`
--
ALTER TABLE `video`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `video_actor_link`
--
ALTER TABLE `video_actor_link`
  ADD PRIMARY KEY (`actor_id`,`video_id`),
  ADD KEY `FK1q01hi0hxspofdyuc20ydyeox` (`video_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `carts`
--
ALTER TABLE `carts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `cart_items`
--
ALTER TABLE `cart_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `music`
--
ALTER TABLE `music`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `video`
--
ALTER TABLE `video`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book_author_link`
--
ALTER TABLE `book_author_link`
  ADD CONSTRAINT `FK2hjlkx2an08aa2n05ntw47ng5` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKapkj5efq7cf79epmd15s1hnbv` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`);

--
-- Constraints for table `buyer_roles`
--
ALTER TABLE `buyer_roles`
  ADD CONSTRAINT `FKdl4u8xxhgoes05jma70m75luo` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  ADD CONSTRAINT `FKm7fwsi5w4dyito22qmmfht62y` FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`id`);

--
-- Constraints for table `carts`
--
ALTER TABLE `carts`
  ADD CONSTRAINT `FK3ks0pitgarpbkkvghdgidrmxe` FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`id`);

--
-- Constraints for table `cart_book_link`
--
ALTER TABLE `cart_book_link`
  ADD CONSTRAINT `FK3w30ajw7k0txwxnlbpt2kxxsq` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`id`),
  ADD CONSTRAINT `FKg0ax0clfy4g4k2q6xerg022lp` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`);

--
-- Constraints for table `cart_items`
--
ALTER TABLE `cart_items`
  ADD CONSTRAINT `FKd5p1jgglnj3gl89odc95hurot` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  ADD CONSTRAINT `FKedryofpdu4slsh36ilpb5y5a4` FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`id`);

--
-- Constraints for table `cart_music_link`
--
ALTER TABLE `cart_music_link`
  ADD CONSTRAINT `FKgfof2ej54b0y9goyv3a9g11al` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`id`),
  ADD CONSTRAINT `FKgphe5twg4wrhrjn0cncph89ll` FOREIGN KEY (`music_id`) REFERENCES `music` (`id`);

--
-- Constraints for table `cart_video_link`
--
ALTER TABLE `cart_video_link`
  ADD CONSTRAINT `FKnugfa1l8rv6k4dcnxk408vo2w` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`),
  ADD CONSTRAINT `FKpodbkeglupcanb17fvyiqjpex` FOREIGN KEY (`cart_id`) REFERENCES `carts` (`id`);

--
-- Constraints for table `music_author_link`
--
ALTER TABLE `music_author_link`
  ADD CONSTRAINT `FK4dby9bqtpurlkdajajro8befr` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  ADD CONSTRAINT `FKdynpqok0sxep6wvilwqd0aiw` FOREIGN KEY (`music_id`) REFERENCES `music` (`id`);

--
-- Constraints for table `video_actor_link`
--
ALTER TABLE `video_actor_link`
  ADD CONSTRAINT `FK1q01hi0hxspofdyuc20ydyeox` FOREIGN KEY (`video_id`) REFERENCES `video` (`id`),
  ADD CONSTRAINT `FKa0aw4cexywi4y9hk5scplbetu` FOREIGN KEY (`actor_id`) REFERENCES `actor` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
