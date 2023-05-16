import './App.css';
import React from 'react';
import { comments } from './commentData';
import Card from './Card';

/*
Map over the comments array with the argument named comment and 
return an instance of the Card component.

For each component, give it an attribute named commentObject and the value {comment}.
*/


function App() {
  return comments.map(comment => <Card commentObject={comment} />);
}

/*
function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}
*/
export default App;
