/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MariaDB
 Source Server Version : 100507
 Source Host           : localhost:3306
 Source Schema         : navigation

 Target Server Type    : MariaDB
 Target Server Version : 100507
 File Encoding         : 65001

 Date: 13/11/2020 10:48:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_homepage_website
-- ----------------------------
DROP TABLE IF EXISTS `t_homepage_website`;
CREATE TABLE `t_homepage_website`  (
  `site_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `link` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `box_shadow` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#5f5f5f',
  `icon` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'img/icon.png',
  `user_id` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`site_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_homepage_website_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_homepage_website
-- ----------------------------
INSERT INTO `t_homepage_website` VALUES (1, 'cnm', 'http://kksan.top/posts/12023/', '#F18033', 'img/log.png', 1);
INSERT INTO `t_homepage_website` VALUES (2, '酷安', 'https://www.coolapk.com', '#11B063', 'img/coolapk.png', 1);
INSERT INTO `t_homepage_website` VALUES (3, 'Via插件', 'http://via-app.cn', '#FA7199', 'img/via.png', 1);
INSERT INTO `t_homepage_website` VALUES (4, '今日热榜', 'https://tophub.today/', '#F2584A', 'img/headline.png', 1);
INSERT INTO `t_homepage_website` VALUES (5, '知乎', 'https://www.zhihu.com/', '#0078D8', 'img/zhihulogo.png', 1);
INSERT INTO `t_homepage_website` VALUES (6, '小米商城', 'https://www.mi.com/', '#F57923', 'img/mi.png', 1);
INSERT INTO `t_homepage_website` VALUES (7, 'unsplash', 'https://unsplash.com/', '#2C2C2C', 'img/unsplash.png', 1);
INSERT INTO `t_homepage_website` VALUES (8, '豆瓣', 'https://www.douban.com/', '#37bf4c', 'img/douban.png', 1);
INSERT INTO `t_homepage_website` VALUES (9, '虎扑', 'https://www.hupu.com/', '#c01d2f', 'img/hupu.png', 1);
INSERT INTO `t_homepage_website` VALUES (10, '斗鱼', 'https://www.douyu.com/', '#fe7700', 'img/douyu.png', 1);
INSERT INTO `t_homepage_website` VALUES (11, 'XDA', 'https://www.xda-developers.com/', '#AC6E2F', 'img/xda.png', 1);
INSERT INTO `t_homepage_website` VALUES (12, '少数派', 'https://sspai.com/', '#D7191A', 'img/sspai.png', 1);
INSERT INTO `t_homepage_website` VALUES (13, '小众软件', 'https://www.appinn.com/', '#3279ea', 'img/xiaozhong.png', 1);
INSERT INTO `t_homepage_website` VALUES (14, '数字尾巴', 'https://www.dgtle.com/', '#62677b', 'img/shuziweiba.png', 1);
INSERT INTO `t_homepage_website` VALUES (15, '疫情跟踪', 'https://ncov.dxy.cn/ncovh5/view/pneumonia', '#7C5DC7', 'img/ding.png', 1);
INSERT INTO `t_homepage_website` VALUES (16, '疫情辟谣', 'https://vp.fact.qq.com/home', '#00A0E9', 'img/true.png', 1);
INSERT INTO `t_homepage_website` VALUES (17, '4399', 'http://www.4399.com', '#000000', 'img/log.png', 3);
INSERT INTO `t_homepage_website` VALUES (18, 'bilibili', 'http://www.bilibili.com', NULL, 'img/earth.svg', 1);
INSERT INTO `t_homepage_website` VALUES (19, 'baidu', 'http://www.baidu.com', NULL, 'img/earth.svg', 1);
INSERT INTO `t_homepage_website` VALUES (22, 'zzz', 'zzz', NULL, 'img/earth.svg', 1);
INSERT INTO `t_homepage_website` VALUES (23, 'dfehfurfew', 'frefr', NULL, 'img/earth.svg', 1);

-- ----------------------------
-- Table structure for t_mark
-- ----------------------------
DROP TABLE IF EXISTS `t_mark`;
CREATE TABLE `t_mark`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `mark` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_mark_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_mark
-- ----------------------------
INSERT INTO `t_mark` VALUES (1, 'nfdu', 'fhrtguehtui', 1);
INSERT INTO `t_mark` VALUES (2, 'nfdu33', 'fhrtgueh11', 1);
INSERT INTO `t_mark` VALUES (3, 'nfdu66', 'fhrtgueh22', 1);
INSERT INTO `t_mark` VALUES (4, 'wcnmd', 'nmsl', 3);
INSERT INTO `t_mark` VALUES (5, 'cnm', 'nssb', 4);
INSERT INTO `t_mark` VALUES (6, '该死的开发者', '你打算什么时候死，怎么死？', 2);
INSERT INTO `t_mark` VALUES (7, '该死的开发者22', '你打算什么时候死，怎么死？222', 2);
INSERT INTO `t_mark` VALUES (8, '开发者是大脑残', 'nmsl', 14);
INSERT INTO `t_mark` VALUES (9, 'ssss', 'ssssss', 2);

-- ----------------------------
-- Table structure for t_search
-- ----------------------------
DROP TABLE IF EXISTS `t_search`;
CREATE TABLE `t_search`  (
  `search_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'img/github-xs.png',
  `searchlink` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `searchname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '#5f5f5f',
  `placeholder` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT 1,
  PRIMARY KEY (`search_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `t_search_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_search
-- ----------------------------
INSERT INTO `t_search` VALUES (1, 'baidu', 'img/baidu-xs.png', 'https://www.baidu.com/s', 'wd', '#3245df', '百度一下...', 1);
INSERT INTO `t_search` VALUES (2, 'google', 'img/google-xs.png', 'https://www.google.com/search', 'q', '#4285f4', '咕噜咕噜...', 1);
INSERT INTO `t_search` VALUES (3, 'bing', 'img/bing-xs.png', 'https://cn.bing.com/search', 'q', '#00868B', 'Bing搜索...', 1);
INSERT INTO `t_search` VALUES (4, 'yahoo', 'img/yahoo-xs.png', 'https://search.yahoo.com/search', 'p', '#5f01d1', 'Yahoo~', 1);
INSERT INTO `t_search` VALUES (5, 'magi', 'img/magi-xs.png', 'https://magi.com/search', 'q', 'black', 'Mag[i]...', 1);
INSERT INTO `t_search` VALUES (6, 'miji', 'img/miji-xs.png', 'https://mijisou.com/', 'q', '#575757', '不追踪你的搜索引擎...', 1);
INSERT INTO `t_search` VALUES (7, 'sougou', 'img/sougou-xs.png', 'https://www.sogou.com/web', 'query', '#f94c18', '搜狗搜索...', 1);
INSERT INTO `t_search` VALUES (8, 'duckduckgo', 'img/duckduckgo-xs.png', 'https://duckduckgo.com', 'q', '#de5833', '嘎嘎嘎...', 1);
INSERT INTO `t_search` VALUES (9, 'doge', 'img/doge-xs.png', 'https://www.dogedoge.com/results', 'q', '#ffca74', '手动狗头.jpg', 1);
INSERT INTO `t_search` VALUES (10, 'wechat', 'img/wechat-xs.png', 'https://weixin.sogou.com/weixin', 'query', '#2ca43a', '搜微信文章...', 1);
INSERT INTO `t_search` VALUES (11, 'seeres', 'img/seeres-xs.png', 'https://seeres.com/search', 'q', '#414baa', 'private search...', 1);
INSERT INTO `t_search` VALUES (12, 'quark', 'img/quark-xs.png', 'https://quark.sm.cn/s', 'q', '#6182f6', '夸克搜索...', 1);
INSERT INTO `t_search` VALUES (13, 'taobao', 'img/taobao-xs.png', 'https://s.taobao.com/search', 'q', '#FF5B00', '淘，我喜欢...', 1);
INSERT INTO `t_search` VALUES (14, 'jingdong', 'img/jingdong-xs.png', 'https://search.jd.com/Search', 'keyword', '#F30213', '多，快，好，省...', 1);
INSERT INTO `t_search` VALUES (15, 'bilibili', 'img/bilibili-xs.png', 'https://search.bilibili.com/all', 'keyword', '#e47494', 'b站是一个学习网站...', 1);
INSERT INTO `t_search` VALUES (16, 'github', 'img/github-xs.png', 'https://github.com/search', 'q', '#24292e', '全球最大的开源社区...', 1);
INSERT INTO `t_search` VALUES (17, 'toutiao', 'img/toutiao-xs.png', 'https://m.toutiao.com/search', 'keyword', '#ed2f28', '搜今日头条...', 1);
INSERT INTO `t_search` VALUES (18, 'weibo', 'img/weibo-xs.png', 'https://s.weibo.com/weibo', 'q', '#e6162d', '搜微博...', 1);
INSERT INTO `t_search` VALUES (19, 'zhihu', 'img/zhihu-xs.png', 'https://www.zhihu.com/search', 'q', '#1087eb', '我们都是有问题的人...', 1);
INSERT INTO `t_search` VALUES (20, 'kuaidi', 'img/kuaidi-xs.png', 'https://m.kuaidi100.com/result.jsp', 'nu', '#317EE7', '搜快递...', 1);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_phone` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_motto` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '123456', '13803140001', 'NMSL');
INSERT INTO `t_user` VALUES (2, 'user1', 'user1', '13803140002', 'user1');
INSERT INTO `t_user` VALUES (3, 'user2', 'user2', '13803140003', 'user2');
INSERT INTO `t_user` VALUES (4, 'user3', 'user3', '13803140004', 'user3');
INSERT INTO `t_user` VALUES (5, 'user4', 'user4', '13803140005', 'user4');
INSERT INTO `t_user` VALUES (6, 'user5', 'user5', '13803140006', 'user5');
INSERT INTO `t_user` VALUES (7, 'user6', 'user6', '13803140007', 'user6');
INSERT INTO `t_user` VALUES (8, 'user7', 'user7', '13803140008', 'user7');
INSERT INTO `t_user` VALUES (9, 'user8', 'user8', '13803140009', 'user8');
INSERT INTO `t_user` VALUES (10, 'user9', 'user9', '13803140010', 'user9');
INSERT INTO `t_user` VALUES (11, 'user99', 'user99', '123456', NULL);
INSERT INTO `t_user` VALUES (12, 'user1000', 'user1000', '123456', '123456');
INSERT INTO `t_user` VALUES (13, 'user1001', '123456', '9999000', 'fjeiffgetgret');
INSERT INTO `t_user` VALUES (14, 'usssser', '7778888888', '8989898989', 'nmslcnmd');
INSERT INTO `t_user` VALUES (15, 'cnm', '3tznsln', '88888888', '三天之内杀了你');

SET FOREIGN_KEY_CHECKS = 1;
