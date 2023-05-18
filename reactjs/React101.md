** React
<2023-05-15 Mon>

- ReactJS is an open-source JavaScript library that is used for building user interfaces in a declarative and efficient way.

- It is a component-based front-end library responsible only for the view layer of an MVC (Model View Controller) architecture. React is used to create modular user interfaces and it promotes the development of reusable UI components that display dynamic data.

- Note: React is not a framework. It is just a library developed by Facebook to solve some problems that we were facing earlier.

### Props
Every component has something called `props`.

A component’s `props` is an object. It holds information about that component.

To access a component’s `props` object, you can reference the `props` object and the dot notation for its properties.

To take advantage of props, we need to pass information to a React component. How do we pass `props`? By giving the component an attribute:
#+begin_src javascript
<Greeting name="Jamel" />
#+end_src

Let’s say that you want to pass a component the message, "We're great!". Here’s how you can do it:
#+begin_src javascript
<SloganDisplay message="We're great!" />
#+end_src

As you can see, to pass information to a component, you need a name for the information that you want to pass.

In the above example, we used the name `message`. You can use any name you want.

If you want to pass information that isn’t a string, then wrap that information in curly braces. Here’s how you would pass an array:
#+begin_src javascript
<Greeting myInfo={["Astronaut", "Narek", "43"]} />
#+end_src

In this next example, we pass several pieces of information to `<Greeting />`. The values that aren’t strings are wrapped in curly braces:
#+begin_src javascript
<Greeting name="The Queen Mary" city="Long Beach, California" age={56} haunted={true} />
#+end_src

Props allow us to customize the component by passing it information.

We’ve learned how to pass information to a component’s props object. You will often want a component to display the information that you pass.

To make sure that a function component can use the props object, define your function component with props as the parameter:
#+begin_src javascript
function Button(props) {
  return <button>{props.displayText}</button>;
}
#+end_src

In the example, props is accepted as a parameter, and the object values are accessed with the dot notation accessors pattern (object.propertyName).

Alternatively, since props is an object, you can also use the destructuring syntax like so:
#+begin_src javascript
function Button({displayText}) {
  return <button>{displayText}</button>;
}
#+end_src

You have learned how to pass a `prop` to a component:
#+begin_src javascript
<Greeting firstName="Esmerelda" />
#+end_src

You have also learned how to access and display a passed-in `prop`:
#+begin_src javascript
render() {
  return <h1>{props.firstName}</h1>;
}
#+end_src

The most common use of `props` is to pass information to a component from /a different component/.

Props in React travel in a one-way direction, from the top to bottom, parent to child.

Let’s explore the parent-child relationship of passing `props` a bit further.
#+begin_src javascript
function App() {
    return <Product name="Apple Watch" price = {399} rating = "4.5/5.0" />;
}
#+end_src

In this example, `App` is the parent and `Product` is the child. `App` passes three props to `Product` (`name`, `price`, and `rating`), which can then be read inside the child component.

Props passed down are immutable, meaning they cannot be changed. If a component wants new values for its props, it needs to rely on the parent component to pass it new ones.


#### Render Different UI Based on props

You can do more with props than just display them. You can also use props to make decisions.
#+begin_src javascript
function LoginMsg(props) {
  if (props.password === 'a-tough-password') {
    return <h2>Sign In Successful.</h2>
  } else {
    return <h2>Sign In Failed..</h2>
  }
}
#+end_src

In this example, we use the props passed in to make a decision rather than rendering the value to the screen.

If the `password` received is equal to `'a-tough-password'`, the resulting message in `<h2></h2>` will be different!

The passed-in `password` is not displayed in either case! The prop is used to decide what will be displayed. This is a common technique.


#### Put an Event Handler in a Function Component

You can, and often will, pass functions as `props`. It is especially common to pass /event handler/ functions.

In the next exercise, we will pass an event handler function as a prop. However, we have to /define/ an event handler before we can pass one anywhere. In this exercise, we will define an event handler function.

How do we define an event handler in React?

We define an event handler as a method on the function component!

Take a look at the Example.js file in the code editor. On lines 4 through 8, an event handler method is defined. On line 10, that event handler method is attached to an event (a click event, in this case).
#+name: Example.js
#+begin_src javascript
import React from 'react';

function Example() {
  function handleEvent() {
    alert(`I am an event handler.
      If you see this message,
      then I have been called.`);
  }
  return (
      <h1 onClick={handleEvent}>
        Hello world
      </h1>
    );
}
#+end_src

Now you’re ready to pass that function to another component.

You can pass a method in the exact same way that you pass any other data—using curly braces.

#+name: Talker.js
#+begin_src javascript
import React from 'react';
import Button from './Button';

function Talker() {
  function talk() {
    let speech = '';
    for (let i = 0; i < 10000; i++) {
      speech += 'blah ';
    }
    alert(speech);
	}
  return <Button talk={talk}/>;
}

export default Talker;
#+end_src

Take a look at *Button.js* in the code editor. Notice that `Button` returns a `<button>` element.

If a user clicks on this `<button>` element, you want your passed-in `talk()` function to get called. This means that you need to attach `talk()` to the `<button>` element as an /event handler/.

How do you do that? In the same way that you attach any event handler to a JSX element: you give that JSX element a special attribute. The attribute’s name should be an event name like `onClick` or `onHover`. The attribute’s value should be the event handler that you want to attach.

#+name: Button.js
#+begin_src javascript
import React from 'react';

function Button(props) {
  return (
    <button onClick={props.talk}>
      Click me!
    </button>
  );
}

export default Button;
#+end_src


#### handleEvent, onEvent, and props.onEvent
Let’s talk about naming things.

When you pass an /event handler/ as a prop, as you just did, there are two names that you have to choose. Both naming choices occur in the parent component, the component that defines the event handler and passes it.

The first name that you have to choose is the name of the event handler itself.

Look at *Talker.js*, lines 6 through 12. This is our event handler. We chose to name it `talk`.

The second name that you have to choose is the name of the prop that you will use to pass the event handler. This is the same thing as the attribute name.

For our prop name, we also chose `talk`, as shown on line 15:
#+begin_src javascript
return <Button talk={talk} />;
#+end_src

These two names can be whatever we want. However, there is a naming convention that is commonly used.

Here’s how the naming convention works: first, think about what /type of event/ you are listening for. In our example, the event type was “click”. If you are listening for a “click” event, then you name your /event handler/ `handleClick`. If you are listening for a “hover” event, then you name your event handler `handleHover`:
#+begin_src javascript
function myClass() {
  function handleHover() {
    alert('I am an event handler.');
    alert('I will be called in response to "hover" events.');
  }
}
#+end_src

Your prop name should be the word `on`, plus your event type. If you are listening for a “click” event, then you name your prop `onClick`. If you are listening for a “hover” event, then you name your prop `onHover`:
#+begin_src javascript
function myClass(){
  function handleHover() {
    alert('I am an event handler.');
    alert('I will listen for a "hover" event.');
  }
   return <Child onHover={handleHover} />;
}
#+end_src


1. In *Talker.js*, change the event handler’s /name/ from `talk` to `handleClick`.


2. In `Talker`'s return statement, change the `prop`'s name from `talk` to `onClick`.
Change the prop’s /value/ to the newly named event handler, `handleClick`.

3. Select *Button.js*.
Change `Button`'s return statement so that it expects a prop named `onClick` instead of `talk`.

4. One major source of confusion is the fact that names like `onClick` have special meanings, but this is only if they’re used on HTML-like elements.

Look at *Button.js*. When you give the `<button>` element an attribute named `onClick`, then this `onClick` attribute has a special purpose. As you’ve learned, this special `onClick` attribute creates an /event listener/ that listens for clicks on the `<button>` element:
#+begin_src javascript
// In Button.js: The onClick attribute creates an event listener:
<button onClick={props.onClick}>
  Click me!
</button>
#+end_src

Now, look at *Talker.js*. Here, the `onClick` attribute you gave to `<Button />` does not create an event listener—it’s just a name of an attribute:
#+begin_src javascript
// In Talker.js: The onClick attribute is just a normal attribute name.
<Button onClick={handleClick} />
#+end_src

The reason for this is that `<Button />` is not an HTML-like JSX element; it’s a /component instance/.

Names like `onClick` only create event listeners if they’re used on HTML-like JSX elements. Otherwise, they’re just ordinary prop names.

#+name: Talker.js
#+begin_src javascript
import React from 'react';
import Button from './Button';

function Talker() {
  function handleClick() {
    let speech = '';
    for (let i = 0; i < 10000; i++) {
      speech += 'blah ';
    }
    alert(speech);
	}
  return <Button onClick={handleClick}/>;
}

export default Talker;
#+end_src

#+name: Button.js
#+begin_src javascript
import React from 'react';

function Button(props) {
    return (
      <button onClick={props.onClick}>
        Click me!
      </button>
    );
}

export default Button;
#+end_src


#### props.children
Every component’s `props` object has a property named `children`.

`props.children` will return everything in between a component’s opening and closing JSX tags.

So far, all of the components that you’ve seen have been /self-closing tags/, such as `<MyFunctionComponent />`. They don’t have to be! You could write `<MyFunctionComponent></MyFunctionComponent>`, and it would still work.

`props.children` would return everything in between `<MyFunctionComponent>` and `</MyFunctionComponent>`.

By using `props.children`, we can separate the outer component, `MyFunctionComponent` in this case, from the content, which makes it flexible and reusable.

Look at *BigButton.js*.

- In Example 1, <BigButton>'s `props.children` would equal the text, “I am a child of BigButton.”
  
- In Example 2, <BigButton>'s `props.children` would equal a `<LilButton />` component.
  
- In Example 3, <BigButton>'s `props.children` would equal undefined.

If a component has more than one child between its JSX tags, then `props.children` will return those children in an array. However, if a component has only one child, then `props.children` will return the single child, /not/ wrapped in an array.

#+name: BigButton.js
#+begin_src javascript
import React from 'react';
import LilButton  from './LilButton';

function BigButton(props) {
  console.log(props.children);
  return <button>I am a Big Button.</button>;
}

export default BigButton;

// Example 1
<BigButton>
  I am a child of BigButton.
</BigButton>


// Example 2
<BigButton>
  <LilButton />
</BigButton>


// Example 3
<BigButton />
#+end_src

#### Giving Default Values to props
Take a look at the `Button` component. Notice that on line 8, `Button` expects to receive a prop named `text`. The received text will be displayed inside of a `<button>` element.

What if nobody passes any `text` to `Button`?

If nobody passes any `text` to `Button`, then `Button`'s display will be blank. It would be better if `Button` could display a default message instead.

You can make this happen by specifying a default value for the prop. There are three ways to do this!

The first method is adding a `defaultProps` static property to the component:
#+begin_src javascript
function Example(props) {
  return <h1>{props.text}</h1>
}
 
Example.defaultProps = {
  text: 'This is default text',
};
#+end_src

You can also specify the default value directly in the function definition:
#+begin_src javascript
function Example({text='This is default text'}) {
   return <h1>{text}</h1>
}
#+end_src

Lastly, you can also set the default value in the function body:
#+begin_src javascript
function Example(props) {
  const {text = 'This is default text'} = props;
  return <h1>{text}</h1>
}
#+end_src

If an `<Example />` doesn’t get passed any text, then it will display “This is default text”.

If an `<Example />` does get passed some text, then it will display that passed-in text.


### Hooks
#### The State Hook
React Hooks, plainly put, are functions that let us manage the internal state of components and handle post-rendering side effects directly from our function components. Using Hooks, we can determine what we want to show the users by declaring how our user interface should look based on the state.

React offers a number of built-in Hooks. A few of these include `useState()`, `useEffect()`, `useContext()`, `useReducer()`, and `useRef()`.


##### Update Function Component State
Let’s get started with the State Hook, the most common Hook used for building React components. The State Hook is a named export from the React library, so we import with object destructuring like the following:
#+begin_src javascript
import React, { useState } from 'react';
#+end_src

When we call the `useState()` function, it returns an array with two values:

- The /current state/: The current value of this state.
- The /state setter/: A function that we can use to update the value of this state.

We can use these two values to track the current state of a data value or property and change it when we need to. To extract the two values from the array, we can assign them to local variables by using array destructuring. For example:
#+begin_src javascript
const [currentState, setCurrentState] = useState();
#+end_src

Let’s have a look at another example of a function component that uses the State Hook:
#+begin_src javascript
import React, { useState } from "react";
 
function Toggle() {
  const [toggle, setToggle] = useState();
 
  return (
    <div>
      <p>The toggle is {toggle}</p>
      <button onClick={() => setToggle("On")}>On</button>
      <button onClick={() => setToggle("Off")}>Off</button>
    </div>
  );
}
#+end_src

Notice how the state setter function, `setToggle()`, is called by our `onClick` /event/ listeners. To update the value of toggle and re-render this component with the new value, all we need to do is call the setToggle() function with the next state value as an argument.

With the State Hook, updating the state is as simple as calling a state setter function. Calling the state setter signals to React that the component needs to re-render, so the whole function defining the component is called again. The magic of `useState()` is that it allows React to keep track of the current value of the state from one render to the next!


##### Initialize State
Like how you used the State Hook to manage a variable with string values, we can use the State Hook to manage the value of any primitive data type and even data collections like arrays and objects!

Have a look at the following function component. What data type does this state variable hold?
#+begin_src javascript
import React, { useState } from 'react';
 
function ToggleLoading() {
  const [isLoading, setIsLoading] = useState();
 
  return (
    <div>
      <p>The data is {isLoading ? 'Loading' : 'Not Loading'}</p>
      <button onClick={() => setIsLoading(true)}>
        Turn Loading On
      </button>
      <button onClick={() => setIsLoading(false)}>
        Turn Loading Off
      </button>
    </div>
  );
}
#+end_src

The `ToggleLoading()` function component above uses the simplest of all data types, a boolean. Booleans are frequently used in React applications to represent whether data has loaded or not. In the example above, we see that `true` and `false` values are passed to the state setter, `setIsLoading()`.

This code works just fine as is, but what if we want our component to start off with `isLoading` set to `true`?

To initialize our state with any value we want, we simply pass the initial value as an argument to the `useState()` function call.
#+begin_src javascript
const [isLoading, setIsLoading] = useState(true);
#+end_src

There are three ways in which this code affects our component:

1. During the first render, the /initial state argument/ is used.

2. When the state setter is called, React ignores the initial state argument and uses the new value.

3. When the component re-renders for any other reason, React continues to use the same value from the previous render.

If we don’t pass an initial value when calling `useState()`, the current value of the state during the first render will be `undefined`. Often, this is perfectly fine for the computers running the code, but it can be unclear to the humans reading our code. So, we prefer to explicitly initialize our state. If we don’t have the value needed during the first render, we can explicitly pass `null` instead of passively leaving the value as `undefined`.


##### Use State Setter Outside of JSX
Let’s see an example of managing the changing value of a string as a user types into a text input field:
#+begin_src javascript
import React, { useState } from 'react';
 
export default function EmailTextInput() {
  const [email, setEmail] = useState('');
  const handleChange = (event) => {
    const updatedEmail = event.target.value;
    setEmail(updatedEmail);
  }
 
  return (
    <input value={email} onChange={handleChange} />
  );
}
#+end_src

Here’s a breakdown of how the above code works:

- We use array destructuring to create our local state variable `email` and our local setter function `setEmail()`.

- The local variable `email` is assigned the current state value at index `0` from the array returned by `useState()`.

- The local variable `setEmail()` is assigned a reference to the state setter function at index `1` from the array returned by `useState()`.

- It’s a convention to name the setter variable using the current state variable (in this example, `email`) with “set” prepended.

The JSX input tag has an event listener called `onChange`. This event listener calls an /event handler/ each time the user types something in this element. In the example above, our event handler is defined inside of the definition for our function component, but outside of our JSX. Earlier in this lesson, we wrote our event handlers right in our JSX. Those inline event handlers work perfectly fine, but when we want to do something more interesting than just calling the state setter with a static value, it’s a good practice to separate that logic from our JSX. This separation of concerns makes our code easier to read, test, and modify.

It’s common in React code to simplify this:
#+begin_src javascript
const handleChange = (event) => {
  const newEmail = event.target.value;
  setEmail(newEmail);
}
#+end_src

to this:
#+begin_src javascript
const handleChange = (event) => setEmail(event.target.value);
#+end_src

or, using object restructuring, this:
#+begin_src javascript
const handleChange = ({target}) => setEmail(target.value);
#+end_src

All three code snippets above behave the same way, so there really isn’t a right and wrong between these different code snippets. We’ll use the last, most concise version moving forward.


1. Let’s use the State Hook to make our program only accept numeric input since we want a phone number from the user.

First, make sure we can use the State Hook by importing useState from the React library.


2. Declare and assign values for our current state and state setter with useState(). Use phone as the name of our current state variable.

Make sure to give the phone state variable an initial value of an empty string!


3. Let’s specify the value of our JSX input tag by adding a value attribute and setting it to the value of our phone state variable.

We also want to detect any changes to the input tag while the user types so add an onChange event listener and assign it the handleChange function.


4. Lastly, complete the handleChange() function. This function checks for the validity of the input value the user is typing. If the input is numeric, it should update the state variable through the setter function.

In the if-statement of the handleChange() function, update the state using the state setter function setPhone() and set it to the new value newPhone.

#+name: PhoneNumber.js
#+begin_src javascript
import React, {useState} from 'react';

// regex to match numbers between 1 and 10 digits long
const validPhoneNumber = /^\d{1,10}$/;

export default function PhoneNumber() {
  // declare current state and state setter 
const [phone, setPhone] = useState('');

const handleChange = ({ target })=> {
    const newPhone = target.value;
    const isValid = validPhoneNumber.test(newPhone);
    if (isValid) {
        // update state 
        setPhone(newPhone);
    }
    // just ignore the event, when new value is invalid
  };

  return (
    <div className='phone'>
      <label for='phone-input'>Phone: </label>
      <input value={phone} onChange={handleChange} id='phone-input' />
    </div>
  );
}
#+end_src


##### Set From Previous State
In the previous exercise, we learned to update the state by passing it a new value like this:
#+begin_src javascript
setState(newStateValue);
#+end_src

However, React state updates are /asynchronous/. This means that there are some scenarios where portions of your code will run before the state is finished updating.

This is a good and a bad thing! Grouping the state updates together can improve performance in your application, but it can result in outdated state values. Consequently, it is best practice to update a state with a callback function, preventing accidental outdated values.

Let’s take a look at the following code to see how it’s done:
#+begin_src javascript
import React, { useState } from 'react';
 
export default function Counter() {
  const [count, setCount] = useState(0);
 
  const increment = () => setCount(prevCount => prevCount + 1);
 
  return (
    <div>
      <p>Wow, you've clicked that button: {count} times</p>
      <button onClick={increment}>Click here!</button>
    </div>
  );
}
#+end_src

When the button is pressed, the `increment()` event handler is called. Inside this function, we use our `setCount()` state setter with a callback function.

Because the next value of `count` depends on the previous value of `count`, we pass a callback function as the argument for `setCount()` instead of a value (as we’ve done in previous exercises).
#+begin_src javascript
setCount(prevCount => prevCount + 1)
#+end_src

When our state setter calls the callback function, this /state setter callback function/ takes our previous `count` as an argument. The value returned by this state setter callback function is used as the next value of `count` (in this case, `prevCount + 1`).

We can also just call `setCount(count +1)` and it would work the same in this example, but for reasons that are out of scope for this lesson, it is safer to use the callback method.


1. Let’s get some practice by creating a navigation bar for a quiz. The navigation bar will let us go back or go to the next question in a quiz.

First, define a goBack() event handler function. It should allow us to navigate to the previous quiz question. Because our next value of state depends on the previous state value, this function should call the state setter with a callback function. Our state setter callback function needs to compute the next value of questionIndex using an argument named prevQuestionIndex.


2. Next, add an event listener to the “Go Back” button that will call our newly defined event handler.


3. If we can go back to a previous question, we should also be able to go to the next question.

Define a goToNext() event handler. Because our next value of state depends on the previous state value, this function should call the state setter with a callback function. Our state setter callback function needs to compute the next value of questionIndex using an argument named prevQuestionIndex.


4. Add an event listener to the “Next Question” button that will call our newly defined event handler.


5. Lastly, add an onFirstQuestion variable with a boolean value, then use that value to toggle the disabled attribute of the “Go Back” button on and off.

#+name: QuizNavBar.js
#+Begin_src javascript
import React, { useState } from 'react';

export default function QuizNavBar({ questions }) {
    const [questionIndex, setQuestionIndex] = useState(0);

    // define event handlers 
    const goBack = () => setQuestionIndex(prevQuestionIndex => prevQuestionIndex - 1);

    const goToNext = () => setQuestionIndex(prevQuestionIndex => prevQuestionIndex + 1);
    
    // determine if on the first question or not 
    // if questionIndex is 0, onFirstQuestion=true, so disabled=true. if questionIndex is not 0, onFirstQuestion=false.
    const onFirstQuestion = questionIndex === 0;

    const onLastQuestion = questionIndex === questions.length - 1;

    return (
      <nav>
	<span>Question #{questionIndex + 1}</span>
	<div>
	  <button onClick={goBack} disabled={onFirstQuestion}>
	    Go Back
	  </button>
	  <button onClick={goToNext} disabled={onLastQuestion}>
	    Next Question
	  </button>
	</div>
      </nav>
    );
  }
#+End_src


##### Arrays in State
JavaScript arrays are the best data model for managing and rendering JSX lists. Let’s take a look at the code for a website for a pizza restaurant.
#+Begin_src javascript
  import React, { useState } from 'react';

  //Static array of pizza options offered. 
  const options = ['Bell Pepper', 'Sausage', 'Pepperoni', 'Pineapple'];

  export default function PersonalPizza() {
    const [selected, setSelected] = useState([]);

    const toggleTopping = ({target}) => {
      const clickedTopping = target.value;
	
      setSelected((prev) => {

       // check if clicked topping is already selected
	if (prev.includes(clickedTopping)) {

	  // filter the clicked topping out of state
	  return prev.filter(t => t !== clickedTopping);
	} else {

	  // add the clicked topping to our state
	  return [clickedTopping, ...prev];
	}
      });
    };

    return (
      <div>
	{options.map(option => (
	  <button value={option} onClick={toggleTopping} key={option}>
	    {selected.includes(option) ? 'Remove ' : 'Add '}
	    {option}
	  </button>
	))}
	<p>Order a {selected.join(', ')} pizza</p>
      </div>
    );
  }
#+End_src

In the above example, we are using two arrays:

- The `options` array contains the names of all of the pizza toppings available.
  
- The `selected` array represents the selected toppings for our personal pizza.
  
The `options` array contains /static data/, meaning that it does not change. It’s best practice to define static data models outside of function components since they don’t need to be recreated each time our component re-renders. In our JSX, we use the JavaScript `.map()` method to render a button for each of the toppings in our `options` array.

The `selected` array contains /dynamic data/, meaning that it changes, usually based on a user’s actions. We initialize `selected` as an empty array. When a button is clicked, the `toggleTopping()` event handler is called. Notice how this event handler uses information from the event object to determine which topping was clicked.

When updating an array in a state, we do not just add new data to the previous array. We replace the previous array with a brand new array. This means that any information that we want to save from the previous array needs to be explicitly copied over to our new array. That’s what this spread syntax does for us: `...prev`.

Notice how we use the `.includes()`, `.filter()`, and `.map()` methods of our arrays. If these are new to you, or you just want a refresher, take a minute to review these array methods. We don’t need to be full-fledged JavaScript gurus to build React applications but know that investing time to strengthen our JavaScript skills will always help us do more faster (and have a lot more fun doing it) as React developers.


1. Declare and initialize a state variable called cart that will keep track of a list of string values.

Each of these string values represents a grocery item that we’ve added to our shopping cart. We’ll add event listeners and event handlers to add and remove items to our cart in the coming steps.

For now, let’s get started by initializing our cart with the value of an empty array for the first render.


2. Take a look at the current code, we have two functions: addItem() and removeItem(). Let’s add some parameters to these event handling functions, addItem() should accept an argument called item and removeItem() should accept an item called targetIndex.

Don’t worry about writing the function body for these event handlers just yet, we’ll do that in the next few steps!


3. Time to shift our focus to the body of the event handler functions. We’ll start with addItem().

Update the cart state with the state setter function every time addItem() is called. Don’t forget to use a callback function for best practice! Inside, use the array spread syntax to add a new item to the state array.


4. Last, removeItem() should remove from the state when called.

Use the array .filter() method to remove the item from our state that’s located at the index of the item that was clicked in our list.

Why would we want to use the index of the clicked item instead of the item itself when determining what to remove from our data model? Say that we have two of the same item in an array. Using the value to remove the item would remove all items with that value, so we use the index as a unique identifier.

#+name: ItemList.js
#+begin_src javascript
import React from "react";

export default function ItemList({ items, onItemClick }) {
  const handleClick = ({ target }) => {
    const item = target.value;
    onItemClick(item);
  };
  return (
    <div>
      {items.map((item, index) => (
        <button value={item} onClick={handleClick} key={index}>
          {item}
        </button>
      ))}
    </div>
  );
};
#+end_src


#+name: GroceryCart.js
#+begin_src javascript
import React, { useState } from "react";
import ItemList from "./ItemList";
import { produce, pantryItems } from "./storeItems";

/*
prev is a name that you have given to the argument passed to setState callback function. What it holds is the value of state before the setState was triggered by React
*/
export default function GroceryCart() {
  // declare and initialize state 
  const [cart, setCart] = useState([]);

  /*
  Need to call our state setter with a state setter callback function.
  Here, `prev` represents the previous state of the cart before adding a new item. The new item is added to the beginning of the array using the spread operator
  */
  const addItem = (item) => {
    setCart((prev) => {
      return [item, ...prev];
    });
   };

  /*
  Remove the item from our state that’s located at the index of the item that was clicked in our list.
  Here, prev represents the previous state of the cart before removing an item. The new state is returned by filtering out the item at the target index
  */
  const removeItem = (targetIndex) => {
    setCart((prev) => {
      return prev.filter((item, index) => index !== targetIndex);
    });
  };

  return (
    <div>
      <h1>Grocery Cart</h1>
      <ul>
        {cart.map((item, index) => (
          <li onClick={() => removeItem(index)} key={index}>
            {item}
          </li>
        ))}
      </ul>
      <h2>Produce</h2>
      <ItemList items={produce} onItemClick={addItem} />
      <h2>Pantry Items</h2>
      <ItemList items={pantryItems} onItemClick={addItem} />
    </div>
  );
}

#+end_src


##### Objects in State
We can also use state with objects. When we work with a set of related variables, it can be very helpful to group them into an object. Let’s look at an example of this in action.
#+begin_src javascript
export default function Login() {
  const [formState, setFormState] = useState({});
  const handleChange = ({ target }) => {
    const { name, value } = target;
    setFormState((prev) => ({
      ...prev,
      [name]: value
    }));
  };
 
  return (
    <form>
      <input
        value={formState.firstName}
        onChange={handleChange}
        name="firstName"
        type="text"
      />
      <input
        value={formState.password}
        onChange={handleChange}
        type="password"
        name="password"
      />
    </form>
  );
}
#+end_src

A few things to notice:

- We use a state setter callback function to update a state based on the previous value.

- The spread syntax is the same for objects as for arrays: `{ ...oldObject, newKey: newValue }`.

- We reuse our event handler across multiple inputs by using the input tag’s `name` attribute to identify which input the change event came from.

Once again, when updating the state with `setFormState()` inside a function component, we do not modify the same object. We must copy over the values from the previous object when setting the next value of a state. Thankfully, the spread syntax makes this super easy to do!

Anytime one of the input values is updated, the `handleChange()` function will be called. Inside this event handler, we use object destructuring to unpack the `target` property from our `event` object, then we use object destructuring again to unpack the `name` and `value` properties from the `target` object.

Inside our state setter callback function, we wrap our curly brackets in parentheses like so:
#+begin_src javascript
setFormState((prev) => ({ ...prev }))
#+end_src

This tells JavaScript that our curly brackets refer to a new object to be returned. We use `...`, the spread operator, to fill in the corresponding fields from our previous state. Finally, we overwrite the appropriate key with its updated value.

Did you notice the square brackets around the `name`? This Computed Property Name allows us to use the string value stored by the `name` variable as a property key.


1. We’ll use objects with states to build an input form.

The local state variable profile and state setter function setProfile are responsible for keeping track of the input values from our users. In our JSX, we are looking up properties stored in the profile object. This throws an error at our first render because we are attempting to get the value of a property from an object that has not been defined yet.

To fix this, initialize profile as an empty object.


2. You should now see the form rendered, but nothing will happen when we type in the input boxes. Our form does not re-render to show the keystrokes yet.

To fix this, add the onChange event listener to our JSX tags to call handleChange() whenever a user types in an input field. This way, we can determine what happens when the user changes the input by typing in the form.


3. Let’s make our handleChange() function a bit easier to read. Use object destructuring to initialize name and value in a more concise way.


4. There’s a bug in our code! Have you noticed it? Try typing in one input, then type in a different input. What happens? Why?

Each time that we call setProfile() in our event handler, we give profile the value of a new object with the name and value of the input that most recently changed, but we lose the values that were stored for inputs with any other name.

Use the spread operator to fix this bug. We want to copy over all of the values from our previous profile object whenever we call our state setter function. Use prevProfile as the argument for our state setter callback function.


5. Finally, add an event listener to the <form> tag to call our handleSubmit() function when the user submits the form.

#+name: OriginalEditProfile.js
#+begin_src javascript
import React, { useState } from "react";

export default function EditProfile() {
  const [profile, setProfile] = useState();

  const handleChange = ({ target }) => {
    const name = target.name;
    const value = target.value;
    setProfile({
      [name]: value
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    alert(JSON.stringify(profile, '', 2));
  };

  return (
    <form>
      <input
        value={profile.firstName || ''}
        name="firstName"
        type="text"
        placeholder="First Name"
      />
      <input
        value={profile.lastName || ''}
        type="text"
        name="lastName"
        placeholder="Last Name"
      />
      <input
        value={profile.bday || ''}
        type="date"
        name="bday"
      />
      <input
        value={profile.password || ''}
        type="password"
        name="password"
        placeholder="Password"
      />
      <button type="submit">Submit</button>
    </form>
    
  );
}

#+end_src


#+name: EditProfile.js
#+begin_src javascript
import React, { useState } from "react";

export default function EditProfile() {
  const [profile, setProfile] = useState({});

  const handleChange = ({ target }) => {
    // Use object destructuring to initialize name and value
    const {name, value} = target;

    setProfile((prevProfile) => ({
      // Use the spread operator here (...provProfile)
      ...prevProfile,
      [name]: value
    }));
  };  

  const handleSubmit = (event) => {
    event.preventDefault();
    alert(JSON.stringify(profile, '', 2));
  };

  return (
    <form>
      <input
        value={profile.firstName || ''}
        name="firstName"
        type="text"
        placeholder="First Name"
        onChange={handleChange}
      />
      <input
        value={profile.lastName || ''}
        type="text"
        name="lastName"
        placeholder="Last Name"
        onChange={handleChange}
      />
      <input
        value={profile.bday || ''}
        type="date"
        name="bday"
        onChange={handleChange}
      />
      <input
        value={profile.password || ''}
        type="password"
        name="password"
        placeholder="Password"
        onChange={handleChange}
      />
      <button type="submit" onClick={handleSubmit}>Submit</button>
    </form>
    
  );
}
#+end_src

#+name: Index.js
#+begin_src javascript
import React from 'react';
import ReactDOM from 'react-dom/client';

import App from './App.js';

ReactDOM.createRoot( 
  document.querySelector('#app')
).render(<App />)
#+end_src


##### Separate Hooks for Separate States
While there are times when it can be helpful to store related data in a data collection, like an array or object, it can also be helpful to create different state variables for data that change separately. Managing dynamic data is much easier when we keep our data models as simple as possible.

For example, if we had a single object that held state for a subject you are studying at school, it might look something like this:
#+begin_src javascript
function Subject() {
  const [state, setState] = useState({
    currentGrade: 'B',
    classmates: ['Hasan', 'Sam', 'Emma'],
    classDetails: {topic: 'Math', teacher: 'Ms. Barry', room: 201};
    exams: [{unit: 1, score: 91}, {unit: 2, score: 88}]);
  });
#+end_src

This would work, but think about how messy it could get to copy over all the other values when we need to update something in this big state object. For example, to update the grade on an exam, we would need an event handler that did something like this:
#+begin_src javascript
setState((prev) => ({
 ...prev,
  exams: prev.exams.map((exam) => {
    if( exam.unit === updatedExam.unit ){
      return { 
        ...exam,
        score: updatedExam.score
      };
    } else {
      return exam;
    }
  }),
}));
#+end_src

Complex code like this is likely to cause bugs. It’s best to create multiple state variables based on which values tend to change together.

We can rewrite the previous example as follows:
#+begin_src javascript
function Subject() {
  const [currentGrade, setGrade] = useState('B');
  const [classmates, setClassmates] = useState(['Hasan', 'Sam', 'Emma']);
  const [classDetails, setClassDetails] = useState({topic: 'Math', teacher: 'Ms. Barry', room: 201});
  const [exams, setExams] = useState([{unit: 1, score: 91}, {unit: 2, score: 88}]);
  // ...
}
#+end_src

Managing dynamic data with separate state variables has many advantages, like making our code more simple to write, read, test, and reuse across components.

Often, we find ourselves packaging and organizing data in collections to pass between components, then separating that data within components where different parts of the data change separately. The wonderful thing about working with Hooks is that we have the freedom to organize our data in the way that makes the most sense to us!

1. Take a look at the Musical functional component. It has a large state object. Let’s refactor it to make it more readable and reusable. We’ll work on splitting it into three separate variables: title, actors, and locations.

In the MusicalRefactored component, take the title data from Musical and give it its own state variable, state setter, and initial value.

Remember to use the conventional pattern for naming state setters.


2. Next, take the actors data from Musical and give it its own state variable, state setter, and initial value.


3. Last, take the locations data from Musical and give it its own state variable, state setter, and initial value.

#+name: Musical.js
#+begin_src javascript
import React, { useState } from "react";

function Musical() {
   const [state, setState] = useState({
    title: "Best Musical Ever",
    actors: ["George Wilson", "Tim Hughes", "Larry Clements"],
    locations: {
      Chicago: {
        dates: ["1/1", "2/2"], 
        address: "chicago theater"}, 
      SanFrancisco: {
        dates: ["5/2"], 
        address: "sf theater"
      }
    }
  })
 }

function MusicalRefactored() {
  const [title, setTitle] = useState("Best Musical Ever");
  const [actors, setActors] = useState(["George Wilson", "Tim Hughes", "Larry Clements"]);
  const [locations, setLocations] = useState({
    Chicago: {
        dates: ["1/1", "2/2"], 
        address: "chicago theater"}, 
      SanFrancisco: {
        dates: ["5/2"], 
        address: "sf theater"
      }
  });
}
#+end_src



#### The Effect Hook
##### Why Use useEffect?
Before Hooks, function components were only used to accept data in the form of props and return some JSX to be rendered. However, as we learned in the last lesson, the State Hook allows us to manage dynamic data, in the form of component state, within our function components.

In this lesson, we’ll use the *Effect Hook* to run some JavaScript code after each render to:

- fetch data from a back-end service.
- subscribe to a stream of data.
- manage timers and intervals.
- read from and make changes to the DOM.

Components will re-render multiple times throughout their lifetime. These key moments present the perfect opportunity to execute these “side effects”.

There are three key moments when the Effect Hook can be utilized:

1. When the component is first added, or /mounted/, to the DOM and renders.
2. When the state or props change, causing the component to re-render.
3. When the component is removed, or /unmounted/, from the DOM.

Later on in this lesson, we’ll learn how to further fine-tune exactly when the Effect Hook executes.


##### Function Component Effects
The Effect Hook tells our component to do something every time it’s rendered (or re-rendered). Combined with states, we can use the Effect Hook to create interesting dynamic changes in our web pages!

Suppose we want to allow a user to change the title of the web page tab every time they type. We can implement this with the Effect Hook (useEffect()) like so:
#+begin_src
import React, { useState, useEffect } from 'react';
 
function PageTitle() {
  const [name, setName] = useState('');
 
  useEffect(() => {
    document.title = `Hi, ${name}`;
  });
 
  return (
    <div>
      <p>Use the input field below to rename this page!</p>
      <input onChange={({target}) => setName(target.value)} value={name} type='text' />
    </div>
  );
}
#+end_src

Let’s take a look at the above example in more detail. First, we import the Effect Hook from the `'react'` library:

import { useEffect } from 'react';


The `useEffect()` function has no return value as the Effect Hook is used to call another function. We pass the callback function, or *effect*, to run after a component renders as the argument of the `useEffect()` function. In our example, the following effect runs after each time the `PageTitle` component renders:

() => { document.title = `Hi, ${name}`;}


Here, we assign `Hi, ${name}` as the value of `document.title`.

The `onChange` event listener triggers the `PageTitle` component to be re-rendered every time the user types in the input. Consequently, this triggers `useEffect()` and changes the document’s title.

Notice how we use the current state inside of our effect. Even though our effect is called after the component renders, we still have access to the variables in the scope of our function component! When React renders our component, it will update the DOM as usual, and then run our effect after the DOM has been updated. This happens for every render, including the first and last one.


1. Import the Effect Hook, the State Hook, and React from the 'react' library.

Make sure to import everything in one line.


2. Call useEffect() with a callback function that creates an alert with the current value of count.

Start clicking the button to see when our alert() function is called and be sure that it is logging the values that we’d expect!


3. Use a template literal so that the message in our alert dialog reads: “Count: 0”, then “Count: 1”, then “Count: 2”, etc.

#+name: Counter.js
#+begin_src
import React, { useState, useEffect } from 'react';

export default function Counter() {
  const [count, setCount] = useState(0);
  useEffect(() => {
    alert(`Count: ${count}`);
  })
  const handleClick = () => {
    setCount((prevCount) =>  prevCount + 1);
  };

  return (
    <div>
      <p>You clicked {count} times</p>
      <button onClick={handleClick}>
        Click me
      </button>
    </div>
  );
}
#+end_src


##### Clean Up Effects
Some effects require **cleanup**. For example, we might want to add event listeners to some element in the DOM, beyond the JSX in our component. When we add event listeners to the DOM, it is important to remove those event listeners when we are done with them to avoid memory leaks!

Let’s consider the following effect:

```
useEffect(()=>{
  document.addEventListener('keydown', handleKeyPress);
  // Specify how to clean up after the effect:
  return () => {
    document.removeEventListener('keydown', handleKeyPress);
  };
})
```

If our effect didn’t return a *cleanup function*, a new event listener would be added to the DOM’s `document` object every time that our component re-renders. Not only would this cause bugs, but it could cause our application performance to diminish and maybe even crash!

Because effects run after every render and not just once, React calls our cleanup function before each re-render and before unmounting to clean up each effect call.

If our effect returns a function, then the `useEffect()` Hook always treats that as the cleanup function. React will call this cleanup function before the component re-renders or unmounts. Since this cleanup function is optional, it is our responsibility to return a cleanup function from our effect when our effect code could create memory leaks.


1. Let’s create a program that documents how many times you’ve clicked on the page.

Write an event handler named increment() that will be responsible for tracking how many times a user has clicked. Define this function so that it calls setClickCount() with a state setter callback function, adding 1 to the previous value of clickCount.


2. Import the useEffect() hook and call it with an effect that adds an event listener for 'mousedown' events on the document object. When a 'mousedown' event occurs anywhere on the document, we want our increment() event handler to be called.


3. If you haven’t already, run our code and click around the browser window. What is happening? Why is this happening?

Each time that our component renders, our effect is called, adding another event listener. With just a few clicks and rerenders, we have attached a lot of event listeners to the DOM! We need to clean up after ourselves!

Update our effect so that it returns a cleanup function that will remove our last event listener from the DOM.


``` {javascript Counter.js}
import React, { useState, useEffect } from 'react';

export default function Counter() {
  const [clickCount, setClickCount] = useState(0);

  // your code here
  // When a 'mousedown' event occurs anywhere on the document, we want our increment() event handler to be called
  useEffect(() => {
    document.addEventListener('mousedown', increment);

    // return a cleanup function that will remove our last event listener from the DOM
    return () => {
      document.removeEventListener('mousedown', increment);
    };
  });

  // an event handler named increment() that will be responsible for tracking how many times a user has clicked. 
  // Define this function so that it calls setClickCount() with a state setter callback function,
  // adding 1 to the previous value of clickCount
  const increment = () => {
  setClickCount((prevClickCount) => prevClickCount + 1)
};

  return (
      <h1>Document Clicks: {clickCount}</h1>
  );
}
```


##### Control When Effects Are Called
The `useEffect()` function calls its first argument (the effect) after each time a component renders. We’ve learned how to return a cleanup function so that we don’t create performance issues and other bugs, but sometimes we want to skip calling our effect on re-renders altogether.

It is common, when defining function components, to run an effect only when the component mounts (renders the first time), but not when the component re-renders. The Effect Hook makes this very easy for us to do! If we want to only call our effect after the first render, we pass an empty array to `useEffect()` as the second argument. This second argument is called the **dependency array**.

The dependency array is used to tell the `useEffect()` method when to call our effect and when to skip it. Our effect is always called after the first render but only called again if something in our dependency array has changed values between renders.

We will continue to learn more about this second argument over the next few exercises, but for now, we’ll focus on using an empty dependency array to call an effect when a component first mounts, and if a cleanup function is returned by our effect, calling that when the component unmounts.
```
useEffect(() => {
  alert("component rendered for the first time");
  return () => {
    alert("component is being removed from the DOM");
  };
}, []); 
```
Without passing an empty array as the second argument to the `useEffect()` above, those alerts would be displayed before and after every render of our component, which is clearly not when those messages are meant to be displayed. Simply passing `[]` to the `useEffect()` function is enough to configure when the effect and cleanup functions are called!


1. Let’s get started by using the following four functions to advance the number stored in time each second:

- useEffect(): the Effect Hook, imported from the ‘react’ library.
- JavaScript setInterval() function.
- setTime(): our state setter function.
- A state setter callback function: used by setTime() to calculate the next value of time based on the previous value of time.
- Add an effect that uses the setInterval() function to call setTime() every second (or 1000 ms).


2. Our time value is updating way too quickly because the Effect Hook calls our effect after every render! Our effect is creating a new interval that updates the value of time each second. We keep adding more and more intervals that keep updating the same time variable. We need to clean up our old intervals before adding new ones!

Let’s start by creating a variable, intervalId and assign it to our setInterval() code from the previous step.

Then, below your intervalId declaration, use the return keyword to return a cleanup function. Our cleanup function should use the clearInterval() function.


3. That seems to have solved our way-too-many-intervals-all-updating-the-same-variable bug!

Let’s add an extra variable to our timer and allow the user to type a message while the timer is counting up.

First, let’s create a state variable called name with a state setter called setName() to manage the value of the input box. Set the state variable to the initial value of an empty string.


4. Great! Let’s go ahead and put that input tag in.

Add an <input> element to our JSX. Set its value attribute to our state variable name.


5. Next, define an event handler function named handleChange(). This event handler will take in the value of the user’s input and update the state variable.

handleChange() should use object destructuring on its parameter to take in target and use the state setter setName to set the value of name to target.value.


6. Excellent job! Put that handleChange() event handler to work!

Add the onChange event listener to the input tag, setting it to handleChange().

Try typing now!


7. Uh oh. More bugs. Did you notice it yet? Type your full name in the text input field. See how the timer seems to stop counting while you are typing? That’s not what we want!

What is going on here? We are creating a new interval after each render, that interval will call our state setter to update time exactly one second after each render. When we type in the input field, our component keeps re-rendering, cleaning up old intervals, and starting new ones… but our state setter never gets called until one second after we are done typing!

Let’s fix this once and for all! We really want to use a single interval. We want that interval to start ticking away after our first render and we want it to be cleaned up after the final render.

To accomplish this, use an empty dependency array!

``` {javascript OriginalTimer.js}
import React, { useState } from 'react';

export default function Timer() {
  const [time, setTime] = useState(0);

  return (
    <>
      <h1>Time: {time}</h1>
    </>
  );
}
```


``` {javascript Timer.js}
import React, { useState, useEffect } from 'react';

export default function Timer() {
  const [time, setTime] = useState(0);

  // create a state variable called name
  const [name, setName] = useState('');

  useEffect(() => {
    // create a variable intervalId and assign to setInterval() code
    const intervalId = setInterval(() => {
      setTime((prev) => prev + 1);
    }, 1000);

    // return a cleanup function
    return () => {
      clearInterval(intervalId);
    };
  }, []);

  // event handler to take in user input and update the state variable
  const handleChange = ({target}) => {
    setName(target.value);
  };


  return (
    <>
      <h1>Time: {time}</h1>
      <input value={name} onChange={handleChange} type='text' />
    </>
  );
}
```


##### Fetch Data
When building software, we often start with default behaviors and then modify them to improve performance.

We’ve learned that the default behavior of the Effect Hook is to call the effect function after every single render.

Next, we learned that we can pass an empty array as the second argument for `useEffect()` if we only want our effect to be called after the component’s first render.

In this exercise, we’ll learn to use the dependency array to further configure exactly when we want our effect to be called!

When our effect is responsible for fetching data from a server, we pay extra close attention to when our effect is called. Unnecessary round trips back and forth between our React components and the server can be costly in terms of:

- Processing
- Performance
- Data usage for mobile users
- API service fees

When the data that our components need to render doesn’t change, we can pass an empty dependency array so that the data is fetched after the first render. When the response is received from the server, we can use a state setter from the State Hook to store the data from the server’s response in our local component state for future renders. Using the State Hook and the Effect Hook together in this way is a powerful pattern that saves our components from unnecessarily fetching new data after every render!

An empty dependency array signals to the Effect Hook that our effect never needs to be re-run, that it doesn’t depend on anything. Specifying zero dependencies means that the result of running that effect won’t change and calling our effect once is enough.

A dependency array that is not empty signals to the Effect Hook that it can skip calling our effect after re-renders unless the value of one of the variables in our dependency array has changed. If the value of a dependency has changed, then the Effect Hook will call our effect again!

Here’s a nice example from the official React docs:
```
useEffect(() => {
  document.title = `You clicked ${count} times`;
}, [count]); // Only re-run the effect if the value stored by count changes
```


``` {javascript OriginalForecast.js}
import React, { useState, useEffect } from "react";
import { get } from './mockBackend/fetch';

export default function Forecast() {
  const [data, setData] = useState();
  const [notes, setNotes] = useState({});
  const [forecastType, setForecastType] = useState('/daily');

  useEffect(() => {
    alert('Requested data from server...');
    get('/daily').then((response) => {
      alert('Response: ' + JSON.stringify(response,'',2));
    });
  });

  const handleChange = (index) => ({ target }) =>
    setNotes((prev) => ({
      ...prev,
      [index]: target.value
    }));

  return (
    <div className='App'>
      <h1>My Weather Planner</h1>
      <div>
        <button onClick={() => setForecastType('/daily')}>5-day</button>
        <button onClick={() => setForecastType('/hourly')}>Today</button>
      </div>
      <table>
        <thead>
          <tr>
            <th>Summary</th>
            <th>Avg Temp</th>
            <th>Precip</th>
            <th>Notes</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item, i) => (
            <tr key={item.id}>
              <td>{item.summary}</td>
              <td> {item.temp.avg}°F</td>
              <td>{item.precip}%</td>
              <td>
                <input
                  value={notes[item.id] || ''}
                  onChange={handleChange(item.id)}
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
```


1. We’ve started building a weather planner app that will fetch data about the weather and allow our users to write some notes next to the forecast. A lot of good code has already been written, but there currently isn’t anything rendering to the screen.

Let’s read through the code and start to wrap our heads around what is going on here. What part of our code do we think is keeping the component from rendering?

In our JSX, we are trying to map over an array stored by the data state variable, but our effect that fetches this data doesn’t get called until after the first render. So during the first render, data is undefined and attempting to call map() on undefined is causing our error!

Let’s prevent this error by checking to see if the data has loaded yet. If it hasn’t, then we want our function component to just return a paragraph tag with the text “Loading…”. If the data is no longer undefined, then the data has been loaded, and we can go ahead and render the full JSX!


2. Our data fetching is being done in our effect. Notice how we are currently just using alert() messages to keep track of requesting and receiving data from our server. Instead of just stringifying the response data and showing it in an alert message, let’s store that data in our state.

When the data has been fetched, use our state setter function to store that data in our component’s state!

Remember that we want to store an array in our data state variable, not the whole response object.


3. Type in each of the notes’ input fields in our table. What do you notice? Why do you think this is happening?

Each time that we type in an input field, the component re-renders to show the new value of that field. Even though we don’t need any new data from the backend, our component is fetching new data after every render!

Use an empty dependency array to ensure that data is only fetched after our component’s first render.


4. Wow, that small code change made a huge difference in the performance of our weather planner app!

Let’s make one more improvement. Did you notice the buttons at the top of our app? We want our users to be able to choose between planning around daily weather forecasts and weekly weather forecasts. Clicking on these buttons currently doesn’t change anything. Let’s fix that!

The server has two different endpoints called: /daily and /hourly. Let’s use the value of the forecastType state variable to determine which endpoint our effect should request data from.

After making this change, our effect behaves differently based on the value of forecastType. You could say that how we use our effect depends on it! Add this variable to our dependency array so that the effect is called again, updating data appropriately, after re-renders where the user has selected a different forecast type.

``` {javascript OriginalForecast.js}
import React, { useState, useEffect } from "react";
import { get } from './mockBackend/fetch';

export default function Forecast() {
  const [data, setData] = useState();
  const [notes, setNotes] = useState({});
  const [forecastType, setForecastType] = useState('/daily');

  // store response data in the "data" state variable
  useEffect(() => {
    alert('Requested data from server...');
    get(forecastType).then((response) => {
      alert('Response: ' + JSON.stringify(response,'',2));
      setData(response.data);
    });
  }, [forecastType]);

  const handleChange = (index) => ({ target }) =>
    setNotes((prev) => ({
      ...prev,
      [index]: target.value
    }));

  // check if data has loaded. If not, return "Loading..."
  if (!data) {
    return <p>Loading...</p>;
  }

  return (
    <div className='App'>
      <h1>My Weather Planner</h1>
      <div>
        <button onClick={() => setForecastType('/daily')}>5-day</button>
        <button onClick={() => setForecastType('/hourly')}>Today</button>
      </div>
      <table>
        <thead>
          <tr>
            <th>Summary</th>
            <th>Avg Temp</th>
            <th>Precip</th>
            <th>Notes</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item, i) => (
            <tr key={item.id}>
              <td>{item.summary}</td>
              <td> {item.temp.avg}°F</td>
              <td>{item.precip}%</td>
              <td>
                <input
                  value={notes[item.id] || ''}
                  onChange={handleChange(item.id)}
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
```


##### Rules of Hooks
There are two main rules to keep in mind when using Hooks:

1. Only call Hooks at the top level.
2. Only call Hooks from React functions.

As we have been practicing with the State Hook and the Effect Hook, we’ve been following these rules with ease, but it is helpful to keep these two rules in mind as you take your new understanding of Hooks out into the wild and begin using more Hooks in your React applications.

When React builds the Virtual DOM, the library calls the functions that define our components over and over again as the user interacts with the user interface. React keeps track of the data and functions that we are managing with Hooks based on their order in the function component’s definition. For this reason, we always call our Hooks at the top level; we never call hooks inside of loops, conditions, or nested functions.

Instead of confusing React with code like this:

if (userName !== '') {
  useEffect(() => {
    localStorage.setItem('savedUserName', userName);
  });
}


We can accomplish the same goal while consistently calling our Hook every time:

useEffect(() => {
  if (userName !== '') {
    localStorage.setItem('savedUserName', userName);
  }
});


Secondly, Hooks can only be used in React Functions. We’ve been working with `useState()` and `useEffect()` in *function* components, and this is the most common use. The only other place where Hooks can be used is within custom hooks. Custom Hooks are incredibly useful for organizing and reusing stateful logic between function components.


``` {javascript OriginalShop.js}
import React, { useState, useEffect } from 'react';
import { get } from './mockBackend/fetch';

export default function Shop() {
  const [categories, setCategories] = useState();
  if (categories) {
    const [selectedCategory, setSelectedCategory] = useState();
    const [items, setItems] = useState({});
  }

  if (!categories) {
    useEffect(() => {
      get('/categories').then((response) => {
        setCategories(response.data);
      });
    });
  }

  // if (selectedCategory && !items[selectedCategory]) {
  //   useEffect(() => {
  //     get(`/items?category=${selectedCategory}`).then((response) => {
  //       setItems((prev) => ({ ...prev, [selectedCategory]: response.data }));
  //     });
  //   });
  // }

  if (!categories) {
    return <p>Loading..</p>;
  }

  return (
    <div className='App'>
      <h1>Clothes 'n Things</h1>
      <nav>
        {categories.map((category) => (
          <button key={category} onClick={() => setSelectedCategory(category)}>
            {category}
          </button>
        ))}
      </nav>
      <h2>{selectedCategory}</h2>
      <ul>
        {!items[selectedCategory]
          ? null
          : items[selectedCategory].map((item) => <li key={item}>{item}</li>)}
      </ul>
    </div>
  );
}
```


1. The code that we are starting with has a lot of good ideas, but there are some bugs that we need to help sort out. Let’s get started by refactoring the code so that the State Hook is always called at the top level.

It looks like the developers that wrote this code wanted to hold off on using the `selectedCategory` and `items` state variables until after the `categories` have been fetched. Conceptually this makes sense, but React requires that all hooks be called on every render, so nesting these `useState()` calls is not a valid option.

First, remove the `if (categories)` statement, and the surrounding curly braces `{ }` to bring all of our State Hook calls to the top level.


2. Next, to be clear about initial values, let’s explicitly set the initial state value for `categories` and `selectedCategory` to `null`.


3. It looks like the idea behind using this expression: `if (!categories)` was to only fetch the categories data from the server once. Nesting a call to the Effect Hook inside of a condition like this will cause different hooks to be called on different re-renders, resulting in errors. Luckily, we know a better way!

Refactor this code so that the effect responsible for fetching the `categories` data from the backend and saving it to local state follows the rules for Hooks and only fetches the categories data once.


4. Whew, we’re making great progress! It’s such a nice feeling to turn error screens into working code, isn’t it?

Now that we are fetching the list of categories from the backend and successfully rendering buttons for each of these to the screen, we are ready to use another effect to fetch the items for each of these categories, when the user clicks on each of them!

Uncomment the block of code that was attempting to do this, and refactor it so that we follow the rules of Hooks. To optimize performance, only call the backend for data when we don’t yet have it stored in the component’s state like this code was trying to do.

``` {javascript Shop.js}
import React, { useState, useEffect } from 'react';
import { get } from './mockBackend/fetch';

export default function Shop() {
  // explicitly set the initial state value for categories and selectedCategory to null
  const [categories, setCategories] = useState(null);

  const [selectedCategory, setSelectedCategory] = useState(null);
  const [items, setItems] = useState({});

  /*
When using the Effect Hook, passing a dependency array as the second argument for useEffect() is the best way to determine when our effect is and is not called.

Remove the if (!categories) condition, and pass an empty dependency array so that this effect is only called after the first render.
  */
  useEffect(() => {
      get('/categories').then((response) => {
        setCategories(response.data);
      });
    }, []);
  
  // list the 2 variables that this effect depends on in the dependency array
  useEffect(() => {
    if (selectedCategory && !items[selectedCategory]) {
      // fetch data and store it to local state
      get(`/items?category=${selectedCategory}`).then((response) => {
        setItems((prev) => (
          { ...prev, [selectedCategory]: response.data }));
        });
}
}, [items, selectedCategory]);


  if (!categories) {
    return <p>Loading..</p>;
  }

  return (
    <div className='App'>
      <h1>Clothes 'n Things</h1>
      <nav>
        {categories.map((category) => (
          <button key={category} onClick={() => setSelectedCategory(category)}>
            {category}
          </button>
        ))}
      </nav>
      <h2>{selectedCategory}</h2>
      <ul>
        {!items[selectedCategory]
          ? null
          : items[selectedCategory].map((item) => <li key={item}>{item}</li>)}
      </ul>
    </div>
  );
}
```

End of <2023-05-18 Thu>

