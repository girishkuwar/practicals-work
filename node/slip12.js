var http=require('http');
var server = http.createServer(function(req , res )
{
    res.writeHead(300,{'content-Type':'text/html'});
    res.write('Hello Node JS');
    return res.end();
});
server.listen(7000);
console.log("7000 port");
