var http = require('http');

var dt = require('./modules');

// find module.js and paste in same folder

http.createServer(function (req,res) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    const result = dt.datetime();
    res.write('Current Date And time is');
    res.write('<br/>');
    res.write(result);
    res.end();
}).listen(5050);
