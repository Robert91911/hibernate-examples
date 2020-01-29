
use seguros; 

-- Dumping structure for table seguros.seguro
DROP TABLE IF EXISTS `seguro1`;
CREATE TABLE IF NOT EXISTS `seguro1` (
  `idSeguro` int(11) NOT NULL AUTO_INCREMENT,
  `nif` varchar(255) NOT NULL UNIQUE,
  `nombre` varchar(255) DEFAULT NULL,
  `ape1` varchar(255) DEFAULT NULL,
  `ape2` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `sexo` int(11) DEFAULT NULL,
  `casado` char(1) DEFAULT NULL,
  `numHijos` int(11) DEFAULT NULL,
  `fechaCreacion` datetime DEFAULT NULL,
  `tipoSeguro` varchar(255) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `horaContacto` time DEFAULT NULL,
  `claves` blob DEFAULT null,
  `comentarios` blob DEFAULT null,
  PRIMARY KEY (`idSeguro`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

