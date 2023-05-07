// Global variable - to store the image object
let storeImage = ""

/*
When user clicks on 'Save Item':
1. store all the inputs into variables
2. do validation
3. calls a function from the productController.js to access the API to add items to the database
*/

//Add an 'onsubmit' event listener for productform to add a product
newCustomerForm.addEventListener('submit', (event) => {

    // Prevent default action of the Form submission
    event.preventDefault();

    // Select the inputs
    const name = document.querySelector('#modalNewName').value;
    const mobile = document.querySelector('#modalNewMobile').value;

    /*
        Do the Validation code here
    */

    // 3. calls a function from the customerController.js to access the API to add items to the database
    addCustomer(name, mobile);

    
});