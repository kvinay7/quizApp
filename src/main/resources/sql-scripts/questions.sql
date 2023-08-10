CREATE DATABASE  IF NOT EXISTS `ques_data`;
USE `ques_data`;

DROP TABLE IF EXISTS `questions`;

CREATE TABLE `questions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category`varchar(20) DEFAULT NULL,
  `difficultylevel` varchar(20) DEFAULT NULL,
  `question_title` varchar(1000) DEFAULT NULL,
  `right_answer` varchar(1000) DEFAULT NULL,
  `option1` varchar(1000) DEFAULT NULL,
  `option2` varchar(1000) DEFAULT NULL,
  `option3` varchar(1000) DEFAULT NULL,
  `option4` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

insert into questions(id, category, difficultylevel, question_title, right_answer, option1, option2, option3, option4)
values(
	1, 
    'Java',
    'Easy',
	'What is a correct syntax to output "Hello World" in Java?',  
    'System.out.println("Hello World")',
	'echo "Hello World"',
	'printf("Hello World")',
	'System.out.println("Hello World")',
    'print("Hello World")'
);
    