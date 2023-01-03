var http = require('http');
var fs = require('fs');

var server = http.createServer(function(req,res){
    res.writeHead(300,{'content-Type':'text/html'});
    var myreadstream = fs.createReadStream(__dirname + '/index.html', 'utf8');

    //  create index.html with some code in same folder

    myreadstream.pipe(res);
});

server.listen(3000);
console.log('port running on 3000');