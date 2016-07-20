package ch.fhnw.oop2.testPrep.iterator;

/**
 * Created by Kelvin on 05-Jul-16.
 */
import java.util.*;

public class VectorI<T> {

    public final static int INITIAL_SIZE = 16;

    public VectorI(){
        size = 0;
        contents = new Object[INITIAL_SIZE];
    }

    public VectorI(VectorI<T> v){
        size = v.size;
        contents = new Object[v.contents.length];
        for(int i=0; i<size; ++i){
            contents[i] = v.contents[i];  // reference copy of element only!!
        }
    }

    @SuppressWarnings("unchecked")
    public T getElement(int index){
        if (index>=0 & index<size)
            return (T)contents[index];
        else{
            throw new IndexOutOfBoundsException("getElement: invalid index");
        }
    }

    public void setElement(int index, T element){
        if (index>=0 & index<size)
            contents[index] = element;
        else{
            throw new IndexOutOfBoundsException("setElement: invalid index");
        }
    }

    public int size(){
        return size;
    }

    public int capacity(){
        return contents.length;
    }

    public void pushBack(T element){
        if (size>=contents.length){
            Object[] temp = contents;
            contents = new Object[temp.length * 2];
            for (int i=0; i<temp.length; ++i)
                contents[i] = temp[i];
        }
        contents[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T popFront(){
        if(size == 0)
            return null;
        else{
            T temp = (T)contents[0];
            for(int i=1; i<size; ++i)
                contents[i-1] = contents[i];
            --size;
            return temp;
        }
    }

    public Iterator<T> iterator(){
        return new VectorIterator();
    }

    //***** nested class : simple iterator *****************************************
    private class VectorIterator implements Iterator<T>{

        public VectorIterator(){
            currentIndex = 0;
            removeAllowed = false;
        }

        @Override
        public boolean hasNext(){
            if (currentIndex < size) return true;
            else return false;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next(){
            if (hasNext()){
                ++currentIndex;
                removeAllowed = true;
                return (T)contents[currentIndex-1];}
            else{
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove(){
            if (removeAllowed){
                for (int i = currentIndex; i<size; ++i)
                    contents[i-1] = contents[i];
                removeAllowed = false;
                --size;
                --currentIndex;
            }
            else{
                throw new IllegalStateException();
            }
        }

        private int currentIndex;  // points to the next element
        private boolean removeAllowed;  // true, if a successful call to next() occurred

    }  //***** end of iterator class *****

    //***** attributes *************************************************************
    private int size;
    private Object[] contents;
}
