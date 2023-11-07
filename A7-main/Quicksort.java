import java.util.ArrayDeque;

public class Quicksort {
  
  
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();

    // ***********************************************************
    // Here is where you'll check the stop condition and return
    // if it is satisfied.
    // ***********************************************************
    

    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    // ***********************************************************
    // Here is where you'll do the partition part of Quicksort:
    //   - Choose a pivot
    //   - Partition the unsorted list into two piles
    // ***********************************************************
    Card pivot = unsorted.removeFirst();  // edit this!
    
      while (unsorted.size() > 0) {
        Card currentCard = unsorted.remove();
        CardPile lesserThanPivot = new CardPile();
        CardPile greaterThanEqualPivot = new CardPile();
        
        if (pivot.compareTo(currentCard) < 0) {
          lesserThanPivot.addLast(currentCard);
          pivot = unsorted.getFirst();
        }
        
        else if (pivot.compareTo(currentCard) > 0) {
          greaterThanEqualPivot.addLast(currentCard);
          pivot = unsorted.getFirst();
        }
        
        return sort(lesserThanPivot, record);
        
// Take the first element as the pivot. (Note: This works well unless the list is already sorted, but we'll ignore that detail.)
// Pull the remaining elements off the list one at a time and append them to either of two new sublists: one for elements less than the pivot and one for elements greater than or equal to the pivot.
// Recursively sort the two sublists, then glue the results back together with the pivot in the middle, and return that as the result.

    // // register the partitions with the recorder
    // record.add(smaller);
    // record.add(pivot);
    // record.add(bigger);
    // record.next();

    // // This will hold the assembled result
    // CardPile result = new CardPile();
    
    // // ***********************************************************
    // // Here is where you'll do the remaining work of Quicksort:
    // //   - Make recursive calls on the partitions
    // //   - Assemble the sorted results into a single pile
    // // ***********************************************************
    
    // // Take the first element as the pivot. (Note: This works well unless the list is already sorted, but we'll ignore that detail.)
    

    // // record the sorted result
    // record.add(result);
    // record.next();
    
    // // return the sorted result here
    // return result;
  }

  }

}
