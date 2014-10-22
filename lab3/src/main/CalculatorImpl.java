/**
 * @class			: CalculatorImpl
 * @interface		: Calculator
 * @author	 		: Ons mlouki
 * 					  Ons.mlouki@gmail.com
 * 					  
 * 
 * @summary			: controls math operations without operators.
 */
package main;

public class CalculatorImpl implements Calculator {
	
	public int multiply(int a, int b){
		int k=Math.abs(a);
		int p=b;
		k--;
		while(k != 0) {
           p=add(p,b);
           k--;
    }
		if(a<0){
			p=-p;	
		}
		if(b<0){
			p=-p;
		}
		return p;
	}
	
//divide result must be an int, for division result .5 we took 1	
	public int divide(int a, int b){
		if (b == 0) {
			throw new ArithmeticException();
	        }
		boolean resEstNegatif = false;
		int res = 0;
		if ( a < 0) {
			resEstNegatif = !resEstNegatif;
			a = -a;
		}
		if ( b < 0) {
			resEstNegatif = !resEstNegatif;
			b = -b;
		}
		
		while (a > 0) {
			int c=a;
		        a = substract(a, b);
		        if(a>=0 ){
		        	res++;
		        }else if(-a <= c){
		        	res++;
		        }
			
		}
		if (resEstNegatif) {
			res = -res;
	        }
		return res;
	}
	
	public int add(int a, int b){
		int res = a;
		if (b > 0) {
			while(b-- != 0) {
	                        res++;
	                }
	        }
		else if (b < 0) {
			while(b++ != 0) {
	                        res--;
	                }
	        }
		return res;
	}
	
	public int substract(int a, int b){	
		int result = a;
		if(b > 0)
		{
			while(b-- > 0)
				result--;
		}
		else if(b < 0)
		{
			while(b++ < 0)
				result++;
		}
		
		return result;
	}
}
