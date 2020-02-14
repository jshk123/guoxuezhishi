//服务器
var http = require("http");
//读取文件
var fs = require("fs");

var server = http.createServer(function (req, res) {
    res.setHeader('Content-Type', 'text/palin; charset=utf-8');
    if (req.url == "/") {
        res.end("首页");
    } else if (req.url == "/music") {
        res.end("音乐频道");
    } else if (req.url == "/news") {
        res.end("新闻频道");
    } else if (/^\/student\/[\d]{6}$/.test(req.url)) {
        //正则
        var reg = /\/student\/([\d]{6})/;
        var xuehao = reg.exec(req.url)[1];
        //读取文本文件
        fs.readFile("./db.json", function (err, data) {
            if (err) {
                res.end("文件读取失败");
                return;
            }
            //转为对象
            var dataObj = JSON.parse(data.toString())
            //判断学号是否存在
            if (!dataObj.hasOwnProperty(xuehao)) {
                res.end("无此学号学生信息！");
                return;
            }
            console.log(dataObj);
            res.write("<h1>学生的学号为：" + xuehao + "</h1>");
            res.write("<h2>姓名：" + dataObj[xuehao]["xingming"] + "</h2>");
            res.write("<h2>语文：" + dataObj[xuehao]["yuwen"] + "</h2>");
            res.write("<h2>数学：" + dataObj[xuehao]["shuxue"] + "</h2>");
            res.end("");
        });

    }
    else {
        res.end("没有此页面");
    }
});
server.listen(3000);
console.log("nodejs start listen 3000 port!");
//正则
var str = "我今年12岁明年13岁后年14岁，就可以买iphone14了！";
var reg = /(\d+)岁/g;
var result;
while (result = reg.exec(str)) {
    console.log(result);
}
;
