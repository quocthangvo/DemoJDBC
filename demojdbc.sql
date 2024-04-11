-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.32-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table demojdbc.group: ~3 rows (approximately)
REPLACE INTO `group` (`id`, `name`, `author_ID`) VALUES
	(1, 'Java Senior hello', 1),
	(3, '.NET Senior', 1),
	(20, '.NET Senior11', 3);

-- Dumping data for table demojdbc.user: ~2 rows (approximately)
REPLACE INTO `user` (`id`, `username`, `email`, `password`, `firstName`, `lastName`, `gender`, `dateOfBirth`, `address`, `phone`, `role`, `status`) VALUES
	(11, 'voquothang', 'thang@gmail.com', '', '0', '0', '0', NULL, '0', '0', '0', 0),
	(13, 'quocthang', 'quocthang@gmail.com', '123456', 'Võ', 'Qu?c Th?ng', 'M', '2002-10-23 00:00:00', 'TPHCM', '0964467214', 'EMPLOYEE', 0);

-- Dumping data for table demojdbc.user_group: ~1 rows (approximately)
REPLACE INTO `user_group` (`group_id`, `user_id`) VALUES
	(4, 17);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
