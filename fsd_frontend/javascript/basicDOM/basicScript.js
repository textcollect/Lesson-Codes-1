// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Strict_mode
"use strict";

/* Multiple Lines Comment
Example of using DOM API and Document object with its methods and properties to manipulate the HTML elements on the webpage */

// Function will be called by an event(e.g. onClick event)

// without function, the script will be executed immediately when the browser launches

function editHTMLelements()
{
    debugger;

    // The scripts inside the function will be executed when the user clicks on the button

    // 1. using getElementById to find the HTML element
    document.getElementById('section1-intro').style.color="red";

    // 2. using tagname to find the HTML element
    // document.body.style.backgroundColor = "antiquewhite";

    // returns array(list) of tags with 'section' as the tag name
    // need tagname and index of the tag (index starts from 0)
    document.getElementsByTagName('section')[0].style.backgroundColor = "antiquewhite";

    // Change the font color of h3 tag with the content "This is another Heading 3 and this is going red color"
    document.getElementsByTagName('h3')[1].style.color = "red";

    // Change the content to "This H3 is changed by Javascript" hint - innertext
    document.getElementsByTagName('h3')[2].innerText = "This H3 is changed by Javascript";

    // 3. use classname to find the HTML elements
    document.getElementsByClassName('htmlElements')[0].style.fontSize = "24px";
    document.getElementsByClassName('htmlElements')[0].style.display = "none";


    // 4. use querySelector method provided by Browser to find the HTML elements
    // Has same structure/syntax as css to find an element in HTML
    document.querySelector('#section2-update > h3').style.color = "purple";


    let myString1 = "<div> <p> <i>This is changed by me</i> </p> </div>";
    document.querySelector('#section2-update > h3').innerHTML = myString1;



    document.querySelector('#myDiv').className = "changeStyle";

    document.querySelector('#section2-update > a').setAttribute("href", "https://www.w3schools.com");
    
    // alternate to previous
    document.querySelector('#section2-update > a').href = "https://www.w3schools.com";
    
}

function changeName()
{
    // 1. Get the value from the input box (e.g. to use the value property)
    // 2. Store the value into a variable (container) (e.g. let myName = ...)
    /* 
    let myName = document.querySelector('#username').value;
    console.log(myName);

    document.querySelector('#playerName > p').replaceWith("Welcome " + myName); 
    */

    // innerText alternative to previous
    //document.querySelector('#playerName > p').innerText = "Welcome " + myName;


    // Prompt
    let myName = prompt("What is your name?", "Jean Looi");
    console.log(myName);

    document.querySelector('#playerName > p').innerText = "Hello " + myName + "! How are you today";
}



// #######################################################################################################################################
// #######################################################################################################################################
// #######################################################################################################################################

// Exercise 2
function changeName2()
{
    let userName2 = document.querySelector("#userName2");
    let myButton = document.querySelector("button");

    let myName2 = prompt('What is your name?');

    if(!myName2) {
        changeName2();
    }
    else {
        localStorage.setItem('name', myName2);
        userName2.innerHTML = 'Hello, ' + myName2 + "! How are you today?";
    }
}

if (!localStorage.getItem('name')) {
    setUserName();
}
else {
    let storedName = localStorage.getItem('name');
    userName2.innerHTML = 'Hello, ' + storedName + "! How are you today?";
}



// #######################################################################################################################################
// #######################################################################################################################################
// #######################################################################################################################################

// Exercise 3
function exercise3()
{
    // 1. Change all of the list items font color with a class of “second” to red
    
    var red = document.querySelectorAll('.second');

    // loop over the elements using a for loop
    for (var i = 0; i < red.length; i++) {
        red[i].style.color="red";
    }


    // 2. Change the list item to bold with the class of third inside the ol tag
    document.querySelector('ol > .third').style.fontWeight="bold";
    
    // 3. Add the text “Hello World” with Heading 1 with an id of header
    document.getElementById('header').innerHTML = "<h1>Hello World</h1>";

    // 4. Create a new li element and give the new li with a text of “four”
    let new4 = document.createElement("li");
    new4.innerText = "four";

    // 5. Append the newly created li element to the ul element
    let ulappend = document.getElementsByTagName("ul")[0];
    ulappend.append(new4); // or ul.append.appendChild(new4)
    
    // 6. Remove the div with a class of footer
    document.getElementsByClassName('footer')[0].style.display="none";

    // alt to number 6
    // document.querySelector(".footer").remove();
}