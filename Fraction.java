/*
 * Group Members:
 * Alvarez, Maria Alexandra
 * Balogo, Renuel Jeremi
 * Cagulada, Sheryn Ann
 * Lumanglas, Yenzy Hynna
 * Palacay, Abigail
 *
 * Class Code and Schedule: 9315 CS122 MTh 9:00 - 10:30
 */
package prog2.prelimgroup;

import java.util.Scanner;
public class Fraction {

    /*
     * Data Members
     */
    private int numerator;
    private int denominator;

    /*
     * Default Constructor
     */
    public Fraction(){
        numerator = 0;
        denominator = 1;
    }

    /*
     * Constructor with parameters
     */
    public Fraction(int num, int den){
        numerator = num;
        denominator = den;
    }

    public Fraction(int wholeNumVal){
        numerator = wholeNumVal;
        denominator = 1;
    }
    /*
     * Set the numerator
     */
    public void setNumerator(int num){numerator = num;}

    /*
     * Set the denominator
     */
    public void setDenominator(int den){
        denominator = den;
    }

    /*
     * Get the numerator
     */
    public int getNumerator(){
        return numerator;
    }

    /*
     * Get the denominator
     */
    public int getDenominator(){
        return denominator;
    }

    /*
     * Concatenate the variables
     */
    public String toString(){
        if (numerator == 0 && denominator != 0) {
            return 0 + "";
        } else if (denominator == 1) {
            return numerator + "";
        } else
            return numerator + "/" + denominator;
    }

    /*
     * Convert Fraction to Decimal
     */
    public double toDouble(){
        return (double) numerator/denominator;
    }


    /*
     * Compute for greatest common divisor (gcd)
     */
    private int computeGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return computeGCD(b, a % b);
    }

    /*
     * Read/Accept a Fraction
     */
    public Fraction readAFraction() {
        Scanner keyboard = new Scanner(System.in);
        int rNum = 0;
        int rDen = 0;
        boolean validNumberRead = false;

        while (!validNumberRead) {
            try {
                System.out.print("Enter a numerator: ");
                rNum = Integer.parseInt(keyboard.nextLine());
                validNumberRead = true;
            } catch (NumberFormatException exception) {
                System.out.println("You have to enter a number");
            }
        }

        validNumberRead = false;
        while (!validNumberRead){
            try {
                System.out.print("Enter a denominator: ");
                rDen = Integer.parseInt(keyboard.nextLine());
                if (rDen == 0)
                    System.out.println("Denominator must not be equal to 0");
                else validNumberRead = true;
            } catch (NumberFormatException exception){
                System.out.println("You have to enter a number");
            }
        }
        return new Fraction(rNum, rDen);
    }

    /*
     * Addition of Fractions
     */

    public Fraction addFraction (Fraction fraction2){
        int computedNum;
        int computedDen;

        computedNum = ((this.getNumerator() * fraction2.getDenominator()) + (this.getDenominator() * fraction2.getNumerator()));
        computedDen = this.getDenominator() * fraction2.getDenominator();

        return new Fraction(computedNum, computedDen);
    }


    /*
     * Subtraction of Fractions
     */
    public Fraction subtractFraction(Fraction fraction2){
        int computedNum;
        int computedDen;

        computedNum = ((this.getNumerator() * fraction2.getDenominator()) - (this.getDenominator() * fraction2.getNumerator()));
        computedDen = this.getDenominator() * fraction2.getDenominator();

        return new Fraction(computedNum, computedDen);
    }

    /*
     * Multiplication of Fractions
     */
    public Fraction multiplyFraction(Fraction fraction2){
        int productNumerator;
        int productDenominator;

        productNumerator = this.getNumerator() * fraction2.getNumerator();
        productDenominator = this.getDenominator() * fraction2.getDenominator();

        return new Fraction(productNumerator, productDenominator);
    }

    /*
     * Division of Fractions
     */
    public Fraction divideFraction(Fraction fraction2){
        int computedNum;
        int computedDen;

        computedNum = this.getNumerator() * fraction2.getDenominator();
        computedDen = this.getDenominator() * fraction2.getNumerator();

        return new Fraction(computedNum, computedDen);
    }

    /*
     * Reduce a Fraction
     */
    public Fraction reduceFraction(){
        int gcf;
        int reducedNumerator;
        int reducedDenominator;

        gcf = computeGCD(this.getNumerator(), this.getDenominator());

        reducedNumerator = this.getNumerator() / gcf;
        reducedDenominator = this.getDenominator() / gcf;

        return new Fraction(reducedNumerator, reducedDenominator);
    }

    public MixedFraction improperToMixed() {
        if (numerator % denominator == 0)
            return new MixedFraction(this.numerator, this.getDenominator(), 0);
        else
            return new MixedFraction(Math.abs(this.getNumerator() % this.getDenominator()), this.getDenominator(), this.getNumerator() / this.getDenominator());
    }
}
