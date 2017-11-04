package com.bbg;


public  class Term {
    int coefficient;
    String base;
    int power;

    static final String XBASE = "x";
    static final String CARROT = "^";

    Term(int cof, int pow) {
        this.coefficient = cof;
        this.base = XBASE;
        this.power = pow;
    }

    Term(int cof, String b, int pow) {
        this.coefficient = cof;
        this.base = b;
        this.power = pow;
    }

    public String toString() {

        if (this.coefficient != 0) {
            if (this.power > 0) {
                return ((this.coefficient >1)? this.coefficient : "") + this.base
                        + (( this.power > 1)?  CARROT + this.power : "");
            } else {
                return Integer.toString(this.coefficient);
            }
        } else {
            return "";
        }
    }

    public boolean equals( Object o ){
        return o.getClass().equals(this.getClass())
                && ((Term)o).equals( this );
    }

    public boolean equals( Term t ){
        return this.coefficient == t.coefficient
                && this.power == t.power
                && this.base.equals(t.base);
    }

    private static boolean testZeroCoefficient() {
        Term t = new Term(0, 0);
        return t.toString().equals("");

    }

    private static boolean testZeroPower() {
        Term t = new Term(5, 0);
        return t.toString().equals("5");
    }

    private static boolean testDefaultBase() {
        Term t = new Term(5, 2);
        return t.toString().equals("5x^2");
    }

    private static boolean testSpecialBase() {
        Term y = new Term(5, "y", 2);
        return y.toString().equals("5y^2");
    }

    private static boolean testEqualsTPos(){
        Term x = new Term(5,5);
        Term y = new Term(5,5);
        return x.equals(y);
    }

    private static boolean testEqualsTNeg(){
        Term x = new Term(5,5);
        Term y = new Term(5,"y", 5);
        return x.equals(y);
    }

    private static boolean testEqualsOPos(){
      Term t = new Term(0,1);
      Term z = new Term( 1,1);
      return t.equals( (Object) z );
    }

    private static boolean testEqualsONeg(){
        Term t = new Term( 9,3);
        return t.equals( CARROT );
    }


    public static void main(String[] args) {
        Polynomial p = new Polynomial();
        System.out.println("Running tests");
        System.out.println("testDefaultBase:"     + ((testDefaultBase()) ? "Passed" : "Failed"));
        System.out.println("testSpecialBase:"     + ((testSpecialBase()) ? "Passed" : "Failed"));
        System.out.println("testZeroPower:"       + ((testZeroPower())   ? "Passed" : "Failed"));
        System.out.println("testZeroCoefficient:" + ((testZeroCoefficient()) ? "Passed" : "Failed"));
        System.out.println("testEqualsTPos:"      + ((testEqualsTPos()) ? "Passed" : "Failed"));
        System.out.println("testEqualsTNeg:"      + ((testEqualsTNeg()) ? "Failed" : "Passed"));
        System.out.println("testEqualsOPos:"      + ((testEqualsOPos()) ? "Passed" : "Failed"));
        System.out.println("testEqualsONeg:"      + ((testEqualsONeg()) ? "Failed" : "Passed"));

    }
}