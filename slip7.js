var http = require('http');

http.createServer(function (req,res) {
    res.writeHead(200, {'Content-Type':'text/html'});
    res.write('<form action="fileupload" method="post" enctype="multipart/form-data">');
    res.write('<input type="file" name="fileuplaod"><br>');
    res.write('<input type="submit">');
    res.write('</form>');
    res.end;
}).listen(8050);
console.log("server running on 8050 port");
