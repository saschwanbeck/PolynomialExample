# PolynomialExample
Example for Zaynah

There are three classes in this repository right now and the only functionality covered at present is:
 - storing a Polynomial
 - adding Polynomials together
 - rendering Polynomials (as in 'toString()')
 
 The structure is centered around the ```Term``` class. It houses the coefficient, degree/power, and base (variable 'x' by default.)
 
 The Polynomial class itself holds a collection of Term objects within a TreeSet (a data structure which only allows unique items to be added, and keeps the items within it, in an ordered fashion.)
 
 The TermComparator class is used by the Polynomial class in constructing the TreeSet with a comparator which understands how to order Term objects. It might not be perfect yet but it is working ok so far.
 
 I have added tests to each one of the classes and have called the tests from the main method. Feel free to read this code and learn from it, but don't try to turn it in as your own or your teacher will surely think you are cheating.
 
 Sarah
 
