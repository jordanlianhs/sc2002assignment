package UI;
import java.util.*;
import java.time.*;
import java.text.*;
import Model.*;


public class CreateMovie {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        String movieName;
        MovieType movieType;
        MovieStatus movieStatus;
        String synopsis; 
        String ageRating; 
        float starRating; 
        double duration;
        LocalDate movieReleaseDate;
        LocalDate movieEndDate;
        String director; 
        int sales;
        ArrayList<String> cast = new ArrayList<String>();
        String temp;


        System.out.println("-----------------------------------");
		System.out.println("Create Movie");
		System.out.println("-----------------------------------");

		System.out.print("Movie Name: ");
        movieName = sc.nextLine();

        System.out.println();
		System.out.println("What is the movie type? ");
		System.out.println("1: 2D");
		System.out.println("2: 3D");
        System.out.println("3: 2D Blockbuster");
        System.out.println("4: 3D Blockbuster");
		System.out.println("Enter your option:");
        temp = sc.nextLine();
        switch(Integer.valueOf(temp)){
            case 1:
                movieType = MovieType.TWO_D;
                break;
            case 2:
                movieType = MovieType.THREE_D;
                break;
            case 3:
                movieType = MovieType.TWO_D_BB;
                break;
            case 4:
                movieType = MovieType.THREE_D_BB;
                break;
            default:
                System.out.println("Wrong input!");
                return;
        }

        System.out.println();
		System.out.println("Movie Status: ");
		System.out.println("1: Coming soon!");
		System.out.println("2: Preview");
		System.out.println("3: Now showing");
		System.out.println("4: End of showing");
        System.out.println("Enter your option:");
        temp = sc.nextLine();
        switch(Integer.valueOf(temp)){
            case 1:
                movieStatus = MovieStatus.COMINGSOON;
                break;
            case 2:
                movieStatus = MovieStatus.PREVIEW;
                break;
            case 3:
                movieStatus = MovieStatus.NOWSHOWING;
                break;
            case 4:
                movieStatus = MovieStatus.ENDOFSHOWING;
                break;
            default:
                System.out.println("Wrong input!");
                return;
        }

        System.out.println();
		System.out.print("Movie Synopsis: ");
		synopsis = sc.nextLine();

        System.out.println();
		System.out.print("Movie Age Rating: ");
		ageRating = sc.nextLine();

        System.out.println();
		System.out.print("Movie Star Rating: ");
        temp = sc.nextLine();
		starRating = Float.valueOf(temp);

        System.out.println();
		System.out.print("Movie Duration: ");
		temp = sc.nextLine();
		duration = Double.valueOf(temp);

        System.out.print("Release Date of the Movie (yyyy-MM-dd): ");
        temp = sc.nextLine();
        if(checkDate(temp)){
            movieReleaseDate = LocalDate.parse(temp);
        }
        else{
            System.out.println("Wrong input!");
            return;
        }

        System.out.print("End Date of the Movie (yyyy-MM-dd): ");
        temp = sc.nextLine();
        if(checkDate(temp)){
            movieEndDate = LocalDate.parse(temp);
        }
        else{
            System.out.println("Wrong input!");
            return;
        }

        System.out.println();
		System.out.print("Director : ");
		director = sc.nextLine();

        System.out.println();
		System.out.print("Sales: ");
		temp = sc.nextLine();
        sales = Integer.valueOf(temp);

        System.out.println();
		System.out.println("Movie Cast (Separate cast by commas): ");
		temp = sc.nextLine();
		String[] tempArr = temp.split("\\s*,\\s*");
        for(String s:tempArr){
            cast.add(s);
        }

        Movie movie = new Movie(movieName, movieType, movieStatus, synopsis, ageRating, starRating, duration, movieReleaseDate, movieEndDate, director, sales,cast);
        movie.writeMovie();
        System.out.println("Movie Created Successfully!!!");
        System.out.println();
    }

    /**
	 * Check for Valid Date
	 * 
	 * @param input
	 * @return
	 */
    public static boolean checkDate(String input) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(input);
			System.out.println("Date input: " + date); // This is just for debugging

		} catch (ParseException e) {
			// e.printStackTrace();
			System.out.println("INVALID DATE!");
			return false;
		}
		return true;
	}
}
