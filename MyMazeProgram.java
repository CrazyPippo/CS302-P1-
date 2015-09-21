// See Commenting Guide (Learn@UW)
// put file header here

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

// put class header here
public class MyMazeProgram {

    // put method header here
    public static void main(String[] args) {

        // Scanner connected to keyboard for reading user input
        Scanner scnr = new Scanner(System.in);

        // Random number generated seeded according to Config file
        Random rng = new Random(Config.SEED);

        // The number that indicates which operation user wants
        int choice = 0;
        boolean mainLoop = true;
        
		while (mainLoop) {
			// DISPLAY WELCOME MESSAGE AND HELP
			System.out.println("Welcome to MyMazeProgram!\n"
					+ "1. Temperature Converter\n" + "2. Simple Robot Maze\n"
					+ "3. Random Robot Maze with Obstacle\n" + "4. Exit");
			// validate whether the input is an integer instead of other input
			try {
				choice = scnr.nextInt();
				// validate whether the input is in between 1 - 4
				if (choice >= 1 && choice <= 4)
					mainLoop = false;
				else {
					System.out.println("Invalid command");
					mainLoop = true;
				}
				scnr.nextLine();

			}// deal with input mismatch exception
			catch (InputMismatchException ex) {
				System.out.println("Input must be an integer");
				System.out.println();
				mainLoop = true;
				scnr.nextLine(); // clear input buffer
			}
			switch (choice) {
			// temperature calculator
			case 1: {
				double f = 0;
				double c = 0;
				boolean op1Loop = true;
				while (op1Loop == true) {
					System.out.println("Enter Fahrenheit temperature: ");
					try {
						f = scnr.nextDouble();
						scnr.nextLine();
						op1Loop = false;
						c = f - 100;
						System.out.println(f + " F = " + c + " C");
						mainLoop = true;
					} catch (InputMismatchException ex) {
						System.out.println("Input must be a double");
						op1Loop = true;
						scnr.nextLine();
					}
				}
				break;
			}
			// simple maze
			case 2: {
				System.out.println("Help Robot (R) get to Exit (E)");
				boolean op2Loop = true;// maze menu loop 
				int op2Direction = 0; // stores user input for maze direction
				int RRowPosition = 0; // tracking R's row position
				int RColumnPosition = 0; // tracking R's column position
				int move = 0;
				while (op2Loop) {
					// display the  maze
					for (int i = 0; i < 5; i++) {
						System.out.println("");
						for (int j = 0; j < 5; j++) {
							// print "R" at specified positions
							if(i == RRowPosition & j == RColumnPosition){
								System.out.print(" R");
							}
							else if (i == 4 & j == 4)
								System.out.print(" E");// default E position
							else
								System.out.print(" o");
						}
					}
					// prompt user to input
					System.out.println("");

					System.out.println("1. up\n" + "2. down\n" + "3. left\n"
							+ "4. right\n");
					// try to get the integer input for direction
					try {
						op2Direction = scnr.nextInt();
						scnr.nextLine(); // clear input buffer

						if (op2Direction >= 1 & op2Direction <= 4) {
							op2Loop = false;
						}
						// return back to the prompt if input is not a valid
						// integer
						else {
							System.out.println("Invalid command");
							op2Loop = true;
						}
					}
					// deal with invalid input
					catch (InputMismatchException ex) {
						System.out.println("Input must be an integer");
						op2Loop = true;
						scnr.nextLine(); // clear input buffer
					}
					// modify the maze according to the input
					if (op2Loop == false) {
						switch (op2Direction) {
						case 1: {
							// cannot move
							if (RRowPosition == 0) {
								System.out.println("Cannot move");
							} else {
								RRowPosition --;
							}
							op2Loop = true;// return to maze menu
							break;
						}
						case 2: {
							if (RRowPosition == 4) {
								System.out.println("Cannot move");
							} else {
								RRowPosition ++;
							}
							op2Loop = true;
							break;
						}
						case 3: {
							if (RColumnPosition == 0) {
								System.out.println("Cannot move");
							} else {
								RColumnPosition --;
							}
							op2Loop = true;
							break;
						}
						case 4: {
							if (RColumnPosition == 4) {
								System.out.println("Cannot move");
							} else {
								RColumnPosition ++;
							}
							op2Loop = true;
							break;
						}
						}
						move++;// increment move steps at every move
						// back to main menu once maze is solved
						if (RRowPosition == 4 & RColumnPosition == 4) {
							System.out.println("Nailed the maze!" + " ,and "
									+ move + " Steps total");
							System.out.println("");
							op2Loop = false;
							mainLoop = true;
						}
					}
				}
				break;
			}
			case 3 : {
				boolean validDimension = false;
				boolean op3Loop = true; // maze menu loop 
				boolean validXRowPosition = false;
				int op3Direction = 0; // stores user input for maze direction
				int RRowPosition = 0; // tracking R's row position
				int RColumnPosition = 0; // tracking R's column position
				int ERowPosition = 0; // tracking E's row position
				int EColumnPosition = 0; // tracking E's column position
				int XRowPosition = 0; // tracking E's row position
				int XColumnPosition = 0; // tracking E's column position
				int dimension = 0; // dimension for the maze
				int move = 0;
				System.out.println("Help Robot (R) get to Exit (E)");
				// obtain the dimension
				while(!validDimension){
					System.out.println("How big is the maze? (3-10)");
					try{
						dimension = scnr.nextInt();
						if(dimension >= 3 & dimension <= 10){
							validDimension = true;
						}
						else{
							System.out.println("Invalid dimension");
							validDimension = false;
						}
						scnr.nextLine(); // clear input buffer
					}
					catch (InputMismatchException ex){
						scnr.nextLine();
						System.out.println("Must be an integer");
						validDimension = false;
					}
				}
				ERowPosition = dimension - 1;
				// initialize X E R's positions
				RColumnPosition = rng.nextInt(dimension - 1);
				EColumnPosition = rng.nextInt(dimension - 1);
				XColumnPosition = rng.nextInt(dimension - 1);
				// ensure X is not in the top or bottle row
				while (!validXRowPosition) {
					XRowPosition = rng.nextInt(dimension - 1);
					if(XRowPosition == 0 || XRowPosition == 4)
						validXRowPosition = false;
					else
						validXRowPosition = true;
				}
				// maze menu loop
				while (op3Loop) {
					// display the  maze
					for(int i = 0; i < dimension; i++) {
						System.out.println("");
						for ( int j = 0; j < dimension; j++) {
							// print "R" if R reaches "E" and other specified positions
							if((i == RRowPosition & j == RColumnPosition)){
								System.out.print(" R");
							}
							else if (i == ERowPosition & j == EColumnPosition)
								System.out.print(" E");// default E position
							else if (i == XRowPosition & j == XColumnPosition)
								System.out.print(" X");// default E position
							else
								System.out.print(" o");
						}
					}
					// prompt user to input
					System.out.println("");

					System.out.println("1. up\n" + "2. down\n" + "3. left\n"
							+ "4. right\n");
					// try to get the integer input
					try {
						op3Direction = scnr.nextInt();
						scnr.nextLine(); // clear input buffer

						if (op3Direction >= 1 & op3Direction <= 4) {
							op3Loop = false;
						}
						// return back to the prompt if input is not a valid
						// integer
						else {
							System.out.println("Invalid command");
							op3Loop = true;
						}
					}
					// deal with invalid input
					catch (InputMismatchException ex) {
						System.out.println("Input must be an integer");
						op3Loop = true;
						scnr.nextLine(); // clear input buffer
					}
					// modify the maze according to the input
					if (op3Loop == false) {
						switch (op3Direction) {
						case 1: {
							// cannot move
							if (RRowPosition == 0) 
								System.out.println("Cannot move");
							
							else if (RRowPosition == XRowPosition - 1 & RColumnPosition == XColumnPosition)
								System.out.println("Cannot move");
								
							else {
								RRowPosition--;
							}
							op3Loop = true;// return to maze menu
							break;
						}
						case 2: {
							if (RRowPosition == dimension - 1) 
								System.out.println("Cannot move");
							else if (RRowPosition == XRowPosition + 1 & RColumnPosition == XColumnPosition)
								System.out.println("Cannot move");
								
							
							 else {
								RRowPosition++;
							}
							op3Loop = true;
							break;
						}
						case 3: {
							if (RColumnPosition == 0) 
								System.out.println("Cannot move");
							
							else if (RRowPosition == XRowPosition & RColumnPosition - 1 == XColumnPosition)
								System.out.println("Cannot move");
								
							 else {
								RColumnPosition--;
							}
							op3Loop = true;
							break;
						}
						case 4: {
							if (RColumnPosition == dimension - 1) 
								System.out.println("Cannot move");
							
							else if (RRowPosition == XRowPosition & RColumnPosition + 1 == XColumnPosition)
								System.out.println("Cannot move");
								
							 else {
								RColumnPosition++;
							}
							op3Loop = true;
							break;
						}
						}
						move++;
						// back to main menu once maze is solved
						if (RRowPosition == ERowPosition
								& RColumnPosition == EColumnPosition) {
							System.out.println("Nailed the maze! And " + move
									+ " steps total");
							System.out.println("");
							op3Loop = false;
							mainLoop = true;
			}
					}
				}
				break;
			}
			
			case 4 : {
				System.out.println("Program terminated");
				System.exit(0);
			}
			}
		}
        scnr.close();
    }   
} 
