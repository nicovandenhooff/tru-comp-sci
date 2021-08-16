
/**
 * ArrayUnorderedList represents an array implementation of an unordered list.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class ArrayUnorderedList<T> extends ArrayList<T> 
implements UnorderedListADT<T>
{
    /**
     * Creates an empty list using the default capacity.
     */
    public ArrayUnorderedList()
    {
        super();
    }
    
    /**
     * Creates an empty list using the specified capacity.
     *
     * @param initialCapacity the initial size of the list
     */
    public ArrayUnorderedList(int initialCapacity)
    {
        super(initialCapacity);
    }
    
    /**
     * Adds the specified element to the front of this list.
     * 
     * @param element the element to be added to the front of the list
     */
    public void addToFront(T element)
    {
        if (size() == list.length)
            expandCapacity();
        
        int scan = 0;
        
        // shift elements up one
        for (int shift = rear; shift > scan; shift--)
            list[shift] = list[shift-1];
        
        // insert element at front
        list[scan] = element;
        rear++;
        modCount++;
    }
    
    /**
     * Adds the specified element to the rear of this list.
     *
     * @param element the element to be added to the list
     */
    public void addToRear(T element)
    {
        // insert element at rear
        list[rear] = element;
        rear++;
        modCount++;
    }
    
    /**
     * Adds the specified element after the specified target element.
     * Throws an ElementNotFoundException if the target is not found.
     *
     * @param element the element to be added after the target element
     * @param target  the target that the element is to be added after
     */
    public void addAfter(T element, T target)
    {
        if (size() == list.length)
            expandCapacity();
    
        int scan = 0;
    
        // find the insertion point
        while (scan < rear && !target.equals(list[scan])) 
            scan++;
    
        if (scan == rear)
            throw new ElementNotFoundException("UnorderedList");
    
        scan++;
    
        // shift elements up one
        for (int shift = rear; shift > scan; shift--)
            list[shift] = list[shift - 1];
    
        // insert element
        list[scan] = element;
        rear++;
        modCount++;
    }
}