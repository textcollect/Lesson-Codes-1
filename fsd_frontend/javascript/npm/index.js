var prompt = require('prompt-sync')({sigint: true});
const clear = require('clear-screen');

//Create some global variables
const space = '_';
const row = 2;
const column = 3;
const field = []; //an empty array
//https://www.freecodecamp.org/news/javascript-2d-arrays/

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
    } //Enf of both Outer Loop
    //result is probably supposed to be [ '_', '_', '_' ]
    //                                  [ '_', '_', '_' ]

    // getWord = field.toString();
    // console.log(getWord);

} //End of generateField function

const print = () =>
{
    clear();

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
    const column = prompt('Enter Col: ');
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

}

generateField(); //Call to generate 2D array field
startGame(); //Call to get input from user