/*
Navicat MySQL Data Transfer

Source Server         : mysql01
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : test01

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2017-10-15 14:37:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `need`
-- ----------------------------
DROP TABLE IF EXISTS `need`;
CREATE TABLE `need` (
  `nd_id` int(11) NOT NULL AUTO_INCREMENT,
  `nd_name` varchar(30) DEFAULT NULL,
  `nd_ms` text,
  `nd_type` varchar(60) DEFAULT NULL,
  `nd_pa` int(11) DEFAULT NULL,
  `nd_money` float DEFAULT NULL,
  `nd_state` int(11) DEFAULT NULL,
  `nd_advice` text,
  `nd_time` date DEFAULT NULL,
  PRIMARY KEY (`nd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of need
-- ----------------------------
INSERT INTO `need` VALUES ('1', 'App研发技术', '无', '2,3,4', '1', '100', '3', '请输入评审意见', '2017-09-22');
INSERT INTO `need` VALUES ('2', '如何谈恋爱', '重大科技需求概述（主要内容、技术指标、预期经济和社会效益等，限500字）', '1,2', '2', '200', '2', '请输入评审意见', '2017-09-22');
INSERT INTO `need` VALUES ('3', '如何学习', '无', '1,2', '3', '1.1', '3', '请输入评审意见', '2017-09-22');
INSERT INTO `need` VALUES ('4', '如何学习C#', '重大科技需求概述（主要内容、技术指标、预期经济和社会效益等，限500字）', '应用研究,实验发展,技术推广与科技服务', '2', '111', '2', '请输入评审意见', '2017-09-22');
INSERT INTO `need` VALUES ('5', '如何学习JAVA', '重大科技需求概述（主要内容、技术指标、预期经济和社会效益等，限500字）', '基础研究,实验发展,技术推广与科技服务', '4', '1111', '2', '请输入评审意见', '2017-09-22');
INSERT INTO `need` VALUES ('6', '如何吃饭', '重大科技需求概述（主要内容、技术指标、预期经济和社会效益等，限500字）', '应用研究,实验发展', '2', '111', '2', '请输入评审意见', '2017-09-23');
INSERT INTO `need` VALUES ('7', '感冒怎么预防', '教你如何预防感冒', '应用研究,实验发展', '2', '111', '1', null, '2017-09-24');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `workplace` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'xhj', 'xhj', '15732119771', '人事部');
INSERT INTO `user` VALUES ('2', 'admin', 'admin', '12345678901', 'std');
INSERT INTO `user` VALUES ('3', 'tyj', 'tyj', '12345678909', 'std');
INSERT INTO `user` VALUES ('4', 'xl', 'xhj', '12345678909', 'std');
