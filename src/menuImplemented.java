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
public class menuImplemented {
      static Scanner scan1 = new Scanner(System.in); //global scanner
      static String username, password;
      public static void main(String[] args) {
            
            createMovies();
           
            startMenu();
            
      }
      
      public static void startMenu(){
            //option 1 - register and create user login credentials
            String userFirstName, userLastName;
            System.out.println("Hello, first-timer. \nPlease register your login credentials below. \n\nEnter your first name: ");
            userFirstName = scan1.nextLine();
      
            System.out.println("Enter your last name: ");
            userLastName = scan1.nextLine();
            
            System.out.println("Username MUST contain at least one digit (0-9).\nEnter username:");
            username = scan1.nextLine();
      
            System.out.println("Choose a password. It must contain at least one special character (! @ # $ % ^ & * or ?) \nEnter password:");
            password = scan1.nextLine();
      
            registerUser(username, password);
      
            //loop to verify login credentials, will need to figure out exit condition and effect
            int countLogins=0;
            boolean loginMethodReturn;
            do {
                  loginMethodReturn = loginUser(username, password);
                  countLogins++;
            } while ((loginMethodReturn == false) && countLogins<3);
            if (countLogins==3){
                  username = "tempUser1";
                  password = "tempPassword#";
                  System.out.println("Due to too many failed attempts, you have been logged in using temporary credentials. Please see below:" +
                          "\n Username: " + username + "\nPassword: " + password);
            }
      
            //option 2 login directly, can only be chosen if user has registered all the above credentials first
      }
      
      
      //method for user to login after setting credentials
      public static boolean loginUser(String username, String password) {
            
            boolean loggedIn;
            System.out.println("Please login. Enter your username:");
            String login = scan1.next();
            
            System.out.println("Enter your password:");
            String loginpass = scan1.next();
            
            loggedIn = ((login.equals(username)) && (loginpass.equals(password)) ? true: false);
            
            if (loggedIn) {
                  System.out.println("You are now logged in.");
            } else {
                  System.out.println("The credentials were not entered correctly, please try again.");
            }
            
            
            return loggedIn;
      }
      
      
      //method to register new user login credentials.
      public static boolean registerUser(String username, String password) {
            
            boolean valid = ((username.contains("1")) || (username.contains("2")) ||
                    (username.contains("3")) || (username.contains("4")) ||
                    (username.contains("5")) || (username.contains("6")) ||
                    (username.contains("7")) || (username.contains("8")) ||
                    (username.contains("9")) || (username.contains("0"))) &&
                    ((password.contains("!")) || (password.contains("@")) || (password.contains("#")) ||
                            (password.contains("$")) || (password.contains("%")) || (password.contains("^")) ||
                            (password.contains("&")) || (password.contains("*")) || (password.contains("?")));
            
            if (valid) {
                  System.out.println("Thank you. \nYour login credentials are set: \nYour username: "+username + "\nYour password: " + password);
            } else {
                  System.out.println("Invalid! Your username must contain a number 1-9" +
                          " and your password must contain at least 1 special character: !@#$%^& or *. Please try again.");
            }
            return valid;
      }
      //String movieTitle, int movieYear, int movieDuration, String movieGenre, double movieRating
      
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
      }
      
      public static String formatMovieDuration(int minutes) {
            String time;
            if (minutes>60){
                  time = minutes/60 + "h " + minutes%60 + "m";
                  return time;
            } else return null;
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
