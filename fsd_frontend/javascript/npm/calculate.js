// This module/js is to perform calculation
// These functions are common function - reusable by other functions

const sum = (num1, num2) => num1 + num2;

//const subtract = (num1, num2) => num1 + num2; //wrong

const subtract = (num1, num2) => num1 - num2;

const multiply = (num1, num2) => num1 * num2;

const division = (num1, num2) => num1 / num2;

// Internal function that do not allow other js to access
const getName = () => "Jean";

// Export the functions for other js to use
module.exports = {sum, subtract, multiply, division};

