CREATE DATABASE `cupcake` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `bruger` (
  `brugernavn` varchar(45) NOT NULL,
  `kodeord` int NOT NULL,
  `rolle` varchar(45) NOT NULL,
  PRIMARY KEY (`brugernavn`),
  UNIQUE KEY `brugernavn_UNIQUE` (`brugernavn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `bund` (
  `navn` varchar(45) NOT NULL,
  `pris` int NOT NULL,
  PRIMARY KEY (`navn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `ordre` (
  `idordre` int NOT NULL AUTO_INCREMENT,
  `bruger` varchar(45) NOT NULL,
  `dato` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idordre`),
  UNIQUE KEY `idordre_UNIQUE` (`idordre`),
  KEY `fk_ordre_bruger1_idx` (`bruger`),
  CONSTRAINT `fk_ordre_bruger1` FOREIGN KEY (`bruger`) REFERENCES `bruger` (`brugernavn`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `produkt` (
  `produktid` int NOT NULL,
  `top` varchar(45) NOT NULL,
  `bund` varchar(45) NOT NULL,
  `pris` int NOT NULL,
  `ordreid` int NOT NULL,
  PRIMARY KEY (`produktid`),
  UNIQUE KEY `produktid_UNIQUE` (`produktid`),
  KEY `fk_produkt_top_idx` (`top`),
  KEY `fk_produkt_bund1_idx` (`bund`),
  KEY `fk_produkt_ordre1_idx` (`ordreid`),
  CONSTRAINT `fk_produkt_bund1` FOREIGN KEY (`bund`) REFERENCES `bund` (`navn`),
  CONSTRAINT `fk_produkt_ordre1` FOREIGN KEY (`ordreid`) REFERENCES `ordre` (`idordre`),
  CONSTRAINT `fk_produkt_top` FOREIGN KEY (`top`) REFERENCES `top` (`navn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `top` (
  `navn` varchar(45) NOT NULL,
  `pris` int NOT NULL,
  PRIMARY KEY (`navn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;