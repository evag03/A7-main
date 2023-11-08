import java.util.ArrayDeque;
/**
 * Implements the class that constrcuts the timer for the merge sorting method.
 */
public class MergeSortTimer {
  /**
   * Constructs a modifed version of the merge sorting method without references to record.
   * @param unsorted The unsorted list of cards
   * @return The sorted list of cards
   */
  public static CardPile sort(CardPile unsorted) {

    ArrayDeque<CardPile> queue = new ArrayDeque<CardPile>();
      
    while (unsorted.size() > 0) {
      Card c = unsorted.remove();
      CardPile isolatedCard = new CardPile();
      isolatedCard.addFirst(c);
      queue.add(isolatedCard);
    }
    
    // While more than one list remains on the queue:
    // Remove the first two lists from the queue and merge them, preserving their sorted order.
    // Put the result back at the end of the queue.

    while (queue.size() > 1) {
      CardPile isolatedCard1 = queue.poll();
      CardPile isolatedCard2 = queue.poll();

      //compare each element in list with itself
      //then poll head
      CardPile mergedPile = new CardPile();
      while (isolatedCard1.size() > 0 && isolatedCard2.size() > 0) {
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
      }
      
      if (isolatedCard1.size() == 0) {
        mergedPile = queue.removeLast();

        while (!isolatedCard2.isEmpty()) {
          mergedPile.addLast(isolatedCard2.removeFirst());  
        }
        
        queue.addLast(mergedPile);
      }
      
      else if (isolatedCard2.size() == 0) {
        mergedPile = queue.removeLast();

        while (!isolatedCard1.isEmpty()) {
          mergedPile.addLast(isolatedCard1.removeFirst());

        }
        queue.addLast(mergedPile);
      }

    }

    // return the sorted result here
    return queue.remove();
  }

  public static void main(String args[]) {
      
      if (args.length<1) {
        System.err.println("Please specify how many cards to sort!");
      } else {
        Card[] deck = Card.newDeck(true);
        CardPile cards = new CardPile();
        
        for (int i = 0; i<Integer.parseInt(args[0]); i++ ) {
          cards.add(deck[(int)(52*Math.random())]);
          System.out.println(i);
        }

        System.out.println(sort(cards).toString());
        
      }
    }
}
