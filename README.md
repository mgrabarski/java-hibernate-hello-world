# Hibernate Hello World!

### Setup:
First need to be load database from world_x.sql file.

In pom.xml must be include correct credentials for database:

```xml
<property name = "hibernate.connection.url">
            jdbc:mysql://localhost:3306/world_x?verifyServerCertificate=false&amp;useSSL=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC
</property>

<property name = "hibernate.connection.username">
	root
</property>

<property name = "hibernate.connection.password">
	password
</property>
```

Using other database then MySQL need to be included correct config:
```xml
<property name = "hibernate.dialect">
            org.hibernate.dialect.MySQLDialect
</property>

<property name = "hibernate.connection.driver_class">
	com.mysql.jdbc.Driver
</property>
```
        
 # Notes

 SessionFactory is heavy object. Best practice is create one object per application live. 
 ```java
 SessionFactory factory = new Configuration().configure().buildSessionFactory();
 ```
 
 Tell hibernate that class is map model for database table:
 ```java
 @Entity
 @Table(name = "city")
 public class City
 ```
 
 Annotation for primary key from table:
 ```java
 @Id // primary key
 @GeneratedValue(strategy = GenerationType.) // set strategy how id is generating
 @Column(name = "ID")
 private int id;
 ```
 
 Map field as column:
 ```java
 @Column(name = "Name")
 ```
 