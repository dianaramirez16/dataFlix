//this class creates the movie objects stored in the queue at runtime
public class CreateMovie { //CAPITALIZE ***
      //private constants that never change
      //change variable names to lowercase ***
      
      private String movieTitle="";
      private int movieReleaseYear =0;
      private String movieDuration="";
      private String movieGenre="";
      private double movieRating=0.0;
      
      
      //movie constructor
      public CreateMovie(String movieTitle, int movieYear, String movieDuration, String movieGenre, double movieRating) {
            this.movieTitle = movieTitle;
            this.movieReleaseYear = movieYear;
            this.movieDuration= movieDuration;
            this.movieGenre =movieGenre;
            this.movieRating =movieRating;
      }
      
      //get methods
      public String getMovieTitle () {
            return movieTitle;
      }
      
      public int getMovieReleaseYear () {
            return movieReleaseYear;
      }
      
      public String getMovieDuration () {
            return movieDuration;
      }
      
      public String getMovieGenre () {
            return movieGenre;
      }
      
      public double getMovieRating () {
            return movieRating;
      }
      
      //set methods
      public void setMovieTitle (String movieTitle) {
            movieTitle = movieTitle;
      }
      
      public void setMovieReleaseYear (int movieReleaseYear) {
            movieReleaseYear = movieReleaseYear;
      }
      
      public void setMovieDuration (String movieDuration) {
            movieDuration= movieDuration;
      }
      
      public void setMovieGenre (String movieGenre) {
            movieGenre = movieGenre;
      }
      
      public void setMovieRating (double movieRating) {
            movieRating = movieRating;
      }
      
      
      public String toString() {
            return "";
      }
      
      
      
      
}
