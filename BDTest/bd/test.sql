-- users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
	`usuario` varchar(25) NOT NULL,
	`contrasena` varchar(25) NOT NULL,
	PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
--
INSERT INTO `users` (`usuario`,`contrasena`) VALUES
('User1', 'Pass1'),
('User2', 'Pass2'),
('User3', 'Pass3');