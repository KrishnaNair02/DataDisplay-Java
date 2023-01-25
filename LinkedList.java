// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions
// of those who do.
// -- Krishna Nair (krishnanair)
// -- Ethan Triggiano (ethantrig)
package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * This is a basic implementation of a linked list
 *
 * @author Mark Wiggans (mmw125)
 * @version 4/14/2015
 * @author Christina Olk (colk)
 * @version 9.4.15
 * @author Grace Fields
 * @version 10.26.15
 * @author Jamal Ahmad (jamal93)
 * @version 10/15/2016
 * @author Margaret Ellis (maellis1)
 * @version 03/16/2017
 * @author JW Lee (jiayiw6)
 * @version 10/14/2019
 * @author Krishna Nair (krishnanair)
 * @version 2021.11.19
 * @author Ethan Triggiano (ethantrig)
 * @version 2021.11.19
 * 
 * @param <E>
 *            This is the type of object that this class will store
 */
public class LinkedList<E> implements LList<E> {

    /**
     * This represents a node in a singly linked list. This node stores data
     * along with having a pointer to the next node in the list
     *
     * @param <D>
     *            This is the type of object that this class will store
     * @author Mark Wiggans (mmw125)
     * @author Christina Olk (colk)
     * @author maellis1
     * @author Jamal Ahmad (jamal93)
     * @author Margaret Ellis (maellis1)
     * @author JW Lee (jiayiw6)
     * 
     * @version 4/14/2015
     * @version 9.4.15
     * @version 10.29.15
     * @version 10/15/2016
     * @version 03/17/2017
     * @version 10/14/2019
     */
    private static class Node<D> {
        private D data;
        private Node<D> next;
        
        public Node(D d) {
            data = d;
        }
        
        public void setNext(Node<D> head) {
            next = head;
        }
        
        public Node<D> next() {
            return next;
        }
        
        public D getData() {
            return data;
        }
    }
    
    private Node<E> head;
    private int size;
    
    /**
     * new LinkedList object
     */
    public LinkedList() {
        head = null;
        size = 0;
    }
    
    /**
     * returns the size of the list
     * @return the size of the list
     */
    public int size() {
        return size;
    }
    
    /**
     * returns the head of this list
     * @return list's head
     */
    public Node<E> getHead()
    {
        return head;
    }
    /**
     * adds a specified object at a specified location
     * @param index - location where object is to be added
     * @param obj - object to be added
     */
    public void add(int index, E obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        if (isEmpty()) {
            head = new Node<E>(obj);
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<E>(obj));
        }
        size++;
    }
    
    /**
     * adds a specified object to the end of the list
     * @param obj - item to be added
     */
    public void add(E obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        Node<E> current = head;
        if (isEmpty()) {
            head = new Node<E>(obj);
        }
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<E>(obj));
        }
        size++;
    }
    
    /**
     * returns true or false if the list is empty or not
     * @return true or false if the list is empty or not
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * removes a specified object from the list
     * @param obj - object to be removed
     * @return true or false if removal was successful
     */
    public boolean remove(E obj) {
        Node<E> current = head;
        if (head == null)
        {
            throw new IndexOutOfBoundsException();
        }
        if (head != null && obj.equals(current.data)) {
            head = head.next;
            size--;
            return true;
        }
        while (size() >= 2 && current.next != null) {
            if (obj.equals(current.next.data)) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                }
                else {
                    current.setNext(null);
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * removes the object at the specified index
     * @param index - location of object that is being removed
     * @return true or false if removal was successful
     */
    public boolean remove(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException();
        }
        else if (index == 0) {
            head = head.next;
            size--;
            return true;
        }
        else {
            Node<E> current = head;
            int currentIndex = 0;
            while (current.next != null) {
                if (currentIndex + 1 == index) {
                    Node<E> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }
            throw new IndexOutOfBoundsException();
        }
    }
    
    /**
     * returns the item at the given index
     * @return the item at the given index
     * @param index - the index that is specified
     */
    public E get(int index) {
        Node<E> current = head;
        int currentIndex = 0;
        E data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }
        if (data == null) {
            throw new IndexOutOfBoundsException();
        }
        return data;
    }
    
    /**
     * returns true or false if the specified object
     * is in the list
     * @param obj - object that is being searched for
     * @return true or false if the specified object
     * is in the list
     */
    public boolean contains(E obj) {
        Node<E> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * clears the list of all entries
     */
    public void clear() {
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }
    }
    
    /**
     * returns the last index of the specified object
     * @param obj - the object that is being searched for
     * @return index of obj's location
     */
    public int lastIndexOf(E obj) {
        int lastIndex = -1;
        Node<E> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;
        }
        return lastIndex;
    }
    
    /**
     * returns the list in the form of a string
     * @return string form of list
     */
    public String toString() {
        String result = "{";
        Node<E> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }
    
    /**
     * returns the list in the form of an array
     * @return array form of list
     */
    public Object[] toArray() {
        Object[] result = new Object[this.size];
        Node<E> current = head;
        int count = 0;
        while (current != null) {
            result[count] = current.getData();
            current = current.next;
            count++;
        }
        return result;
    }
    
    /**
     * checks to see if input obj is equal to this list
     * @param obj that this is being compared to
     * @return true or false if equal or not
     */
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            LinkedList<E> temp = (LinkedList<E>)obj;
            if (temp.size == this.size) {
                Node<E> current = head;
                Node<E> current2 = temp.head;
                while (current != null) {
                    if (!current.getData().equals(current2.getData())) {
                        return false;
                    }
                    current = current.next();
                    current2 = current2.next();
                }
                return true;
            }
        }
        return false;
    }
    
    /**
     * sorts the list alphabetically
     * @param headRef - reference to the head of this list
     * @param c - comparator object used to compare race names
     */
    public void selectionSortAlpha(Node<E> headRef, Comparator<Race> c) 
    {
        Node<E> temp = headRef;
        while (temp != null)
        {
            Node<E> min = temp;
            Node<E> r = temp.next;
            while (r != null)
            {
                if (c.compare((Race)min.getData(), (Race)r.getData()) < 0)
                {
                    min = r;
                }
                r = r.next;
            }
            E x = temp.data;
            temp.data = min.data;
            min.data = x;
            temp = temp.next;
        }
    }
    
    /**
     * sorts the list in order of CFR (highest to lowest)
     * @param headRef - reference to the head of this list
     * @param c - comparator object used to compare CFR's
     */
    public void selectionSortCFR(Node<E> headRef, Comparator<Race> c)
    {
        Node<E> temp = headRef;
        while (temp != null)
        {
            Node<E> min = temp;
            Node<E> r = temp.next;
            while (r != null)
            {
                if (c.compare((Race)min.getData(), (Race)r.getData()) == 0)
                {
                    CompareByAlpha cba1 = new CompareByAlpha();
                    if (cba1.compare((Race)min.getData(),
                        (Race)r.getData()) < 0)
                    {
                        min = r;
                    }
                }
                if (c.compare((Race)min.getData(), (Race)r.getData()) < 0)
                {
                    min = r;
                }
                r = r.next;
            }
            E x = temp.data;
            temp.data = min.data;
            min.data = x;
            temp = temp.next;
        }
    }

    /**
     * new iterator object
     * @return new iterator object
     */
    public Iterator<E> iterator() 
    {
        return new LListIterator<E>();
    }
    
    private class LListIterator<A> implements Iterator<E> {
        
        private Node<E> curr;
        private Node<E> next;
        

        /**
         * Creates a new DLListIterator
         */
        public LListIterator() 
        {
            curr = null;
            next = head.next();
        }

        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() 
        {
            return (next.getData() != null);
        }

        /**
         *Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public E next() 
        {
            curr = next;
            next = next.next();
            if (curr.getData() == null)
            {
                throw new NoSuchElementException("No nodes left in the list.");
            }
            return curr.data;
        }
    }

}