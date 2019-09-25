function fearNotLetter(str) {
  if(str.length == 0){
    return undefined;
  }
  let prev = str.charCodeAt(0);
  for(let i = 1; i < str.length; i++){
      let code = str.charCodeAt(i);
      if(code !== prev + 1){
        console.log(String.fromCharCode(prev + 1));
        return String.fromCharCode(prev + 1);
      }
      prev = code;
  }
  return undefined;
}

fearNotLetter("abce");
