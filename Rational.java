//Kyle Moon
//APCS1 pd5
//Rational
//2015-12-09

public class Rational implements Comparable
{
    // Instance Variables
    private int _n;
    private int _d;
    
    // Constructors
    public Rational()
    {
        _n = 0;
        _d = 1;
    }
    
    public Rational(int n, int d)
    {
        this();
        if (d != 0)
        {
            _n = n;
            _d = d;
        }
        else
	{
            System.out.println("Invalid denominator. Fraction set to 0 / 1");
	}
    }
    
    // Accessor Methods
    public int getN()
    {
        return _n;
    }
    
    public int getD()
    {
        return _d;
    }
    
    // Override toString() Method
    public String toString()
    {
        return ( "Fraction: " + _n + " / " + _d + "\n");
    }
    
    // Float Value Method
    public double floatValue()
    {
        return ( _n / _d * 1.0 );
    }
    
    // Multiply Method
    public void multiply(Rational fraction)
    {
        _n *= fraction.getN();
        _d *= fraction.getD();
    }
    
    // Divide Method
    public void divide(Rational fraction)
    {
        if ( fraction.getN() != 0 )
        {
            _n *= fraction.getD();
            _d *= fraction.getN();
        }
        else
            System.out.println("This cannot be done. Numerator is 0.");
    }
    
    // Add Method
    public void add(Rational fraction)
    {
        if ( _d == fraction.getD() )
            _n += fraction.getN();
        else
        {
            _n = ( ( _n * fraction.getD() ) + ( fraction.getN() * _d ) );
            _d = ( _d * fraction.getD() );
        }
    }
    
    // Subtract Method
    public void subtract(Rational fraction)
    {
        if ( _d == fraction.getD() )
            _n -= fraction.getN();
        else
        {
            _n = ( ( _n * fraction.getD() ) - ( fraction.getN() * _d ) );
            _d = ( _d * fraction.getD() );
        }
    }
    
    // Reduce Method
    public void reduce()
    {
        if ( gcd() != 1 )
        {
            _n /= gcd();
            _d /= gcd();
        }
    }
    
    // GCD Function
    public int gcd()
    {
        int ans = 0;
        int num1 = _n;
        int num2 = _d;
        
        if ( _n > _d )
        {
            while ( (num1 % num2) != 0 )
                num2 = num1 % num2;

            ans = num2;
        }
        else if (_d > _n)
        {
            while ( (num2 % num1) != 0 )
                num1 = num2 % num1;
            
            ans = num1;
        }
        else
            ans = _n;
            
        return ans;
    }
    
    // Static GCD Method
    public static int gcd(int n, int d)
    {
        Rational ans = new Rational(n, d);
        return ans.gcd();
    }
    
    // Compare To Method
    public int compareTo(Object other)
    {
	int nOther = 0;
	int dOther = 1;
	int retI;
	
	if (other instanceof Comparable)
	{
	    Comparable t;
	    t = (Comparable)other;
	    nOther = t._n;
	    dOther = t._d;
	}
	else
	{
	    throw new ClassCastException("Input not valid.");
	}

	if (_n * dOther > nOther * _d)
	{
	    retI = 1;
	}
	else if (_n * dOther < nOther * _d)
	{
	    retI = -1;
	}
	else
	{
	    retI = 0;
	}
	return retI;
    }
    
    // Equals Method
    public boolean equals(Object other)
    {
        return ( (this == other) || compareTo(other) == 0);
    }
    
    // Main Method
    public static void main( String[] args )
    {
        // Phase I
        System.out.println("Phase I: ");
        System.out.println("===============================");
        Rational r = new Rational(2,3);
        Rational s = new Rational(1,2);
        System.out.println("R: " + r);
        System.out.println("S: " + s);
        r.multiply(s);
        System.out.println("R: " + r);
        System.out.println("S: " + s);
        System.out.println("===============================");
        System.out.println("");
        
        // Phase II
        System.out.println("Phase II: ");
        System.out.println("===============================");
        r = new Rational(2,3);
        s = new Rational(1,2);
        Rational t = new Rational(4,18);
        System.out.println("R: " + r);
        System.out.println("S: " + s);
        System.out.println("T: " + t);
        r.add(s);
        t.reduce();
        System.out.println("R: " + r);
        System.out.println("S: " + s);
        System.out.println("T: " + t);
        System.out.println("===============================");
        System.out.println("");
        
        // Phase III
        System.out.println("Phase II: ");
        System.out.println("===============================");
        System.out.println("The GCD of 10 and 25 is: " + gcd(10, 25) );
        System.out.println("");
        System.out.println("R: " + r);
        System.out.println("S: " + s);
        System.out.println("T: " + t);
        System.out.println("R is greater than S: " + r.compareTo(s) );
        System.out.println("S is smaller than T: " + s.compareTo(r) );
        Rational u = new Rational(7, 6);
        System.out.println("");
        System.out.println("U: " + u);
        System.out.println("U is equal to R: " + r.compareTo(u) );
        System.out.println("===============================");
        System.out.println("");
    }
}
