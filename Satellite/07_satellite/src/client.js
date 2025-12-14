var http = require("http");

// HttpRequest Open
var option = {
    host: 'localhost',
    port: '10001',
    path: '/index.html'
}

// Callback 함수
var callback = function(res){
    // response event data 발생 시 데이터를 받음
    var content = '';
    res.on('data', function(data){
        content += data;
    });

    res.on('end', function(){
        console.log("Receiving Completed");
        console.log(content);
    });
}

var request = http.request(option, callback);
request.end();
