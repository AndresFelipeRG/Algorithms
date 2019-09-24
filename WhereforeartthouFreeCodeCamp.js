function whatIsInAName(collection, source) {
  // What's in a name?
  var arr = [];
  // Only change code below this line
  let keys = Object.keys(source);
  arr = collection.filter((item)=> {
      return [...keys].reduce((acc, prop)=> {return acc && item.hasOwnProperty(prop) && item[prop] == source[prop]; }, true);
  });
  // Only change code above this line
  return arr;
}

whatIsInAName([{ first: "Romeo", last: "Montague" }, { first: "Mercutio", last: null }, { first: "Tybalt", last: "Capulet" }], { last: "Capulet" });
