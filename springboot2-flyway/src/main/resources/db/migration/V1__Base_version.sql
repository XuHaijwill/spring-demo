DROP TABLE IF EXISTS user ;
CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key',
                        `name` varchar(20) NOT NULL COMMENT 'name',
                        `age` int(5) DEFAULT NULL COMMENT 'age',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
