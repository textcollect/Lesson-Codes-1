// run in terminal: npm i prompt-sync
// provides prompt() function to prompt for input and store into a variable
var prompt = require('prompt-sync')({sigint: true});

// run in terminal: npm i clear-screen
// provides clear() fn to Clear your console buffer
const clear = require('clear-screen'); 

// Create some global variables (remember: const variables cannot be changed later)
const space = '_';
const row = 2;
const column = 3;
const field = []; //create an empty array first (can make it 2D later or can create 2D straight away)
// https://www.freecodecamp.org/news/javascript-2d-arrays/

/*
to reference data in 2D-array: field[#1][#2],

#1 = row; index of big array (i.e. which [i#] in [ [i1], [i2], [i3]...])

#2 = column; index of inner array (i.e. which element in array [i#])

visualise: [[1, 2, 3],
            [a, b, c]]; 
            
#1 will be [1, 2, 3] or [a, b, c]. I trust myself to figure out what #2 will be...
*/

const word = "MADCAT";

let getWord = "";

const generateField = () =>
{
    // Nested for-loop
    // outer loop for the row, inner for column
    for (let i = 0; i < row; i++)
    {
        // Create 2d array
        field[i] = []; //create empty array for each row first

        for (let col = 0; col < column; col++)
        {
            field[i][col] = space; //loop "column"-times; here is 3 times, so ['_', '_', '_']
        }
        //console.log(field); //print row-by-row
    } //End of both Outer Loop

    //field = [[ '_', '_', '_' ], [ '_', '_', '_' ]]

    // getWord = field.toString();
    // console.log(getWord);

} //End of generateField function



const print = () =>
{
    clear(); //Clear your console buffer

    const displayString = field.map(row => 
        {
            return row.join('');
        }).join('\n'); //make the join b/w the 2 inner arrays into new line

        console.log(displayString);

        getWord = displayString.toString().replace('\n', '');
} //End of print function

/*
in print() fn above, map method loops thru
- each column and join the elements w no space
- then each row and joing the elements with next line (i.e. '\n')
*/



const askQuestion = () =>
{
    //prompt
    const row = prompt('Enter Row: ');
    const column = prompt('Enter Column: ');
    const letter = prompt('Enter a letter: ').toUpperCase();

    //Change array element to the letter based on user input
    field[row][column] = letter;
}



const startGame = () =>
{
    //call the functions: generateField(), askQuestion
    //check if gameover - if win, end and display message
    //if not gameover, get user input again

    let isPlaying = true;

    while (isPlaying)
    {
        print();
        if (word == getWord)
        {
            console.log("Correct! Game Over!")
            isPlaying = false;
        }
        else
        {            
            askQuestion();
        }
    }

} //End of startGame() function

generateField(); //Call to generate 2D array field
startGame(); //Call to start game

// type in console to run: node index.js