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

/**
 * Superclass for object-type Fraction
 */
public class Fraction {

    /**
     * Declares data members as private for encapsulation
     */
    private int numerator;
    private int denominator;

    /**
     * Creates no-argument constructor
     * <p>Initializes numerator and denominator</p>
     */
    public Fraction(){
        numerator = 0;
        denominator = 1;
    } // end of Fraction method

    /**
     * Creates a Fraction parameterized constructor
     * @param num The numerator
     * @param den The denominator
     */
    public Fraction(int num, int den){
        numerator = num;
        denominator = den;
    } // end of Fraction method

    /**
     * Creates parameterized constructor for whole number args
     * <p>Initializes numerator to the value of the whole number,
     * and the denominator to 1</p>
     * @param wholeNumVal The whole number value
     */
    public Fraction(int wholeNumVal){
        numerator = wholeNumVal;
        denominator = 1;
    } // end of Fraction method

    /**
     * Sets the numerator value
     * @param num The numerator value
     */
    public void setNumerator(int num){numerator = num;} // end of setNumerator method

    /**
     * Sets the denominator value
     * @param den The denominator value
     */
    public void setDenominator(int den){
        denominator = den;
    } // end of setDenominator method

    /**
     * Gets the numerator value
     * @return <code> int </code> specifying the numerator value
     */
    public int getNumerator(){return numerator;} // end of getNumerator method

    /**
     * Gets the denominator value
     * @return <code> int </code> specifying the denominator value
     */
    public int getDenominator(){
        return denominator;
    } // end of getDenominator method

    /**
     * Returns a string format of the fraction.
     * <p>If the numerator is 0, fraction string becomes "0".</p>
     * <p>If the denominator is 1, string is the "numerator".</p>
     * <p>Otherwise, string uses "/" to separate numerator and denominator.</p>
     * @return <code> string </code> representing the fraction
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
     * Returns a decimal form of the fraction.
     * @return <code> double </code> representing fraction in
     * decimal form by dividing numerator with denominator
     */
    public double toDouble(){
        return (double) numerator/denominator;
    }

    /**
     * Recursively computes the greatest common divisor (GCD).
     * <p>If either number is zero, the GCD is the other number.</p>
     * <p>Otherwise, the method recursively calls itself with the
     * second number, and the remainder of the first number divided
     * by the second number.</p>
     * @param a The first number value
     * @param b The second number value
     * @return <code> int </code> representing the GCD of two values
     */
    private int computeGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return computeGCD(b, a % b);
    } // end of computeGCD method

    /**
     * <h3>Adds Fractions</h3>
     * <p>Computes the numerator by adding the products from multiplying
     * each fraction's numerator with the other fraction's denominator.</p>
     * <p>Computes the denominator by multiplying each fraction's
     * denominator.</p>
     * @param fraction2 Fraction to add to this fraction
     * @return <code> Fraction </code> representing the new Fraction
     * that is the sum of two Fractions.
     */
    public Fraction addFraction (Fraction fraction2){
        int computedNum;
        int computedDen;

        computedNum = ((this.getNumerator() * fraction2.getDenominator()) + (this.getDenominator() * fraction2.getNumerator()));
        computedDen = this.getDenominator() * fraction2.getDenominator();

        return new Fraction(computedNum, computedDen);
    } // end of addFraction method

    /**
     * <h3>Subtracts Fractions</h3>
     * <p>Computes the numerator by subtracting the products from
     * each fraction's numerator by the other fraction's denominator.</p>
     * <p>Computes the denominator by multiplying each fraction's
     * denominator.</p>
     * @param fraction2 Fraction to subtract from this fraction
     * @return <code> Fraction </code> representing the new Fraction
     * that is the difference of two Fractions.
     */
    public Fraction subtractFraction(Fraction fraction2){
        int computedNum;
        int computedDen;

        computedNum = ((this.getNumerator() * fraction2.getDenominator()) - (this.getDenominator() * fraction2.getNumerator()));
        computedDen = this.getDenominator() * fraction2.getDenominator();

        return new Fraction(computedNum, computedDen);
    } // end of subtractFraction method

    /**
     * <h3>Multiplies Fractions</h3>
     * <p>Computes the numerator by multiplying each fraction's
     * numerator.</p>
     * <p>Computes the denominator by multiplying each fraction's
     * denominator.</p>
     * @param fraction2 Fraction to multiply to this fraction
     * @return <code> Fraction </code> representing the new Fraction
     * that is the product of two Fractions.
     */
    public Fraction multiplyFraction(Fraction fraction2){
        int productNumerator;
        int productDenominator;

        productNumerator = this.getNumerator() * fraction2.getNumerator();
        productDenominator = this.getDenominator() * fraction2.getDenominator();

        return new Fraction(productNumerator, productDenominator);
    } // end of multiplyFraction method

    /**
     * <h3>Divides Fractions</h3>
     * <p>Computes the numerator by multiplying the numerator of
     * this fraction to the denominator of the other fraction.</p>
     * <p>Computes the denominator by multiplying the denominator of
     * this fraction to the numerator of the other fraction.</p>
     * @param fraction2 Fraction to divide by this fraction
     * @return <code> Fraction </code> representing the new Fraction
     * that is the quotient of two Fractions.
     */
    public Fraction divideFraction(Fraction fraction2){
        int computedNum;
        int computedDen;

        computedNum = this.getNumerator() * fraction2.getDenominator();
        computedDen = this.getDenominator() * fraction2.getNumerator();

        return new Fraction(computedNum, computedDen);
    } // end of divideFraction method

    /**
     * <h3>Reduces a Fraction to its lowest term</h3>
     * <p>Divides the numerator, and denominator by the GCD of the
     * numerator and denominator to compute their lowest terms.</p>
     * @return <code> Fraction </code> representing the new Fraction
     * that is the reduced Fraction.
     */
    public Fraction reduceFraction(){
        int reducedNumerator;
        int reducedDenominator;

        reducedNumerator = this.getNumerator() / computeGCD(this.getNumerator(),this.getDenominator());
        reducedDenominator = this.getDenominator() / computeGCD(this.getNumerator(), this.getDenominator());

        return new Fraction(reducedNumerator, reducedDenominator);
    } // end of reduceFraction method

 /**
     * Returns a mixed fraction form of the fraction.
     * <p>If the numerator is a multiple of the denominator, the
     * mixed fraction with an equivalent fraction part and
     * no whole number is returned.</p>
     * <p>If the denominator is of negative value, the method returns
     * mixed fraction with:
     * <p>- absolute value of numerator (<code>numerator%denominator</code>),
     * <p>- absolute value of denominator,
     * <p>- and whole number (<code>numerator / denominator</code>).</p>
     * <p>Otherwise, computation of mixed fraction parameters from the second
     * condition retains but the denominator doesn't have to be of absolute
     * value.</p>
     * @return <code> MixedFraction </code> representing the converted
     * new Mixed Fraction
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
