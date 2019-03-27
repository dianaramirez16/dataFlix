/* contains main method
 *  ╒══════════════════════════════════════════════════════╕
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
import java.util.*;
import java.util.Random;

public class menuImplemented {
      static Random random = new Random();
      static Scanner scan1 = new Scanner(System.in); //global int scanner
      static Scanner scan2 = new Scanner(System.in); //global string scanner
      static String username, password;
      static CreateMovie[] myMovieArray; //holds movie objects
      static ArrayStack <CreateMovie> arrayStack= new ArrayStack<>(); //stack
      static CircularQueue circularQueue = new CircularQueue(); //queue
      static int countUsers=0, countAttempts=0;
      static String credentialsArray[] = new String[4];
      static int[] genreArray = new int[4]; //horror, comedy, action, anime
      static int[] watchedMovieArray = new int[17]; //stores movie counts
      static int[] moviesPerGenre = new int[5]; //prints movies found through genre search
      
      
      public static void main(String[] args) {
            
            createMovies();
            startMenu();
            
      }
      
      public static void startMenu(){
            int optionToRegister;
            do {
                  System.out.print("Hello, first-timer. Please select option 1 to get started with your new account.");
                  System.out.println(printMenu());
                  optionToRegister = scan1.nextInt();
                  
                  if (optionToRegister==1) {
                        collectCredentials(); //method stores credentials in array
                  } else { //if option 1 is not entered
                        System.out.println("You do not have access to this feature until you are registered.");
                  }
                  
                  System.out.println(printMenu());
                  int optionToContinue = scan1.nextInt();
                  
                  while (optionToContinue==1) {
                        System.out.println("You are already registered, would you like to try another option?");
                        System.out.println(printMenu());
                        optionToContinue = scan1.nextInt();
                  }
                  
                  while (optionToContinue==2) {
                        System.out.println("You are already logged in, please choose another option.");
                        System.out.println(printMenu());
                        optionToContinue = scan1.nextInt();
                  }
                  //scan1.next(); //frees up scanner
                  while (optionToContinue==3) {
                        watchMovie();
                        System.out.println(printMenu());
                        optionToContinue = scan1.nextInt();
                  }
                  
                  while (optionToContinue==4) {
                        System.out.println("This is your watch history ordered from first watched to most recent at the end");
                        System.out.println(circularQueue);
                        System.out.println(printMenu());
                        optionToContinue = scan1.nextInt();
                  }
                  
                  while (optionToContinue==5) {
                        System.out.println("This is your Recent Watched History");
                        System.out.println(arrayStack);
                        System.out.println(printMenu());
                        optionToContinue = scan1.nextInt();
                  }
                  
                  while (optionToContinue==6){
                        for (int i =0; i<watchedMovieArray.length; i++){
                              System.out.println(i);
                        }
                  }
            } while (scan1.nextInt()!=99);   ///ends do while loop
      }
      
      public static String printMenu(){
            return "\n1. Register account" +
                    "\n2. Login " +
                    "\n3. Watch a movie" +
                    "\n4. View Complete Watch History" + //first in first out, lists movies chronologically order
                    "\n5. View Most Recently Watched " + //last in first out, views last watched first
                    "\n6. Number of times Each Movie has been Watched" +
                    "\n7. Most watched Movie" +
                    "\n8. Most watched Genre" +
                    "\n9. Log Out\n--------------\n";
      }
      
      public static void collectCredentials(){
            String userFirstName, userLastName;
            //scan1.nextLine();  //prepares scanner for next input
            System.out.println("Please register your login credentials. Enter your first name: ");
            userFirstName = scan2.nextLine();
            
            System.out.println("Enter your last name: ");
            userLastName = scan2.nextLine();
            
            System.out.println("Username MUST contain at least one digit (0-9). Enter username:");
            username = scan2.nextLine();
            
            System.out.println("Choose a password. It must contain at least one special character (! @ # $ % ^ & * or ?) Enter password:");
            password = scan2.nextLine();
            
            
            if ((checkCredentials(username,password))&&(countUsers==0)) {  //if credentials are valid, store in array
                  credentialsArray[0] = userFirstName;
                  credentialsArray[1] = userLastName;
                  credentialsArray[2] = username;
                  credentialsArray[3] = password;
                  countUsers++;
            } else {
                  countAttempts++;
                  if (countAttempts<3){
                        collectCredentials(); //prompts user to enter credentials all over again
                  } else {
                        int randomN = random.nextInt(999999) + 0;
                        username = userLastName+randomN;
                        password = "password!";
                        
                        System.out.println("\nDue to too many failed attempts, you have been logged in using temporary credentials. Please see below:" +
                                "\nUsername: " + username + "\nPassword: " + password+ "\n\nYou may now access the rest of the menu.");
                  }
                  
                  
            }
      }
      
      
      
      //method checks credentials
      public static boolean checkCredentials(String username, String password) {
            
            boolean validUsername = ((username.contains("1")) || (username.contains("2")) ||
                    (username.contains("3")) || (username.contains("4")) ||
                    (username.contains("5")) || (username.contains("6")) ||
                    (username.contains("7")) || (username.contains("8")) ||
                    (username.contains("9")) || (username.contains("0")));
            boolean validPassword = ((password.length()>7) && (password.contains("!")) || (password.contains("@")) || (password.contains("#")) ||
                    (password.contains("$")) || (password.contains("%")) || (password.contains("^")) ||
                    (password.contains("&")) || (password.contains("*")) || (password.contains("?")));
            
            boolean valid = false;
            if ((validPassword==false)&&(validUsername==false)&&countAttempts<2) {
                  System.out.println("Neither your username nor your password fulfill the requirements, Press ENTER and try again.");
            } else if (validUsername==false &&countAttempts<2) {
                  System.out.println("Your username does not fulfill the requirements. It must be unique and contain a digit 1-9. " +
                          "\nPress ENTER and try again.");
                  valid=false;
            } else if (validPassword==false&&countAttempts<2) {
                  System.out.println("Your password does not fulfill the requirements. It must be longer than 8 characters " +
                          "\nand contain a special character, such as ! or @. \nPress ENTER and try again.");
                  valid = false;
            } else if ((validPassword)&&(validUsername)&&countAttempts<2) {
                  
                  System.out.println("Thank you. \nYour login credentials are set. username: "+username + "\t password: " + password);
                  System.out.println("\nYou are now logged in.");
                  valid=true;
            }
            return valid;
      }
      
      /*
      
      public static void loginUser(String username, String password) {
            int countLogins=0;
            boolean loggedIn ;
            
            if (credentialsArray.contains()) {
            
            }
            
            
            return loggedIn;
      }
      */
      
      
      //String movieTitle, int movieYear, int movieDuration, String movieGenre, double movieRating
      public static String formatMovieDuration ( int minutes){
            String time;
            if (minutes > 60) {
                  time = minutes / 60 + "h" + minutes % 60 + "m";
                  return time;
            } else return null;
      }
      
      public static void createMovies(){
            //create array initialized to hold all these movies
            CreateMovie movie1 = new CreateMovie("Get Out", 2017, formatMovieDuration(104), "Horror", 7.7);
            CreateMovie movie2 = new CreateMovie("Spirited Away", 2001, formatMovieDuration(125), "Anime", 8.6);
            CreateMovie movie3 = new CreateMovie("Legally Blonde", 2001, formatMovieDuration(96), "Comedy", 6.3);
            CreateMovie movie4 = new CreateMovie("The Addams Family", 1991, formatMovieDuration(99), "Comedy", 6.9);
            CreateMovie movie5 = new CreateMovie("Pikachu's Vacation", 1998, formatMovieDuration(23), "Anime", 5.8);
            CreateMovie movie6 = new CreateMovie("A Quiet Place", 2018, formatMovieDuration(90), "Horror", 7.6);
            CreateMovie movie7 = new CreateMovie("The Grudge", 2004, formatMovieDuration(91), "Horror", 5.9);
            CreateMovie movie8 = new CreateMovie("The Silence of the Lambs", 1991, formatMovieDuration(118), "Horror", 8.6);
            CreateMovie movie9 = new CreateMovie("Ratatouille", 2007, formatMovieDuration(111), "Anime", 8.0);
            CreateMovie movie10 = new CreateMovie("Kiki's Delivery Service", 1989, formatMovieDuration(103), "Anime", 7.9);
            CreateMovie movie11 = new CreateMovie("50 First Dates", 2004, formatMovieDuration(99), "Comedy", 6.8 );
            CreateMovie movie12 = new CreateMovie("Ace Ventura: Pet Detective", 1994, formatMovieDuration(86), "Comedy", 6.9);
            CreateMovie movie13 = new CreateMovie("Wonder Woman", 2017, formatMovieDuration(141), "Action", 7.5 );
            CreateMovie movie14 = new CreateMovie("Aquaman", 2018, formatMovieDuration(143), "Action", 7.2);
            CreateMovie movie15 = new CreateMovie("Deadpool", 2016, formatMovieDuration(108), "Action", 8.0);
            CreateMovie movie16 = new CreateMovie("The Fifth Element", 1997, formatMovieDuration(126), "Action", 7.7 );
            myMovieArray = new CreateMovie[] {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10,
                    movie11, movie12, movie13, movie14, movie15, movie16};
            
      }
      
      public static void watchMovie(){
            for (int i = 0; i<16; i++ ){  //prints array
                  int j=i+1;
                  String s ="\t" + j + ". '" + (myMovieArray[i].getMovieTitle()) +
                          "', (" +(myMovieArray[i].getMovieReleaseYear()) +
                          "). Duration: " + (myMovieArray[i].getMovieDuration()) +
                          " Genre: " + (myMovieArray[i].getMovieGenre()) +
                          ", Rating: " + (myMovieArray[i].getMovieRating()) + "/10";
                  System.out.println(s);
            }
            
            System.out.println("\nWould you like to search for a movie by title (ENTER 1) or by genre(ENTER 2)? +"
                    + " \nPress any other number to exit back to main menu");
            int searchByValue = scan1.nextInt();
            if (searchByValue ==1) {  //SEARCH BY TITLE BEGINS
                  while (searchByValue ==1) {
                        //scan1.nextLine(); //throws aways scanner pause
                        System.out.println("\nEnter the complete title you would like to search for: ");
                        String titleSearched = scan2.nextLine(); //saves user input
                        int movieIndex = searchByTitle(titleSearched); //int returned by method stored as index of movie
                        if (movieIndex>16){
                              System.out.println("No search results found. Please try searching for another title.");
                              break;
                        } else {
                              System.out.println("Search Results found: " + myMovieArray[movieIndex].getMovieTitle()+
                                      " (" + myMovieArray[movieIndex].getMovieReleaseYear()+")");
                              
                              System.out.println("Would you like to watch this movie[Enter 1] or exit back to main menu [enter any other number] ?");
                              int optionToWatchOrExit = scan1.nextInt();
                              if (optionToWatchOrExit ==1) {
                                    
                                    pushMovie(movieIndex);   //MOVIE HAS BEEN WATCHED
                                    
                              } else if (optionToWatchOrExit !=1) {
                                    break;
                              }
                        }
                  }
            } else if (searchByValue==2) {  //SEARCH BY GENRE BEGINS
                  int optionToWatchOrExit=0;
                  while (searchByValue==2|| optionToWatchOrExit==2) {
                        System.out.println("\nEnter the genre you would like to search for: ");
                        String genreSearched = scan2.nextLine();
                        printGenreResults(genreSearched);
                        
                        System.out.println("\nWould you like to watch any movie[Enter 1] from this list or search again[Press 2]? "
                                + "\nPress any other number to exit to main menu.");
                        optionToWatchOrExit = scan1.nextInt();
                        if (optionToWatchOrExit ==1) { //user will next select a movie to watch
                              System.out.println("\nEnter the complete title you would like to watch from this list: ");
                              String titleSearched = scan2.nextLine(); //saves user title to watch
                              int movieIndex = searchByTitle(titleSearched);
                              System.out.println("movieIndex: "+ movieIndex);//int returned by method stored as index of movie
                              pushMovie(movieIndex);
                        } else if (optionToWatchOrExit==2) {
                              //returns to while loop
                        } else {
                              break;
                        }
                  }
            }
      }//ends movie Watch method
      
      public static void pushMovie(int movieIndex){
            arrayStack.push(myMovieArray[movieIndex]); //adds to stack
            circularQueue.offer(myMovieArray[movieIndex]);  //adds to queue
            countMovieTitle(myMovieArray[movieIndex]);  //counts times movie was watched
            //this if statement increments genre array counter
            //horror, comedy, action, anime
            if (myMovieArray[movieIndex].getMovieGenre().equals("Horror")) {
                  genreArray[0]++;
            } else if (myMovieArray[movieIndex].getMovieGenre().equals("Comedy")) {
                  genreArray[1]++;
            } else if (myMovieArray[movieIndex].getMovieGenre().equals("Action")) {
                  genreArray[2]++;
            } else if (myMovieArray[movieIndex].getMovieGenre().equals("Anime")) {
                  genreArray[3]++;
            }
            System.out.println("You have watched: " + myMovieArray[movieIndex].getMovieTitle());
      }
      
      
      public static void printGenreResults(String genreSearched) {
            int j = 0;
            for (int i=0; i<myMovieArray.length; i++) {
                  if (genreSearched.equals(myMovieArray[i].getMovieGenre()) ) { //boolean genre was found
                        // if the movie has genre"searched", add the mymovie array index to the movies
                        // per genre array
                        
                        moviesPerGenre[j] = i;
                        j++;
                        
                        System.out.println("Search Results found: " + myMovieArray[i].getMovieGenre() + ", Title: " +
                                myMovieArray[i].getMovieTitle()+"(" + myMovieArray[i].getMovieReleaseYear()+ ")");
                  }
            }
      }
      
      public static int searchByTitle(String titleSearched) {
            int movieIndex=0;
            for (int i =0; i<myMovieArray.length; i++) {
                  if (titleSearched.equals(myMovieArray[i].getMovieTitle())) {
                        return movieIndex= i;
                  }
            }
            return movieIndex;
      }
      
      public static void countMovieTitle(CreateMovie movie) {
            if (movie.getMovieTitle().equals("Get Out")) {
                  watchedMovieArray[0]++;
            } else if (movie.getMovieTitle().equals("Spirited Away")) {
                  genreArray[1]++;
            } else if (movie.getMovieTitle().equals("Legally Blonde")) {
                  genreArray[2]++;
            } else if (movie.getMovieTitle().equals("The Addams Family")) {
                  genreArray[3]++;
            } else if (movie.getMovieTitle().equals("Pikachu's Vacation")) {
                  genreArray[4]++;
            }else if (movie.getMovieTitle().equals("A Quiet Place")) {
                  genreArray[5]++;
            }else if (movie.getMovieTitle().equals("The Grudge")) {
                  genreArray[6]++;
            }else if (movie.getMovieTitle().equals("The Silence of the Lambs")) {
                  genreArray[7]++;
            }else if (movie.getMovieTitle().equals("Ratatouille")) {
                  genreArray[8]++;
            }else if (movie.getMovieTitle().equals("Kiki's Delivery Service")) {
                  genreArray[9]++;
            }else if (movie.getMovieTitle().equals("50 First Dates")) {
                  genreArray[10]++;
            }else if (movie.getMovieTitle().equals("Ace Ventura: Pet Detective")) {
                  genreArray[11]++;
            }else if (movie.getMovieTitle().equals("Wonder Woman")) {
                  genreArray[12]++;
            }else if (movie.getMovieTitle().equals("Aquaman")) {
                  genreArray[13]++;
            }else if (movie.getMovieTitle().equals("Deadpool")) {
                  genreArray[14]++;
            }else if (movie.getMovieTitle().equals("The Fifth Element")) {
                  genreArray[15]++;
            }
      }
      
      public void printStack() { //
            for (int i = arrayStack.TOS; i>0; i-- ){
                  String s = i + "" + (myMovieArray[i].getMovieTitle()) + "\n";
                  System.out.println(s);
                  //
            }
      }
      
      public void printQueue() { //
            for (int i = arrayStack.TOS; i > 0; i--) {
                  String s = i + "" + (myMovieArray[i].getMovieTitle()) + "\n";
                  System.out.println(s);
            }
            
     
      
      /*
      public String checkGenre(String subjecttemp){
            String validated;
            String Horror = "Horror";
            String Comedy = "Comedy";
            String Action = "Action";
            String Anime = "Anime";
            int horrorCounter;
            int comedyCounter;
            int actionCounter;
            int animeCounter;
            
            // create global genre counter array
            
             this will reference the array the movies are stored in *************
            for (int i=0; i<movieList.length(); i++) {
            
            }
            //this will iterate through the counters and increment counters
            return most watched genre cast as a string
            return validated;
      }
      
      //scan1.close();
      */
      
      }
}