CREATE TABLE `Automovil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `anoFabricacion` int(11) DEFAULT NULL,
  `anoModelo` int(11) DEFAULT NULL,
  `kilometraje` float DEFAULT NULL,
  `observaciones` varchar(255) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `color_id` bigint(20) DEFAULT NULL,
  `modelo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKDB3AB6C8D57F9041` (`color_id`),
  KEY `FKDB3AB6C8FD9BBF73` (`modelo_id`),
  CONSTRAINT `FKDB3AB6C8D57F9041` FOREIGN KEY (`color_id`) REFERENCES `Color` (`id`),
  CONSTRAINT `FKDB3AB6C8FD9BBF73` FOREIGN KEY (`modelo_id`) REFERENCES `Modelo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


CREATE TABLE `Color` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

CREATE TABLE `Foto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `contenido` longblob,
  `nombre` varchar(255) DEFAULT NULL,
  `automovil_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2181244A939AA1` (`automovil_id`),
  CONSTRAINT `FK2181244A939AA1` FOREIGN KEY (`automovil_id`) REFERENCES `Automovil` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Marca` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;



CREATE TABLE `Modelo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `potencia` int(11) DEFAULT NULL,
  `marca_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK89B056869C6F5A1` (`marca_id`),
  CONSTRAINT `FK89B056869C6F5A1` FOREIGN KEY (`marca_id`) REFERENCES `Marca` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;