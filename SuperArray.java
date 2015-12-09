
public class SuperArray<T> implements List<T> {

    private Object[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values


    //default constructor
    //initializes 10-item array
    public SuperArray() { 
    _data = (T[])new Object[10]; //typecast into array of T's
    _lastPos = -1;
    _size = 0;    
    }

    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() { 
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
        foo += _data[i] + ",";
    }
    if ( foo.length() > 1 )
        //shave off trailing comma
        foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
    }

    // Increments Both _lastPos and _size
    public void inc()
    {
        _lastPos++;
        _size++;
    }
    
    // Decrements both _lastPos and _size
    public void dec()
    {
        _lastPos--;
        _size--;
    }
    
    //double capacity of this instance of SuperArray 
    private void expand() { 
    Object[] temp = (T[])new Object[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
        temp[i] = _data[i];
    _data = temp;
    }

    //accessor method -- return value at specified index
    public T get( int index ) {
    return (T)_data[index];
    }

    //mutator method -- set index to newVal, return old value at index
    public T set( int index, T obj ) {
    Object temp = (T)_data[index];
    _data[index] = obj;
    return (T)temp;
    }


    //adds an item after the last item
    public boolean add( T obj ) { 
        _lastPos++;
        if (_lastPos >= _size)
            expand();
        
        _data[_lastPos] = obj;
        _size++;
        
        return true;
    }

    //inserts an item at index    
    public void add( int index, T obj ) { 
        if (index > _lastPos)
            add(obj);
        else
        {
            _size++;
            
            while ( _data.length < _size )
                expand();
            
            add(obj);
            _size--;
            
            for (int i = _lastPos; i >= index; i--)
                set( i , set( i - 1 , (T)_data[i] ) );
        }
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public T remove( int index ) { 
        T value = (T)_data[index];
        for (int i = index; i < _lastPos; i++)
            set(i, set( i + 1, (T)_data[i] ) );
        
        dec();
        return value;
    }


    //return number of meaningful items in _data
    public int size() {
        return _size;
    }


    public static void main( String[] args ) {

    SuperArray<Integer> curtis = new SuperArray<Integer>();
    System.out.println( "Printing empty SuperArray curtis..." );
    System.out.println( curtis );

    for( int i = 0; i < curtis._data.length; i++ ) {
        curtis.set( i, i * 2 );
    }

    System.out.println("Printing populated SuperArray curtis...");
    System.out.println(curtis);

    for( int i = 0; i < 3; i++ ) {
        curtis.expand();
        System.out.println("Printing expanded SuperArray curtis...");
        System.out.println(curtis);
        System.out.println("new length of underlying array: " 
                   + curtis._data.length );
    }

    SuperArray<Integer> mayfield = new SuperArray<Integer>();
    System.out.println("Printing empty SuperArray mayfield...");
    System.out.println(mayfield);

    mayfield.add(5);
    mayfield.add(4);
    mayfield.add(3);
    mayfield.add(2);
    mayfield.add(1);

    System.out.println("Printing populated SuperArray mayfield...");
    System.out.println(mayfield);

    mayfield.remove(3);
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);
    mayfield.remove(3);
    System.out.println("Printing SuperArray mayfield post-remove...");
    System.out.println(mayfield);

    mayfield.add(3,99);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    mayfield.add(2,88);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    mayfield.add(1,77);
    System.out.println("Printing SuperArray mayfield post-insert...");
    System.out.println(mayfield);
    
    }//end main()

}//end class SuperArray
