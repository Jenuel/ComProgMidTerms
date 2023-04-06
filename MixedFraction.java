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

public class MixedFraction extends Fraction {

    /**
     * Declare data members as private for encapsulation
     */
    private int wholeNumber;

    /**
     * Default Constructor
     */
    public MixedFraction() {
        super();
        this.wholeNumber = 0;
    } // end of MixedFraction method

    /**
     * Constructor with Parameters
     */
    public MixedFraction(int num, int den, int wholeNumber) {
        super(num, den);
        this.wholeNumber = wholeNumber;
    } // end of MixedFraction method

    /**
     * A constructor that can accept a whole number and fraction
     */
    public MixedFraction (int wholeNumber, Fraction fraction){
        super(fraction.getNumerator(), fraction.getDenominator());
        this.wholeNumber = wholeNumber;
    } // end of MixedFraction method

    /**
     * A constructor that can accept a fraction
     */
    public MixedFraction(Fraction fraction) {
        super(fraction.getNumerator(), fraction.getDenominator());
    } // end of MixedFraction method

    /**
     * A method that can set the whole number when called
     */
    public void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    } // end of setWholeNumber method

    /**
     * A method that can set the fraction part when called
     */
    public void setFraction(Fraction fraction) {
        this.setNumerator(fraction.getNumerator());
        this.setDenominator(fraction.getDenominator());
    } // end of setFraction method

    /**
     * A method that will return the whole number part when called
     */
    public int getWholeNumber() {
        return wholeNumber;
    } // end of getWholeNumber method

    /**
     * Get Fraction
     */
    public Fraction getFraction() {
        return new Fraction(this.getNumerator(), this.getDenominator());
    } //end of getFraction method

    /**
     * Create a toString method for the string representation of a mixed fraction
     */
    public String toString() {
        if (wholeNumber == 0)
            return " " + super.toString();
        else if (this.getNumerator() % this.getDenominator() == 0 || this.getNumerator() == 0)
            return this.wholeNumber + "";
        else
            return this.wholeNumber + " " + super.toString();
    } // end of toString method

    /**
     * Create a toDouble method to convert a mixed fraction to decimal
     */

    public double toDouble(){
        double result;
        Fraction fraction;

        fraction = this.mixedToImproper();
        result = fraction.toDouble();

        return result;
    }

    /**
     * Create a method that will convert a mixed fraction to an improper fraction
     */
    public Fraction mixedToImproper() {
        return new Fraction(this.getWholeNumber() * this.getDenominator() + this.getNumerator(), this.getDenominator());
    } // end of mixedToImproper method


    /**
     * Create a method that will add the mixed fractions
     */
    public MixedFraction add (MixedFraction other) {
        Fraction frac1;
        Fraction frac2;

        frac1 = this.mixedToImproper();
        frac2 = other.mixedToImproper();

        Fraction sFrac;
        sFrac = frac1.addFraction(frac2);
        sFrac = sFrac.reduceFraction();

        MixedFraction sMixed;
        sMixed = sFrac.improperToMixed();

        return new MixedFraction(sMixed.getNumerator(), sMixed.getDenominator(), sMixed.getWholeNumber());
    } // end of add method

    /**
     * Create a method that will subtract the mixed fractions
     */
    public MixedFraction subtract(MixedFraction other) {
        Fraction frac1;
        Fraction frac2;

        frac1 = this.mixedToImproper();
        frac2 = other.mixedToImproper();

        Fraction dFrac;
        dFrac = frac1.subtractFraction(frac2);
        dFrac = dFrac.reduceFraction();

        MixedFraction dMixed;
        dMixed = dFrac.improperToMixed();

        return new MixedFraction(dMixed.getNumerator(), dMixed.getDenominator(), dMixed.getWholeNumber());
    } // end of subtract method

    /**
     * Create a method that will multiply the mixed fractions
     */
    public MixedFraction multiply(MixedFraction other) {
        Fraction frac1;
        Fraction frac2;

        frac1 = this.mixedToImproper();
        frac2 = other.mixedToImproper();

        Fraction pFrac;
        pFrac = frac1.multiplyFraction(frac2);
        pFrac = pFrac.reduceFraction();

        MixedFraction pMixed;
        pMixed = pFrac.improperToMixed();

        return new MixedFraction(pMixed.getNumerator(), pMixed.getDenominator(), pMixed.getWholeNumber());
    } // end of multiply method

    /**
     * Create a method that will divide the mixed fractions
     */
    public MixedFraction divide(MixedFraction other){
        Fraction frac1;
        Fraction frac2;

        frac1 = this.mixedToImproper();
        frac2 = other.mixedToImproper();

        Fraction qFrac;
        qFrac = frac1.divideFraction(frac2);
        qFrac = qFrac.reduceFraction();

        MixedFraction qMixed;
        qMixed = qFrac.improperToMixed();

        return new MixedFraction(qMixed.getNumerator(), qMixed.getDenominator(), qMixed.getWholeNumber());
    } // end of divide method
} // end of MixedFraction method
