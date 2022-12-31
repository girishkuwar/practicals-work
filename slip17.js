var express = require ('express');
const fs = require('fs');
var app = express();
var PORT = 3000;

var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended:false}));
app.get('/',function(req,res){
    const files = fs.createReadStream('slip17.html');
    res.writeHead(200,{'content-type':'text/html'});
    files.pipe(res);
});

app.post('/file-data',function(req,res){
    var name = req.body.id;
    res.download(name);
});

app.listen(PORT,function(err){
    if (err) console.log(err);
    console.log("Server Listening PORT ",PORT);
});
