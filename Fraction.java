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
     * Compute for least common denominator (lcd)
     */
    private int computeLCD(int den1, int den2){
        return den1*den2/computeGCD(den1,den2);
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
    public Fraction multiplyFraction(Fraction fraction1, Fraction fraction2){
        int productNumerator;
        int productDenominator;

        productNumerator = fraction1.getNumerator() * fraction2.getNumerator();
        productDenominator = fraction1.getDenominator() * fraction2.getDenominator();

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
    public Fraction reduceFraction(Fraction fraction){
        int gcf;
        int reducedNumerator;
        int reducedDenominator;

        gcf = computeGCD(fraction.getNumerator(), fraction.getDenominator());

        reducedNumerator = fraction.getNumerator() / gcf;
        reducedDenominator = fraction.getDenominator() / gcf;

        return new Fraction(reducedNumerator, reducedDenominator);
    }
   
    public MixedFraction improperToMixed() {
        if (numerator % denominator == 0)
            return new MixedFraction(this.numerator, this.getDenominator(), 0);
        else
            return new MixedFraction(Math.abs(this.getNumerator() % this.getDenominator()), this.getDenominator(), this.getNumerator() / this.getDenominator());
    }
}
