// Import the functions from the calculate.js into this test

// Using Jest to test: npm install --save-dev jest
// https://jestjs.io/docs/getting-started

// calculate is the object that we created to access the functions
// exported from the calculate.js

const calculate = require('./calculate');


//sum, subtract, multiply, division

/*
test is an object provided by jest framework to perform the
unit testing for the function/class that we created

test object needs to take in 2 arguments:
    1. a short description on the test
    2. a function with the test case: expect(functionName).matcher(output)
*/

// test cases

test("sum 2 + 3 is 5", () => 
{
    expect(calculate.sum(2,3)).toBe(5);
});

test("subtract 5+2 is 3", () =>
{
    expect(calculate.subtract(5,2)).toBe(3);
});