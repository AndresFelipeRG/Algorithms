function pairElement(str) {
  const pairs = {"A":"T", "T":"A", "C":"G","G":"C" };
  let arr = [];
  for(let i = 0; i < str.length; i++){
      arr.push([str.charAt(i), pairs[str.charAt(i)]]);
  }
  console.log(arr);
  return arr;
}

pairElement("GCG");
