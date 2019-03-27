 /* ╒══════════════════════════════════════════════════════╕
  *  |   Student ID: 210595699                              |
  *  |   Name: Diana Ramirez                                |
  *  |   Class: Data Structures                             |
  *  |                                                      |
  *  |   Project Description:                               |
  *  |   This code demonstrates a menu-driven software      |
  *  |   used to collect and present data about movie-      |
  *  |   watching patterns from user input.                 |
  *  ╘══════════════════════════════════════════════════════╛
  */
 public class ArrayStack <E> {
      
       // Storage for the Stack
      
       private CreateMovie movie; //creates local reference to movie objs
       private CreateMovie[] movieList; //creates local movieLIst array
       public int TOS;	// Indicates nothing is there initially
       private static final int INITIAL_CAPACITY = 20;
      
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
             for(int i=0; i<movieList.length; i++) {
                   if (movie.equals(movieList[i])){
                         return null;
                   }
             }
             return (this.movieList[++TOS] = movie); //adds to stack
            
       }
      
      
       public CreateMovie pop() {
             // This method deletes an element from the Stack
             // First check if there is an element to delete
             if(!isEmpty()) {
                  
                   CreateMovie temp = movieList[TOS--]; //saves data to temp
                   TOS--; //decrements TOS pointer
                   return temp; //returns element
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