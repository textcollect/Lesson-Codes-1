var prompt = require('prompt-sync')({sigint: true});

// run in terminal: npm i clear-screen
// provides clear() fn to Clear your console buffer
const clear = require('clear-screen'); 

// Create some global variables (remember: const variables cannot be changed later)
const hat = '^';
const hole = 'O';
const fieldCharacter = '░';
const pathCharacter = '*';
const row = 10;
const col = 10;
const field = []; //create an empty array first

let x1 = Math.floor((Math.random() * 10)); //random number from 0 to 10
let x2 = Math.floor((Math.random() * 10) + 1); //random number from 1 to 10

let hatRow = Math.floor((Math.random() * 10)), hatCol = Math.floor((Math.random() * 10));

let index1 = 0, index2 = 0; //initialise values for the 2d array

let getHat = "";

// function to generate the field
const generateField = () => 
{
    // Nested for-loop
    //outer loop for row, inner for column
    for (let i = 0; i < row; i++)
    {
        // Create 2D array
        field[i] = []; //empty array for each row

        for (let j = 0; j < col; j++)
        {
            field[i][j] = fieldCharacter; //generates 10 fieldCharacters in i-th row
        }
    } //End of nested for-loop

    

} //End of generateField function


// fn to generate holes & hat
const holeGenerator = () =>
{
    let i = 0;

    // while loop to generate holes randomly
    while (i < Math.floor((Math.random() * 100) + 1))
    {
        field[Math.floor((Math.random() * 10))][Math.floor((Math.random() * 10))] = hole;
        i++;
    }

    //generate hat at a random position that is not (0, 0).
    //if random index is (0, 0), make it (1, 0).
    if (!(hatRow == 0 && hatCol == 0))
    {
        field[hatRow][hatCol] = hat;
    }
    else
    {
        hatRow++;
        field[hatRow][hatCol] = hat;
    }
}

// fn to print out the field in the console
const print = () =>
{
    // Clear console buffer first
    clear();

    field[0][0] = pathCharacter;

    const displayField = field.map(row =>
        {
            return row.join('');
        }).join('\n');

    
    console.log(displayField);
    //console.log(typeof(displayField)); //string

    //console.log(field.indexOf(hat));
    //getHat = displayField.toString().replace('\n', '');

}


// movement function takes in current index values and returns updated values
const movement = (doYouKnowTheWay, index1, index2) =>
{
    

    //Change array element depending on user input
    if (doYouKnowTheWay == 'u')
    {
        index1--;
    }
    else if (doYouKnowTheWay == 'd')
    {
        index1++;
    }
    else if (doYouKnowTheWay == 'l')
    {
        index2--;
    }
    else if (doYouKnowTheWay == 'r')
    {
        index2++;
    }

    return [index1, index2]; // Return an array containing both values

}

// function to prompt for user input
const askQuestion = () =>
{
    const doYouKnowTheWay = prompt('Which way? ').toLowerCase();


    if (!(doYouKnowTheWay == 'u' || doYouKnowTheWay == 'd' || doYouKnowTheWay == 'l' || doYouKnowTheWay == 'r'))
    {
        console.log("Enter (u, d, l or r)");
        askQuestion();
    }
    else
    {
        [index1, index2] = movement(doYouKnowTheWay, index1, index2);

        if (field[index1][index2] == hole)
        {
            console.log("Sorry, you fell down a hole!");
            isPlaying = false;
        }
        else
        {
            field[index1][index2] = pathCharacter;
        }
        
    }
}

const startGame = () =>
{
    let isPlaying = true;

    while (isPlaying)
    {
        print();

        if (index1 == hatRow && index2 == hatCol)
        {
            console.log("Congrats, you found your hat!");
            isPlaying = false;
        }
        else if (field[index1][index2] == hole)
        {
            console.log("Sorry, you fell down a hole!");
            isPlaying = false;
        }
        else if (index1 < 0 || index1 > 10 || index2 < 0 || index2 >10 )
        {
            console.log("Out of bounds - Game End!");
            isPlaying = false;
        }
        else
        {
            askQuestion();
        }
    }
}

generateField();
holeGenerator();
startGame();