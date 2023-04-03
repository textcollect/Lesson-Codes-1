// Practice 1
// Q1
function printText() {
    console.log("Hello World");
}
printText();

// Q2
/*
1. Where do we get the numbers to add?
    - e.g. from the User (input text), from the backend (database)
2. Is the numbers to be added dynamic/change?
*/

// Global Scope - Any js files, functions, Class, block-scope, can use the variables
let num1 = 10;
let num2 = 5;

const PI = Math.PI;
const interestRate = 0.05; // from the backend (database)

const addNum = (number1, number2) => number1 + number2;
console.log(addNum(num1, num2));

const printLength2 = (word) => {
    return console.log(`word length: ${word.length}`);
};
//const word2 = prompt(`Please enter word here`);
//printLength2(word2);


const printWord = (word) => {
    return word.length;
}
console.log(printWord("test"))


// Practice 3
/*
1. Which variable(s) is dynamic - get from user? From the backend (database)?
 - transaction amount - get from the user input
 - fee & interest - get from database
2. How many parameter(s) does the function require? 3 parameters
*/

// Hardcode values into variables
const interest = 0.01, fee = 3;
let transactionPrice = 100;

// Create the function to calculate the total cost 
const calculateCost = (interest, fee, price) => {
    const payment = price + (price * interest) + fee;
    return payment;
}

let calCost = calculateCost(interest, fee, transactionPrice);

// Display the total cost to the front-end
console.log(`Maris's transaction cost is $${transactionPrice}, and she needs to pay $${calCost}`);



// Exercise #2
const printNames = (name1, name2, name3) => console.log(`Welcome, ${name1}, ${name2}, ${name3}`);

printNames("Eddy", "John", "Peter");



// Exercise #3 - Puppy Age Calculator
const converter = 7; //retrieve from database
let puppyAge = 2; //input from user from front-end

const calculateDogAge = (converter, puppyAge) => converter * puppyAge;

console.log(`Your doggie is ${calculateDogAge(converter, puppyAge)} years old in human years!`);


// Exercise #4
let radius = 5; //Input from user from front-end

const calcCircumference = radius => Math.PI * 2 * radius;
const calcArea = radius => Math.PI * radius ** 2;

const getCalc1 = calcCircumference(radius).toFixed(2);
const getArea = calcArea(radius).toFixed(2);

console.log(`The circumference is ${getCalc1}`);
console.log(`The area is ${getArea}`);
