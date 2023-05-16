// import logo from './logo.svg';
import './App.css';
import { animals } from './animals';
import React from 'react';
import { createRoot } from 'react-dom/client';



const container = document.getElementById('root');
const root = createRoot(container);
const background = (
  <div>
    <img className='background' alt='Ocean' src='/images/bg.jpg' />
  </div>
);

const showBackground = true;
const title = '';

const images = [];

// For each animal, add a new <img /> to that array.
for (const animal in animals) {
  images.push(<img key={animal} className='animal' alt={animal} src={animals[animal].image} aria-label='{animal}' role='button' onClick={displayFact}/>)
};

// function to pick a random fact based on selected animal
function displayFact(e) {

  // event listener targetting alt to get name of animal being clicked
  const animal = e.target.alt;

  //generate random index
  const randIndex = Math.floor(Math.random() * animals[animal].facts.length);
  console.log(randIndex);

  //save the fun fact in a variable
  const selectAnimalFact = animals[animal].facts[randIndex];

  document.getElementById('fact').innerHTML = selectAnimalFact;
}

// Show background when showBackground == true
const animalFacts = (
  <div>
    <h1>{title || 'Click an animal for a fun fact'}</h1>
    {showBackground && background}
    <div className='animals'>{images}</div>
    <p id='fact'></p>
  </div>
);

root.render(animalFacts);

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

export default App; 
*/
