var mysql = require('mysql');

var con = mysql.createConnection({

 host: "localhost",
 user: "admin",
 password: "root@123",
 database: "mydatabase"
});
con.connect(function(err) {
 if (err) throw err;
 con.query("CREATE TABLE customer(cid int(10) primary key, cname varchar(50), ca
dd varchar(60));", function (err, result, fields) {
 if (err) throw err;
 console.log("Table created!!!");
 });
});
