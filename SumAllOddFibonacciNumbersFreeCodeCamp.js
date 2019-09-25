

function sumFibs(num) {

  let arr = [1,1];
  if(num == 0){
    console.log(1);
    return 1;
  }
  if(num == 1){
    console.log(2);
        return 2;
  }
  for(let i = 2; i <= num; i++){
        let temp= arr[i-1]+arr[i-2];
        if(temp > num ){
          break;
        }
        arr.push(temp);
  }
  
 
  let sum = arr.reduce( (acc, curr) => {
                       if(curr %2 !== 0 ){
                         return acc + curr;
                       }
                       return acc;
                }, 0);
  
  console.log(sum);
  return arr;
}
sumFibs(1);
sumFibs(4);
sumFibs(10);
sumFibs(4000000);
sumFibs(75024);
sumFibs(75025);
