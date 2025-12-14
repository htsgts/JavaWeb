console.log("\033[91m" + "Callback" + "\033[0m");

var fs = require("fs");
var http = require("http");

var data = fs.readFileSync("main.js");
console.log(data.toString());

http.createServer(function(request, response){
    response.writeHead(200, {"Content-Type": "text/html"});

    // Sync
    // var content = fs.readFileSync("main.js");
    // console.log(content.toString());
    // response.write("<h1>Read File OK</h1>");
    // response.write(content.toString());

    // Async
    fs.readFile("main.js", function(err, data){
        console.log(err);
        if(err) return console.error(err);
        console.log(data.toString());
    });

    console.log("응답을 완료하였습니다.")
    response.end("");
}).listen(10001);