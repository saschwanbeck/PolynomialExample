package com.bbg;

import java.util.Iterator;
import java.util.TreeSet;

public class Polynomial {

// polynomial is a collection of terms
TreeSet terms;

  public Polynomial(){
      terms = new TreeSet(new TermComparator());
  }

  public Polynomial add( Polynomial p){
      Polynomial rv = new Polynomial();



      return rv;
  }

  public boolean addTerm( Term t){
      boolean rv = false;
    Iterator h = terms.descendingIterator();
    Term q;
    while( h.hasNext() ){
       q = (Term) h.next();
       if( q.base == t.base && q.power == t.power ){
           q.coefficient += t.coefficient;
           rv = true;
       }
    }

    // We didn't find a similar term in the polynomial yet
    if( !rv ){
        terms.add( t );
    }

      return rv;
  }

  public String toString(){
      StringBuffer b = new StringBuffer(3*terms.size());

      Iterator i = terms.descendingIterator();
      boolean isFirst = true;
      while( i.hasNext() ){
          Term t = (Term) i.next();
          b.append( ((t.coefficient) >= 0 && !isFirst)? "+" : "" );
          b.append( t );
          isFirst = false;
      }

      return b.toString();
  }

  public static boolean testConThreeTerms(){
      Polynomial p = new Polynomial();
      Term x2 = new Term(3,2);
      Term x = new Term(1,1);
      Term x0 = new Term(1,0);
      boolean rv = p.addTerm(x2);
      rv &= p.addTerm(x);
      rv &= p.addTerm(x0);
      rv &= p.addTerm(x2);
      System.out.println( p );
      return ( rv );
  }

    public static void main(String[] args) {
        // write your code here
        System.out.println("Testing Polynomial");
        testConThreeTerms();

    }



}