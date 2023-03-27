/**
 * Group Members:
 * Alvarez, Maria Alexandra
 * Balogo, Renuel Jeremi
 * Cagulada, Sheryn Ann
 * Lumanglas, Yenzy Hynna
 * Palacay, Abigail
 *
 * Class Code and Schedule: 9315 CS122 MTh 9:00 - 10:30
 */

package midterms;

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
     * Create a constructor that can accept a whole number and fraction
     */
    public MixedFraction (int wholeNumber, Fraction fraction){
        super();
        this.wholeNumber = wholeNumber;
    } // end of MixedFraction method

    /**
     * Create a constructor that can accept a fraction
     */
    public MixedFraction(Fraction fraction) {
        super();
    } // end of MixedFraction method

    /**
     * Set the Whole Number
     */
    public void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    } // end of setWholeNumber method

    /**
     * set Fraction
     */
    public void setFraction(Fraction fraction) {

    } // end of setFraction method


    /**
     * Get Whole Number
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
        else
            return this.wholeNumber + " " + super.toString();
    } // end of toString method

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
        Fraction frac1 = new Fraction();
        Fraction frac2 = new Fraction();

        frac1 = this.mixedToImproper();
        frac2 = other.mixedToImproper();

        Fraction sFrac = new Fraction();
        sFrac = frac1.addFraction(frac2);
        sFrac = sFrac.reduceFraction();

        MixedFraction sMixed = new MixedFraction();
        sMixed = sFrac.improperToMixed();

        return new MixedFraction(sMixed.getNumerator(), sMixed.getDenominator(), sMixed.getWholeNumber());
    } // end of add method

    /**
     * Create a method that will subtract the mixed fractions
     */
    public MixedFraction subtract(MixedFraction other) {
        Fraction frac1 = new Fraction();
        Fraction frac2 = new Fraction();

        frac1 = this.mixedToImproper();
        frac2 = other.mixedToImproper();

        Fraction dFrac = new Fraction();
        dFrac = frac1.subtractFraction(frac2);
        dFrac = dFrac.reduceFraction();

        MixedFraction dMixed = new MixedFraction();
        dMixed = dFrac.improperToMixed();

        return new MixedFraction(dMixed.getNumerator(), dMixed.getDenominator(), dMixed.getWholeNumber());
    } // end of subtract method

    /**
     * Create a method that will multiply the mixed fractions
     */
    public MixedFraction multiply(MixedFraction other) {
        Fraction frac1 = new Fraction();
        Fraction frac2 = new Fraction();

        frac1 = this.mixedToImproper();
        frac2 = other.mixedToImproper();

        Fraction pFrac = new Fraction();
        pFrac = frac1.multiplyFraction(frac2);
        pFrac = pFrac.reduceFraction();

        MixedFraction pMixed = new MixedFraction();
        pMixed = pFrac.improperToMixed();

        return new MixedFraction(pMixed.getNumerator(), pMixed.getDenominator(), pMixed.getWholeNumber());
    } // end of multiply method

    /**
     * Create a method that will divide the mixed fractions
     */
    public MixedFraction divide(MixedFraction other) {
        Fraction frac1 = new Fraction();
        Fraction frac2 = new Fraction();

        frac1 = this.mixedToImproper();
        frac2 = other.mixedToImproper();

        Fraction qFrac = new Fraction();
        qFrac = frac1.divideFraction(frac2);
        qFrac = qFrac.reduceFraction();

        MixedFraction qMixed = new MixedFraction();
        qMixed = qFrac.improperToMixed();

        return new MixedFraction(qMixed.getNumerator(), qMixed.getDenominator(), qMixed.getWholeNumber());
    } // end of divide method
} // end of MixedFraction method
