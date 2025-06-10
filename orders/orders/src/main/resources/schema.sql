CREATE TABLE IF NOT EXISTS `orders` (
  `order_id` int AUTO_INCREMENT  PRIMARY KEY,
  `amount` float NOT NULL,
  `order_Status` varchar(100) NOT NULL,
  `order_Date` date NOT NULL
);