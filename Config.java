*
 * Contains constants that will be used by MyEpicProgram
 * for controlling some parameters of the program.
 * 
 * DO NOT EDIT THE VARIABLE NAMES OR TYPES 
 * OR ADD VARIABLES TO THIS FILE.
 * This file will not be handed in, we will use our
 * own config file.
 *
 * Values that are defined here must be used by name
 * because we will change these values to ensure that
 * your program works with any settings.
 *
 * You may assume that SEED will be a valid integer. It may be negative.
 * You may assume that MIN will be a positive integer 3 or greater.
 * You may assume that MAX will be a positive integer greater than or equal to MIN.
 * You may assume that MAX will be less than or equal to 40.
 *
 * Use these values instead of hard-coding the literal value
 * in places where these values are needed.
 *
 * @author Deb Deppeler deppeler@cs.wisc.edu
 */
public class Config {

    /** Used to seed the java.util.Random object for generating
     * random numbers needed by the Robot Maze.  
     * By seeding the Random generator, we can predict
     * the "pseudo-random" values that will be generated.
     * This predicitability aids in program development 
     * and allows for automated grading.
     */
    public static final int SEED = 3;

    /**
     * MIN is use to determine the minimum number of rows 
     * and columns that a user can choose for their 
     * Robot Maze problem.
     */
    public static final int MIN = 3;

    /**
     * MAX is use to determine the maximum number of rows 
     * and columns that a user can choose for their 
     * Robot Maze problem.  It must be greater than or
     * equal to the value in MIN. 
     */
    public static final int MAX = 10;

}
