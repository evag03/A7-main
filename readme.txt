Timer Findings:

We found that InsertionSort consistently takes the longest amount of time to finish sorting, followed by
SelectionSort, then QuickSort being the fastest (go figure). InsertionSort took about double the time
that SelectionSort did, with Quicksort only taking about a tenth of the time that SelectionSort took.

We found that there was a sharp increase in the time it took for the sorting methods to execute after
increasing the number of cards the program had to sort from 20 thousand to 40 thousand, with
InsertionSort taking around 12 seconds rather than a little over a second. The difference in time
between the three sorting methods grew exponentially as the number of cards to sort increased as well.

Musa's Reflection:

    I believe what went well in this assignment was making sure we understood the algorithm step-by-step through first by 
    drawing it out as if we were solving a card problem in real-life. Then we started ascribing implementations to each step 
    of the card-solving algorithm based on the drawings. Making sure we could do this was crucial to completing the assignment, there 
    was too many times in TA Hours where we would say that we "understood the algorithm conceptually but just not how to start 
    implementing it" and the TA would immediately tell us that we had to understand it conceptually and then would draw it out and 
    go over it with us again. That really helped with insertion sort in terms of figuring out how to implement the listIterator, and 
    it really helped out in quickSort when we didn't know how the recursion was supposed to work (we drew out how to do Quicksort 
    first, and then labeled each step in the process where we return). 

    I'd say that's what I struggled with too, because I had to have a lot of TAs tell us that we didn't actually understand 
    the algorithm conceptually, which I appreciate. In future assignments, I'm going to work on being able to 'label' 
    different parts of an algorithm with code while drawing it out so we're less confused. 

Eva's Reflection:
    What went well was learning how to use recursion as an alternative to iteration. It took time to
    understand how to change the sorting algorithms to account for the way recursion works backwards,
    but I feel I have a better idea of how it changes a program and how to avoid the roadblocks that
    we encountered while figuring out what needed to be adjusted with backwards sorting. One of those
    roadblocks was programming the MergeSort class to work properly with the Timer class. The timer
    consistently runs in an infinite loop when trying to run it, and we haven't been able to find
    a way to get it to properly measure the time for the method to sort like we were able to for
    the other three sorting methods. We'll likely go back to this assingment in the future and try
    to get a better idea of what we could have adjusted to fix the timer while simultaneously
    gaining a greater understanding of measuring execution times in programming.