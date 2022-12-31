var mysql = require('mysql');

var con = mysql.createConnection({
  host : 'localhost', 
  user : 'root', 
  password : ''
});

con.connect(function (err){
  if (err) throw err;
  console.log('connected');
  
  con.query('CREATE DATABASE inventory', function(err, result){
  if (err) throw err;
  else {
    console.log('Database Created');
    con.query('use inventory');
    var sql = 'CREATE TABLE customer (cid INT , cname VARCHAR(25) ,  phone INT(10) , city VARCHAR(25))';
    con.query(sql, function (err, result){
        if (err) throw err;
        console.log('Table Created');
    });
  }

  });
});


