/*
 Navicat Premium Dump SQL

 Source Server         : local-db-mysql
 Source Server Type    : MySQL
 Source Server Version : 50741 (5.7.41)
 Source Host           : localhost:3306
 Source Schema         : online-test

 Target Server Type    : MySQL
 Target Server Version : 50741 (5.7.41)
 File Encoding         : 65001

 Date: 22/11/2024 22:40:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for evaluations
-- ----------------------------
DROP TABLE IF EXISTS `evaluations`;
CREATE TABLE `evaluations`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) NULL DEFAULT NULL COMMENT '父级评论ID',
  `commenter_id` int(11) NULL DEFAULT NULL COMMENT '评论者ID',
  `replier_id` int(11) NULL DEFAULT NULL COMMENT '回复者ID',
  `content_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '内容类型',
  `content_id` int(11) NULL DEFAULT NULL COMMENT '内容ID',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '评论内容',
  `upvote_list` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '点赞列表，以\",\"分割',
  `create_time` datetime NULL DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of evaluations
-- ----------------------------
INSERT INTO `evaluations` VALUES (1, NULL, 2, NULL, '试卷模块', 12, '这张卷子难不难？', '2', '2024-08-09 15:34:17');
INSERT INTO `evaluations` VALUES (4, 1, 2, NULL, '试卷模块', 12, '还行！', '2', '2024-08-09 15:35:06');
INSERT INTO `evaluations` VALUES (5, 1, 2, 2, '试卷模块', 12, '回复', '2', '2024-08-09 15:49:16');
INSERT INTO `evaluations` VALUES (6, NULL, 2, NULL, '试卷模块', 12, 'dsdsds', '2', '2024-08-13 15:40:23');
INSERT INTO `evaluations` VALUES (7, 6, 2, NULL, '试卷模块', 12, '432545', '2', '2024-08-13 15:40:30');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '内容',
  `create_time` datetime NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '网站即将进行系统维护，服务暂停通知', '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">尊敬的用户，为了给您带来更加流畅、安全的浏览体验，本网站将于今晚23:00至次日凌晨5:00进行系统升级与维护。</span></p><p><img src=\"/api/online-test/v1.0/file/getFile?fileName=a83d99110.jpg\" alt=\"/api/online-test/v1.0/file/getFile?fileName=a83d99110.jpg\" data-href=\"/api/online-test/v1.0/file/getFile?fileName=a83d99110.jpg\" style=\"width: 417.00px;height: 311.12px;\"/></p><p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">在此期间，网站将暂停所有服务，包括登录、浏览、下单等功能。</span></p><p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">请提前安排好您的使用计划，对给您带来的不便深表歉意，并感谢您的理解与支持！</span></p>', '2024-08-03 12:23:30');
INSERT INTO `notice` VALUES (5, '加强账户安全，请立即更新密码', '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">近期，我们发现有不法分子试图通过非法手段获取用户信息。为了保障您的账户安全，我们强烈建议您立即登录网站，更新您的登录密码，并开启双重验证功能。同时，请确保不要使用过于简单或与个人信息相关的密码，以免遭受损失。</span></p>', '2024-08-03 12:24:16');
INSERT INTO `notice` VALUES (6, '夏日狂欢节，限时优惠等你来抢！', '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">炎炎夏日，我们为您准备了丰富多彩的夏日狂欢节活动！从即日起至本月底，全场商品低至五折起，更有满额赠礼、积分翻倍等多重好礼等你来拿！快来抢购心仪的商品，享受清凉一夏吧！</span></p>', '2024-08-03 12:24:31');
INSERT INTO `notice` VALUES (7, '关于隐私政策的重要更新，请仔细阅读', '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">为了更好地保护您的个人隐私，我们已对隐私政策进行了全面更新。新政策详细说明了我们如何收集、使用、存储和保护您的个人信息。请您务必花时间仔细阅读，并在下次登录时确认同意。如有任何疑问，欢迎随时联系我们的客服团队。</span></p>', '2024-08-03 12:24:46');
INSERT INTO `notice` VALUES (8, '全新功能“智能推荐”正式上线，让购物更便捷！', '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">经过长时间的研发与测试，我们的“智能推荐”功能终于与大家见面了！该功能将根据您的浏览历史和购买记录，为您精准推荐感兴趣的商品和优惠信息。让您的购物之旅更加轻松愉快，快来体验吧！</span></p>', '2024-08-03 12:25:01');
INSERT INTO `notice` VALUES (9, '快递服务调整公告，请注意查收时间变化', '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">由于近期物流行业调整，我们的快递服务配送时间将有所变动。请广大用户在下单时留意预计送达时间，并提前做好收货准备。对于因此给您带来的不便，我们深表歉意，并感谢您的理解与支持。</span></p>', '2024-08-03 12:25:14');
INSERT INTO `notice` VALUES (10, '会员日尊享特惠，独家福利不容错过！', '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">每月的会员日即将来临，我们为尊贵的会员朋友们准备了专属的优惠活动和丰富礼品。会员日当天，所有会员均可享受额外折扣、积分加倍、专属商品等多重福利。快来加入我们的会员行列，享受更多惊喜吧！</span></p>', '2024-08-03 12:25:27');
INSERT INTO `notice` VALUES (11, '警惕网络诈骗，保护个人财产安全', '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\"> 近期，我们发现有不法分子冒充本网站客服进行诈骗活动。请广大用户提高警惕，切勿轻信任何要求提供账户密码、验证码或转账的信息。如遇可疑情况，请立即联系我们的官方客服进行核实。我们也将加大打击力度，维护用户的合法权益。</span></p>', '2024-08-03 12:25:39');
INSERT INTO `notice` VALUES (12, '全新面貌，更优体验 —— 网站改版上线', '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">经过精心设计与优化，我们的网站以全新的面貌与大家见面了！新版网站在界面设计、功能布局、用户体验等方面均进行了大幅提升。希望您能在新版网站中找到更多的乐趣与便利。如有任何建议或反馈，欢迎随时与我们联系。</span></p>', '2024-08-03 12:25:56');
INSERT INTO `notice` VALUES (13, ' 关于网站内容版权的严正声明', '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">本网站所有内容（包括但不限于文字、图片、视频等）均受版权法保护。未经本网站明确授权，任何单位或个人不得擅自转载、复制、链接或以其他方式使用本网站内容。我们保留对侵权行为追究法律责任的权利。请广大用户尊重知识产权，共同维护良好的网络环境。</span></p>', '2024-08-03 12:26:09');
INSERT INTO `notice` VALUES (14, '诚邀合作伙伴，共创辉煌未来！', '<p>技术到底是什么，你我所处的技术行业为什么会存在，未来的机会在哪里。</p><p>因此，我结合自己的工作经历，希望和大家一起聊聊，技术的本质与未来的方向，到底在哪里，才疏学浅，如果内容有误还希望你在评论区指正。</p><h1>背景</h1><h2>行业现状</h2><p>互联网行业发展放缓，进入调整阶段，具体表现为市场需求、用户规模、营收利润、创新活力等方面的放缓或下降。</p><p>一些曾经风光无限的互联网公司也遭遇了业绩下滑、股价暴跌、裁员潮等困境，你是不是也曾听过互联网的寒冬已至的言论？</p><p>其实互联网本身，并没有衰败或消亡，而是因为互联网高速发展的时代过去了。</p><ol><li>中国经济增速放缓、消费升级趋势减弱、人口红利消失等因素的影响，中国互联网市场的需求增长趋于饱和或下降。</li><li>用户规模停滞，智能手机普及率饱和，互联网用户规模增长趋于停滞，由增量市场变为存量市场，互联网获客成本越来越高。</li><li>监管政策收紧，互联网行业规范和监管愈加严格，更加注重合规，因此互联网行业也会收到影响。</li></ol><h2>供需环境</h2><p>供需环境变化，应届生要求越来越高，更加注重学历。</p><p>社招更是看中学历的同时，开始限制年龄。招聘更看重项目经验，业务经验。五年前，你只要做过一些项目，哪怕不是实际使用的，也很容易拿到offer。而现在企业在看中技术能力的同时，还会关注候选人对与行业的理解，以及以往的工作经验。</p><h1>技术的本质</h1><p>先说结论，<strong>技术的本质是工具</strong>。 我把过去几年的认知变化分成了四个阶段，给大家展示一下我对于技术的认知成长过程。</p><h2>第一阶段</h2><p>技术就是应用各类前沿的框架、中间件。</p><p>刚毕业时，我就职于一家传统信息企业。谈不上所谓的架构，只需要Spring、Mysql就构建起了我们的所有技术栈。当然，微服务框架更不可能，Redis、MQ在系统中都没使用到。</p><p>此时互联网企业已经开始快速发展，抖音诞生区区不过一年。</p><p>一线城市的互联网公司，都已经开始使用上了SpringBoot、微服务，还有各类我没有听说过的中间件。</p><p>工作环境的闭塞，让我对各类技术有着无限憧憬，因为很多当下难以解决的问题，应用一些新技术、新架构，就能立刻对很多难题降维打击。</p><p>举个例子，如果你使用本地缓存，那么集群部署时，你一定要考虑集群的缓存一致性问题，可这个问题如果用上分布式缓存Redis，那么一致性问题迎刃而解。</p><p>所以那个时候的我认为，技术就是应用各类中间件，只要用上这些中间件、框架，我就已经走在了技术的前沿。</p><h2>第二阶段</h2><p>技术对我而言就是互联网。<br>半年后，我摆脱传统行业，来到了一个小型互联网公司，用上了不少在我眼中的新技术。</p><p>但任何新技术，如果只停留在表面，那么对于使用者来说，就是几个API，几行代码，你很快就会感到厌倦，发现问题也会焦虑，因为不清楚原理，问题就无从排查。</p><p>很快，所谓的“新技术”，就不能给我带来成就感了。我开始羡慕那些互联网行业APP，无时无刻都在畅想着，如果我做的产品能够被大家看到并应用，那该是多么有意思的一件事情。</p><p>于是我又认为，技术就是做那些被人看见、被人应用的网站、APP。</p><h2>第三阶段</h2><p>技术就是高并发、大流量、大数据。<br>当自己真正负责了某一个APP的后端研发后，很多技术都有机会应用，也能够在AppStore下载自己的APP了，没事刷一刷，看到某一个信息是通过我自己写的代码展示出去，又满足了第二阶段的目标了。</p><p>那么我接下来追求的变成了，让更多的人使用我做的产品，起码让我的亲人、朋友也能看到我做的东西。</p><p>当然，随之而来的就是日益增长的数据规模和大流量，这些无时无刻都在挑战系统的性能，如何去解决这些问题，成为了我很长一段时间的工作主线。</p><p>应对高并发、大流量，我们需要对系统作出各种极致性能的优化。</p><p>为了性能优化，还需要了解更多的底层原理，才能在遇到问题时有一个合理的解决方案。</p><p>所以，我认为技术就是高并发、大数据，做好这些，才算做好了技术。</p><h2>第四阶段</h2><p>经过了传统企业，到互联网公司，再到互联网大厂的一番经历，让我发现<strong>技术的本质就是工具</strong>，在不同阶段，去解决不同的问题。</p><p>在第一阶段，技术解决了各类行业的<strong>数据信息化问题</strong>，借助各类中间件、架构把具体的需求落地。</p><p>在第二阶段、第三阶段，技术解决了业务的<strong>规模化问题</strong>，因为在互联网，流量迅猛增长，我需要去用技术解决规模化带来的各类的问题，做出性能优化。</p><p>当然，技术在其他领域也发挥着作用，比如<strong>AI&算法</strong>，给予了互联网工具“智能化”的可能，还有比如我们很难接触到的<strong>底层框架研发</strong>，也就是技术的“技术”，这些底层能力，帮助我们更好的发挥我们的技术能力。</p><h1>未来机会</h1><h2>大厂仍是最好的选择</h2><p>即使是在互联网增速放缓、内卷持续严重的今天，即使我选择从大厂离职，但我依然认为大厂是最好的选择。</p><p>为什么这么说，几个理由</p><ul><li>大厂有着更前沿的技术能力，你可以随意选择最适合的工具去解决问题</li><li>大厂有着更大的数据、流量规模，你所做的工作，天然的就具备规模化的能力</li><li>大厂有先进的管理方法，你所接触的做事方法、目标管理可能让你疲倦，但工作方法大概率是行业内经过验证的，你不会走弯路，能让你有更快的进步速度</li></ul><h2>数字化转型</h2><p>如果你在互联网行业，可能没有听说过这个词，因为在高速发展的互联网行业，本身就是数字驱动的，比如重视数据指标、AB实验等。但在二线、三线城市的计算机行业或者一些传统行业，数字化转型是很大的发展机会。</p><p>过去十年，传统行业做的普遍是信息化转型，也就是把线下，需要用纸、笔来完成工作的，转移到系统中。</p><p>那什么是数字化转型？</p><blockquote>我用我自己的理解说一下，数字化转型就是业务流程精细化管理，数据驱动，实现降本增效。</blockquote><p>我目前所在的公司的推进大方向之一，就是数字化转型。因为许多行业的数字化程度非常低，本质而言，就是把数字驱动的能力，带给传统企业，让传统企业也能感受到数字化带来的发展可能。</p><p>举个例子，比如一个餐饮系统数字化转型后，一方面可以把用户下单、餐厅接单、开始制作、出餐、上餐线上化，还可以和原材料供应系统打通，当有订单来时，自动检测餐饮的库存信息，库存不足及时提供预警，甚至可以作出订单预测，比如什么时间点，哪类餐品的点单量最高。</p><p>当然，数字化转型与互联网有着极大的不同，在互联网行业，你只需要坐在工位，等着产品提出需求就可以了。但是传统行业，你需要深入客户现场，实地查看业务流程，与用户交谈，才能真正的理解客户需求。</p><p>或许这样的工作并不炫酷，还需要出差，但在互联网行业饱和的今天，用技术去解决真实世界的问题，也不失为一个很好的选择。</p><h2>AI&智能化</h2><p>随着AI快速发展，各类智能化功能已经遍布了我们使用的各类APP，极客时间有了AI自动总结，懂车帝有了智能选车度搜索问题，有时候第一个也会是AI来给我们解答。</p><blockquote>任何行业遇上AI都可以再做一遍。</blockquote><p>抛开底层算法、模型不谈，但从使用者角度来说，最重要的是如何与行业、场景结合相使用。但是想要做好应用，需要你在行业有着比较深的沉淀，有较深的行业认知。</p><p>当然，智能化也不仅限于AI，像上面餐饮系统的例子，如果能够实现订单预测、自动库存管理，其实也是智能化的体现。</p>', '2024-08-03 12:26:23');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷的ID',
  `project_id` int(11) NULL DEFAULT NULL COMMENT '科目ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '创建者用户ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '试卷名',
  `detail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '试卷简介',
  `limit_time` bigint(20) NULL DEFAULT NULL COMMENT '限时，分',
  `total_score` int(11) NULL DEFAULT NULL COMMENT '总分',
  `is_show` tinyint(1) NULL DEFAULT NULL COMMENT '是否已经审核',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES (2, 8, 1, '近代考古重大发现辨析', '<p>主观题，共三大题，言之有理即可。</p>', 60, 100, 1, '2024-10-18 18:46:19');
INSERT INTO `paper` VALUES (3, 2, 1, '微积分期中考试', '<p>题型分布：选择题 20题，每题一分；多选题 30 题，每题 2 分；大题 4 道，每道5分。</p>', 120, 100, 0, '2024-10-18 18:46:19');
INSERT INTO `paper` VALUES (4, 4, 1, '模电水平摸底考', '<p>卷子简介</p>', 100, 100, 1, '2024-10-18 18:46:19');
INSERT INTO `paper` VALUES (5, 6, 1, '考研英语重难点攻克卷（一）', '<p>考研英语</p>', 120, 100, 1, '2024-10-18 18:46:19');
INSERT INTO `paper` VALUES (6, 6, 1, '考研英语重难点攻克卷（二）', '<p>考研英语重难点攻克卷（二）：考研英语</p>', 120, 100, 1, '2024-10-18 18:46:19');
INSERT INTO `paper` VALUES (7, 6, 1, '考研英语重难点攻克卷（三）', '<p>考研英语考试（三）</p>', 120, 100, 1, '2024-11-14 18:51:20');
INSERT INTO `paper` VALUES (8, 6, 1, '考研英语重难点攻克卷（四）', '<p>考研英语（三）</p>', 120, 100, 1, '2024-11-14 18:51:20');
INSERT INTO `paper` VALUES (9, 5, 1, '高数期中考试', '<p>高数成学</p>', 100, 100, 1, '2024-11-14 18:51:20');
INSERT INTO `paper` VALUES (10, 7, 1, '清朝相关历史知识考试（一）', '<p>清朝历史考试</p>', 120, 100, 1, '2024-11-14 18:51:20');
INSERT INTO `paper` VALUES (11, 8, 1, '雍正王朝相关历史知识考试（一）', '<p>四爷“雍正帝”的前世今生</p>', 120, 100, 1, '2024-11-22 11:53:59');
INSERT INTO `paper` VALUES (12, 11, 1, 'Web摸底考试', '<p>计算机技术</p>', 120, 10, 1, '2024-11-22 14:53:59');

-- ----------------------------
-- Table structure for paper_practice
-- ----------------------------
DROP TABLE IF EXISTS `paper_practice`;
CREATE TABLE `paper_practice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '试卷题目关联ID',
  `paper_id` int(11) NULL DEFAULT NULL COMMENT '试卷ID',
  `practice_id` int(11) NULL DEFAULT NULL COMMENT '试题ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paper_practice
-- ----------------------------
INSERT INTO `paper_practice` VALUES (56, 4, 20);
INSERT INTO `paper_practice` VALUES (60, 10, 17);
INSERT INTO `paper_practice` VALUES (61, 10, 18);
INSERT INTO `paper_practice` VALUES (62, 10, 16);
INSERT INTO `paper_practice` VALUES (67, 12, 14);
INSERT INTO `paper_practice` VALUES (75, 12, 11);
INSERT INTO `paper_practice` VALUES (76, 12, 23);
INSERT INTO `paper_practice` VALUES (77, 12, 12);

-- ----------------------------
-- Table structure for practice
-- ----------------------------
DROP TABLE IF EXISTS `practice`;
CREATE TABLE `practice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '试题ID',
  `practice_type` tinyint(255) NULL DEFAULT NULL COMMENT '题目类型',
  `ask_item` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '题目（富文本）',
  `ask_item_text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '题目的中文',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '题目创建者ID',
  `project_id` int(11) NULL DEFAULT NULL COMMENT '科目ID',
  `question` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '问题选项',
  `answer` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '答案选项',
  `right_answer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '正确答案',
  `score` int(11) NULL DEFAULT NULL COMMENT '题目分值',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of practice
-- ----------------------------
INSERT INTO `practice` VALUES (11, 1, '<p style=\"text-align: left;\"><span style=\"color: rgb(0, 0, 0); font-size: 15px;\"><strong>在Web开发中，用于定义网页结构的标准标记语言是，如图？</strong></span></p><p style=\"text-align: left;\"><img src=\"/api/online-test/v1.0/file/getFile?fileName=c56d4ecSnipaste_2024-11-22_15-02-00.png\" alt=\"/api/online-test/v1.0/file/getFile?fileName=c56d4ecSnipaste_2024-11-22_15-02-00.png\" data-href=\"/api/online-test/v1.0/file/getFile?fileName=c56d4ecSnipaste_2024-11-22_15-02-00.png\" style=\"width: 30%;\"></p>', '在Web开发中，用于定义网页结构的标准标记语言是，如图？', 1, 11, '[{\"type\":\"A\",\"value\":\"HTML (HyperText Markup Language)\"},{\"type\":\"B\",\"value\":\"CSS (Cascading Style Sheets)\"},{\"type\":\"C\",\"value\":\"JavaScript\"},{\"type\":\"D\",\"value\":\"PHP\"}]', '[{\"type\":\"A\",\"value\":\"暂无解析\"},{\"type\":\"B\",\"value\":\"此为错误答案\"},{\"type\":\"C\",\"value\":\"此为错误答案\"},{\"type\":\"D\",\"value\":\"此为错误答案\"}]', '[\"A\"]', 1, '2024-08-02 16:58:16');
INSERT INTO `practice` VALUES (12, 1, '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\"><strong>以下哪个HTTP状态码表示请求的资源已被永久移动到新URL？</strong></span></p>', '关于HTTP和HTTPS，以下说法正确的是？', 1, 11, '[{\"type\":\"A\",\"value\":\"200 OK\"},{\"type\":\"B\",\"value\":\"301 Moved Permanently\"},{\"type\":\"C\",\"value\":\"404 Not Found\"},{\"type\":\"D\",\"value\":\"500 Internal Server Error\"}]', '[{\"type\":\"A\",\"value\":\"\"},{\"type\":\"B\",\"value\":\"此为正确答案\"},{\"type\":\"C\",\"value\":\"\"},{\"type\":\"D\",\"value\":\"\"}]', '[\"B\"]', 1, '2024-08-02 17:02:11');
INSERT INTO `practice` VALUES (13, 2, '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\"><strong>关于HTTP和HTTPS，以下说法正确的是？</strong></span></p>', '以下哪个HTTP状态码表示请求的资源已被永久移动到新URL？', 1, 11, '[{\"type\":\"A\",\"value\":\"HTTP是超文本传输协议，默认端口为80\"},{\"type\":\"B\",\"value\":\"HTTPS是HTTP的安全版本，通过SSL/TLS协议加密数据\"},{\"type\":\"C\",\"value\":\"HTTPS比HTTP更安全，因为它加密了传输的数据\"},{\"type\":\"D\",\"value\":\"HTTPS可能略微降低网页加载速度，因为需要额外的加密和解密过程\"}]', '[{\"type\":\"A\",\"value\":\"正确\"},{\"type\":\"B\",\"value\":\"正确\"},{\"type\":\"C\",\"value\":\"正确\"},{\"type\":\"D\",\"value\":\"正确\"}]', '[\"A\",\"B\",\"C\",\"D\"]', 3, '2024-08-02 17:06:04');
INSERT INTO `practice` VALUES (14, 1, '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\"><strong>在Web开发中，JavaScript的主要用途包括哪些？</strong></span></p>', '在Web开发中，用于定义网页结构的标准标记语言是？', 1, 11, '[{\"type\":\"A\",\"value\":\"网页内容的动态更新\"},{\"type\":\"B\",\"value\":\"客户端与服务器之间的数据交互（通过AJAX）\"},{\"type\":\"C\",\"value\":\"控制网页的样式（注：这主要是CSS的作用，但JavaScript可以动态修改CSS）\"},{\"type\":\"D\",\"value\":\"网页事件处理（如点击、滚动等）\"}]', '[{\"type\":\"A\",\"value\":\"正确\"},{\"type\":\"B\",\"value\":\"正确\"},{\"type\":\"C\",\"value\":\"错误\"},{\"type\":\"D\",\"value\":\"正确\"}]', '[\"A\"]', 1, '2024-08-02 17:07:24');
INSERT INTO `practice` VALUES (15, 1, '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">下列哪项事件标志着中国封建社会的开始？</span></p>', '下列哪项事件标志着中国封建社会的开始？', 1, 7, '[{\"type\":\"A\",\"value\":\"夏朝的建立\"},{\"type\":\"B\",\"value\":\"商朝的甲骨文出现\"},{\"type\":\"C\",\"value\":\"秦朝的统一\"},{\"type\":\"D\",\"value\":\"汉朝的丝绸之路开通\"}]', '[{\"type\":\"A\",\"value\":\"夏朝的建立。夏朝是中国历史上的第一个王朝，标志着中国进入了奴隶制社会晚期或向封建社会的过渡阶段（具体定义有争议，但广泛认为夏朝是封建制度萌芽的时期）。\"},{\"type\":\"B\",\"value\":\"错误\"},{\"type\":\"C\",\"value\":\"错误\"},{\"type\":\"D\",\"value\":\"错误\"}]', '[\"A\"]', 2, '2024-08-03 12:57:55');
INSERT INTO `practice` VALUES (16, 1, '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">第一次工业革命的主要标志是什么？</span></p>', '第一次工业革命的主要标志是什么？', 1, 7, '[{\"type\":\"A\",\"value\":\"蒸汽机的广泛应用\"},{\"type\":\"B\",\"value\":\"电力的发明与应用\"},{\"type\":\"C\",\"value\":\"计算机的普及\"},{\"type\":\"D\",\"value\":\"互联网的诞生\"}]', '[{\"type\":\"A\",\"value\":\"蒸汽机的广泛应用。第一次工业革命，也称为蒸汽时代，其标志是蒸汽机的广泛应用，特别是瓦特改良的蒸汽机，极大地推动了生产力的发展。\"},{\"type\":\"B\",\"value\":\"错误\"},{\"type\":\"C\",\"value\":\"错误\"},{\"type\":\"D\",\"value\":\"错误\"}]', '[\"A\"]', 2, '2024-08-03 13:00:13');
INSERT INTO `practice` VALUES (17, 1, '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">下列哪位人物是文艺复兴时期的杰出代表，以其绘画作品《蒙娜丽莎》闻名于世？</span></p>', '下列哪位人物是文艺复兴时期的杰出代表，以其绘画作品《蒙娜丽莎》闻名于世？', 1, 7, '[{\"type\":\"A\",\"value\":\"达·芬奇\"},{\"type\":\"B\",\"value\":\"米开朗基罗\"},{\"type\":\"C\",\"value\":\"拉斐尔\"},{\"type\":\"D\",\"value\":\"莎士比亚\"}]', '[{\"type\":\"A\",\"value\":\"达·芬奇。列奥纳多·达·芬奇是意大利文艺复兴时期的画家、科学家、发明家，其代表作《蒙娜丽莎》是世界上最著名的油画之一。\"},{\"type\":\"B\",\"value\":\"错误\"},{\"type\":\"C\",\"value\":\"错误\"},{\"type\":\"D\",\"value\":\"错误\"}]', '[\"A\"]', 2, '2024-08-03 13:01:05');
INSERT INTO `practice` VALUES (18, 1, '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">第二次世界大战的转折点是哪场战役？</span></p>', '第二次世界大战的转折点是哪场战役？', 1, 7, '[{\"type\":\"A\",\"value\":\"斯大林格勒战役\"},{\"type\":\"B\",\"value\":\"诺曼底登陆\"},{\"type\":\"C\",\"value\":\"莫斯科保卫战\"},{\"type\":\"D\",\"value\":\"太平洋战争中的中途岛战役\"}]', '[{\"type\":\"A\",\"value\":\"斯大林格勒战役。斯大林格勒战役是第二次世界大战的转折点，它不仅是苏德战场根本转折的开始，而且是第二次世界大战的重要转折点。\"},{\"type\":\"B\",\"value\":\"错误\"},{\"type\":\"C\",\"value\":\"错误\"},{\"type\":\"D\",\"value\":\"错误\"}]', '[\"A\"]', 2, '2024-08-03 13:02:45');
INSERT INTO `practice` VALUES (19, 2, '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">以下关于数据结构的描述中，哪些是正确的？</span></p>', '以下关于数据结构的描述中，哪些是正确的？', 1, 10, '[{\"type\":\"A\",\"value\":\"数据结构是指相互之间存在一种或多种关系的数据元素的全体。\"},{\"type\":\"B\",\"value\":\"图结构中的数据元素之间存在多对多的复杂关系。\"},{\"type\":\"C\",\"value\":\"线性结构中的数据元素之间存在一对一的线性关系。\"},{\"type\":\"D\",\"value\":\"图结构中的数据元素之间存在多对多的复杂关系。\"}]', '[{\"type\":\"A\",\"value\":\"正确。数据结构是计算机存储、组织数据的方式，它描述了数据元素之间的逻辑关系，因此数据结构是指相互之间存在一种或多种关系的数据元素的全体。\"},{\"type\":\"B\",\"value\":\"正确。树形结构是数据元素之间存在一对多的层次关系的数据结构，如二叉树、多叉树等。\"},{\"type\":\"C\",\"value\":\"正确。线性结构是最简单的一种数据结构，其特点是数据元素之间存在一对一的线性关系，如线性表。\"},{\"type\":\"D\",\"value\":\"正确。图结构中的数据元素（节点）之间可以存在多对多的复杂关系，每个节点可以与其他多个节点相连。\"}]', '[\"A\",\"B\",\"C\",\"D\"]', 3, '2024-08-03 13:17:49');
INSERT INTO `practice` VALUES (20, 1, '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">在共射极放大电路中，为了稳定静态工作点，常采用的方法是</span></p>', '在共射极放大电路中，为了稳定静态工作点，常采用的方法是', 1, 4, '[{\"type\":\"A\",\"value\":\"引入电压负反馈\"},{\"type\":\"B\",\"value\":\"引入电流负反馈\"},{\"type\":\"C\",\"value\":\"发射极电阻Re分压式偏置电路\"},{\"type\":\"D\",\"value\":\"增大集电极电阻Rc\"}]', '[{\"type\":\"A\",\"value\":\"错误\"},{\"type\":\"B\",\"value\":\"错误\"},{\"type\":\"C\",\"value\":\"发射极电阻Re分压式偏置电路是常用的稳定静态工作点的方法，它通过Re电阻对基极电流进行分流，同时利用Re上的压降来稳定基极电位，从而稳定静态工作点。\"},{\"type\":\"D\",\"value\":\"错误\"}]', '[\"C\"]', 2, '2024-08-03 13:19:48');
INSERT INTO `practice` VALUES (21, 2, '<p><span style=\"color: rgb(5, 7, 59); background-color: rgb(253, 253, 254); font-size: 15px;\">下列关于算法的描述中，哪些是正确的？</span></p>', '下列关于算法的描述中，哪些是正确的？', 1, 10, '[{\"type\":\"A\",\"value\":\"算法是解决问题的方法和步骤。\"},{\"type\":\"B\",\"value\":\"算法必须包含输入和输出。\"},{\"type\":\"C\",\"value\":\"算法可以有多个输入，但只能有一个输出。\"},{\"type\":\"D\",\"value\":\"算法的有穷性指算法必须在有限步骤内结束。\"}]', '[{\"type\":\"A\",\"value\":\"算法是解决问题的方法和步骤的清晰描述，是计算机程序设计的核心。\"},{\"type\":\"B\",\"value\":\"算法可以有多个输入和多个输出，这取决于算法的具体设计。\"},{\"type\":\"C\",\"value\":\"错误\"},{\"type\":\"D\",\"value\":\"算法的有穷性是指算法必须在有限步骤内结束，不能无限循环。\"}]', '[\"A\",\"B\",\"D\"]', 3, '2024-08-03 13:21:59');
INSERT INTO `practice` VALUES (22, 3, '<p><strong>1 + 1 = ？</strong></p>', '1 + 1 = ？', 1, 11, '[]', '[]', '\"2\"', 1, '2024-08-09 12:54:21');
INSERT INTO `practice` VALUES (23, 4, '<p><u><strong>1 + 1 = 3？</strong></u></p>', '1 + 1 = 3？', 1, 11, '[{\"type\":\"A\",\"value\":\"该描述是对的\"},{\"type\":\"B\",\"value\":\"该描述是错的\"}]', '[]', '[\"B\"]', 1, '2024-08-09 12:55:03');

-- ----------------------------
-- Table structure for project_type
-- ----------------------------
DROP TABLE IF EXISTS `project_type`;
CREATE TABLE `project_type`  (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '分类名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_type
-- ----------------------------
INSERT INTO `project_type` VALUES (1, '人文科学');
INSERT INTO `project_type` VALUES (2, '大学微积分');
INSERT INTO `project_type` VALUES (3, '大学英语');
INSERT INTO `project_type` VALUES (4, '模拟电子技术');
INSERT INTO `project_type` VALUES (5, '高数上册');
INSERT INTO `project_type` VALUES (6, '考研英语');
INSERT INTO `project_type` VALUES (7, '历史');
INSERT INTO `project_type` VALUES (8, '考古元史');
INSERT INTO `project_type` VALUES (9, '计算机组成原理');
INSERT INTO `project_type` VALUES (10, '数据结构');
INSERT INTO `project_type` VALUES (11, 'Web开发');

-- ----------------------------
-- Table structure for test_history
-- ----------------------------
DROP TABLE IF EXISTS `test_history`;
CREATE TABLE `test_history`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '答题历史ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `paper_id` int(11) NULL DEFAULT NULL COMMENT '卷子ID',
  `practice_id` int(11) NULL DEFAULT NULL COMMENT '试题ID',
  `post_score` int(11) NULL DEFAULT NULL COMMENT '获取分数',
  `answer` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '用户作答答案',
  `create_time` datetime NULL DEFAULT NULL COMMENT '答题时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_history
-- ----------------------------
INSERT INTO `test_history` VALUES (28, 8, 12, 12, 0, '[\"A\"]', '2024-11-22 22:34:28');
INSERT INTO `test_history` VALUES (29, 8, 12, 23, 0, '[\"A\"]', '2024-11-22 22:34:28');
INSERT INTO `test_history` VALUES (30, 8, 12, 11, 0, '[\"C\"]', '2024-11-22 22:34:28');
INSERT INTO `test_history` VALUES (31, 8, 12, 14, 0, '[\"B\"]', '2024-11-22 22:34:28');
INSERT INTO `test_history` VALUES (32, 8, 12, 12, 0, '[\"C\"]', '2024-11-22 22:34:58');
INSERT INTO `test_history` VALUES (33, 8, 12, 23, 1, '[\"B\"]', '2024-11-22 22:34:58');
INSERT INTO `test_history` VALUES (34, 8, 12, 11, 1, '[\"A\"]', '2024-11-22 22:34:58');
INSERT INTO `test_history` VALUES (35, 8, 12, 14, 0, '[\"D\"]', '2024-11-22 22:34:58');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `user_account` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_pwd` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `user_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `user_email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `user_role` int(11) NULL DEFAULT NULL COMMENT '用户角色',
  `is_login` tinyint(1) NULL DEFAULT NULL COMMENT '可登录状态(0：可用，1：不可用)',
  `is_word` tinyint(1) NULL DEFAULT NULL COMMENT '禁言状态(0：可用，1：不可用)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '用户注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '程序员辰星', '14e1b600b1fd579f47433b88e8d85291', '/api/online-test/v1.0/file/getFile?fileName=5515588猫头鹰.png', '143543@qq.com', 1, 0, 0, '2024-08-25 12:53:05');
INSERT INTO `user` VALUES (2, 'daquan', '还有人不吃香菜', '14e1b600b1fd579f47433b88e8d85291', '/api/online-test/v1.0/file/getFile?fileName=2d6f3f0Snipaste_2024-11-22_00-46-36.png', '1233211@qq.com', 2, 0, 0, '2024-07-31 16:12:12');
INSERT INTO `user` VALUES (3, 'chenhua', '张华呀', '14e1b600b1fd579f47433b88e8d85291', '/api/online-test/v1.0/file/getFile?fileName=4c42814Snipaste_2024-11-22_00-47-02.png', '12121@qq.com', 2, 0, 0, '2024-08-23 07:37:34');
INSERT INTO `user` VALUES (4, 'liran', '你说公主请上车', '14e1b600b1fd579f47433b88e8d85291', '/api/online-test/v1.0/file/getFile?fileName=750fc00Snipaste_2024-11-22_00-46-29.png', '344343@qq.com', 2, 0, 0, '2024-08-25 07:38:26');
INSERT INTO `user` VALUES (5, 'hujun', '胡小俊呀', '14e1b600b1fd579f47433b88e8d85291', '/api/online-test/v1.0/file/getFile?fileName=22df52aSnipaste_2024-11-22_00-46-48.png', '4343@qq.com', 2, 0, 0, '2024-08-24 07:39:24');
INSERT INTO `user` VALUES (6, 'tianya', '天涯蜘蛛精', '14e1b600b1fd579f47433b88e8d85291', '/api/online-test/v1.0/file/getFile?fileName=fe8b3ceSnipaste_2024-11-22_00-46-13.png', '5454@qq.com', 2, 0, 0, '2024-08-11 07:39:49');
INSERT INTO `user` VALUES (7, 'yueguang', '月光太美了', '14e1b600b1fd579f47433b88e8d85291', '/api/online-test/v1.0/file/getFile?fileName=4357de4Snipaste_2024-11-22_00-47-21.png', '4343@qq.com', 1, 0, 1, '2024-08-25 07:40:12');
INSERT INTO `user` VALUES (8, 'zhangxiaotian', '张小天', '1f32aa4c9a1d2ea010adcf2348166a04', '/api/online-test/v1.0/file/getFile?fileName=e946d79Snipaste_2024-11-22_00-46-41.png', '5454@qq.com', 2, 0, 0, '2024-11-22 00:58:56');
INSERT INTO `user` VALUES (9, 'huiuiuds', '你还好吗？？', '847c497e8f12d2071a99ec6ba119d9e2', '/api/online-test/v1.0/file/getFile?fileName=871b4bfSnipaste_2024-11-22_00-47-41.png', '124323@qq.com', 2, 0, 0, '2024-11-22 00:59:37');
INSERT INTO `user` VALUES (10, 'juiuytu', '大写的伙伴', '14e1b600b1fd579f47433b88e8d85291', '/api/online-test/v1.0/file/getFile?fileName=a66d271pic_7.jpg', '434367@qq.com', 2, 0, 0, '2024-11-22 01:00:07');
INSERT INTO `user` VALUES (11, 'xiaoju', '我家的小菊', '14e1b600b1fd579f47433b88e8d85291', '/api/online-test/v1.0/file/getFile?fileName=b86d9d2Snipaste_2024-11-22_00-47-32.png', '1221@qq.com', 2, 0, 0, '2024-11-22 01:00:37');

SET FOREIGN_KEY_CHECKS = 1;
