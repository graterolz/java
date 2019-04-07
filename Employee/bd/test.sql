-- users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
	`idemp` int(11) NOT NULL AUTO_INCREMENT,
	`ape1` varchar(50) NOT NULL,
	`ape2` varchar(50) NOT NULL,
	`nom1` varchar(50) NOT NULL,
	`nom2` varchar(50) NOT NULL,
	`fecnac` date NOT NULL,
	`sexo` char(1) NOT NULL,
	PRIMARY KEY (`idemp`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;
--
INSERT INTO `users` (`idemp`, `ape1`, `ape2`, `nom1`, `nom2`, `fecnac`, `sexo`) VALUES
(1, 'ZABALA', 'PARADA', 'MARISELA', 'DE LOS ANGELES', '1975-05-12', 'F'),
(2, 'HERNANDEZ', 'AVILA', 'JUAN', 'JOSE', '1988-07-12', 'M'),
(3, 'PIRELA', '', 'ANA', 'MARIA', '1978-05-10', 'F'),
(4, 'PEREZ', 'PABON', 'MAYRA', '', '1975-05-12', 'F'),
(5, 'MEJIA', 'MEJIA', 'Gabriel', '', '1990-08-12', 'M');