import java.util.ListIterator;

public class InsertionSortTimer {
  
  public static CardPile sort(CardPile unsorted) {
    
    // Here is the result list you will be creating
    CardPile sorted = new CardPile();    
    Card c = unsorted.getFirst();
    unsorted.removeFirst();
    sorted.add(c);
    
    while (unsorted.size() > 0) {
      // Remove the first element from unsorted and find the point where it should go in sorted
      // (the point where all previous elements are smaller than the removed element, and all
      // following elements are greater than or equal to it).
      // Insert the removed element into sorted at this point.
      c = unsorted.remove();
    
      if ((c.compareTo(sorted.getFirst())) < 0) {
        sorted.addFirst(c);
      }
      
      else {
        ListIterator<Card> pos = sorted.listIterator(sorted.size());
        Card lastCard = pos.previous();

        while (pos.hasPrevious() && c.compareTo((lastCard)) < 0) {
          lastCard = pos.previous();
        }        
        sorted.insertAfter(c, lastCard);

      }  
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
