/*
    Last Name: Boudreau
    Name: Antoine-Matis
    DA: 2139664
 */

package oss.altaspace;

import java.awt.image.BandedSampleModel;
import java.util.Scanner;

public class Formatif3AMB {
    Scanner scanner;    //  Initialise the scanner in the start.
    public Formatif3AMB(){
        this.scanner = new Scanner(System.in);
    }

    /*              OUTPUTS             */

    /**
     * Prints the question to the commandline
     * @param question enter your question here
      */
    private void printQuestion(String question){
        System.out.print(question +  "\t: ");
    }

    /*              INPUTS              */
    // @TODO Test inputs and ensure quality.
    /**
     * Ask the user its question.
     * Await valid input form user.
     * @param question enter your question here.
     * @return answer
     */
    public String readString(String question) {
        String answer = "";
        printQuestion(question);
        answer = this.scanner.nextLine();
        return answer;
    }

    /**
     * Ask the user for an int.
     * Check if it can be converted:
     * if yes return the converted answer.
     * else start over.
     * @param question enter your question here.
     * @return answer
     */
    public int readInt(String question){
        boolean isNotValid = true;
        int answer;
        answer = 0;
        String rawAnswer = "";  //  Temporary variable to store the "raw" String answer before conversion.

        while(isNotValid) {
            try {
                rawAnswer  = readString(question);
                answer = Integer.parseInt(rawAnswer);
                //  Continue if user is not trying to break the code
                isNotValid = false;
            } catch (Exception exception) {
                System.out.println("Error: " + exception + ". Please try again.");
                //  Go here if there is an error somehow
            }
        }
        return answer;
    }

    /*              CALCULATIONS            */
    // @TODO Test the calculations functions.
    /**
     * Calculate the Area of the rectangle using the formula :
     * Area =  length * height
     * @param length the length of the rectangle
     * @param height the height of the rectangle
     * @return area of the rectangle
     */
    public int computeRectangleArea( int length, int height){
        int area = length * height;
        return (area);
    }

    /**
     * Calculate the Perimeter of the rectangle using the formula :
     * Perimeter = 2*length + 2*height.
     * @param length the length of the rectengle
     * @param height the height of the rectangle
     * @returns perimeter of the rectangle.
     */
    public int computeRectanglePerimeter( int length, int height) {
        int perimeter = length*2 + height*2;
        return perimeter;
    }

    /*              CORE            */

    /**
     * Prints the rectangle infos as well as
     * calling the calculations methods if
     * necessary.
     * @TODO seperate printing from computations.
     * @param color the color of the rectangle
     * @param
     *
     */


    public static void main(String[] args) {
        new Formatif3AMB();
    }
}
