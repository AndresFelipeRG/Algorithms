function translatePigLatin(str) {
  const vowels = new Set(['a', 'e', 'i', 'o', 'u']);
  let result = str.toLowerCase();
  if(vowels.has(result.charAt(0))){
     
     return result+"way";
  }
  let temp = result.split("");
  let end = "";
  let front = "";
  for(let i = 0; i < temp.length; i++){
    if(!vowels.has(temp[i])){
        
        end = end + temp[i];
        i++;
        while(!vowels.has(temp[i]) && i < temp.length){
            
             end = end + temp[i];
             i++;
        }
        end = end + "ay";
        front = front + temp.slice(i, temp.length).join("");
        break;
    }
    else {
       front = front + temp[i];
    }
  }
  result = temp.join("");
  console.log(front+end);
 
  return front + end;
}

translatePigLatin("ttttt");
translatePigLatin("california");
translatePigLatin("algorithm");
translatePigLatin("glove");
