
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E> implements List<E> {
    
    private int Count;
    private Node<E> head;

    @Override
    public int size() {
        
        return Count;
    }

    @Override
    public boolean isEmpty() {
        
        if(Count == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        
        Node<E> currentNode = head;
        
        if(head == null) {
            throw new NullPointerException("List is empty!");
        }
        
        int i = 0;
        while(i < Count) {
            if(currentNode.data == o) {
                return true;
            }
            currentNode = currentNode.next;
            i++;
        }
        
        return false;
    }

    @Override
    public Object[] toArray() {
        
        E[] array = (E[]) new Object[Count];
        Node<E> temp = head;
        
        for(int i  = 0; i < array.length; i++) {
            array[i] = temp.data;
            temp = temp.next;
        }
        
        return array;
    }

    @Override
    public boolean add(E e) {
        
        Node<E> node = new Node<E>();
        node.data = e;
        node.next = null;
        
        if(head == null) { 
            head = node;
            Count++;
        }
        
        else {
            
            Node<E> currentNode = head;
            
            while(currentNode.next != null) {
               currentNode = currentNode.next; 
            }
            
            currentNode.next = node;
            Count++;
            return true;
        }
        
        return true;
    }

    // TODO
    // Removing the last element results in NullPointerException when toString() is called.
    @Override
    public boolean remove(Object o) {
        
        if(head == null) {
            throw new NullPointerException("List is empty");
        }
        
        boolean isRemoved = false;
        Node<E> currentNode = head;
        Node<E> previousNode = head;
        
        if(head.data.equals(o)) {
            head = head.next;
            Count--;
            return isRemoved = true;
        }

        while(currentNode != null) {
            if(currentNode.data.equals(o)) {
                previousNode.next = currentNode.next;
                isRemoved = true;
            }
            currentNode = currentNode.next;
        }

        if(isRemoved == true) {
            Count--;
        }

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        
        for(E i : c) {
            
            add(i);
        }
        return true;
    }

    @Override
    public void clear() {
        
        Count = 0;
        head = null;   
    }

    @Override
    public E get(int index) {
        Node<E> currentNode = head;
        
        if(head == null) {
            throw new NullPointerException("List is empty");
        }
        
        if(index >= Count || index < 0) {
            throw new IndexOutOfBoundsException("Node out of bounds");
        }
        
        int i = 0;
        while(i < index) {
            currentNode = currentNode.next;
            i++;
        }
        
        return currentNode.data;
    }


    @Override
    public E set(int index, E element) {
        
        if(head == null || index >= Count) {
            throw new IndexOutOfBoundsException("Index is greater than list size");
        }
        
        Node<E> currentNode = head;
        
        int i = 0;
        while(i < index) {
            currentNode = currentNode.next;
            i++;
        } 
        currentNode.data = element;
        
        return currentNode.data;
    }

    // TODO
    // Adding in between elements doesn't work.
    @Override
    public void add(int index, E element) {
        
        if(head == null || index >= Count) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        
       Node<E> currentNode = head;
       Node<E> previousNode = head;
       
       int i = 0;
       while(i < index) {
           previousNode = currentNode;
           currentNode = currentNode.next;
           i++;
           Count++;
           break;
       }
       
       Node<E> newNode = new Node<E>(element);
       newNode.next = currentNode;
       
       if(currentNode.equals(head)) {
           head = newNode;
           Count++;
       } 
      
    }

    // TODO
    // Remove only removes the first element (the element at index 0)
    @Override
    public E remove(int index) {
        
        if(index >= Count) {
            throw new NullPointerException("List is empty");
        }
        
        Node<E> currentNode = head;
        Node<E> previousNode = head;
        
        if(currentNode.equals(head)) {
            head = head.next;
            Count--;
            return currentNode.data;
        }
        
        int i = 0;
        while(currentNode != null) {
            if(i == index) {
                previousNode.next = currentNode.next;
                currentNode = currentNode.next; 
                break;
            }
            i++;
            currentNode = currentNode.next;
        }
        
        Count--;
       
        return currentNode.data;
    }

    @Override
    public int indexOf(Object o) {
        
        if(head == null) {
            return -1;
        }
        
       Node<E> currentNode = head;
       int index = 0;
       
       while(currentNode != null) {
           if(currentNode.data == null) {
               return -1;
           }
           if(currentNode.data.equals(o)) {
               return index;
           }
           currentNode = currentNode.next;
           index++;
       }
        return -1;
    }

    // TODO
    // last index of doesn't return the correct index.
    @Override
    public int lastIndexOf(Object o) {
        
        if(head == null) {
            throw new NullPointerException("List is empty!");
        }
        
        int index = Count - 1;
        Node<E> currentNode = head;
        
        while(currentNode != null) {
           if(currentNode.data.equals(o)) {
               index--;
               return index;
           }
           
           currentNode = currentNode.next;
           index--;
        }
        
        return -1;
    }
    
    @Override
    public String toString() {
        String stringValue = "";
        Node<E> currentNode = head;
        
       
            int i = 0;
            while(i < Count) {
                stringValue += currentNode.data + " -> ";
                currentNode = currentNode.next;
                i++;
            } 
        
       
        return stringValue;
    }
    
   
    
    // ------------------------------------------------------
    // ------------------------------------------------------
    // The below are methods that we don't care to implement.
    // ------------------------------------------------------
    // ------------------------------------------------------
    
    @Override
    public Iterator<E> iterator() {
        return null;
    }
    
    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
    
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }      
}

