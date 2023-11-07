import java.util.ArrayDeque;
import java.util.*;

public class MergeSort {
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
      
    // ***********************************************************
    // Here is where you'll do the "work" of MergeSort:
    //   - Use queue to store the intermediate piles
    //   - Don't forget to register the new state with the
    //     recorder after each merge step:
    //        record.next();        // tell it this is a new step
    //        for (CardPile pile: queue) { // add all piles
    //           record.add(pile);
    //        }
    // ***********************************************************
    while (unsorted.size() > 0) {
      Card c = unsorted.remove();
      CardPile isolatedCard = new CardPile();
      isolatedCard.addFirst(c);
      queue.add(isolatedCard);

      // record.next();        // tell it this is a new step
      // for (CardPile pile: queue) { // add all piles
      //   record.add(pile);
      // }
    }
    record.add(unsorted);
    
// While more than one list remains on the queue:
// Remove the first two lists from the queue and merge them, preserving their sorted order.
// Put the result back at the end of the queue.

    while (queue.size() > 1) {
      CardPile isolatedCard1 = queue.poll();
      CardPile isolatedCard2 = queue.poll();

      //compare each element in list with itself
      //then poll head
      while (isolatedCard1.size() > 0 && isolatedCard2.size() > 0) {
        CardPile mergedPile = new CardPile();
        Card pile1Head = isolatedCard1.peek();
        Card pile2Head = isolatedCard2.peek();

        if (isolatedCard1.peek().compareTo(isolatedCard2.peek()) < 0) {
          mergedPile.addLast(isolatedCard1.removeFirst());
        }

        else if (pile1Head.compareTo(pile2Head) > 0) {
          mergedPile.addLast(isolatedCard2.removeFirst());
        }
        
        else {
          mergedPile.addLast(isolatedCard1.removeFirst());
        }

        queue.addLast(mergedPile);
        record.add(mergedPile);
      }
      
      if (isolatedCard1.size() == 0) {
        CardPile mergedPile = queue.removeLast();

        while (!isolatedCard2.isEmpty()) {
          mergedPile.addLast(isolatedCard2.removeFirst());  
        }
        
        queue.addLast(mergedPile);
        record.add(mergedPile);
      }
      
      else if (isolatedCard2.size() == 0) {
        CardPile mergedPile = queue.removeLast();

        while (!isolatedCard1.isEmpty()) {
          mergedPile.addLast(isolatedCard1.removeFirst());

        }
        queue.addLast(mergedPile);
        record.add(mergedPile);

      }
      

      record.next();        // tell it this is a new step
        for (CardPile pile: queue) { // add all piles
           record.add(pile);
        }

    }

    
    // return the sorted result here
    return queue.remove();
  }

// To merge two sorted lists into a single sorted list:
// Look at the first element in each list.
// Take the smaller of the two off the front of its old list and put it at the end of a new (merged) list.
// Repeat this until both one of the old lists is empty, at which point you can append the remainder of the other original list to the new list.
// If the original lists were sorted, and you always take the smallest element available, then the resulting list will also be sorted. (You might want to convince yourself of this fact before continuing.)
// Note: the key operation here is the merging of two sorted lists. Probably you will want to develop a method for this and test it thoroughly before tackling the full program.

 /** Starts the program running */

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
    cards = MergeSort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: MergeSort");
  }
}

