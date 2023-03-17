package prog2.prelimgroup;

public class MixedFraction extends Fraction {

    private int wholeNumber;

    public MixedFraction() {
        super();
        this.wholeNumber = 0;
    }

    public MixedFraction(int num, int den, int wholeNumber) {
        super(num, den);
        this.wholeNumber = wholeNumber;
    }
    public MixedFraction (int wholeNumber, Fraction fraction){
        super();
        this.wholeNumber = wholeNumber;
    }

    public MixedFraction(Fraction fraction) {
        super();
    }

    public void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    }

    public void setFraction(Fraction fraction) {

    }

    public int getWholeNumber() {
        return wholeNumber;
    }

    public Fraction getFraction() {
        return new Fraction();

    }

    public String toString() {
        if (wholeNumber == 0)
            return " " + super.toString();
        else
            return this.wholeNumber + " " + super.toString();
    }

    public Fraction mixedToImproper() {
        return new Fraction(this.getWholeNumber() * this.getDenominator() + this.getNumerator(), this.getDenominator());
    }


    public MixedFraction add (MixedFraction other) {
        Fraction frac1 = new Fraction();
        Fraction frac2 = new Fraction();

        frac1 = this.mixedToImproper();
        frac2 = other.mixedToImproper();

        Fraction sFrac = new Fraction();
        sFrac = frac1.addFraction(frac2);
        sFrac = sFrac.reduceFraction(sFrac);

        MixedFraction sMixed = new MixedFraction();
        sMixed = sFrac.improperToMixed();

        return new MixedFraction(sMixed.getNumerator(), sMixed.getDenominator(), sMixed.getWholeNumber());
    }

    public MixedFraction subtract(MixedFraction other) {
        Fraction frac1 = new Fraction();
        Fraction frac2 = new Fraction();

        frac1 = this.mixedToImproper();
        frac2 = other.mixedToImproper();

        Fraction dFrac = new Fraction();
        dFrac = frac1.subtractFraction(frac2);
        dFrac = dFrac.reduceFraction(dFrac);

        MixedFraction dMixed = new MixedFraction();
        dMixed = dFrac.improperToMixed();

        return new MixedFraction(dMixed.getNumerator(), dMixed.getDenominator(), dMixed.getWholeNumber());
    }
}
