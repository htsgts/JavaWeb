function over(arg){
    arg.src = "./images/color.jpeg";
    arg.width = arg.width * 1.2;
    console.log("현재 이미지의 크기는 " + arg.width);
}

function out(arg){
    arg.src = "./images/grayscale.jpeg";
    arg.width = arg.width * 10 / 12;
}

function clck(arg){
    arg.width = "1000";
}

function dblclck(arg){
    arg.width = "600";
}