//引入mongodb
var MongoClient = require('mongodb').MongoClient;

//mongodb的端口号和数据库名字，如果数据库不存在会被创建
var dburl = 'mongodb://localhost:27017/xuesheng';

//连接数据库
MongoClient.connect(dburl, function (err, db) {
    if (err) {
        console.log("数据库连接失败，请mongod");
        return;
    }
    console.log("数据库连接成功");
});