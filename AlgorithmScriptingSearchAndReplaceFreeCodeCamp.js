function myReplace(str, before, after) {
  let arr  = str.split(" ");
  arr = arr.map((s)=>  {
      if(s.toLowerCase() === before.toLowerCase()){
        if(s.charAt(0) === s.charAt(0).toUpperCase()){
            
             return after.charAt(0).toUpperCase() + after.substring(1);
        }
        return   after.charAt(0).toLowerCase() + after.substring(1);

      }
      return s;
  }).join(" ");
  console.log(arr);
  return arr;
}

myReplace("A quick brown fox jumped over the lazy dog", "jumped", "leaped");
myReplace("Let us get back to more Coding", "Coding", "algorithms");
myReplace("His name is Tom", "Tom", "john");

myReplace("This has a spellngi error", "spellngi", "spelling");
myReplace("He is Sleeping on the couch", "Sleeping", "sitting");
