//this class creates the movie objects stored in the queue at runtime
public class CreateMovie { //CAPITALIZE ***
      //private constants that never change
      //change variable names to lowercase ***
      
      private String MOVIE_TITLE="";
      private int MOVIE_RELEASE_YEAR =0;
      private String MOVIE_DURATION ="";
      private String MOVIE_GENRE="";
      private double MOVIE_RATING=0.0;
      
      
      //movie constructor
      public CreateMovie(String movieTitle, int movieYear, String movieDuration, String movieGenre, double movieRating) {
            this.MOVIE_TITLE = movieTitle;
            this.MOVIE_RELEASE_YEAR = movieYear;
            this.MOVIE_DURATION= movieDuration;
            this.MOVIE_GENRE =movieGenre;
            this.MOVIE_RATING =movieRating;
      }
      
      //get methods
      public String getMovieTitle () {
            return MOVIE_TITLE;
      }
      
      public int getMovieReleaseYear () {
            return MOVIE_RELEASE_YEAR;
      }
      
      public String getMovieDuration () {
            return MOVIE_DURATION;
      }
      
      public String getMovieGenre () {
            return MOVIE_GENRE;
      }
      
      public double getMovieRating () {
            return MOVIE_RATING;
      }
      
      //set methods
      public void setMovieTitle (String movieTitle) {
            MOVIE_TITLE = movieTitle;
      }
      
      public void setMovieReleaseYear (int movieReleaseYear) {
            MOVIE_RELEASE_YEAR = movieReleaseYear;
      }
      
      public void setMovieDuration (String movieDuration) {
            MOVIE_DURATION = movieDuration;
      }
      
      public void setMovieGenre (String movieGenre) {
            MOVIE_GENRE = movieGenre;
      }
      
      public void setMovieRating (double movieRating) {
            MOVIE_RATING = movieRating;
      }
      
      
      public String toString() {
            return "";
      }
      
      
      
      
}
