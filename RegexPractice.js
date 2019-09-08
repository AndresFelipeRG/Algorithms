const matchAll = require('string.prototype.matchall');
matchAll.shim();
str = "ashdhdadda ajdad-b244 http://hello.world.com/dadjad-adna12313?&?%#https://helo133.ddaf.affa.world.com 12131441589hj$%#@#";
regex = /(?:http|https){1}(:\/\/)([0-9a-z-]+){1}(\.([0-9a-z-]+)){1,}(\/{0,1})/g;
console.log([...str.matchAll(regex)].map((arr)=>{return arr[0].replace(/http:\/\/|https:\/\//g, '');}));
