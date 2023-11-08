import java.time.*;
import java.util.*;

/** 
 *  Class to measure execution time.
 *  Based on https://replit.com/@RemyCron/Timing
 *
 * @author Nick Howe
 * @version Sept. 2021
 */
class Timer {
  /** Access to the system clock */
  private Clock clock;

  /** Is timer currently active? */
  private boolean isActive;

  /** Start time on clock */
  private double startTime;

  /** Constructor makes a timer in the off state */
  public Timer() {
    clock = Clock.systemDefaultZone();
    isActive = false;
    startTime = 0.0;
  }

  /** 
   *  Starts the timer.  If already running, throws an exception
   */
  public void start() {
    if (isActive) {
      throw new RuntimeException("Attempt to start a timer that is already running.");
    } else {
      isActive = true;
      startTime = clock.millis()*0.001; // In seconds
    }
  }

  /** 
   *  Restarts the timer, regardless of running status
   */
  public void restart() {
    isActive = true;
    startTime = clock.millis()*0.001; // In seconds
  }

  /**
   *  Stops the timer and returns the elapsed time
   *  @return Elapsed time in seconds
   */
  public double stop() {
    double stopTime = clock.millis()*0.001;
    this.isActive = false;
    return stopTime-startTime;
  }

  public static void main(String[] args) {
    String[] args1 = {"10000"};
    String[] args2 = {"20000"};
    String[] args3 = {"40000"};
    String[] args4 = {"80000"};
    Timer timer = new Timer();

    System.out.println("Testing speed of 10000 cards");
    timer.start();
    InsertionSortTimer.main(args1);
    System.out.println("Insertion sort time: " + timer.stop());

    timer.start();
    SelectionSortTimer.main(args1);
    System.out.println("Selection sort time: " + timer.stop());

    timer.start();
    QuickSortTimer.main(args1);
    System.out.println("Quick sort time: " + timer.stop());

    System.out.println("Testing speed of 20000 cards");
    timer.start();
    InsertionSortTimer.main(args2);
    System.out.println("Insertion sort time: " + timer.stop());

    timer.start();
    SelectionSortTimer.main(args2);
    System.out.println("Selection sort time: " + timer.stop());
    
    timer.start();
    QuickSortTimer.main(args2);
    System.out.println("Quick sort time: " + timer.stop());

    System.out.println("Testing speed of 40000 cards");
    timer.start();
    InsertionSortTimer.main(args3);
    System.out.println("Insertion sort time: " + timer.stop());

    timer.start();
    SelectionSortTimer.main(args3);
    System.out.println("Selection sort time: " + timer.stop());
    
    timer.start();
    QuickSortTimer.main(args3);
    System.out.println("Quick sort time: " + timer.stop());

    System.out.println("Testing speed of 80000 cards");
    timer.start();
    InsertionSortTimer.main(args4);
    System.out.println("Insertion sort time: " + timer.stop());

    timer.start();
    SelectionSortTimer.main(args4);
    System.out.println("Selection sort time: " + timer.stop());
    
    timer.start();
    QuickSortTimer.main(args4);
    System.out.println("Quick sort time: " + timer.stop());
  }
}