package Model;

public class Rating{

    static Scanner s = new Scanner(System.in);

    public static void main(String arg[]) {

        System.out.println("Rate the movie " + Movie.getTitle + " on a scale of 1 to 5: ");
        int rateMovie = s.nextInt();

        // new rating for that movie = (avg rating * num of ratings + rateMovie) / (num of ratings + 1)
        // num of ratings += 1

        // if num of ratings == 1 {display "NA"}

	}
}