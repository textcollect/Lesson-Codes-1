// Some other functions/system/process may need to call the function to perform calculation and the function will need to return the result
// Business logics (set up at the backend)

// Create an arrow function to perform the calculation for BMI (e.g. Fat Index, Body Mass)

// All the const values
const bmiValue = 10000;

// create a function (arrow function) named calculateBMI
const calculateBMI = (weight, height) => {
    let bmi =  (weight / height / height) * bmiValue;
    return bmi;
};

// Add on functions for more calculations for Business Logics
