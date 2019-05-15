# springMySql
sql:
CREATE TABLE `student` (
  `name` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

problem:
IDEA搭建mybatis项目之异常：java.io.IOException: Could not find resource mapping/UserMapper.xml
answer:
IDEA的Maven是不会编译src的java目录的xml文件，所以在Mybatis的配置文件中找不到xml文件！
pom中新增：
<build>
    <resources>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.xml</include>
            </includes>
        </resource>
    </resources>
</build>
