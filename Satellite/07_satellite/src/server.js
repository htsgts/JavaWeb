var http = require("http");
var fs = require("fs");
var url = require("url");

console.log("Server Program Start");

// Create Server
http.createServer(function(request, response){
    console.log(request.url);
    var pathName = url.parse(request.url).pathname;
    console.log("pathName : " + pathName);

    // Root 접속 시 index.html로 세팅
    if(pathName == "/"){
        pathName = "/index.html";
    }

    // ReadFile
    fs.readFile(pathName.substring(1), function(err, data){
        if(err){
            console.log(err);
            response.writeHead(404, {"Content-Type": "text/html"});
            //response.write("야 이거 없는 파일이야");
        }
        else {
            response.writeHead(200, {"Content-Type": "text/html; charset=utf-8"});
            // 읽은 내용을 Body에 기술
            response.write(data.toString());
        }
        response.end("");
    });
}).listen(10001);