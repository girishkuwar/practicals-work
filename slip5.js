var http = require('http');
var fs = require('fs');
var formidable = require('formidable');

http.createServer(function (req,res){
    if(req.url=='/'){
    res.writeHead(200,{'content-type':'text/html'});
    res.write('<form action="fapp" method="post" enctype="multipart/form-data">');
    res.write('<h1>Select two files</h1>');
    res.write('<input type="file" name="rf"><br>');
    res.write('<input type="file" name="wf"><br>');
    res.write('<input type="submit">');
    res.write('</form>');
    res.end;
    }
    else if (req.url=='/fapp'){
        var form = new formidable.IncomingForm();
        form.parse(req,function(err,fields,files){
            if(!err){
                var w = fs.createWriteStream(files.wf.name,{flags:'a'});
                
                var r = fs.createReadStream(files.rf.name);

                w.on('close',function(){
                    console.log('writing Done');
                });

                r.pipe(w);
                res.write(files.rf.name);
                res.end("appended Successfully");
            }
            else{res.write("error in writing");}
        });
    }
    else{
        res.end("Page Not Found");
    }
}).listen(5050);
