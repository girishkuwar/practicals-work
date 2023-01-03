var http = require('http');
var uc = require('upper-case');

http.createServer(function (req,res) {
    res.writeHead(200, {'Content-Type':'text/html'});
    res.write(uc.upperCase("hello-word"));
    return res.end;
}).listen(8050);
console.log("server running on 8080 port");
