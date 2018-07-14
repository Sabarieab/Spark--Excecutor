package com.lti.sdd.service.controller.util;

public abstract class MathFunctions {
	


    /**
     * This function takes a number n and returns its absolute value.
     * @param n
     * @returns {number}
     */
 public static int evalAbs(int n) {
			return Math.abs(n);
    }




    /**
     * This function rounds a number n up to the next highest integer.
     * @param n
     * @returns {number}
     */
 public static int evalCeil(double n) {
      return (int) Math.ceil(n) ;
    }

   

    /**
     * This function rounds a number n down to the nearest whole integer
     * @param n
     * @returns {number}
     */
 public  static int evalFloor(double n) {
     return (int) Math.round(n);
    }

 
    /**
     * This function takes a number x and returns e^x
     * @param x
     * @returns {number}
     */
 public static double evalExp(double n) {
    	   return Math.exp(n);
    }

  /**
     * Returns the PI constant
     * @returns {number}
     */
 public static double evalPi() {
        return Math.PI;
    }

  


    /**
     * This function takes two numeric arguments X and Y and returns X^Y.
     * @param x - base
     * @param y - exponent
     * @returns {number}
     */
 public static double evalPow(double x, double y) {
     return Math.pow(x, y);
    }



    /**
     * sqrt(X)
     * This function takes one numeric argument X and returns its square root.
     * @param x
     * @returns {number}
     */
 public static double evalSqrt(double x) {
       return Math.sqrt(x);
    }

    

    /**
     * ln(X)
     * This function takes a number X and returns its natural log (base e).
     * @param x
     * @returns {number}
     */
 public static double evalLn(double x) {
     return Math.log(x);
    }

  

    /**
     * log(X,Y)
     * log(X)
     * This function takes either one or two numeric arguments and returns the log of the first argument X using the
     * second argument Y as the base. If the second argument Y is omitted, this function evaluates the log of number
     * X with base 10.
     * @param x
     * @param y
     * @returns {number}
     */
 public static double evalLog(double x, double y) {
    	double result;
    	result= 	Math.log(x)/Math.log(y);
    return result;
    }



    /**
     * min(X,...)
     * This function takes an arbitrary number of  string arguments, and returns the min;
     * strings are greater than numbers.
     * @returns {*}
     */
 public static String evalMinString(String[] args) {
    	 
	        String shortestString = args[0];
	        for (String s : args) {
	        	 if (s.compareTo(shortestString) <1 ) {
			           
	        		 shortestString = s;
		            }
	        }
	        return shortestString;
      
    }
    /**
     * min(X,...)
     * This function takes an arbitrary number of numeric  arguments, and returns the min;
     * strings are greater than numbers.
     * @returns {*}
     */

 public static int evalMinInt(int[] args) {
		  int minInt = 2147483647 ;

	        for (Integer s : args) {
	            if (s < minInt) {
	            	minInt = s;
	               
	            }
	        }
	        return minInt;
		    }


  
	    /**
	     * max(X,...)
	     * This function takes an arbitrary number of  string arguments, and returns the max;
	     * strings are greater than numbers.
	     * @returns {*}
	     */
 public static String evalMaxString(String[] args) {
	    	  int maxLength = 0;
		        String longestString = args[0];
		  
		        for (String s : args) {
		        	
		        	
		            if (s.compareTo(longestString) >1 ) {
		           
		                longestString = s;
		            }
		        }
		        return longestString;
	      
	    }
	    /**
	     * max(X,...)
	     * This function takes an arbitrary number of numeric  arguments, and returns the max;
	     * strings are greater than numbers.
	     * @returns {*}
	     */

 public static int evalMaxInt(int[] args) {
			  int maxInt = 0 ;
	
		        for (Integer s : args) {
		            if (s > maxInt) {
		            	maxInt = s;
		               
		            }
		        }
		        return maxInt;
			    }

   

    /**
     * round(X,Y)
     * This function takes one or two numeric arguments X and Y, returning X rounded to the amount of decimal places
     * specified by Y. The default is to round to an integer.
     * @param n
     * @param prec
     * @returns {*}
     */
 public static double evalRound(double n, int prec) {
	 		 		 
	 double expTen	= Math.pow(10, prec);	
	 double temp1= n* expTen;
	 double temp2	= Math.round(temp1);
	 double retVal = temp2 / expTen;
			return retVal;				
	      

	
    }
 
  /**
     * round(X)
     * This function is overloaded takes one or two numeric arguments X and Y, returning X rounded to the amount of decimal places
     * specified by Y. The default is to round to an integer.
     * @param n
     * @param prec
     * @returns {*}
     */
 public static double evalRound(double n) {
       return Math.round(n);
    }


    /**
     * random()
     * This function takes no arguments and returns a pseudo-random integer ranging from zero to 2^31-1,
     * for example: 0 ... 2147483647
     * @returns {Number}
     */
    static double evalRandom() {
        return Math.random(); 
    }

   


}
