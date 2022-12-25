var http = require('http');
var fs = require('fs');

var server = http.createServer(function (req,res){
    fs.open('ex.txt','r+', function(err, fd) {
        if(err){
            console.log(err);
            return res.end('404 not found');
        }
        else{
            console.log('file opened succesfully');
            fs.readFile('ex2.txt', function(err,data){
                if(!err){
                    console.log('success');
                    res.end(data);
                }
            });
        }
    })
})
server.listen(8080);
