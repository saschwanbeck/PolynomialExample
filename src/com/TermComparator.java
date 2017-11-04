package com.bbg;

import java.util.Comparator;

public class TermComparator implements Comparator {

    public int compare( Object t1, Object t2){
        int rv = -10;

        // THey are both terms!
        if( t1.getClass() == t2.getClass()
                && Term.class == t1.getClass() ){

            // Bases are the same!
            if( ((Term)t1).base.equals(((Term)t2).base) ){
                rv = ((Integer)((Term)t1).power).compareTo( ((Term)t2).power );
            } else {
                rv = ((Term)t1).base.compareToIgnoreCase(((Term)t2).base);
            }
        } else {
            if( t1.getClass() == this.getClass() )
                rv = 1;
            else if( t2.getClass() == this.getClass() )
                rv = -1;
        }

        return rv;
    }

    public boolean equals( Object o ){
        return o.getClass().equals(this.getClass())
                && ((Term)o).equals( this );
    }

    public static void main(String[] args ){

        TermComparator tc = new TermComparator();
        System.out.println("testCompareDiffClassTO:"  + ((tc.testCompareDiffClassTO()) ? "Passed" : "Failed"));
        System.out.println("testCompareDiffClassOT:"  + ((tc.testCompareDiffClassOT()) ? "Passed" : "Failed"));
        System.out.println("testCompareSameClassEqual:" + ((tc.testCompareSameClassEqual()) ? "Passed" : "Failed"));
        System.out.println("testCompareSameClassXY:"    + ((tc.testCompareSameClassXY()) ? "Passed" : "Failed"));
        System.out.println("testCompareSameClassYX:"    + ((tc.testCompareSameClassYX()) ? "Passed" : "Failed"));


    }

    public  boolean testCompareDiffClassTO(){
        Term t = new Term(3,5);
        return this.compare( t, Term.CARROT) == 1;
    }

    public  boolean testCompareDiffClassOT(){
        Term t = new Term(3,5);
        return this.compare( Term.CARROT, t) == -1;
    }

    public  boolean testCompareSameClassEqual(){
        Term t = new Term(3,5);
        Term z = new Term( 3, 5);
        return this.compare(t,z) == 0;
    }

    public  boolean testCompareSameClassXY(){
        Term x = new Term( 3,5);
        Term y = new Term(3,"y", 5);
        return this.compare(x,y) == -1;
    }

    public  boolean testCompareSameClassYX(){
        Term x = new Term( 3,5);
        Term y = new Term(3,"y", 5);
        return this.compare(y,x) == 1;
    }



}
