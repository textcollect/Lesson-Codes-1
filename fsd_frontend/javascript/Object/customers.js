/*
Requirements:
Admin needs to have a portal to display, add and search customer's name so that they can
perform their day-to-day operation to support the customers.

1. Display customer names tt is retrieved from the database (db) [hardcode customer in an array]
2. Add a new customer name into the array (send the new name to store in db)
3. Search for an existing customer's name in the array (Check if customer exists)
*/

const customerList = ["Tom", "Jerry", "Mary", "Peter", "Jenny"];

/*
1. Display customer names from an array when I click on the Display button

- NOT using the Form onSubmit default behaviour which submits the form for us
- Why: might beed to perform more actions to the inputs (e.g. validation, checks)


Steps:
1) Create a function to handle the form submission
2) Validate input to check 

Function displayNameForm
    Pass In: nothing

    if customerList array is not empty
        print customer names

    else
        print "No customer records found"


    Pass Out: nothing
End Function

*/

function displayNameForm() {
    if (customerList.length > 0) {
        document.querySelector("#output > p").innerHTML = customerList;
    }
    else {
        document.querySelector("#output > p").innerHTML = "No customer records found";
    }
}


/*
3) Search for an existing customer's name in the array

Function searchNameForm
    Pass In: nothing

    1. Initialise getName to empty string
    2. Get input from the searchName inputbox and store into getName

    if getName is equal to the array element (if customerList.includes(getName) == true)
        Print the customer name + " is in our customer list"
    else 
        Print the customer name + " is not in our customer list"



    Alternatively:
    3. Initialise isExist to false

    For customer counter less than customerList array length
        if getName is equal to the array element
            set isNameExist to true
            break
    End For loop


    if isNameExist is true
        Print the customer name + " is in our customer list"
    else 
        Print the customer name + " is not in our customer list"


    Pass Out: nothing

End Function
*/


// Create a common function to:
// 1) Pass in the name from the textbox
// 2) For Loop and check if name is equals to customerList element
// 3) return true/false to the calling function (whoever that call the common function)

/*
Function checkname
    Pass in: name

    Initialise isExist to false

    For customer counter less than customerList array length
        if getName is equal to the array element
            set isNameExist to true
            break
    End For loop


    Pass out: isNameExist
End function
*/

const checkName = (name) => {
    let isNameExist = false; //default to false

    for (let i = 0; i < customerList.length; i++) {
        if (name.toLowerCase() == customerList[i].toLowerCase()) {
            isNameExist = true;
            break; //go out of for loop
        }
    }

    return isNameExist; //return true/false
}


function searchNameForm() {
    const getName = document.querySelector("#searchName").value;

    const checkExist = checkName(getName);

    if (checkExist) {
        document.querySelector("#output > p").innerHTML = `${getName} is in our customer list`;
    }
    else {
        document.querySelector("#output > p").innerHTML = `${getName} is not in our customer list`;
    }
}

/*
String is an object provided by built-in browser with properties and methods
- property example: length
- methods example: 
*/

/*
2) Add a new customer name into the array

Function addNameForm
    Pass In: nothing

    Initialise getName to store the input text from the addName input box
    Initialise isExist to false

    For customer counter less than customerList array length
        if getName is equal to the array element
            set isNameExist to true
            break
    End For loop


    if isNameExist is true
        Print the customer name + " is already in our customer list. Cannot add the customer."
    else 
        Print the customer name + " is added to our customer list successfully"

    Pass Out: nothing
End function
*/

const addNameForm = () => {
    const getName = document.querySelector("#addName").value;
    
    const checkExist = checkName(getName);

    if (checkExist) { //isNameExist == true
        document.querySelector("#output > p").innerHTML = `${getName} is already in our customer list. Cannot add the customer.`;
    }
    else {
        document.querySelector("#output > p").innerHTML = `${getName} is added to our customer list successfully`;
    }
}


// ########################################################################
// ########################################################################
// ########################################################################
// ########################################################################
// ########################################################################
// ########################################################################

/*
(1) built-in objects from browser API: Array, Object, String, Math, Date
(2) Custom object: We build our own objects to store different group of values

Basic Objects
- Objects allows us to group values, useful for more complex data structures

- e.g. eCommerce developer: Product object, Customer Object, Payment object, etc

- A customer will have id, name, membership, totalSpending
(Get the object list from the db, use a for-loop to create all the customers)
*/

// Each customer is an individual object - created 4 objects
// Store all the objects into an array for easy access
const customer1 = {}; //empty object

const customer2 = {
    id: "a111",
    name: "Jean Looi",
    membership: "Gold",
    totalSpending: "3000"
};

const customer3 = {
    id: "a112",
    name: "Tom Tan",
    membership: "Premium",
    totalSpending: "2000"
};

const customer4 = {
    id: "a113",
    name: "Jerry Lim",
    membership: "Gold",
    totalSpending: "3500"
};

const customer5 = {
    id: "a114",
    name: "Anna Ann",
    membership: "Silver",
    totalSpending: "500"
};

const allCustomer = [];
allCustomer.push(customer2, customer3, customer4, customer5);

console.log(allCustomer);
//console.log(allCustomer[0].name)

/*
Display the customer list w the following structure:

Customer Name = Jean Looi, Membership = Gold, Total Spending for the Month = 3000
Customer Name = Tom Tan, Membership = Premium, Total Spending for the Month = 2000
Customer Name = Jerry Lim, Membership = Gold, Total Spending for the Month = 3500
Customer Name = Anna Ann, Membership = Silver, Total Spending for the Month = 500


*/

const displayCustomerForm = () => {
    let custList = displayList(allCustomer);

    document.querySelector("#customerList > p").innerHTML = custList;
}

/*
    let custList = "";

    for (let i = 0; i < allCustomer.length; i++) {
        
        custList += `
        Customer Name = ${allCustomer[i].name}, 
        Membership = ${allCustomer[i].membership}, 
        Total Spending for the Month = ${allCustomer[i].totalSpending}
        <br/>
        `;
    }

*/

// ########################################################################

// Filter
/*
Array filter method creates and return a new array w all the element(s) tt
pass the test (from the fn) when we call the filter method.

filter method req a fn as the argument and runs the function on each array element
*/

const filterCustomerMForm = () => {
    // Create an array tt contains just the filtered elements
    const filterMembership = allCustomer.filter(element => element.membership == "Gold");

    //const filterMembership = allCustomer.filter(checkMember); //returns array of elements (from allCustomer array) tt pass test from checkMember fn

    let custList = displayList(filterMembership);

    document.querySelector("#customerList > p").innerHTML = custList;
}


/*
function checkMember(element) 
{
    return element.membership == "Gold";
}
*/



// fn tt takes in the array to be used as parameter and returns the string on call
function displayList(custListArr) {

    // initialise variable as empty string
    // this will be what is returned on fn call
    let custList = "";

    for (let i = 0; i < custListArr.length; i++) {

        custList += `
        Customer Name = ${custListArr[i].name}, 
        Membership = ${custListArr[i].membership}, 
        Total Spending for the Month = ${custListArr[i].totalSpending}
        <br/>
        `;
    }
    return custList; //returns string with all the info
}


const filterCustomerSForm = () => {
    const filterSpending = allCustomer.filter(object2 => object2.totalSpending > 1000);
    
    let custList = displayList(filterSpending);
    document.querySelector("#customerList > p").innerHTML = custList;
}
// 1. Refactor above
// 2. filter cust w spending > 1000 when click on the button



// ########################################################################
// ########################################################################
// ########################################################################


/*
Alternative from instructor

// Common function
const displayCust = customerArr => {
    let custList = "";

    for (let i = 0; i < customerArr.length; i++) 
    {
        custList += `
        Customer Name = ${customerArr[i].name}, 
        Membership = ${customerArr[i].membership}, 
        Total Spending for the Month = ${customerArr[i].totalSpending}
        <br/>
        `;
    }

    //return custList;
    //usual way is to return the value back to the caller 
    //- meaning the line below this SHOULD NOT be here but in the function displayCustomerForm()
    
    document.querySelector("#customerList > p").innerHTML = custList;
}


function displayCustomerForm() {
    displayCust(allCustomer); //argument is array
}

function filterCustomerMForm() {
    // Create an array tt contains just the filtered elements
    const filterMembership = allCustomer.filter(element => element.membership == "Gold");

    // Alternative to above
    //const filterMembership = allCustomer.filter(checkMember); //returns array of elements (from allCustomer array) tt pass test from checkMember fn

    displayCust(filterMembership);
}
*/
