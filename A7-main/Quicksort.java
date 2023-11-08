import java.util.*;
/**
 * Implements the class that constrcuts the insertion sorting method.
 */
public class Quicksort {
  /**
   * Constructs the quick sorting method, which takes the first unsorted card as a pivot, pulls the remaining unsorted cards off the list one at a time and appends them to either a smaller or bigger list based on whether it's smaller or bigger/equal to the pivot, and recursively sorts the two sublist before reattaching the results with the pivot in between and returning that as the result.
   * @param unsorted The unsorted list of cards
   * @param record The recorder that keeps track of changes in the CardPile as it is sorted
   * @return The sorted list of cards
   */
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    record.add(unsorted);
    record.next();
    
    // ***********************************************************
    // Here is where you'll check the stop condition and return
    // if it is satisfied.
    // ***********************************************************
    if (unsorted.size() <= 1) {
      return unsorted;
    }

    // Here are the two partitions you will be creating
    CardPile smaller = new CardPile();
    CardPile bigger = new CardPile();

    // ***********************************************************
    // Here is where you'll do the partition part of Quicksort:
    //   - Choose a pivot
    //   - Partition the unsorted list into two piles
    // ***********************************************************
    Card pivot = unsorted.removeFirst();  // edit this!
    
    while (!unsorted.isEmpty()) {
      Card firstCard = unsorted.removeFirst();
      if (pivot.compareTo(firstCard) < 0) {
        smaller.add(firstCard);
      }
      else if (pivot.compareTo(firstCard) >= 0) {
        bigger.add(firstCard);
      }
    }

    // register the partitions with the recorder
    record.add(smaller);
    record.add(pivot);
    record.add(bigger);
    record.next();

    // This will hold the assembled result
    CardPile result = new CardPile();
    
    // ***********************************************************
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************

    
    result.append(sort(bigger, record));
    result.add(pivot);
    result.append(sort(smaller, record));

    // record the sorted result
    record.add(result);
    record.next();
    
    // return the sorted result here
    return result;
  }
  
public static void main(String args[]) {

    // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    // cards = cards.split(cards.get(39));

    // mix up the cards
    Collections.shuffle(cards);

    // if you want to sort in array form, use:
    Card[] card_arr = cards.toArray(new Card[0]);

    // in your program, this would be a call to a real sorting algorithm
    cards = Quicksort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: MergeSort");
  }
}
