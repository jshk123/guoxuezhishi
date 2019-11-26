var solarLunar = require("solarLunar");
var solar2lunarData = solarLunar.solar2lunar(2015, 10, 8); // 输入的日子为公历
var lunar2solarData = solarLunar.lunar2solar(2015, 8, 26); // 输入的日子为农历
console.log(solar2lunarData);