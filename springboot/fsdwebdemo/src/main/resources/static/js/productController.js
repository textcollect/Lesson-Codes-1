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

const product1 = {
    name: "Dark T-Shirt 1",
    description: "This is a cat print",
    imageURL: "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif",
    style: "Cat pattern",
    price: 20.50
}

const product2 = {
    name: "Light T-Shirt 1",
    description: "This is a puppy print",
    imageURL: "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif",
    style: "Puppy pattern",
    price: 20.50
}

//(2) Push the product objects into an array
const productList = [];
productList.push(product1, product2);



function displayDetails(index) {
   //When user clicks on any "More" button, the details of the selected product will be displayed
    document.querySelector("#modalName").innerHTML =  productList[index].name;
    document.querySelector("#modalStyle").innerHTML =  productList[index].style;
    document.querySelector("#modalPrice").innerHTML =  productList[index].price;
    document.querySelector("#modalImg").src =  productList[index].imageURL;


    //launch the productDetail page
    //productList[index] pass it to the productDetail page to display
    //session storage
}


//(3)  Display all products when user launch the product.html page
//const displayProduct = () => {
function displayProduct() {

    let display = "";

    for (let i = 0; i < productList.length; i++ ) {

        display += `
            <div  class="col-lg-4">
            <div class="card" style="width: 18rem;">
                <img src=${productList[i].imageURL} class="card-img-top"
                    alt="image">
                <div class="card-body">
                    <h5 class="card-title">${productList[i].name}</h5>
                    <p class="card-text">${productList[i].style}</p>
                    <a id="item${i+1}" href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#productModal" onClick="displayDetails(${i})">More</a>
                </div>
            </div>
        </div>
        `
    }

    document.querySelector("#row").innerHTML= display;

} //End of displayProduct function


//4) Add new product to the product list when user clicks on the submit button from the productform.html
function addProduct(n, d, i, s, p) {

    //The parameters will be sent in from another function through the arguments
    /*
    1) Construct/Create the object
        property: value
    */
    const productItem = {
        name: n,
        description: d,
        imageURL: i,
        style: s,
        price: p
    }

    productList.push(productItem);

}

//Hardcoded now: The individual propery value are sent in through the argument - later we need to refactor when we have the productForm.html
addProduct("Blue T-Shirt", "This is a blue T-Shirt", "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif", "Flower print", 35);

addProduct("Red T-Shirt", "This is a red T-Shirt", "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif", "Flower print", 25);

addProduct("White T-Shirt", "This is a white T-Shirt", "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif", "Flower print", 40);

displayProduct();





