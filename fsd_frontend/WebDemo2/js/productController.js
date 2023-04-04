/*
Product Controller performs action to the products to be displayed

1. Display all products to be retrieved from the backend
2. Add product to the productlist (send the new project to the backend)
    - edit an existing product detail
    - remove an existing product from the product list
*/

// 1. Hardcode 5 product items - replace it later to be retrieved from the backend
// Product Details: name, desciption, imageURL, style, price
//image url: http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif

// 1) Create the onjects for the Products
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

// 2) Push the product objects into an array
const productList = [];
productList.push(product1, product2);

// 3) Display all products when user launch the product.html page
const displayProduct = () => {
    let display = "";

    for (let i = 0; i < productList.length; i++)
    {
        display += `
            <div class="col-lg-4">
                <div class="card" style="width: 18rem;">
                    <img src="${productList[i].imageURL}" class="card-img-top" alt="image">
                    <div class="card-body">
                        <h5 class="card-title">${productList[i].name}</h5>
                        <p class="card-text">${productList[i].style}</p>
                        <a href="#" class="btn btn-primary" data-toggle="modal" data-target="#productModal">More</a>
                    </div>
                </div>
            </div>
            `
    }

    document.querySelector("#row").innerHTML = display;

} //End of displayProduct fn

// Call displayProduct fn
displayProduct();