var http = require('http');
var port = 8050;
http.createServer(function (req,res) {
    res.writeHead(200, {'Content-Type':'text/html'});
    res.write('<form action="fileupload" method="post" enctype="multipart/form-data">');
    res.write('<input type="file" name="fileuplaod"><br>');
    res.write('<input type="submit">');
    res.write('</form>');
    res.end;
}).listen(port);
console.log("server running on "+port+" port");