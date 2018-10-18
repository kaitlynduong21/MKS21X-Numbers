public class RationalNumber extends RealNumber{

  private int numerator, denominator;

  private static int gcd(int a, int b){
    while (b != 0) {
        int newa = b;
        b = a % b;
        a = newa;
      }
    return a;
    }

  private void reduce(){
    int x = gcd(numerator, denominator);
    numerator = this.numerator / x;
    denominator = this.denominator / x;
  }

  public RationalNumber(int nume, int deno){
    super(0.0);
    if (deno == 0) {
      nume = 0;
      deno = 1;
    }
    numerator = nume;
    denominator = deno;
    reduce();
  }

  public double getValue() {
    return (double)numerator / (double)denominator;
  }

  public int getNumerator(){
    return numerator;
  }

  public int getDenominator(){
    return denominator;
  }

  public RationalNumber reciprocal(){
    RationalNumber newReciprocal = new RationalNumber (getDenominator(), getNumerator());
    return newReciprocal;
  }

  public boolean equals(RationalNumber other){
    return (this.getValue() == other.getValue());
  }

  public String toString(){
    if (getDenominator() == 1) {
      return "" + getNumerator();
    }
    if (getNumerator() == 0) {
      return "" + getNumerator();
    }
    if (getNumerator() > 0 && getDenominator() < 0) {
      return "-" + getNumerator() + "/" + (-1 * getDenominator());
    }
    return getNumerator() + "/" + getDenominator();
  }


  public RationalNumber multiply(RationalNumber other){
    RationalNumber newNumber;
    newNumber = new RationalNumber (this.getNumerator() * other.getNumerator(), this.getDenominator() * other.getDenominator());
    return newNumber;
  }


  public RationalNumber divide(RationalNumber other){
    return this.multiply(other.reciprocal());
  }

  public RationalNumber add(RationalNumber other){
    int newDenominator;
    newDenominator = (this.getDenominator() * other.getDenominator());
    int newNumerator;
    newNumerator = (this.getNumerator() * (other.getDenominator()) + this.getDenominator() * other.getNumerator());
    RationalNumber a = new RationalNumber (newNumerator, newDenominator);
    return a;
  }

  public RationalNumber subtract(RationalNumber other){
    int newDenominator;
    newDenominator = (this.getDenominator() * other.getDenominator());
    int newNumerator;
    newNumerator = (this.getNumerator() * (other.getDenominator()) - this.getDenominator() * other.getNumerator());
    RationalNumber a = new RationalNumber (newNumerator, newDenominator);
    return a;
  }
}
