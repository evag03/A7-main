import java.util.ArrayDeque;
/**
 * Implements the class that constrcuts the timer for the insertion sorting method.
 */
public class SelectionSortTimer {
  /**
   * Constructs a modifed version of the selection sorting method without references to record.
   * @param unsorted The unsorted list of cards
   * @return The sorted list of cards
   */
  public static CardPile sort(CardPile unsorted) {
  
      // Here is the result list you will be creating
      CardPile sorted = new CardPile();

      while (unsorted.size() > 0) {
          Card min = unsorted.getFirst();
          for (Card currentCard : unsorted) {
              if (min.compareTo(currentCard) > 0) {
              min = currentCard;
              }
          }
          sorted.add(min);
          unsorted.remove(min);
      }
      return sorted;
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
