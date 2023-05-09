/*
    ProductController perform action to the products to be displayed

    (1) Display all products to be retrieved from the back-end
    (2) Add product to the product list (send the new project to the back-end)
    --- edit an existing product detail
    -- remove an existing product from the product list
*/

//(1) Hardcode 2 product items - replace it later to be retrieved from the back-end
//Product Details: name, description, imageURL, style, price
//image URL: http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif

//(1) Create the objects for the Products - replace it later to be retrieved from the back-end

//const product1 = {
//    name: "Dark T-Shirt 1",
//    description: "This is a cat print",
//    imageURL: "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif",
//    style: "Cat pattern",
//    price: 20.50
//}
//
//const product2 = {
//    name: "Light T-Shirt 1",
//    description: "This is a puppy print",
//    imageURL: "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif",
//    style: "Puppy pattern",
//    price: 20.50
//}
//
////(2) Push the product objects into an array
//const productController = [];
//productController.push(product1, product2);

//development APIs
const addAPI = 'http://localhost:8080/customer/add';
const displayAPI = 'http://localhost:8080/customer/all';

// Initialise an empty array that will be used to store the data received from displayAPI ('/all' api)
let customerController = [];

function displayCustomer() {

    //fetch data from database using the REST API endpoint from Spring Boot
    // GET http method is the default, so no need to specify the specifics for GET
    fetch(displayAPI)
        .then((resp) => resp.json())
        .then(function (data) {
            console.log("2. receive data")
            console.log(data);

            data.forEach(function (customer, index) {
                const customerObj = {
                    id: customer.id,
                    name: customer.name,
                    mobile: customer.mobile                    
                };

                // this array contains 5 items from the db(received via the '/all' API)
                customerController.push(customerObj);
            });

            // calls the function to display all the 5 objects from the customerController array
            // function is declared below
            renderCustomerPage();
        })
        .catch(function (error) {
            console.log(error);
        });
}


//(3)  Display all customers when user launch the customer.html page
//const displayProduct = () => {
function renderCustomerPage() {

    let display = "";
    
    display += `
            <table class="table table-bordered table-sm">
                <thead>
                    <tr class="table-success">
                        <th style="text-align: center;">Name</th>
                        <th style="text-align: center;">Mobile</th>
                    </tr>
                </thead>
                <tbody>`;
            //         <tr>
            //             <td>John</td>
            //             <td>12345678</td>
            //         </tr>
            //         <tr>
            //             <td>Alan</td>
            //             <td>01234567</td>
            //         </tr>
            //     </tbody>
            // </table>`;

    for (let i = 0; i < customerController.length; i++) {
        display += `
        <tr>
                    <td>${customerController[i].name}</td>
                    <td>${customerController[i].mobile}</td>
                </tr>`;
    }

    // Close the table
    display += `</tbody></table>`;

    document.querySelector("#customer-table").innerHTML = display;

} //End of renderCustomerPage function


//4) Add new product to the product list when user clicks on the submit button from the productform.html
// function addProduct(n, d, i, s, p) {

//     //The parameters will be sent in from another function through the arguments
//     /*
//     1) Construct/Create the object
//         property: value
//     */
//     const productItem = {
//         name: n,
//         description: d,
//         imageURL: i,
//         style: s,
//         price: p
//     }

//     productController.push(productItem);
// }

//4) Add new product to the product list when user clicks on the submit button from the productform.html
function addCustomer(name, mobile) {
    
    // formData is an Object provided by the Browser API for us to send the data over to the backend
    // Make sure names in the append matches the names from the ItemController java
    // no need to match sequence
    const formData = new FormData();
    formData.append('name', name);
    formData.append('mobile', mobile);

    // Call the addAPI
    fetch(addAPI, {
        method: 'POST',
        body: formData
    })
        .then(function (response) {
            console.log(response.status); // Will show you the status - 200 OK, 500, 404
            if (response.ok) {
                alert("Successfully Added Customer!")
                
                // Refresh the page
                window.location.reload()

                // Alternatively, can call the display function again
                //displayCustomer()
            }
            else {
                alert("Something went wrong. Please try again")
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Error adding customer")
        });
}






