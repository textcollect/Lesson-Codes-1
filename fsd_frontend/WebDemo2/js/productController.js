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

const displayDetails = index => {
    
    //When user clicks on any "More" button, the details of the selected product will be displayed
    document.querySelector("#modalName").innerHTML = productList[index].name;
    document.querySelector("#modalDesc").innerHTML = productList[index].description;
    document.querySelector("#modalImg").src = productList[index].imageURL;
    document.querySelector("#modalStyle").innerHTML = productList[index].style;
    document.querySelector("#modalPrice").innerHTML = productList[index].price;
}

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
                        <a id="item${i+1}" href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#productModal" onClick="displayDetails(${i})">More</a>
                    </div>
                </div>
            </div>
            `
    }

    document.querySelector("#row").innerHTML = display;
} //End of displayProduct fn



// 4) Add product to product list when user clicks on the submit button from productform.html
// Add product fn
const addProduct = (prdtName, prdtDescription, prdtImageURL, prdtStyle, prdtPrice) => {
    /*
    The parameters will be sent in from another fn thru the arguments
    1. Construct/Create the product
        property: value (apparently standard is to use same name for both i.e. parameters same names as object properties)
    */

    const productItem = {
        name: prdtName,
        description: prdtDescription,
        imageURL: prdtImageURL,
        style: prdtStyle,
        price: prdtPrice
    }

    productList.push(productItem);
}

//The individual property value are sent in thru the argument - need to refactor when have productForm.html
addProduct("Blue T-shirt", "This is a blue T-Shirt", "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif", "Flower print", 35);
addProduct("Red T-shirt", "This is a red T-Shirt", "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif", "Flower print", 25);
addProduct("White T-shirt", "This is a white T-Shirt", "http://www.jennybeaumont.com/wp-content/uploads/2015/03/placeholder.gif", "Flower print", 40);



// Call displayProduct fn
displayProduct();