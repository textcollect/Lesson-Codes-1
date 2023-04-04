// Do i need to have a return value
// This function is to get the inputs from the form for further process
// Print out the BMI

function submitInput()
{
    event.preventDefault();
    
    const weight = document.querySelector("#weight").value;
    const height = document.querySelector("#height").value;

    // Validate input - check for 0 division, check for empty fields

    // call the calculateBMI function to perform the calculation
    const getBMI = calculateBMI(weight, height); //passing in weight and height as the arguments

    console.log(getBMI);

    document.getElementById('message').innerText = `Your BMI is ${getBMI.toFixed(2)}`;


    // Scope concept
    // const and let are scoped
    if (weight == "") {
        // Block Scope
        console.log("Error");

        let sum = a + b; //cannot use sum outside of this block
        const test = "hello"; //cannot call test outside this block
        var name = "Jean"; //can use outside

        return sum;
    }

    
    
}