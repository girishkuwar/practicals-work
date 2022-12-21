var fs = require('fs');

fs.appendFile('msg.txt','data to append in new file using javascript',function(err){
    if(err) throw err;
    console.log('saved!');});
    //same time
    var fs = require('fs');
    fs.appendFileSync('msg.txt','data to append new data');