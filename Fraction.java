/**
 * Group Members:
 * Alvarez, Maria Alexandra
 * Balogo, Renuel Jeremi
 * Cagulada, Sheryn Ann
 * Lumanglas, Yenzy Hynna
 * Palacay, Abigail
 * Class Code and Schedule: 9315 CS122 MTh 9:00 - 10:30
 */

package prog2.prelimgroup;

public class Fraction {

    /**
     * Declare data members as private for encapsulation
     */
    private int numerator;
    private int denominator;

    /**
     * Declare default Constructor
     */
    public Fraction(){
        numerator = 0;
        denominator = 1;
    } // end of Fraction method

    /**
     * Create a constructor with parameters
     */
    public Fraction(int num, int den){
        numerator = num;
        denominator = den;
    } // end of Fraction method

    /**
     * Create a Fraction method where denominator is 1 and the numerator is whole number value
     */
    public Fraction(int wholeNumVal){
        numerator = wholeNumVal;
        denominator = 1;
    } // end of Fraction method

    /**
     * Create a setter method for your numerator
     */
    public void setNumerator(int num){numerator = num;} // end of setNumerator method

    /**
     * Create a setter method for your denominator
     */
    public void setDenominator(int den){
        denominator = den;
    } // end of setDenominator method

    /**
     *  Create a getter method for your numerator
     */
    public int getNumerator(){return numerator;} // end of getNumerator method

    /**
     * Create a getter method for your denominator
     */
    public int getDenominator(){
        return denominator;
    } // end of getDenominator method

    /**
     * Create a toString method for the string representation of a fraction
     */
    public String toString(){
        if (numerator == 0 && denominator != 0) {
            return 0 + "";
        } else if (denominator == 1) {
            return numerator + "";
        } else
            return numerator + "/" + denominator;
    }  // end of toString method

    /**
     * Create a method to Convert Fraction to Decimal
     */
    public double toDouble(){
        return (double) numerator/denominator;
    }

    /**
     * Create a recursive method to compute for greatest common divisor (gcd)
     */
    private int computeGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return computeGCD(b, a % b);
    } // end of computeGCD method

    /**
     * Create a method where you can Add Fractions
     */
    public Fraction addFraction (Fraction fraction2){
        int computedNum;
        int computedDen;

        computedNum = ((this.getNumerator() * fraction2.getDenominator()) + (this.getDenominator() * fraction2.getNumerator()));
        computedDen = this.getDenominator() * fraction2.getDenominator();

        return new Fraction(computedNum, computedDen);
    } // end of addFraction method

    /**
     * Create a method to subtract Fractions
     */
    public Fraction subtractFraction(Fraction fraction2){
        int computedNum;
        int computedDen;

        computedNum = ((this.getNumerator() * fraction2.getDenominator()) - (this.getDenominator() * fraction2.getNumerator()));
        computedDen = this.getDenominator() * fraction2.getDenominator();

        return new Fraction(computedNum, computedDen);
    } // end of subtractFraction method

    /**
     * Create a method where you can Multiply Fraction
     **/
    public Fraction multiplyFraction(Fraction fraction2){
        int productNumerator;
        int productDenominator;

        productNumerator = this.getNumerator() * fraction2.getNumerator();
        productDenominator = this.getDenominator() * fraction2.getDenominator();

        return new Fraction(productNumerator, productDenominator);
    } // end of multiplyFraction method

    /**
     * Create a method to Divide Fractions
     */
    public Fraction divideFraction(Fraction fraction2){
        int computedNum;
        int computedDen;

        computedNum = this.getNumerator() * fraction2.getDenominator();
        computedDen = this.getDenominator() * fraction2.getNumerator();

        return new Fraction(computedNum, computedDen);
    } // end of divideFraction method

    /**
     * Create a method to Reduce a Fraction
     */
    public Fraction reduceFraction(){
        int reducedNumerator;
        int reducedDenominator;

        reducedNumerator = this.getNumerator() / computeGCD(this.getNumerator(),this.getDenominator());
        reducedDenominator = this.getDenominator() / computeGCD(this.getNumerator(), this.getDenominator());

        return new Fraction(reducedNumerator, reducedDenominator);
    } // end of reduceFraction method

    /**
     * Create a method that will convert an improper fraction to mixed fraction
     */
    public MixedFraction improperToMixed() {
        if (numerator % denominator == 0)
            return new MixedFraction(this.numerator, this.getDenominator(), 0);
        else if (this.getNumerator()/this.getDenominator() < 0 && this.getDenominator() < 0) {
            return new MixedFraction(Math.abs(this.getNumerator() % this.getDenominator()), Math.abs(this.getDenominator()),
            this.getNumerator()/this.getDenominator());
        } else
            return new MixedFraction(Math.abs(this.getNumerator() % this.getDenominator()), this.getDenominator(),
                    this.getNumerator() / this.getDenominator());
    } // end of improperToMixed method
} // end of Fraction class
