function spinalCase(str) {
  // "It's such a fine line between stupid, and clever."
  // --David St. Hubbins
  let re = /[A-Z]{0,1}[a-z]+/g;

  return ([...str.matchAll(re)].map((item)=>{return String(item).toLowerCase();}).join('-'));

}

spinalCase('ThisIsSpinalTap');
spinalCase("The_Andy_Griffith_Show");
spinalCase("Teletubbies say Eh-oh");spinalCase("AllThe-small Things");
