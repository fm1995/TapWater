CREATE DATABASE  IF NOT EXISTS `sy` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sy`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: sy
-- ------------------------------------------------------
-- Server version	5.6.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `be_comment`
--

DROP TABLE IF EXISTS `be_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `be_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_no` varchar(16) DEFAULT NULL COMMENT '工单号',
  `datee` datetime DEFAULT NULL COMMENT '留言时间',
  `emp_id` int(11) DEFAULT NULL COMMENT '留言人',
  `comment` varchar(1000) DEFAULT NULL COMMENT '留言内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工单附加信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `be_comment`
--

LOCK TABLES `be_comment` WRITE;
/*!40000 ALTER TABLE `be_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `be_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `be_flow`
--

DROP TABLE IF EXISTS `be_flow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `be_flow` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键	步骤ID',
  `step_name` varchar(20) DEFAULT NULL COMMENT '步骤名称',
  `dept_id` int(11) DEFAULT NULL COMMENT '步骤负责部门',
  `type1` int(11) DEFAULT NULL COMMENT '“新户”的流程',
  `type2` int(11) DEFAULT NULL COMMENT '“分户”的流程',
  `type3` int(11) DEFAULT NULL COMMENT '“过户”的流程',
  `type4` int(11) DEFAULT NULL COMMENT '“代扣”的流程',
  `type5` int(11) DEFAULT NULL COMMENT '“换表”的流程',
  `type6` int(11) DEFAULT NULL COMMENT '“重签”的流程',
  `type7` int(11) DEFAULT NULL COMMENT '“销户”的流程',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='流程模板';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `be_flow`
--

LOCK TABLES `be_flow` WRITE;
/*!40000 ALTER TABLE `be_flow` DISABLE KEYS */;
INSERT INTO `be_flow` VALUES (-1,'终止',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(0,'完成',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1,'用户申请',0,1,1,1,1,1,1,1),(2,'初步审核',0,2,2,2,2,2,2,2),(3,'交施工费',0,3,3,NULL,NULL,3,NULL,NULL),(4,'水费清算',0,NULL,4,NULL,NULL,NULL,NULL,3),(5,'供水协议',0,4,5,NULL,NULL,NULL,3,NULL),(6,'施工竣工',0,5,6,NULL,NULL,4,NULL,NULL),(7,'通水停水',0,6,7,NULL,NULL,5,NULL,4),(8,'档案存档',0,7,8,3,3,6,4,5);
/*!40000 ALTER TABLE `be_flow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `be_formula`
--

DROP TABLE IF EXISTS `be_formula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `be_formula` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增	ID',
  `order_user_id` int(11) DEFAULT NULL COMMENT '“工单用户详表”中的ID',
  `water_type_code` varchar(3) DEFAULT NULL COMMENT '用水类型代码（其实就是费用类型代码）',
  `allot_text` varchar(10) DEFAULT NULL COMMENT '提取值表述（仅供参考，如：80%）',
  `allot_type` int(11) DEFAULT NULL COMMENT '提取方式（0提量 1提比 2取剩余）',
  `allot_value` int(11) DEFAULT NULL COMMENT '提取值（提量时表示水量，提比时表示百分比，取剩余时此字段无用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工单用户提比提量';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `be_formula`
--

LOCK TABLES `be_formula` WRITE;
/*!40000 ALTER TABLE `be_formula` DISABLE KEYS */;
/*!40000 ALTER TABLE `be_formula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `be_history`
--

DROP TABLE IF EXISTS `be_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `be_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_no` varchar(16) DEFAULT NULL COMMENT '工单号',
  `step_id` int(11) DEFAULT NULL COMMENT '步骤ID',
  `datee` datetime DEFAULT NULL COMMENT '处理时间',
  `emp_id` int(11) DEFAULT NULL COMMENT '处理人',
  `is_back` bit(1) DEFAULT NULL COMMENT '被撤回',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='流程历史记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `be_history`
--

LOCK TABLES `be_history` WRITE;
/*!40000 ALTER TABLE `be_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `be_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `be_order`
--

DROP TABLE IF EXISTS `be_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `be_order` (
  `order_no` varchar(16) NOT NULL COMMENT '业扩工单（规则：16位，如：B1comment 20140105comment 0001。前两位表示工单类型，中间8位表示建单日期，最后四位是按工单类型和月份的流水号）',
  `order_type` int(11) DEFAULT NULL COMMENT '工单类型（1新户 2分户 3过户 4代扣 5换表 6重签 7销户）',
  `step_id` int(11) DEFAULT NULL COMMENT '当前步骤ID（1comment 8步骤，0完成，comment 1终止）',
  `create_emp` int(11) DEFAULT NULL COMMENT '建单人',
  `create_date` datetime DEFAULT NULL COMMENT '工单创建日期',
  `complete_emp` int(11) DEFAULT NULL COMMENT '归档人',
  `complete_date` datetime DEFAULT NULL COMMENT '工单完成日期',
  `lastEdit_emp` int(11) DEFAULT NULL COMMENT '最后操作人',
  `lastEdit_date` datetime DEFAULT NULL COMMENT '最后操作时间',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名称',
  `user_type` varchar(8) DEFAULT NULL COMMENT '用户类型（私户 公户）',
  `address` varchar(100) DEFAULT NULL COMMENT '用户地址',
  `link_man` varchar(20) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `use_target` varchar(40) DEFAULT NULL COMMENT '接水用途',
  `house_height` int(11) DEFAULT NULL COMMENT '房屋层次',
  `max_amount` int(11) DEFAULT NULL COMMENT '用水量',
  `meter_type_id` int(11) DEFAULT NULL COMMENT '申请表径',
  `meter_count` int(11) DEFAULT NULL COMMENT '申请装表表数',
  `user_remark` varchar(200) DEFAULT NULL COMMENT '用户申请的备注说明',
  `pay_type` varchar(10) DEFAULT NULL COMMENT '收费方式（坐收 走收 银行代扣）',
  `bank_company` varchar(40) DEFAULT NULL COMMENT '开户银行',
  `bank_num` varchar(20) DEFAULT NULL COMMENT '银行账号',
  `old_user_no` varchar(10) DEFAULT NULL COMMENT '原用户编码',
  `old_user_name` varchar(80) DEFAULT NULL COMMENT '原用户姓名',
  `old_user_phone` varchar(20) DEFAULT NULL COMMENT '原用户电话',
  `old_user_addr` varchar(200) DEFAULT NULL COMMENT '原用户地址',
  `old_meter` varchar(10) DEFAULT NULL COMMENT '原用户表径（不存ID，直接存文字 ）',
  `audit_emp_id` int(11) DEFAULT NULL COMMENT '初步审核人',
  `audit_message` varchar(200) DEFAULT NULL COMMENT '初审意见',
  `project_money` decimal(18,2) DEFAULT NULL COMMENT '总应收金额',
  `real_money` decimal(18,2) DEFAULT NULL COMMENT '总实收金额',
  `pay_date` datetime DEFAULT NULL COMMENT '交费日期',
  `project_date1` datetime DEFAULT NULL COMMENT '开工日期',
  `project_date2` datetime DEFAULT NULL COMMENT '竣工日期',
  `area_id` int(11) DEFAULT NULL COMMENT '所属辖区',
  `abort_cause` varchar(200) DEFAULT NULL COMMENT '工单终止原因',
  PRIMARY KEY (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT=' 业扩工单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `be_order`
--

LOCK TABLES `be_order` WRITE;
/*!40000 ALTER TABLE `be_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `be_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `be_orderlite`
--

DROP TABLE IF EXISTS `be_orderlite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `be_orderlite` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `order_type` int(11) DEFAULT NULL COMMENT '工单类型（1新户...）',
  `datee` datetime DEFAULT NULL COMMENT '操作时间',
  `emp_id` int(11) DEFAULT NULL COMMENT '操作人',
  `user_no` varchar(10) DEFAULT NULL COMMENT '用户编码',
  `user_name` varchar(80) DEFAULT NULL COMMENT '用户姓名',
  `description` varchar(1000) DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='快捷工单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `be_orderlite`
--

LOCK TABLES `be_orderlite` WRITE;
/*!40000 ALTER TABLE `be_orderlite` DISABLE KEYS */;
/*!40000 ALTER TABLE `be_orderlite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `be_orderuser`
--

DROP TABLE IF EXISTS `be_orderuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `be_orderuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增	ID',
  `order_no` varchar(16) DEFAULT NULL COMMENT '所属工单',
  `user_name` varchar(80) DEFAULT NULL COMMENT '用户姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `sms_phone` varchar(20) DEFAULT NULL COMMENT '短信电话',
  `address` varchar(200) DEFAULT NULL COMMENT '联系地址',
  `project_money` decimal(18,2) DEFAULT NULL COMMENT '应交金额',
  `real_money` decimal(18,2) DEFAULT NULL COMMENT '实交金额',
  `invoice_no` varchar(10) DEFAULT NULL COMMENT '发票号',
  `formula` varchar(100) DEFAULT NULL COMMENT '提比提量值',
  `contract_num` varchar(20) DEFAULT NULL COMMENT '合同编号',
  `meter_type_id` int(11) DEFAULT NULL COMMENT '表径（即水表类型）',
  `meter_name` varchar(20) DEFAULT NULL COMMENT '身表码',
  `max_value` int(11) DEFAULT NULL COMMENT '最大表码值',
  `start_value` int(11) DEFAULT NULL COMMENT '起始底码',
  `meter_factory` varchar(100) DEFAULT NULL COMMENT '水表厂家',
  `doc_num` varchar(20) DEFAULT NULL COMMENT '档案编号',
  `user_no` varchar(10) DEFAULT NULL COMMENT '最终产生的用户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工单用户详表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `be_orderuser`
--

LOCK TABLES `be_orderuser` WRITE;
/*!40000 ALTER TABLE `be_orderuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `be_orderuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iv_archive`
--

DROP TABLE IF EXISTS `iv_archive`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iv_archive` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `emp_id` int(11) DEFAULT NULL COMMENT '交票人',
  `in_id` int(11) DEFAULT NULL COMMENT '对应入库id',
  `start_no` varchar(10) DEFAULT NULL COMMENT '起始号码',
  `end_no` varchar(10) DEFAULT NULL COMMENT '结束号码',
  `counts` int(11) DEFAULT NULL COMMENT '总张数',
  `archive_date` datetime DEFAULT NULL COMMENT '交票日期',
  `archive_emp_id` int(11) DEFAULT NULL COMMENT '收票人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交票记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iv_archive`
--

LOCK TABLES `iv_archive` WRITE;
/*!40000 ALTER TABLE `iv_archive` DISABLE KEYS */;
/*!40000 ALTER TABLE `iv_archive` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iv_ininvoice`
--

DROP TABLE IF EXISTS `iv_ininvoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iv_ininvoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `invoice_type` int(11) DEFAULT NULL COMMENT '发票类型（0普通发票 1增值税发票）',
  `start_no` varchar(10) DEFAULT NULL COMMENT '开始号码',
  `end_no` varchar(10) DEFAULT NULL COMMENT '结束号码',
  `counts` int(11) DEFAULT NULL COMMENT '总张数',
  `in_date` datetime DEFAULT NULL COMMENT '入库时间',
  `in_emp_id` int(11) DEFAULT NULL COMMENT '入库操作人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票入库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iv_ininvoice`
--

LOCK TABLES `iv_ininvoice` WRITE;
/*!40000 ALTER TABLE `iv_ininvoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `iv_ininvoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iv_invoice`
--

DROP TABLE IF EXISTS `iv_invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iv_invoice` (
  `invoice_no` varchar(10) NOT NULL COMMENT '发票号码（一般是8位。批量收费时是10位，前8位相同，后2位是流水号。）',
  `invoice_type` int(11) DEFAULT NULL COMMENT '发票类型（0普通发票 1增值税发票）',
  `emp_id` int(11) DEFAULT NULL COMMENT '领用收费员',
  `in_id` int(11) DEFAULT NULL COMMENT '入库批次id',
  `out_id` int(11) DEFAULT NULL COMMENT '出库批次id',
  `archive_id` int(11) DEFAULT NULL COMMENT '交票批次id',
  `used` bit(1) DEFAULT NULL COMMENT '已使用',
  `use_date` datetime DEFAULT NULL COMMENT '使用日期',
  `invalid` bit(1) DEFAULT NULL COMMENT '已作废',
  `invalid_date` datetime DEFAULT NULL COMMENT '作废日期',
  `archived` bit(1) DEFAULT NULL COMMENT '已交票',
  `archive_date` datetime DEFAULT NULL COMMENT '交票日期',
  PRIMARY KEY (`invoice_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iv_invoice`
--

LOCK TABLES `iv_invoice` WRITE;
/*!40000 ALTER TABLE `iv_invoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `iv_invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iv_outinvoice`
--

DROP TABLE IF EXISTS `iv_outinvoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `iv_outinvoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `emp_id` int(11) DEFAULT NULL COMMENT '领用人',
  `in_id` int(11) DEFAULT NULL COMMENT '对应入库id',
  `start_no` varchar(10) DEFAULT NULL COMMENT '起始号码',
  `end_no` varchar(10) DEFAULT NULL COMMENT '结束号码',
  `counts` int(11) DEFAULT NULL COMMENT '总张数',
  `out_date` datetime DEFAULT NULL COMMENT '出库日期',
  `out_emp_id` int(11) DEFAULT NULL COMMENT '出库操作人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发票出库';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iv_outinvoice`
--

LOCK TABLES `iv_outinvoice` WRITE;
/*!40000 ALTER TABLE `iv_outinvoice` DISABLE KEYS */;
/*!40000 ALTER TABLE `iv_outinvoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `py_balance`
--

DROP TABLE IF EXISTS `py_balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `py_balance` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userno` varchar(10) DEFAULT NULL COMMENT '用户编码',
  `balancedate` date DEFAULT NULL COMMENT '销账日期',
  `balancemoney` decimal(18,2) DEFAULT NULL COMMENT '销账金额',
  `billno` varchar(20) DEFAULT NULL COMMENT '水费单',
  `billrealmoney1` decimal(18,2) DEFAULT NULL COMMENT '销账前实收金额',
  `billrealmoney2` decimal(18,2) DEFAULT NULL COMMENT '销账后实收金额',
  `payno` varchar(22) DEFAULT NULL COMMENT '交费单',
  `payusemoney1` decimal(18,2) DEFAULT NULL COMMENT '销账前已用金额',
  `payusemoney2` decimal(18,2) DEFAULT NULL COMMENT '销账后已用金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销账明细';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `py_balance`
--

LOCK TABLES `py_balance` WRITE;
/*!40000 ALTER TABLE `py_balance` DISABLE KEYS */;
/*!40000 ALTER TABLE `py_balance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `py_balancedetail`
--

DROP TABLE IF EXISTS `py_balancedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `py_balancedetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `parent_id` int(11) DEFAULT NULL COMMENT '总目id',
  `user_no` varchar(10) DEFAULT NULL COMMENT '用户编码',
  `balance_date` datetime DEFAULT NULL COMMENT '销账日期',
  `balance_money` decimal(18,2) DEFAULT NULL COMMENT '销账金额',
  `bill_no` varchar(20) DEFAULT NULL COMMENT '水费单号',
  `bill_detail_id` int(11) DEFAULT NULL COMMENT '水费单明细id',
  `cost_type_code` varchar(3) DEFAULT NULL COMMENT '费用项编码',
  `detail_real_money1` decimal(18,2) DEFAULT NULL COMMENT '销账前实收金额',
  `detail_real_money2` decimal(18,2) DEFAULT NULL COMMENT '销账后实收金额',
  `pay_no` varchar(22) DEFAULT NULL COMMENT '交费单号',
  `pay_use_money1` decimal(18,2) DEFAULT NULL COMMENT '销账前已用金额',
  `pay_use_money2` decimal(18,2) DEFAULT NULL COMMENT '销账后已用金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销账明细';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `py_balancedetail`
--

LOCK TABLES `py_balancedetail` WRITE;
/*!40000 ALTER TABLE `py_balancedetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `py_balancedetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `py_bill`
--

DROP TABLE IF EXISTS `py_bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `py_bill` (
  `bill_no` varchar(20) NOT NULL COMMENT '水费单号（规则：SF0100000987-201308，共19位，SF+用户编码+年月）',
  `read_id` int(11) DEFAULT NULL COMMENT '对应的抄表id',
  `user_no` varchar(10) DEFAULT NULL COMMENT '用户编码',
  `create_date` datetime DEFAULT NULL COMMENT '建单日期',
  `bill_money` decimal(18,2) DEFAULT NULL COMMENT '应交金额',
  `real_money` decimal(18,2) DEFAULT NULL COMMENT '实交金额',
  `balance` bit(1) DEFAULT NULL COMMENT '已结清',
  `balance_date` datetime DEFAULT NULL COMMENT '结清日期',
  PRIMARY KEY (`bill_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='水费单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `py_bill`
--

LOCK TABLES `py_bill` WRITE;
/*!40000 ALTER TABLE `py_bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `py_bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `py_billdetail`
--

DROP TABLE IF EXISTS `py_billdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `py_billdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `bill_no` varchar(20) DEFAULT NULL COMMENT '所属水费单',
  `user_no` varchar(10) DEFAULT NULL COMMENT '用户编码',
  `cost_type_code` varchar(3) DEFAULT NULL COMMENT '费用项编码',
  `amount` int(11) DEFAULT NULL COMMENT '水量',
  `price` decimal(18,2) DEFAULT NULL COMMENT '单价',
  `detail_money` decimal(18,2) DEFAULT NULL COMMENT '应收金额',
  `real_money` decimal(18,2) DEFAULT NULL COMMENT '实收金额',
  `balance` bit(1) DEFAULT NULL COMMENT '已结清',
  `balance_date` datetime DEFAULT NULL COMMENT '结清日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='水费单明细';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `py_billdetail`
--

LOCK TABLES `py_billdetail` WRITE;
/*!40000 ALTER TABLE `py_billdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `py_billdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `py_pay`
--

DROP TABLE IF EXISTS `py_pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `py_pay` (
  `pay_no` varchar(22) NOT NULL COMMENT '交费单号（规则：JF0100000987-201401-02，共22位。JF用户编码-年月-按月流水）',
  `user_no` varchar(10) DEFAULT NULL COMMENT '用户编码',
  `pay_type` varchar(10) DEFAULT NULL COMMENT '交费方式（坐收 走收 银行代扣）',
  `pay_date` datetime DEFAULT NULL COMMENT '交费日期',
  `invoice` varchar(10) DEFAULT NULL COMMENT '发票号码',
  `pay_money` decimal(18,2) DEFAULT NULL COMMENT '交费金额',
  `use_money` decimal(18,2) DEFAULT NULL COMMENT '已用金额',
  `emp_id` int(11) DEFAULT NULL COMMENT '收费员',
  PRIMARY KEY (`pay_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交费单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `py_pay`
--

LOCK TABLES `py_pay` WRITE;
/*!40000 ALTER TABLE `py_pay` DISABLE KEYS */;
/*!40000 ALTER TABLE `py_pay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `py_sumreport`
--

DROP TABLE IF EXISTS `py_sumreport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `py_sumreport` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `typee` int(11) DEFAULT NULL COMMENT '类型（0月报表  1年报表）',
  `report_year` int(11) DEFAULT NULL COMMENT '年份',
  `report_month` int(11) DEFAULT NULL COMMENT '月份（只有月报表才有值）',
  `line_no` int(11) DEFAULT NULL COMMENT '行号',
  `c1` varchar(50) DEFAULT NULL COMMENT '第一列',
  `c2` varchar(50) DEFAULT NULL COMMENT '第二列',
  `c3` varchar(50) DEFAULT NULL COMMENT '第三列',
  `c4` varchar(50) DEFAULT NULL COMMENT '第四列',
  `c5` varchar(50) DEFAULT NULL COMMENT '第五列',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='各类用水统计总表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `py_sumreport`
--

LOCK TABLES `py_sumreport` WRITE;
/*!40000 ALTER TABLE `py_sumreport` DISABLE KEYS */;
/*!40000 ALTER TABLE `py_sumreport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `py_userhistory`
--

DROP TABLE IF EXISTS `py_userhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `py_userhistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userno` varchar(10) DEFAULT NULL COMMENT '用户编码',
  `typee` int(11) DEFAULT NULL COMMENT '记录类型（0水费单 1交费单）',
  `orderno` varchar(22) DEFAULT NULL COMMENT '水费单或交费单号',
  `datee` datetime DEFAULT NULL COMMENT '建单时间',
  `prevalue` int(11) DEFAULT NULL COMMENT '上月表码（仅水费单有值）',
  `curvalue` int(11) DEFAULT NULL COMMENT '本月表码（仅水费单有值）',
  `amount` int(11) DEFAULT NULL COMMENT '用水量  （仅水费单有值）',
  `billmoney` decimal(18,2) DEFAULT NULL COMMENT '应缴水费（仅水费单有值）',
  `paymoney` decimal(18,2) DEFAULT NULL COMMENT '交费金额（仅交费单有值）',
  `usermoney` decimal(18,2) DEFAULT NULL COMMENT '余额/欠费（正数表示余额    负数表示欠费）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户历史详单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `py_userhistory`
--

LOCK TABLES `py_userhistory` WRITE;
/*!40000 ALTER TABLE `py_userhistory` DISABLE KEYS */;
/*!40000 ALTER TABLE `py_userhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rd_changemaxvalue`
--

DROP TABLE IF EXISTS `rd_changemaxvalue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rd_changemaxvalue` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `datee` datetime DEFAULT NULL COMMENT '操作日期',
  `emp_id` int(11) DEFAULT NULL COMMENT '操作员',
  `user_no` varchar(10) DEFAULT NULL COMMENT '用户编码',
  `meter_no` varchar(14) DEFAULT NULL COMMENT '水表编码',
  `max_value1` int(11) DEFAULT NULL COMMENT '修正前最大表码值',
  `max_value2` int(11) DEFAULT NULL COMMENT '修正后最大表码值',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='最大表码修正记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rd_changemaxvalue`
--

LOCK TABLES `rd_changemaxvalue` WRITE;
/*!40000 ALTER TABLE `rd_changemaxvalue` DISABLE KEYS */;
/*!40000 ALTER TABLE `rd_changemaxvalue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rd_changevalue`
--

DROP TABLE IF EXISTS `rd_changevalue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rd_changevalue` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `datee` datetime DEFAULT NULL COMMENT '操作日期',
  `emp_id` int(11) DEFAULT NULL COMMENT '操作员',
  `user_no` varchar(10) DEFAULT NULL COMMENT '用户编码',
  `pre_value1` int(11) DEFAULT NULL COMMENT '修正前底码',
  `pre_value2` int(11) DEFAULT NULL COMMENT '修正后底码',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='底码修正记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rd_changevalue`
--

LOCK TABLES `rd_changevalue` WRITE;
/*!40000 ALTER TABLE `rd_changevalue` DISABLE KEYS */;
/*!40000 ALTER TABLE `rd_changevalue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rd_read`
--

DROP TABLE IF EXISTS `rd_read`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rd_read` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `read_year` int(11) DEFAULT NULL COMMENT '抄表年份',
  `read_month` int(11) DEFAULT NULL COMMENT '抄表月份',
  `user_no` varchar(10) DEFAULT NULL COMMENT '用户编码',
  `meter_no` varchar(14) DEFAULT NULL COMMENT '水表编码',
  `max_value` int(11) DEFAULT NULL COMMENT '最大表码值（冗余数据）',
  `volume_id` int(11) DEFAULT NULL COMMENT '表册id',
  `volume_index` int(11) DEFAULT NULL COMMENT '表册中的序号（冗余数据）',
  `read_emp_id` int(11) DEFAULT NULL COMMENT '抄表人',
  `read_date` datetime DEFAULT NULL COMMENT '抄表时间',
  `pre_value` int(11) DEFAULT NULL COMMENT '上月表码',
  `enter` bit(1) DEFAULT NULL COMMENT '已输入',
  `cur_value` int(11) DEFAULT NULL COMMENT '本月表码',
  `dial` bit(1) DEFAULT NULL COMMENT '转表',
  `amount` int(11) DEFAULT NULL COMMENT '用水量',
  `formula` varchar(100) DEFAULT NULL COMMENT '套用提比提量值',
  `audit` bit(1) DEFAULT NULL COMMENT '已审核',
  `audit_emp_id` int(11) DEFAULT NULL COMMENT '审核人',
  `audit_date` datetime DEFAULT NULL COMMENT '审核日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='抄表数据';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rd_read`
--

LOCK TABLES `rd_read` WRITE;
/*!40000 ALTER TABLE `rd_read` DISABLE KEYS */;
/*!40000 ALTER TABLE `rd_read` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rd_readtypes`
--

DROP TABLE IF EXISTS `rd_readtypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rd_readtypes` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `read_id` int(11) DEFAULT NULL COMMENT '抄表id',
  `user_no` varchar(10) DEFAULT NULL COMMENT '用户编码',
  `water_type_code` varchar(3) DEFAULT NULL COMMENT '用水类型代码（其实就是费用类型）',
  `allot_text` varchar(10) DEFAULT NULL COMMENT '提取值表述（仅供参考，如：80%）',
  `amount` int(11) DEFAULT NULL COMMENT '分量水量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类水量';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rd_readtypes`
--

LOCK TABLES `rd_readtypes` WRITE;
/*!40000 ALTER TABLE `rd_readtypes` DISABLE KEYS */;
/*!40000 ALTER TABLE `rd_readtypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rd_task`
--

DROP TABLE IF EXISTS `rd_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rd_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `read_year` int(11) DEFAULT NULL COMMENT '抄表年份',
  `read_month` int(11) DEFAULT NULL COMMENT '抄表月份',
  `volume_id` int(11) DEFAULT NULL COMMENT '表册',
  `emp_id` int(11) DEFAULT NULL COMMENT '责任抄表人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='抄表任务分配';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rd_task`
--

LOCK TABLES `rd_task` WRITE;
/*!40000 ALTER TABLE `rd_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `rd_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rd_volume`
--

DROP TABLE IF EXISTS `rd_volume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rd_volume` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `volume_name` varchar(50) DEFAULT NULL COMMENT '表册名称',
  `area_id` int(11) DEFAULT NULL COMMENT '所属辖区ID',
  `order_index` int(11) DEFAULT NULL COMMENT '排列顺序',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `disabled` bit(1) DEFAULT NULL COMMENT '禁用 （0可使用 1已禁用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表册';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rd_volume`
--

LOCK TABLES `rd_volume` WRITE;
/*!40000 ALTER TABLE `rd_volume` DISABLE KEYS */;
/*!40000 ALTER TABLE `rd_volume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rd_yearmonth`
--

DROP TABLE IF EXISTS `rd_yearmonth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rd_yearmonth` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `read_year` int(11) DEFAULT NULL COMMENT '抄表年份',
  `read_month` int(11) DEFAULT NULL COMMENT '抄表月份',
  `is_current` bit(1) DEFAULT NULL COMMENT '当前',
  `init_emp_id` int(11) DEFAULT NULL COMMENT '初始化操作人',
  `init_date` datetime DEFAULT NULL COMMENT '初始化时间',
  `end_date` datetime DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='抄表年月';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rd_yearmonth`
--

LOCK TABLES `rd_yearmonth` WRITE;
/*!40000 ALTER TABLE `rd_yearmonth` DISABLE KEYS */;
/*!40000 ALTER TABLE `rd_yearmonth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_area`
--

DROP TABLE IF EXISTS `sy_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_area` (
  `area_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID（范围1~99，不能超过99）',
  `area_name` varchar(45) DEFAULT NULL COMMENT '抄表辖区名称',
  `area_remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `area_disabled` bit(1) DEFAULT b'0' COMMENT '禁用 （0可使用 1已禁用）',
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='抄表辖区';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_area`
--

LOCK TABLES `sy_area` WRITE;
/*!40000 ALTER TABLE `sy_area` DISABLE KEYS */;
/*!40000 ALTER TABLE `sy_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_cost_type`
--

DROP TABLE IF EXISTS `sy_cost_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_cost_type` (
  `costtype_id` int(11) NOT NULL AUTO_INCREMENT,
  `costtype_kind` int(11) DEFAULT '0' COMMENT '类型 （0用水类型 1附加费）',
  `costtype_code` varchar(3) DEFAULT NULL COMMENT '编码 （用水类型2位数，附加费3位数）',
  `cost_type_name` varchar(20) DEFAULT NULL COMMENT '费用类型名称（根据不同情况，建议分别为该字段取别名为：用水类型名称WaterTypeName、附加费类型名称SurchargeName）',
  `costtype_full_name` varchar(50) DEFAULT NULL COMMENT '费用类型全称（主要用于附加费）',
  `costtype_price` decimal(9,2) DEFAULT NULL COMMENT '单价（元）',
  `costtype_surcharge_text` varchar(800) DEFAULT NULL COMMENT '附加费征收范围说明文字（缓存，仅有参考意义）',
  `costtype_remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `costtype_disabled` bit(1) DEFAULT b'0' COMMENT '禁用 （0可使用 1已禁用）',
  PRIMARY KEY (`costtype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='费用类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_cost_type`
--

LOCK TABLES `sy_cost_type` WRITE;
/*!40000 ALTER TABLE `sy_cost_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `sy_cost_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_dept`
--

DROP TABLE IF EXISTS `sy_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `dept_remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `dept_disabled` bit(1) DEFAULT b'0' COMMENT '禁用 （0可使用 1已禁用）',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_dept`
--

LOCK TABLES `sy_dept` WRITE;
/*!40000 ALTER TABLE `sy_dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `sy_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_emp`
--

DROP TABLE IF EXISTS `sy_emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_emp` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) DEFAULT NULL COMMENT '员工姓名',
  `emp_no` varchar(10) DEFAULT NULL COMMENT '工号',
  `emp_pwd` varchar(20) DEFAULT NULL COMMENT '密码 （MD5加密）',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `emp_remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `emp_disabled` bit(1) DEFAULT b'0' COMMENT '禁用 （0可使用 1已禁用）',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_emp`
--

LOCK TABLES `sy_emp` WRITE;
/*!40000 ALTER TABLE `sy_emp` DISABLE KEYS */;
/*!40000 ALTER TABLE `sy_emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_emp_area_power`
--

DROP TABLE IF EXISTS `sy_emp_area_power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_emp_area_power` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `emp_id` int(11) DEFAULT NULL COMMENT '员工ID',
  `area_id` int(11) DEFAULT NULL COMMENT '抄表辖区ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工辖区权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_emp_area_power`
--

LOCK TABLES `sy_emp_area_power` WRITE;
/*!40000 ALTER TABLE `sy_emp_area_power` DISABLE KEYS */;
/*!40000 ALTER TABLE `sy_emp_area_power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_emp_menu_power`
--

DROP TABLE IF EXISTS `sy_emp_menu_power`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_emp_menu_power` (
  `empmenupower_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) DEFAULT NULL COMMENT '员工ID',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`empmenupower_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工菜单权限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_emp_menu_power`
--

LOCK TABLES `sy_emp_menu_power` WRITE;
/*!40000 ALTER TABLE `sy_emp_menu_power` DISABLE KEYS */;
/*!40000 ALTER TABLE `sy_emp_menu_power` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_menu`
--

DROP TABLE IF EXISTS `sy_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `menu_parent` int(11) DEFAULT NULL COMMENT '菜单上级ID',
  `menu_url` varchar(200) DEFAULT NULL COMMENT '菜单链接的URL',
  `menu_on_click` varchar(200) DEFAULT NULL COMMENT '菜单点击时的js代码',
  `menu_icon` varchar(30) DEFAULT NULL COMMENT '菜单图标对应的样式类',
  `menu_order_index` int(11) DEFAULT NULL COMMENT '菜单排序号',
  `flow_id` int(11) DEFAULT NULL COMMENT '此菜单项对应业扩流程中的流程ID',
  `menu_disabled` bit(1) DEFAULT b'0' COMMENT '禁用 （0可使用 1已禁用）',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_menu`
--

LOCK TABLES `sy_menu` WRITE;
/*!40000 ALTER TABLE `sy_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `sy_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_meter_type`
--

DROP TABLE IF EXISTS `sy_meter_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_meter_type` (
  `metertype_id` int(11) NOT NULL AUTO_INCREMENT,
  `meter_type_name` varchar(20) DEFAULT NULL COMMENT '水表型号名称',
  `metertype_aperture` int(11) DEFAULT NULL COMMENT '口径',
  `metertype_max_value` int(11) DEFAULT NULL COMMENT '最大表码值（吨。此种水表的默认最大表码值）',
  `metertype_min_value` int(11) DEFAULT NULL COMMENT '下限设置（吨。仅供参考，不做实际用途）',
  `metertype_life` int(11) DEFAULT NULL COMMENT '周检年限（月）',
  `metertype_remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `metertype_disabled` bit(1) DEFAULT NULL COMMENT '禁用 （0可使用 1已禁用',
  PRIMARY KEY (`metertype_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='水表型号';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_meter_type`
--

LOCK TABLES `sy_meter_type` WRITE;
/*!40000 ALTER TABLE `sy_meter_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `sy_meter_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sy_surcharge`
--

DROP TABLE IF EXISTS `sy_surcharge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sy_surcharge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `surcharge_id` int(11) DEFAULT NULL COMMENT '附加费ID（其实就是费用类型ID）',
  `water_type_id` int(11) DEFAULT NULL COMMENT '用水类型ID（其实就是费用类型ID）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='附加费关联(费用类型表中有两种费用类型，在sy_CostType表中用cost_type_kind字段区分)';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sy_surcharge`
--

LOCK TABLES `sy_surcharge` WRITE;
/*!40000 ALTER TABLE `sy_surcharge` DISABLE KEYS */;
/*!40000 ALTER TABLE `sy_surcharge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `us_formula`
--

DROP TABLE IF EXISTS `us_formula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `us_formula` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键,自增	ID',
  `user_no` varchar(10) DEFAULT NULL COMMENT '用户编码',
  `water_type_code` varchar(3) DEFAULT NULL COMMENT '用水类型代码（其实就是费用类型代码）',
  `allot_text` varchar(10) DEFAULT NULL COMMENT '提取值表述（仅供参考，如：80%）',
  `allot_type` int(11) DEFAULT NULL COMMENT '提取方式（0提量 1提比 2取剩余）',
  `allot_value` int(11) DEFAULT NULL COMMENT '提取值（提量时表示水量，提比时表示百分比，取剩余时此字段无用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='提比提量';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `us_formula`
--

LOCK TABLES `us_formula` WRITE;
/*!40000 ALTER TABLE `us_formula` DISABLE KEYS */;
/*!40000 ALTER TABLE `us_formula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `us_meter`
--

DROP TABLE IF EXISTS `us_meter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `us_meter` (
  `meter_no` varchar(14) NOT NULL COMMENT '主键 水表编号（14位，规则：M+10位用户编码+杠+2位流水号。如：M0100000987-02，表示用户0100000987的第2块水表，此用户换过一次表。）',
  `user_no` varchar(10) DEFAULT NULL COMMENT '所属用户',
  `meter_name` varchar(20) DEFAULT NULL COMMENT '表身码',
  `meter_type_id` int(11) DEFAULT NULL COMMENT '水表类型',
  `max_value` int(11) DEFAULT NULL COMMENT '最大表码值',
  `start_value` int(11) DEFAULT NULL COMMENT '起始底码（仅供参考）',
  `setup_date` datetime DEFAULT NULL COMMENT '装表日期',
  `factory` varchar(100) DEFAULT NULL COMMENT '水表厂家',
  `disabled` bit(1) DEFAULT NULL COMMENT '禁用 （0可使用 1已禁用）',
  PRIMARY KEY (`meter_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='水表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `us_meter`
--

LOCK TABLES `us_meter` WRITE;
/*!40000 ALTER TABLE `us_meter` DISABLE KEYS */;
/*!40000 ALTER TABLE `us_meter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `us_sms`
--

DROP TABLE IF EXISTS `us_sms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `us_sms` (
  `sms_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键,自增	ID',
  `send_time` datetime DEFAULT NULL COMMENT '发送时间',
  `emp_id` int(11) DEFAULT NULL COMMENT '操作人',
  `sms_message` varchar(1000) DEFAULT NULL COMMENT '发送内容',
  `sms_type` int(11) DEFAULT '0' COMMENT '发送类型（0给所有用户发 1只给欠费用户发）',
  PRIMARY KEY (`sms_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='短信群发记录';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `us_sms`
--

LOCK TABLES `us_sms` WRITE;
/*!40000 ALTER TABLE `us_sms` DISABLE KEYS */;
/*!40000 ALTER TABLE `us_sms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `us_user`
--

DROP TABLE IF EXISTS `us_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `us_user` (
  `user_no` varchar(10) NOT NULL COMMENT '主键	用户编码（规则：共10位，前2位表示辖区，后8位是全局流水号）',
  `user_name` varchar(80) DEFAULT NULL COMMENT '用户姓名（最多40个汉字）',
  `ABC` varchar(80) DEFAULT NULL COMMENT '简码',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `address` varchar(200) DEFAULT NULL COMMENT '联系地址（即用水地址）',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `sms_phone` varchar(20) DEFAULT NULL COMMENT '短信电话',
  `area_id` int(11) DEFAULT NULL COMMENT '所属辖区',
  `user_type` varchar(10) DEFAULT NULL COMMENT '用户类型（公户、私户）',
  `pay_type` varchar(10) DEFAULT NULL COMMENT '收款方式（坐收、走收、银行代扣）',
  `bank_name` varchar(100) DEFAULT NULL COMMENT '开户银行',
  `bank_num` varchar(20) DEFAULT NULL COMMENT '银行账号',
  `formula` varchar(100) DEFAULT NULL COMMENT '提比提量值',
  `user_money` decimal(18,2) DEFAULT NULL COMMENT '用户金额（正数是预缴费余额、负数是欠费金额）',
  `meter_id` int(11) DEFAULT NULL COMMENT '水表ID',
  `doc_num` varchar(20) DEFAULT NULL COMMENT '档案编号',
  `pwd` varchar(20) DEFAULT NULL COMMENT '密码（MD5加密。暂时无用，为将来的移动互联网查询预留的字段）',
  `contract_num` varchar(20) DEFAULT NULL COMMENT '合同编号（指供水协议的合同编号）',
  `contract_date` datetime DEFAULT NULL COMMENT '合同签订日期',
  `volume_id` int(11) DEFAULT NULL COMMENT '所属表册ID',
  `volume_order_index` int(11) DEFAULT NULL COMMENT '在表册中的序号',
  `user_disabled` bit(1) DEFAULT b'0' COMMENT '禁用 （0可使用 1已禁用）',
  PRIMARY KEY (`user_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `us_user`
--

LOCK TABLES `us_user` WRITE;
/*!40000 ALTER TABLE `us_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `us_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-23 11:02:58
