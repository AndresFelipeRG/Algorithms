function uniteUnique(arr) {
  let s = new Set();
  let newArr = [];
  
  [...arguments].map((item)=> {
         
          item.map((elem)=>{
          if(!s.has(elem)){
              s.add(elem);
              newArr.push(elem);
          }
          return elem;
          });
          return item;
        
  });
  console.log(newArr);
  return newArr;
}
