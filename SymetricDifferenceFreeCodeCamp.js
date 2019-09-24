function diffArray(arr1, arr2) {
  var newArr = [];
  let set1 = new Set(arr1);
  let set2 = new Set(arr2);
  for(let i of arr2){
    if(!set1.has(i)){
      newArr.push(i);
    }
  }
  for(let i of arr1){
    if(!set2.has(i)){
      newArr.push(i);
    }
  }
  // Same, same; but different.
  return newArr;
}

diffArray([1, 2, 3, 5], [1, 2, 3, 4, 5]);
