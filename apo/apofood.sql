CREATE TABLE `menus` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `typeId` int(10) NOT NULL,
  `burden` varchar(100) DEFAULT NULL,
  `brief` varchar(500) DEFAULT NULL,
  `price` FLOAT DEFAULT NULL,
  `sums` int DEFAULT NULL,
  `pricel` FLOAT DEFAULT NULL,
  `sumsl` int DEFAULT NULL,
  `imgPath` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES ('1', '粉蒸肉', '1', '米粉、五花肉', '暂无1', '26', '0', '23', '0', '/apo/uploade/m_fenzhengrou.gif');
INSERT INTO `menus` VALUES ('2', '糖醋排骨', '2', '排骨、糖、醋', '暂无2', '26', '0', '24', '4', '/apo/uploade/m_tangcupaigu.gif');
INSERT INTO `menus` VALUES ('3', '咸肉菜饭', '2', '咸肉、米饭', '暂无3', '15', '0', '12', '4', '/apo/uploade/m_xianroucaifan.gif');
INSERT INTO `menus` VALUES ('4', '五香驴肉', '3', '驴肉', '暂无4', '25', '0', '21', '1', '/apo/uploade/m_wuxianglvrou.gif');
INSERT INTO `menus` VALUES ('5', '黄瓜拉皮', '3', '黄瓜、拉皮', '暂无5', '8', '0', '6', '1', '/apo/uploade/m_huanggualapi.gif');
INSERT INTO `menus` VALUES ('6', '水煮鱼', '4', '鱼、辣椒', '暂无6', '38', '0', '32', '1', '/apo/uploade/m_shuizhuyu.gif');
INSERT INTO `menus` VALUES ('7', '烤鱼', '4', '鱼、辣椒', '暂无6', '38', '0', '32', '1', '/apo/uploade/m_shuizhuyu.gif');
SELECT * FROM menus 
DROP TABLE menus
select * from `menus` ORDER BY sumsl desc
select count(*) from menus
CREATE TABLE `notice` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `content` varchar(100) NOT NULL,
  `times` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '新增菜单', '糖醋排骨', '2017-08-31');
INSERT INTO `notice` VALUES ('2', '本店特色', '咸肉菜饭', '2017-08-31');
INSERT INTO `notice` VALUES ('3', '关于卫生', '绝对卫生 请放心使用', '2017-09-04');
SELECT * FROM notice
drop table notice
 CREATE TABLE `types` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `typename` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES ('1', '凉拌菜');
INSERT INTO `types` VALUES ('2', '炒菜');
INSERT INTO `types` VALUES ('3', '炒饭');
INSERT INTO `types` VALUES ('4', '蒸菜');
INSERT INTO `types` VALUES ('5', '川菜');
drop table types
select * from types
SELECT * from types a ,menus b WHERE a.id=b.typeId
select * from `types` a, `menus` b where a.id=b.typeId limit 1,4

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `realName` varchar(50) NOT NULL,
  `sex`  bit,
  `birthday` DATE,
  `card` varchar(50) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
	`tel` VARCHAR(11),
  `email` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'user1', '123456', '秦始皇', 1, '2818/9/5', '123123123123123123', '北京市插秧去','13983672116', '123213@qq.com', '371111' );
SELECT * from users
drop table users


CREATE TABLE `orders`(
	`id` int PRIMARY KEY auto_increment,
	`userId` int,
	`menuId` int,
	`orderSum` int,
	`price` FLOAT,
	`count` FLOAT,
	`orderTime` Datetime,
	`send` bit,
	`userName` VARCHAR(50),
	`userTel` VARCHAR(11),
	`userAddress` VARCHAR(100),
	`menuName` VARCHAR(50)
);
insert into `orders` VALUES(1,1,1,2,23,46,'2018-9-6',1,'秦始皇','13983672116','北京市插秧去','粉蒸肉');
insert into `orders` VALUES(2,1,2,1,24,24,'2018-9-6',0,'秦始皇','13983672116','北京市插秧去','糖醋排骨');
insert into `orders` VALUES(3,2,1,2,23,46,'2018-9-6',1,'user2','13983672116','北京市插秧去','粉蒸肉');
insert into `orders` VALUES(5,2,2,1,24,24,'2018-9-6',0,'user2','13983672116','北京市插秧去','糖醋排骨');
insert into `orders` VALUES(6,1,1,2,23,46,'2018-9-6',1,'秦始皇','13983672116','北京市插秧去','粉蒸肉');
insert into `orders` VALUES(7,1,2,1,24,24,'2018-9-6',0,'秦始皇','13983672116','北京市插秧去','糖醋排骨');
insert into `orders` VALUES(8,2,1,2,23,46,'2018-9-6',1,'user2','13983672116','北京市插秧去','粉蒸肉');
insert into `orders` VALUES(9,2,2,1,24,24,'2018-9-6',0,'user2','13983672116','北京市插秧去','糖醋排骨');
insert into `orders` VALUES(10,2,2,1,24,24,'2018-9-10',0,'user2','13983672116','北京市插秧去','糖醋排骨');
insert into `orders` VALUES(11,2,2,1,24,24,'2018-9-11',0,'user2','13983672116','北京市插秧去','糖醋排骨');
insert into `orders` VALUES(12,2,2,1,24,24,'2018-9-11',0,'user2','13983672116','北京市插秧去','糖醋排骨');


SELECT * from orders
drop TABLE orders


select * from `orders`  where 1 = 1  and menuName like '%粉蒸肉%'



CREATE TABLE `admin`(
	`id` int PRIMARY key auto_increment,
	`name` VARCHAR(20),
	`password` VARCHAR(50)
	
);
INSERT into `admin` VALUES(1,'admin1','1');
SELECT * from `admin`
