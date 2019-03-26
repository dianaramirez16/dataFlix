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
      static Scanner scan1 = new Scanner(System.in); //global scanner
      static String username, password;
      static CreateMovie[] myMovieArray; //holds movie objects
      static ArrayStack arrayStack; //stack
      static CircularQueue circularQueue; //queue
      static int countUsers=0, countAttempts=0;
      static String credentialsArray[] = new String[20];
      static int[] genreArray = {0,0,0,0}; //horror, comedy, action, anime
      
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
                        break;
                  } else { //if option 1 is not entered
                        System.out.println("You do not have access to this feature until you are registered.");
                  }
                  
                  System.out.println(printMenu());
                  int optionToContinue = scan1.nextInt();
                  
                  while (optionToContinue==1) {
                        System.out.println("You are already registered, would you like to try another option?");
                        
                        printMenu();
                  }
                  if (optionToContinue==2) {
                       System.out.println("You are already logged in, please choose another option.");
                       break;
                  }
                  printMenu();
                  if (optionToContinue==3) {
                        watchMovie();
                  }
                  
            } while (scan1.nextInt()!=99);   ///ends do while loop
      }
      
      public static String printMenu(){
            return "1. Register account" +
                    "\n2. Login " +
                    "\n3. Watch a movie" +
                    "\n4. View Complete Watch History" + //first in first out, lists movies chronologically order
                    "\n5. View Most Recently Watched " + //last in first out, views last watched first
                    "\n6. Number of times Each Movie has been Watched" +
                    "\n7. Most watched Movie" +
                    "\n8. Most watched Genre" +
                    "\n9. Log Out\n--------------\n\n";
      }
      
      public static void collectCredentials(){
            String userFirstName, userLastName;
            scan1.nextLine();  //prepares scanner for next input
            System.out.println("Please register your login credentials. Enter your first name: ");
            userFirstName = scan1.nextLine();
            
            System.out.println("Enter your last name: ");
            userLastName = scan1.nextLine();
            
            System.out.println("Username MUST contain at least one digit (0-9). Enter username:");
            username = scan1.nextLine();
            
            System.out.println("Choose a password. It must contain at least one special character (! @ # $ % ^ & * or ?) Enter password:");
            password = scan1.nextLine();
            
            
            if ((checkCredentials(username,password))&&(countUsers==0)) {  //if credentials are valid, store in array
                        credentialsArray[0] = userFirstName;
                        credentialsArray[1] = userLastName;
                        credentialsArray[2] = username;
                        credentialsArray[3] = password;
                        countUsers++;
            } else if ((countUsers==1)) {
                        credentialsArray[4] = userFirstName;
                        credentialsArray[5] = userLastName;
                        credentialsArray[6] = username;
                        credentialsArray[7] = password;
                        countUsers++;
            } else if ((countUsers==2)) {
                        credentialsArray[8] = userFirstName;
                        credentialsArray[9] = userLastName;
                        credentialsArray[10] = username;
                        credentialsArray[11] = password;
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
                  System.out.println("\nYou may now log in.");
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
                  time = minutes / 60 + "h " + minutes % 60 + "m";
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
            CreateMovie movie9 = new CreateMovie("Let the Right One In", 2008, formatMovieDuration(114), "Horror", 7.9);
            CreateMovie movie10 = new CreateMovie("Anastasia", 1997, formatMovieDuration(94), "Anime", 7.1);
            CreateMovie movie11 = new CreateMovie("Ratatouille", 2007, formatMovieDuration(111), "Anime", 8.0);
            CreateMovie movie12 = new CreateMovie("Kiki's Delivery Service", 1989, formatMovieDuration(103), "Anime", 7.9);
            CreateMovie movie13 = new CreateMovie("50 First Dates", 2004, formatMovieDuration(99), "Comedy", 6.8 );
            CreateMovie movie14 = new CreateMovie("Ace Ventura: Pet Detective", 1994, formatMovieDuration(86), "Comedy", 6.9);
            CreateMovie movie15 = new CreateMovie("Wonder Woman", 2017, formatMovieDuration(141), "Action", 7.5 );
            CreateMovie movie16 = new CreateMovie("Aquaman", 2018, formatMovieDuration(143), "Action", 7.2);
            CreateMovie movie17 = new CreateMovie("Deadpool", 2016, formatMovieDuration(108), "Action", 8.0);
            CreateMovie movie18 = new CreateMovie("The Fifth Element", 1997, formatMovieDuration(126), "Action", 7.7 );
            myMovieArray = new CreateMovie[] {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10, movie11, movie12, movie13, movie14, movie15, movie16, movie17, movie18};
            
      }
      
      public static String watchMovie(){
            //user will pick int from 1-18 (array holds 0-17)
            
            for (int i = 0; i<19; i++ ){  //prints array
                  String s ="\t" + i + "\t" + (myMovieArray[i].getMovieTitle());
                  System.out.println(s);
                  //this string only holds movie title
            }
            int movieIndex;
            System.out.println("Search for a movie: ");
            String movieSearched = scan1.nextLine();
            
            
            System.out.println("movieindex variable: " + movieIndex);
            CreateMovie temp = myMovieArray[movieIndex];
            //create shallow copy & replace variables below in push methods
            
            //horror, comedy, action, anime
            if (temp.getMovieGenre().equals("Horror")) {
                  genreArray[0]++;
                  //this statement will match the string inside the movie object and incrememnt appropritate counter
                  //if statement for each genre
            } else if (temp.getMovieGenre().equals("Comedy")) {
                  genreArray[1]++;
            } else if (temp.getMovieGenre().equals("Action")) {
                  genreArray[2]++;
            } else if (temp.getMovieGenre().equals("Anime")) {
                  genreArray[3]++;
            }
            
            //countMovieTitle(accepts movie object;
            
            arrayStack.push(temp); //adds to stack
            circularQueue.offer(temp);  //adds to queue
            return "You have watched: " + temp.getMovieTitle();
            
            //instantiate global genre array, increment whenever it's watched
      }
      
      public int searchMovie(String movieSearched) {
            int movieIndex;
            for (int i =0; i<myMovieArray.length; i++) {
                  if (movieSearched.equals(myMovieArray[i])) {
                        movieIndex = i;
                  } else {
                        System.out.println("Could not find a match, search again.");
                        movieIndex=0;
                  }
                  
            }
            return movieIndex;
      }
      
      public void countMovieTitle(CreateMovie movie) {
            //create global array to countMovies watched
            //string temp = movie.getMOvieTitle();
            //bunch of switch statements
            
            
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