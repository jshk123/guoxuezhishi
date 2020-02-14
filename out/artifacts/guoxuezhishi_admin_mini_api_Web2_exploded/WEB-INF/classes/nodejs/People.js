function People(name, sex, age) {
    this.name = name;
    this.sex = sex;
    this.age = age;
}

People.prototype.sayHello = function () {
    console.log("我是" + this.name + ",今年是一个" + this.age + "岁的" + this.sex + "同学！")
};

// exports.People = People;
module.exports = People;