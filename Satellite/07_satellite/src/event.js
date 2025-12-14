// event 모듈 require
var events = require("events");
console.log("Event Example Start!!");

// 이벤트 발생기 EventEmitter 생성
var EventEmitter = new events.EventEmitter();

// 이벤트 처리 함수
var goHome = function(){
    console.log("이제 집에 가야할 시간");

    EventEmitter.emit("arriveNow");
}

// goHomeNow 이벤트 발생 시 goHome을 시전
EventEmitter.on("goHomeNow", goHome);

// 함수 직접 설정 가능
EventEmitter.on("sleepNow", function(){
    console.log("아무 걱정없이 지구에 나를 내려놓으십시오.");
});

EventEmitter.on("arriveNow", function(){
    console.log("순식간에 집 도착");
});

for(let i=0; i<10; i++){
    EventEmitter.emit("goHomeNow");
    EventEmitter.emit("sleepNow");
}