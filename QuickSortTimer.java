import java.util.*;
/**
 * Implements the class that constrcuts the timer for the quick sorting method.
 */
public class QuickSortTimer {
  /**
   * Constructs a modifed version of the quick sorting method without references to record.
   * @param unsorted The unsorted list of cards
   * @return The sorted list of cards
   */
  public static CardPile sort(CardPile unsorted) {

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
    Card pivot = unsorted.removeFirst(); 
    
    while (!unsorted.isEmpty()) {
      Card firstCard = unsorted.removeFirst();
      if (pivot.compareTo(firstCard) < 0) {
        smaller.add(firstCard);
      }
      else if (pivot.compareTo(firstCard) >= 0) {
        bigger.add(firstCard);
      }
    }

    // This will hold the assembled result
    CardPile result = new CardPile();
    
    // ***********************************************************
    // Here is where you'll do the remaining work of Quicksort:
    //   - Make recursive calls on the partitions
    //   - Assemble the sorted results into a single pile
    // ***********************************************************
    
    result.append(sort(bigger));
    result.add(pivot);
    result.append(sort(smaller));

    // return the sorted result here
    return result;
  }
  
  
  public static void main(String args[]) {
    
    if (args.length<1) {
      System.err.println("Please specify how many cards to sort!");
    } else {
      Card[] deck = Card.newDeck(true);
      CardPile cards = new CardPile();
      
      for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
        cards.add(deck[(int)(52*Math.random())]);
      }

      sort(cards); 
    }
  }
}
