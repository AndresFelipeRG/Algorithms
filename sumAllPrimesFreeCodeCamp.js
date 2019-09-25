function sumPrimes(num) {
  let primes= [];
  for(let i = 2; i <= num; i++){
        let j = 1;
        let prime = true;
        while(j <= Math.sqrt(i)){
            if(i % j === 0 && j > 1){
                prime =false;
                break;
            }
            j++;
        }
        //console.log(i + ""+prime + Math.sqrt(i));
        if(prime){
          primes.push(i);
        }
       
  }
  
  let sum =  primes.reduce((acc, curr)=>{return acc + curr}, 0);
  console.log(sum);
  return sum;
}

sumPrimes(10);
sumPrimes(977);
