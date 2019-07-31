create database sts;

use sts;

show tables;

CREATE TABLE `student` (
  `sid` int(11) NOT NULL,
  `sname` varchar(255) DEFAULT NULL,
  `gradeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `FKgt0p1a0107p44o4s35i1oko6y` (`gradeid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `grades` (
  `gid` int(11) NOT NULL,
  `studentgrade` varchar(255) DEFAULT NULL,
  `student_sid` int(11) DEFAULT NULL,
  PRIMARY KEY (`gid`),
  KEY `FKdla3edq8ccwyl7jtklkfsla6w` (`student_sid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SELECT * FROM sts.grades;
SELECT * FROM sts.student;

SELECT student.sid, student.sname, grades.studentgrade 
FROM sts.student ,sts.grades 
where student.gradeid=grades.gid;