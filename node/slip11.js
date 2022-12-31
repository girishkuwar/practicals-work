var mysql = require('mysql');

var con = mysql.createConnection({

 host: "localhost",
 user: "admin",
 password: "root@123",
 database: "mydatabase"
});
con.connect(function(err) {
 if (err) throw err;
 var sql = "DELETE FROM customer WHERE cid=3";
 con.query(sql, function (err, result) {
 if (err) throw err;
 console.log("Number of records deleted: "+result.affectedRows);
 });
});
