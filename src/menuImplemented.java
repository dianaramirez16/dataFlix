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
      public static void main(String[] args) {
            String username, password;
            createMovies();
            Scanner scan1 = new Scanner(System.in);
            System.out.println("Hello, first-timer. Please register your login credentials. Username MUST contain at least one digit (0-9).\nEnter username:");
            username = scan1.nextLine();
            
            System.out.println("Choose a password. It must contain at least one special character (! @ # $ % ^ & * or ?) \nEnter password:");
            password = scan1.nextLine();
            registerUser(username, password);
            
            int countLogins=0;
            boolean loginMethodReturn;
            do {
                  loginMethodReturn = loginUser(username, password);
                  countLogins++;
            } while ((loginMethodReturn == false) && countLogins<3);
            
            
            //create login procedure method
            
            //have user log in
            //startMenu();
            //scan1.close();
      }
      
      //method for user to login after setting credentials
      public static boolean loginUser(String username, String password) {
            Scanner scan2 = new Scanner(System.in);
            boolean loggedIn;
            System.out.println("Please login. Enter your username:");
            String login = scan2.next();
            
            System.out.println("Enter your password:");
            String loginpass = scan2.next();
            
            loggedIn = ((login.equals(username)) && (loginpass.equals(password)) ? true: false);
            
            if (loggedIn) {
                  System.out.println("You are now logged in.");
            } else {
                  System.out.println("The credentials were not entered correctly, please try again.");
            }
            
            //scan2.close();
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
            CreateMovie movie1 = new CreateMovie("Get Out", 2017, 144, "Horror/Mystery", 7.7);
            CreateMovie movie2 = new CreateMovie("Spirited Away", 2001, );
      }
      
      public static String formatMovieDuration(int minutes) {
            String time;
            if (minutes>60){
                  time = minutes/60 + "h " + minutes%60 + "m";
                  return time;
            } else return null;
      }
      
      //
      public String checkGenre(){
            String Horror = "Horror";
            String Comedy = "Comedy";
            String Action = "Action";
            String Anime = "Anime";
            int horrorCounter;
            int comedyCounter;
            int actionCounter;
            int animeCounter;
            
            /* this will reference the array the movies are stored in *************
            for (int i=0; i<movieList.length(); i++) {
            
            }
            //this will iterate through the counters and increment counters
            return most watched genre cast as a string */
      }
      
}
