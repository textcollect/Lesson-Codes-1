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

// Development APIs
// const addAPI = 'http://localhost:8080/item/add';
// const displayAPI = 'http://localhost:8080/item/all';

// Production APIs
const addAPI = 'https://webdemonewtp.azurewebsites.net/item/add';
const displayAPI = 'https://webdemonewtp.azurewebsites.net/item/all';


// Initialise an empty array that will be used to store the data received from displayAPI ('/all' api)
let productController = [];

function displayItem() {

    //fetch data from database using the REST API endpoint from Spring Boot
    // GET http method is the default, so no need to specify the specifics for GET
    fetch(displayAPI)
        .then((resp) => resp.json())
        .then(function (data) {
            console.log("2. receive data")
            console.log(data);

            data.forEach(function (item, index) {
                const itemObj = {
                    id: item.id,
                    name: item.name,
                    description: item.description,
                    imageUrl: item.imageUrl,
                    style: item.style,
                    price: item.price
                };
                // this array contains 12 items from the db(received via the '/all' API)
                productController.push(itemObj);
            });
            // calls the function to display all the 12 objects from the productController array
            // function is declared below
            renderProductPage();
        })
        .catch(function (error) {
            console.log(error);
        });
}


function displayDetails(index) {
    //When user clicks on any "More" button, the details of the selected product will be displayed
    document.querySelector("#modalName").innerHTML = productController[index].name;
    document.querySelector("#modalStyle").innerHTML = productController[index].style;
    document.querySelector("#modalPrice").innerHTML = productController[index].price;
    document.querySelector("#modalImg").src = productController[index].imageUrl;


    //launch the productDetail page
    //productController[index] pass it to the productDetail page to display
    //session storage
}


//(3)  Display all products when user launch the product.html page
//const displayProduct = () => {
function renderProductPage() {

    let display = "";

    for (let i = 0; i < productController.length; i++) {

        display += `
            <div  class="col-lg-4">
            <div class="card" style="width: 18rem;">
                <img src=${productController[i].imageUrl} class="card-img-top"
                    alt="image">
                <div class="card-body">
                    <h5 class="card-title">${productController[i].name}</h5>
                    <p class="card-text">${productController[i].style}</p>
                    <p class="card-text">${productController[i].description}</p>
                    <a id="item${i + 1}" href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#productModal" onClick="displayDetails(${i})">More</a>
                </div>
            </div>
        </div>
        `
    }

    document.querySelector("#row").innerHTML = display;

} //End of renderProductPage function


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
function addProduct(name, description, imageUrl, style, price, imageObject) {
    
    // formData is an Object provided by the Browser API for us to send the data over to the backend
    // Make sure names in the append matches the names from the ItemController java
    // no need to match sequence
    const formData = new FormData();
    formData.append('name', name);
    formData.append('description', description);
    formData.append('imageUrl', imageUrl);
    formData.append('style', style);
    formData.append('price', price);
    formData.append('imagefile', imageObject);

    // Call the addAPI
    fetch(addAPI, {
        method: 'POST',
        body: formData
    })
        .then(function (response) {
            console.log(response.status); // Will show you the status - 200 OK, 500, 404
            if (response.ok) {
                alert("Successfully Added Product!")

                // Refresh the page
                window.location.reload()
            }
            else {
                alert("Something went wrong. Please try again")
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            alert("Error adding item to Product")
        });
}






