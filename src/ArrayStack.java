

public class ArrayStack <E> {
      
      // Storage for the Stack
      
      private CreateMovie movie; //creates local reference to movie objs
      private CreateMovie[] movieList; //creates local movieLIst array
      private int TOS;	// Indicates nothing is there initially
      private static final int INITIAL_CAPACITY = 5;
      
      // Default constructor to create Stack
      public void ArrayStack() {
            this.movieList = new CreateMovie[INITIAL_CAPACITY];
            this.TOS = -1;
      }
      
      
      public CreateMovie push(CreateMovie movie) {
            // Adds elements to the Stack
            // First check if there is enough space to add element
            if(TOS == this.movieList.length - 1) {	// Stack Full
                  System.out.println("Stack Overflow..!!");
                  // We can now call reallocate() to increase the capacity
                  return null;
            }
		/*TOS++;	// Go to the proper index
		this.theData[TOS] = obj;
		return;*/
            return (this.movieList[++TOS] = movie);
      }
      
      
      public CreateMovie pop() {
            // This method deletes an element from the Stack
            // First check if there is an element to delete
            if(!isEmpty()) {
			/*E temp = this.theData[TOS];	// Save the data first
			TOS--;						// Then decrement the TOS
			return temp;				// Then return the element
			 */
                  return this.movieList[TOS--];
            }
            else {
                  System.out.println("Stack Underflow..!!");
            }
            return null;
      }
      
      
      public CreateMovie peek() {
            if(TOS==-1) { //stack is empty
                  System.out.println("stack is empty");
                  return null;
            } else {
                  System.out.println(movieList[TOS]);
                  return movieList[TOS];
            }
            
      }
      
      
      public boolean isEmpty() {
		/*if((TOS == -1) {
			return true;
		}
		else
			return false;*/
            return (TOS == -1);
      }
      
      // Use toString to display the Stack contents
      // stack will be used to print in reverse order
      public String toString() {
            String s = "Movies Watched, (most recent at the top): ";
            CreateMovie moviePrinting = null; //default constructor called
            
            for(int i = TOS; i >= 0; i--) {
                  moviePrinting = movieList[i]; //will hold only one movie at a time
                  s += moviePrinting.getMovieTitle() + " | " ;
            }
            return s;
      }
      
      
}