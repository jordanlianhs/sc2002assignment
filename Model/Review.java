package Model;

public class Review {
     /**
      * this Review's username (email)
      */
      private String username;
    
      /**
       * this Review's number of stars
       */
      private double numOfStars;
  
      /**
       * this Review's additional comment (optional)
       */
      private String additionalComment;


    public Review(String username, double numOfStars, String additionalComment) {
        this.username = username;
        this.numOfStars = numOfStars;
        this.additionalComment = additionalComment;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getNumOfStars() {
        return this.numOfStars;
    }

    public void setNumOfStars(double numOfStars) {
        this.numOfStars = numOfStars;
    }

    public String getAdditionalComment() {
        return this.additionalComment;
    }

    public void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }


    
}
