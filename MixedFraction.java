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
 * MixedFraction class represents a type of fraction which
 * consists of a whole number and a fraction part.
 * Mixed Fraction class is a subclass of Fraction class
 */
public class MixedFraction extends Fraction {

    /**
     * Declares data members as private for encapsulation
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
     * Creates no-argument constructor.
     * <p>Initializes numerator and denominator using superclass
     * constructor.</p>
     * <p>Initializes variable for whole number.</p>
     */
    public MixedFraction(int num, int den, int wholeNumber) {
        super(num, den);
        this.wholeNumber = wholeNumber;
    } // end of MixedFraction method

    /**
     * Creates MixedFraction parameterized constructor.
     * <p>Initializes numerator and denominator using superclass.</p>
     * <p>Initializes instance variable whole number with its
     * parameter value.</p>
     * @param num The numerator
     * @param den The denominator
     * @param wholeNumber The whole number
     */
    public MixedFraction (int wholeNumber, Fraction fraction){
        super(fraction.getNumerator(), fraction.getDenominator());
        this.wholeNumber = wholeNumber;
    } // end of MixedFraction method

    /**
     * Creates parameterized constructor for whole number and fraction
     * args.
     * <p>Initializes Fraction variables using super() method with
     * numerator and denominator args.</p>
     * <p>Initializes instance variable whole number with its
     * parameter value.</p>
     * @param fraction The fraction part
     * @param wholeNumber The whole number part
     */
    public MixedFraction(Fraction fraction) {
        super(fraction.getNumerator(), fraction.getDenominator());
    } // end of MixedFraction method

    /**
     * Creates mixed fraction parameterized constructor for fraction
     * args.
     * <p>Initializes Fraction variables using super() method with
     * numerator and denominator args.</p>
     * @param fraction The fraction
     */
    public void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    } // end of setWholeNumber method

    /**
     * Sets the whole number value
     * @param wholeNumber The whole number value
     */
    public void setFraction(Fraction fraction) {
        this.setNumerator(fraction.getNumerator());
        this.setDenominator(fraction.getDenominator());
    } // end of setFraction method

    /**
     * Sets the mixed fraction numerator and denominator values.
     * @param fraction The fraction numerator and denominator values.
     */
    public int getWholeNumber() {
        return wholeNumber;
    } // end of getWholeNumber method

    /**
     * Gets the whole number value.
     * @return <code> int </code> representing the whole number.
     */
    public Fraction getFraction() {
        return new Fraction(this.getNumerator(), this.getDenominator());
    } //end of getFraction method

    /**
     * Gets the fraction values
     * @return <code> Fraction </code> representing fraction with the
     * numerator and denominator.
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
     * Returns a string format of the mixed fraction.
     * <p>If the whole number is 0, mixed fraction string does not have
     * whole number and uses superclass method {@link Fraction#toString()}
     * for the fraction part string.</p>
     * <p>If the numerator is a multiple of denominator or if it is 0,
     * mixed fraction string is the whole number with no fraction part.</p>
     * <p>Otherwise, string consists of the whole number separated by a
     * space to the fraction part that uses superclass method
     * {@link Fraction#toString()}.</p>
     * @return <code> string </code> representing the mixed fraction
     */
    public double toDouble(){
        double result;
        Fraction fraction;

        fraction = this.mixedToImproper();
        result = fraction.toDouble();

        return result;
    }

    /**
     * Returns an improper fraction form of a mixed fraction.
     * @return <code> Fraction </code> representing new fraction in
     * improper form by adding the product of the whole number and
     * denominator with the numerator for the new numerator, and
     * retaining the denominator.
     */
    public Fraction mixedToImproper() {
        return new Fraction(this.getWholeNumber() * this.getDenominator() + this.getNumerator(), this.getDenominator());
    } // end of mixedToImproper method


    /**
     * <h3>Adds Mixed Fractions</h3>
     * <p>Declares fraction variables for two improper fractions.</p>
     * <p>Converts this and other mixed fraction to improper fraction
     * using {@link #mixedToImproper()} to assign for each fraction
     * variables.</p>
     * <p>Initializes the sum of the other fraction and this fraction
     * using {@link #addFraction(Fraction)} method.</p>
     * <p>Reduces the sum using {@link #reduceFraction()} method.</p>
     * <p>Declares and initializes a mixed fraction variable by
     * converting the improper fraction to mixed using
     * {@link Fraction#improperToMixed()} method.</p>
     * @param other The mixed fraction to add to this fraction.
     * @return <code> MixedFraction </code> representing the new Mixed
     * Fraction that is the sum of two Mixed Fractions.
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
     * <h3>Subtracts Mixed Fractions</h3>
     * <p>Declares fraction variables for two improper fractions.</p>
     * <p>Converts this and other mixed fraction to improper fraction
     * using {@link #mixedToImproper()} to assign for each fraction
     * variables.</p>
     * <p>Initializes the difference of the other fraction and this fraction
     * using {@link #subtractFraction(Fraction)} method.</p>
     * <p>Reduces the difference using {@link #reduceFraction()} method.</p>
     * <p>Declares and initializes a mixed fraction variable by
     * converting the improper fraction to mixed using
     * {@link Fraction#improperToMixed()} method.</p>
     * @param other The mixed fraction to subtract from this fraction.
     * @return <code> MixedFraction </code> representing the new Mixed
     * Fraction that is the difference of two Mixed Fractions.
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
     * <h3>Multiplies Mixed Fractions</h3>
     * <p>Declares fraction variables for two improper fractions.</p>
     * <p>Converts this and other mixed fraction to improper fraction
     * using {@link #mixedToImproper()} to assign for each fraction
     * variables.</p>
     * <p>Initializes the product of the other fraction and this fraction
     * using {@link #multiplyFraction(Fraction)} method.</p>
     * <p>Reduces the product using {@link #reduceFraction()} method.</p>
     * <p>Declares and initializes a mixed fraction variable by
     * converting the improper fraction to mixed using
     * {@link Fraction#improperToMixed()} method.</p>
     * @param other The mixed fraction to multiply to this fraction.
     * @return <code> MixedFraction </code> representing the new Mixed
     * Fraction that is the product of two Mixed Fractions.
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
     * <h3>Divides Mixed Fractions</h3>
     * <p>Declares fraction variables for two improper fractions.</p>
     * <p>Converts this and other mixed fraction to improper fraction
     * using {@link #mixedToImproper()} to assign for each fraction
     * variables.</p>
     * <p>Initializes the quotient of the other fraction and this fraction
     * using {@link #divideFraction(Fraction)} method.</p>
     * <p>Reduces the product using {@link #reduceFraction()} method.</p>
     * <p>Declares and initializes a mixed fraction variable by
     * converting the improper fraction to mixed using
     * {@link Fraction#improperToMixed()} method.</p>
     * @param other The mixed fraction to divide by this fraction.
     * @return <code> MixedFraction </code> representing the new Mixed
     * Fraction that is the quotient of two Mixed Fractions.
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
