/*
    Last Name: Boudreau
    Name: Antoine-Matis
    DA: 2139664
 */

package oss.altaspace;

import java.awt.image.BandedSampleModel;
import java.util.Random;
import java.util.Scanner;
import java.math.BigInteger;


public class Formatif3AMB {
    Scanner scanner;    //  Initialise the scanner in the start.

    public Formatif3AMB() {
        this.scanner = new Scanner(System.in);
        testPrintRectanglesInfo();
        askAndPrintRectangleInfo();
    }

    /*              OUTPUTS             */

    /**
     * Prints the question to the commandline
     *
     * @param question enter your question here
     */
    private void printQuestion(String question) {
        System.out.print(question + "\t: ");
    }

    /**
     * Prints a line
     */
    private void printLine(int numberOfLine ){
        // Default parameter
        numberOfLine = numberOfLine != 0 ? numberOfLine : numberOfLine;

    }

    /*              INPUTS              */
    // @TODO Test inputs and ensure quality.

    /**
     * Ask the user its question.
     * Await valid input form user.
     *
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
     *
     * @param question enter your question here.
     * @return answer
     */
    public int readInt(String question) {
        boolean isNotValid = true;
        int answer;
        answer = 0;
        String rawAnswer = "";  //  Temporary variable to store the "raw" String answer before conversion.

        while (isNotValid) {
            try {
                rawAnswer = readString(question);
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
     *
     * @param length the length of the rectangle
     * @param height the height of the rectangle
     * @return area of the rectangle
     */
    public long computeRectangleArea(int length, int height) {
        BigInteger bigLength = BigInteger.valueOf(length);
        BigInteger bigHeight = BigInteger.valueOf(height);
        BigInteger bigArea = bigLength.multiply(bigHeight);
        Long longArea = absoluteValueOf(Long.valueOf(bigArea.toString()));
        return (longArea);

    }

    /**
     * Calculate the Perimeter of the rectangle using the formula :
     * Perimeter = 2*length + 2*height.
     *
     * @param length the length of the rectengle
     * @param height the height of the rectangle
     * @returns perimeter of the rectangle.
     */
    public long computeRectanglePerimeter(int length, int height) {
        BigInteger bigLength = BigInteger.valueOf(length);
        BigInteger bigHeight = BigInteger.valueOf(height);
        BigInteger bigPerimeter = (bigLength.multiply(BigInteger.TWO)).add(bigHeight.multiply(BigInteger.TWO));
        Long longPerimiter = absoluteValueOf(Long.valueOf(bigPerimeter.toString()));
        return (longPerimiter);
    }

    /**
     * @param number
     * @return absolute value of the number
     */
    public long absoluteValueOf(long number) {
        return (number >= 0 ? number : number * -1);
    }

    /*              CORE            */

    /**
     * Prints the rectangle info as well as
     * calling the calculations methods if
     * necessary.
     *
     * @param color  the color of the rectangle
     * @param length the length of the rectangle
     * @param height the height of the rectangle
     * @TODO seperate printing from computations.
     */
    public void printRectangleInfo(String color, int length, int height) {
        //  Compute the needed info
        long rectangleArea = computeRectangleArea(length, height);
        long rectanglePerimeter = computeRectanglePerimeter(length, height);

        //  Print the info
        System.out.println("The rectangle has a length of " + length + " and a height of " + height + ".");
        System.out.println("The rectangle is : " + color + ".");
        System.out.println("It area is : " + rectangleArea + ".");
        System.out.println("It perimeter is : " + rectanglePerimeter + ".");
    }

    /**
     * Ask the info of the rectangle.
     * Call printRectangleInfo
     */
    public void askAndPrintRectangleInfo() {
        String color = readString("What is the rectangle's color ?");
        int length = readInt("What is the rectangle's length?");
        int height = readInt("What is the rectangle's height?");

        printRectangleInfo(color, length, height);
    }

    /*              TEST            */

    /**
     * Fill the test printRectangleInfo five times with random values.
     */
    public void testPrintRectanglesInfo() {
        Random random = new Random();
        String[] randomColors = {"blue", "red", "\"", "!", "a"};
        for (int i = 1; i <= 5; i++) {
            System.out.println("Test nb : " + i);
            printRectangleInfo(randomColors[i - 1], random.nextInt(), random.nextInt());
        }
    }

    public static void main(String[] args) {
        new Formatif3AMB();
    }
}
