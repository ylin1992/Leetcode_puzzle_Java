package Design;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class _286_PeekingIterator<T> implements Iterator<T> {
   private Iterator<T> iter;
   private T nextEle;

   public _286_PeekingIterator(Iterator<T> iterator) {
      // initialize any member here.
      iter = iterator;
      nextEle = iter.hasNext() ? iter.next() : null;
   }

   // Returns the next element in the iteration without advancing the iterator.
   public T peek() {
      return nextEle;
   }

   // hasNext() and next() should behave the same as in the Iterator interface.
   // Override them if needed.
   @Override
   public T next() {
      T temp = nextEle;
      nextEle = iter.hasNext() ? iter.next() : null;
      return temp;
   }

   @Override
   public boolean hasNext() {
      return iter.hasNext() || nextEle != null;
   }

   public static void main(String[] args) {
      List<Double> list = new ArrayList<>();
      list.add(1.0);
      list.add(2.0);
      list.add(3.0);

      Iterator<Double> iter = list.iterator();
      _286_PeekingIterator<Double> iterator = new _286_PeekingIterator<>(iter);
      System.out.println(iterator.hasNext());
      System.out.println(iterator.nextEle);
      System.out.println(iterator.next());
      System.out.println(iterator.next());
   }
}



