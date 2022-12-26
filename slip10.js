var mysql = require('mysql');

var con = mysql.createConnection({

 host: "localhost",
 user: "admin",
 password: "root@123",
 database: "mydatabase"
});
con.connect(function(err) {
 if (err) throw err;
 console.log("Connected!!");
 var sql = "INSERT INTO student VALUES (11,'Reema','Dange Chowk'),(12,'Tina','wa
kad'),(13,'Rina','pimpri')";
 con.query(sql, function (err, result, fields) {
 if (err) throw err;
 console.log("3 record inserted");
 });
});