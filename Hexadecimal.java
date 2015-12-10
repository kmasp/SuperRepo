//Kyle Moon
//APCS1 pd5
//Hexadecimal
//2015-12-08

public class Hexadecimal implements Comparable
{

    private int _decNum;
    private String _hexNum;
    private static final String HEXDIGITS = "0123456789ABCDEF";

    public Hexadecimal()
    { 
	_decNum = 0;
	_hexNum = "0";
    }

    public Hexadecimal( int n )
    {
	_decNum = n;
	_hexNum = decToHex(n);
    }

    public String toString()
    {
	return _hexNum;
    }

    public static String decToHex( int n )
    {
	String s = "";
	while (n >= 1)
	{
	    s = HEXDIGITS.substring( (n % 16), n % 16 + 1) + s;
	    n /= 16;
	}
	return s;

    }

    public static String decToHexR( int n )
    { 
	if (n >= 1)
	{
	    return decToHexR(n / 16) + HEXDIGITS.substring( (n % 16), n % 16 + 1);
	}
	else
	{
	    return "";
	}
    }

    public static int hexToDec( String s)
    {
	int k = 0;
	for(int i = 0; i < s.length(); i++)
	{
	    char c = s.charAt(i);
	    k += (HEXDIGITS.indexOf(c) * Math.pow(16, s.length() - i - 1));
	}
	return k;
    }

    /*
    public static int hexToDec( String s)
    {
	if (s.length() == 0)
	{
	    return "";
	}
	else
	{
	    char c = s.substring(s.length()-1, s.length());
	}
    }
    */
	
    public boolean equals( Object other )
    { 
	return this.compareTo(other) == 0;
    }


    public int compareTo( Object other )
    {
	int bool;
	if (! (other instanceof Hexadecimal))
	{
	    bool = -1;
	}
	else
	{
	    bool = this._decNum-(((Hexadecimal)other)._decNum);
	}
	return bool;
    }


    //main method for testing
    public static void main( String[] args )
    {

	System.out.println();
	System.out.println(hexToDec("128"));
	System.out.println(hexToDec("3FE"));
	
	System.out.println( "Testing ..." );

	Hexadecimal h1 = new Hexadecimal(10);
	Hexadecimal h2 = new Hexadecimal(10);
	Hexadecimal h3 = h1;
	Hexadecimal h4 = new Hexadecimal(20);

	System.out.println( h1 );
	System.out.println( h2 );
	System.out.println( h3 );       
	System.out.println( h4 );       

	System.out.println( "\n==..." );
	System.out.println( h1 == h2 ); //should be false
	System.out.println( h1 == h3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( h1.equals(h2) ); //should be true
	System.out.println( h1.equals(h3) ); //should be true
	System.out.println( h3.equals(h1) ); //should be true
	System.out.println( h4.equals(h2) ); //should be false
	System.out.println( h1.equals(h4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( h1.compareTo(h2) ); //should be 0
	System.out.println( h1.compareTo(h3) ); //should be 0
	System.out.println( h1.compareTo(h4) ); //should be neg
	System.out.println( h4.compareTo(h1) ); //should be pos
	
    }//end main()

} //end class
