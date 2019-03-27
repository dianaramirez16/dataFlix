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
            return this.movieTitle;
      }
      
      public int getMovieReleaseYear () {
            return this.movieReleaseYear;
      }
      
      public String getMovieDuration () {
            return this.movieDuration;
      }
      
      public String getMovieGenre () {
            return this.movieGenre;
      }
      
      public double getMovieRating () {
            return this.movieRating;
      }
      
      //set methods
      public void setMovieTitle (String movieTitle) {
            this.movieTitle = movieTitle;
      }
      
      public void setMovieReleaseYear (int movieReleaseYear) {
            this.movieReleaseYear = movieReleaseYear;
      }
      
      public void setMovieDuration (String movieDuration) {
            this.movieDuration= movieDuration;
      }
      
      public void setMovieGenre (String movieGenre) {
            this.movieGenre = movieGenre;
      }
      
      public void setMovieRating (double movieRating) {
            this.movieRating = movieRating;
      }
      
      
      public String toString() {
            return "";
      }
      
      
      
      
}