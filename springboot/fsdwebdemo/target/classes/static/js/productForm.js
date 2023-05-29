// Global variable - to store the image object
let storeImage = ""

/*
When user clicks on 'Save Item':
1. store all the inputs into variables
2. do validation
3. calls a function from the productController.js to access the API to add items to the database
*/

//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {

    // Prevent default action of the Form submission
    event.preventDefault();

    // Select the inputs
    const name = document.querySelector('#newItemNameInput').value;
    const description = document.querySelector('#newItemDescription').value;

    // Browser security will not be able to track/store the actual path of where you choose your image
    //will instead provide a random path
    // Here, we are replacing the fakepath(C:\fakepath\) with empty path("")
    const imageUrl = document.querySelector('#newItemImageFile').value.replace("C:\\fakepath\\", "");

    const style = document.querySelector('#newItemStyle').value;
    const price = document.querySelector('#newItemPrice').value;


    /*
        Do the Validation code here
    */


    // 3. calls a function from the productController.js to access the API to add items to the database
    addProduct(name, description, imageUrl, style, price, storeImage);

});


// select file input
const input = document.querySelector('#newItemImageFile');

// add event listener
input.addEventListener('change', () => {

    // store inside storeImage variable the files to be uploaded
    storeImage = input.files[0]; //array of files to access
});
