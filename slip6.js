var http = require('http');
var fs = require('fs');
http.createServer(function (req,res){
    fs.open('ex.txt',function(err, fd) {
        if(err){
            console.error(err);
            return res.end('404 not found');
        }
        else{
            console.log('file opened succesfully');
            fs.readFile('ex.txt', function(err,data){
           
                if(!err){
                    console.log('success');
                    res.end(data);
                    fs.close(fd);
                }
            });
        }
    })
}).listen(8080);
