function convertHTML(str) {
  // &colon;&rpar;
  let m = { "&":"&amp;", "<":"&lt;", ">":"&gt;", '"':"&quot;" , "'":'&apos;'};
  let res = "";
  str.split("").map(
        (c)=>{
          if(m.hasOwnProperty(c)){
            res = res + m[c];
            return c;
          }
          else{
             res = res + c;
             return c;
          }
        }
  ).join("");
  console.log(res);
  return res;
}

convertHTML("Dolce & Gabbana");
convertHTML("Hamburgers < Pizza < Tacos");
convertHTML("Sixty > twelve");
convertHTML('Stuff in "quotation marks"');
convertHTML("Schindler's List");
