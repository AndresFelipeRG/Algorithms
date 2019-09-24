function destroyer(arr) {
  // Remove all the values
  let first = arguments[0];
  let elements = new Set([...arguments].slice(1, arguments.length));

  return first.filter((item)=>{return !elements.has(item);});
}

destroyer([1, 2, 3, 1, 2, 3], 2, 3);
