package prog2.prelimgroup;

public class MixedFraction extends Fraction{

    private int wholeNumber;

    public MixedFraction(){
        super();
        this.wholeNumber=0;
    }

    public MixedFraction( int num , int den, int wholeNumber){
        super(num, den);
        this.wholeNumber=wholeNumber;
    }

    public MixedFraction (Fraction fraction) {
        super();
    }

    public void setWholeNumber(int wholeNumber){
        this.wholeNumber = wholeNumber;
    }

    public void setFraction(Fraction fraction){

    }

    public int getWholeNumber(){return wholeNumber;}

    public Fraction getFraction(){ return new Fraction();

    }

    public String toString(){
        return this.wholeNumber+ " " + super.toString();

    }
    public Fraction toFraction(){
        return new Fraction();
    }

    public MixedFraction add (MixedFraction other) {
        int sWholeNumber;
        Fraction sFrac = new Fraction();
        sWholeNumber = this.getWholeNumber() + other.getWholeNumber();
        sFrac = this.addFraction(other);
        sFrac = sFrac.reduceFraction(sFrac);
        return new MixedFraction(sFrac.getNumerator(),sFrac.getDenominator(), sWholeNumber);
    }

    public Fraction mixedToImproper(){
        return new Fraction(this.getWholeNumber() * this.getDenominator() + this.getNumerator() ,this.getDenominator());
    }

    public MixedFraction improperToMixed(){
        return new MixedFraction(this.getNumerator() % this.getDenominator(), this.getDenominator(), this.getNumerator() / this.getDenominator());
    }

    public MixedFraction subtract ( MixedFraction other){
        Fraction frac1= new Fraction();
        Fraction frac2= new Fraction();

        frac1= this.mixedToImproper();
        frac2= other.mixedToImproper();

        Fraction dFrac= new Fraction();

        dFrac= frac1.subtractFraction(frac2);
        dFrac= dFrac.reduceFraction(dFrac);

        MixedFraction dMixed = new MixedFraction();
        dMixed = (MixedFraction) dFrac;
        dMixed = dMixed.improperToMixed();

        return new MixedFraction(dMixed.getNumerator(), dMixed.getDenominator(),dMixed.getWholeNumber() );

    }
