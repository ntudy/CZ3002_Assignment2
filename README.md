# CZ3002_Assignment2

1. Download [MySQL](https://www.mysql.com/downloads/)
2. Download [Tomcat](https://tomcat.apache.org/download-90.cgi) 
3. Download [Eclipse](https://www.eclipse.org/downloads/)
4. Import Java project into Eclipse from **CZ3002.war**
5. Create MySQL database and insert test data:

```
mysql -u [your username] -p [your database] < CZ3002.sql
```
6. Change **src/db.properties** to your MySQL user, password and database.
7. Configure run time server to Tomcat.
8. Run project on Configured server.
9. Open http://localhost:8080/Assignment2 in browser.
10. Submit inserted test data or other data inserted by yourself.
```
Username: root
Password: root
```
