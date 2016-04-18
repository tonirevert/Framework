CREATE DATABASE  IF NOT EXISTS `prog` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `prog`;
-- MySQL dump 10.13  Distrib 5.5.47, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: prog
-- ------------------------------------------------------
-- Server version	5.5.47-0ubuntu0.14.04.1

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `dni` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `name` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `surname` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `date_birthday` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `mobile` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `user` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `avatar` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `state` tinyint(1) NOT NULL DEFAULT '0',
  `age` int(4) NOT NULL,
  `benefit` float NOT NULL,
  `date_contract` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `antiquity` int(4) NOT NULL,
  `salary` float NOT NULL,
  `activity` int(10) NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('01795418S','Pedro','Calabuig','7/4/1979','34937174961','PedroCalabuig@dummy.org','Pedro6509','gA7k9K0h','src/Modules/Admin/View/img/avatar/default.png',0,37,112.5,'19/4/2004',11,1112.5,5),('08430215W','German','Mira','26/7/1962','34485359729','GermanMira@dummy.org','German9448','fP1p6I2u','src/Modules/Admin/View/img/avatar/default.png',0,53,122.5,'26/10/2003',12,1122.5,5),('08833619D','Pepa','Pindado','30/6/1963','34613578465','PepaPindado@dummy.org','Pepa8633','hX3j8V2o','src/Modules/Admin/View/img/avatar/default.png',1,52,92.5,'22/3/2007',9,1092.5,5),('11775110F','Ramon','Soto','6/5/1964','34638816621','RamonSoto@dummy.org','Ramon1366','iO5y2J2a','src/Modules/Admin/View/img/avatar/default.png',1,51,132.5,'2/9/2002',13,1132.5,5),('12246666V','Ismael','Tortosa','28/6/1995','34098443811','IsmaelTortosa@dummy.org','Ismael5495','sN1h9B4e','src/Modules/Admin/View/img/avatar/default.png',1,20,42.5,'2/3/2012',4,1042.5,5),('12345678Z','Test','Test','5/2/1990','34258965348','t@t.es','Test','Az123456','src/Modules/Admin/View/img/avatar/12345678Z',1,26,70,'3/4/2014',2,1070,100),('15206693J','Jaume','Hinojosa','14/6/1963','34966704569','JaumeHinojosa@dummy.org','Jaume4476','wL0r9B0o','src/Modules/Admin/View/img/avatar/default.png',1,52,12.5,'23/11/2014',1,1012.5,5),('16311717W','German','Rueda','13/9/1990','34157640163','GermanRueda@dummy.org','German0483','rI7j6V0c','src/Modules/Admin/View/img/avatar/default.png',0,25,82.5,'7/12/2007',8,1082.5,5),('17553939V','Antonio','Dominguez','14/2/1965','34772969770','AntonioDominguez@dummy.org','Antonio4980','cA8c7T7c','src/Modules/Admin/View/img/avatar/default.png',0,51,172.5,'31/7/1998',17,1172.5,5),('19364016V','Vicent','Soriano','12/10/1975','34162237805','VicentSoriano@dummy.org','Vicent7087','yC0e3P3b','src/Modules/Admin/View/img/avatar/default.png',0,40,72.5,'24/8/2008',7,1072.5,5),('24622185H','Santiago','Alonso','30/12/1965','34580183035','SantiagoAlonso@dummy.org','Santiago4661','lS4d3A8j','src/Modules/Admin/View/img/avatar/default.png',0,50,2.5,'2/11/2015',0,1002.5,5),('25567957F','Salva','Dominguez','17/12/1957','34345217915','SalvaDominguez@dummy.org','Salva0936','nB8t5Q6w','src/Modules/Admin/View/img/avatar/default.png',0,58,62.5,'3/10/2009',6,1062.5,5),('25708068W','Oscar','Vellber','25/10/1960','34705346017','OscarVellber@dummy.org','Oscar6754','yJ4r2A1y','src/Modules/Admin/View/img/avatar/default.png',1,55,32.5,'19/8/2012',3,1032.5,5),('28574324K','Salva','Alonso','30/5/1984','34945677488','SalvaAlonso@dummy.org','Salva5786','nT3v1U2z','src/Modules/Admin/View/img/avatar/default.png',0,31,142.5,'14/1/2002',14,1142.5,5),('32076397E','Miguel','Moreno','18/7/1966','34138686297','MiguelMoreno@dummy.org','Miguel0126','wW2o5K0l','src/Modules/Admin/View/img/avatar/default.png',0,49,172.5,'10/11/1998',17,1172.5,5),('34336719L','Sara','Tortosa','8/8/1973','34372262197','SaraTortosa@dummy.org','Sara9639','iU4j7Y6a','src/Modules/Admin/View/img/avatar/default.png',1,42,142.5,'19/1/2002',14,1142.5,5),('36892483T','Natalia','Esteller','1/11/1973','34682300957','NataliaEsteller@dummy.org','Natalia4689','zN3q7U9f','src/Modules/Admin/View/img/avatar/default.png',1,42,42.5,'9/5/2011',4,1042.5,5),('37234045N','Roser','Carril','6/1/1985','34298372393','RoserCarril@dummy.org','Roser9495','mE7j9C4m','src/Modules/Admin/View/img/avatar/default.png',0,31,2.5,'19/5/2015',0,1002.5,5),('37646467K','Roser','Soriano','12/3/1951','34175372779','RoserSoriano@dummy.org','Roser8857','aZ1v7E6z','src/Modules/Admin/View/img/avatar/default.png',0,65,142.5,'10/5/2001',14,1142.5,5),('37743592V','Pablo','Fernandez','10/9/1959','34814993265','PabloFernandez@dummy.org','Pablo3217','kT2f2K0s','src/Modules/Admin/View/img/avatar/default.png',0,56,22.5,'23/1/2014',2,1022.5,5),('38907688Z','Ismael','Moreno','21/7/1987','34161568229','IsmaelMoreno@dummy.org','Ismael7380','qC1u4O1j','src/Modules/Admin/View/img/avatar/default.png',1,28,102.5,'7/12/2005',10,1102.5,5),('46783970S','Ramon','Donat','22/12/1984','34092340996','RamonDonat@dummy.org','Ramon6489','xP7x8G9f','src/Modules/Admin/View/img/avatar/default.png',0,31,32.5,'20/7/2012',3,1032.5,5),('47760678M','Jordi','Ruiz','17/7/1950','34929257306','JordiRuiz@dummy.org','Jordi1776','vP1s8L9o','src/Modules/Admin/View/img/avatar/default.png',0,65,52.5,'7/3/2011',5,1052.5,5),('48638483S','Juanjo','Tortosa','12/9/1974','34337490633','JuanjoTortosa@dummy.org','Juanjo8640','rY3a3Y0q','src/Modules/Admin/View/img/avatar/default.png',0,41,162.5,'2/4/1999',16,1162.5,5),('54306539C','Pablo','Hoyos','16/4/1985','34542850818','PabloHoyos@dummy.org','Pablo6060','pN5i3L4r','src/Modules/Admin/View/img/avatar/default.png',1,30,142.5,'5/10/2001',14,1142.5,5),('58288510R','Joana','Luque','27/6/1977','34424024411','JoanaLuque@dummy.org','Joana7075','tM8j9K4k','src/Modules/Admin/View/img/avatar/default.png',1,38,152.5,'4/1/2001',15,1152.5,5),('60322845D','Toni','Mesas','7/12/1984','34649366077','ToniMesas@dummy.org','Toni4796','wY0m0E9e','src/Modules/Admin/View/img/avatar/default.png',0,31,122.5,'22/11/2003',12,1122.5,5),('61628898F','Miguel','Fernandez','25/3/1959','34384063307','MiguelFernandez@dummy.org','Miguel5117','fZ1v8P7y','src/Modules/Admin/View/img/avatar/default.png',1,57,92.5,'26/9/2006',9,1092.5,5),('62715181T','Paco','Revert','23/10/1995','34637625548','PacoRevert@dummy.org','Paco3993','mM3q8U2p','src/Modules/Admin/View/img/avatar/default.png',0,20,32.5,'23/5/2012',3,1032.5,5),('63454249D','Salva','Ferri','17/4/1962','34162748245','SalvaFerri@dummy.org','Salva3441','hO0l7S7e','src/Modules/Admin/View/img/avatar/default.png',0,53,12.5,'15/11/2014',1,1012.5,5),('69057745S','Pepa','Raga','25/7/1959','34003440344','PepaRaga@dummy.org','Pepa3644','iB2f6H2z','src/Modules/Admin/View/img/avatar/default.png',1,56,132.5,'13/11/2002',13,1132.5,5),('69628280N','Alfonso','Ventura','4/1/1965','34814376863','AlfonsoVentura@dummy.org','Alfonso4701','fP4o9D0c','src/Modules/Admin/View/img/avatar/default.png',1,51,102.5,'19/1/2006',10,1102.5,5),('74344463E','Elena','Francés','11/10/1984','34126741733','ElenaFrances@dummy.org','Elena8228','aU6g4T9e','src/Modules/Admin/View/img/avatar/default.png',1,31,142.5,'13/7/2001',14,1142.5,5),('77955165T','Antonio','Francés','17/4/1984','34519131734','AntonioFrances@dummy.org','Antonio2727','lM6g8X1a','src/Modules/Admin/View/img/avatar/default.png',0,31,112.5,'3/4/2005',11,1112.5,5),('78507215G','Pedro','Palomares','13/10/1968','34884713133','PedroPalomares@dummy.org','Pedro7207','gH3x6L8s','src/Modules/Admin/View/img/avatar/default.png',1,47,92.5,'7/8/2006',9,1092.5,5),('78551348T','Joan','Molla','20/5/1955','34971807460','JoanMolla@dummy.org','Joan5660','lC4j4T8p','src/Modules/Admin/View/img/avatar/default.png',1,60,112.5,'6/9/2004',11,1112.5,5),('78899849M','Eduardo','Esteller','21/7/1974','34315381552','EduardoEsteller@dummy.org','Eduardo0431','rT8n2O1r','src/Modules/Admin/View/img/avatar/default.png',0,41,52.5,'5/9/2010',5,1052.5,5),('80944156A','Joan','Fernandez','20/2/1989','34935824268','JoanFernandez@dummy.org','Joan9478','mF2v1P3g','src/Modules/Admin/View/img/avatar/default.png',0,27,92.5,'31/5/2006',9,1092.5,5),('84122381L','Joana','Pindado','10/2/1985','34274208187','JoanaPindado@dummy.org','Joana4023','mY5k1A0z','src/Modules/Admin/View/img/avatar/default.png',1,31,132.5,'9/8/2002',13,1132.5,5),('87425712K','Pepe','Vellber','13/3/1983','34878309452','PepeVellber@dummy.org','Pepe6451','cI4n9G0r','src/Modules/Admin/View/img/avatar/default.png',1,33,82.5,'25/6/2007',8,1082.5,5),('87681500A','Oscar','Gramage','11/7/1968','34135958631','OscarGramage@dummy.org','Oscar8567','vZ6k0O3m','src/Modules/Admin/View/img/avatar/default.png',1,47,72.5,'24/2/2009',7,1072.5,5),('88087320B','Pepa','Gil','17/7/1972','34476393292','PepaGil@dummy.org','Pepa4196','cJ3s8I3d','src/Modules/Admin/View/img/avatar/default.png',0,43,92.5,'7/1/2007',9,1092.5,5),('92024565R','Sara','Soriano','9/5/1972','34599064343','SaraSoriano@dummy.org','Sara2135','wM4n4Q0j','src/Modules/Admin/View/img/avatar/default.png',1,43,72.5,'25/9/2008',7,1072.5,5),('92562195Y','Alfonso','Palomares','1/12/1960','34603252670','AlfonsoPalomares@dummy.org','Alfonso8747','hL3f1F1y','src/Modules/Admin/View/img/avatar/default.png',1,55,62.5,'4/12/2009',6,1062.5,5),('92937759A','Nuria','Vellber','27/10/1953','34130939248','NuriaVellber@dummy.org','Nuria9595','wW7k6X3t','src/Modules/Admin/View/img/avatar/default.png',1,62,42.5,'11/4/2011',4,1042.5,5),('94066331B','Eduardo','Gramage','21/11/1973','34936807817','EduardoGramage@dummy.org','Eduardo2717','tX7o2T1q','src/Modules/Admin/View/img/avatar/default.png',1,42,72.5,'9/8/2008',7,1072.5,5),('94272670V','Juanjo','Gil','13/8/1983','34767643588','JuanjoGil@dummy.org','Juanjo9235','fJ4p7U2x','src/Modules/Admin/View/img/avatar/default.png',0,32,42.5,'24/9/2011',4,1042.5,5),('96227565G','Daniel','Soriano','6/11/1977','34384749708','DanielSoriano@dummy.org','Daniel2188','dK2v8D2k','src/Modules/Admin/View/img/avatar/default.png',1,38,122.5,'30/10/2003',12,1122.5,5),('97049814A','Miguel','Dominguez','15/7/1950','34589914963','MiguelDominguez@dummy.org','Miguel3963','uX1n5F0p','src/Modules/Admin/View/img/avatar/default.png',1,65,172.5,'15/1/1999',17,1172.5,5),('98921268Q','Toni','Segrelles','28/8/1969','34095028031','ToniSegrelles@dummy.org','Toni4868','mG8o8X2k','src/Modules/Admin/View/img/avatar/default.png',1,46,82.5,'31/7/2007',8,1082.5,5),('99823858V','Lola','Alonso','27/10/1956','34425601598','LolaAlonso@dummy.org','Lola4339','qR8l3O4x','src/Modules/Admin/View/img/avatar/default.png',0,59,2.5,'10/9/2015',0,1002.5,5);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-12 20:55:10
