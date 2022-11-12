package UI;
import java.util.*;
import java.io.*;
import Model.*;
import java.time.*;
import java.time.format.*;

public class UpdateMovie {
    /**
     * Array List for movies
     */
    private ArrayList<Movie> movieArray;
    
    /**
     * Main function driving the view
     * @param args null argument can be used to drive the function
     * @throws Exception Throws Exception
     */
    public void main(){
        try{
            Scanner sc = new Scanner(System.in); // Console
        
            // Update a variable of movie
            String file1 = "./Database/MovieCollectionNew.txt";
            File movieFile = new File(file1);
    
            Scanner y = new Scanner(movieFile);
            y.useDelimiter("[,\n]");
    
            movieArray = new ArrayList<Movie>();
            
            while (y.hasNextLine()) {
                // add list of movies to array
                String line = y.nextLine();
                String[] parts = line.split(",");
                Movie m = new Movie();
                m.readMovie(parts[0]);
                movieArray.add(m);
            }
    
            y.close();
    
            // Scan for movie to update
            System.out.println("Which movie's details would you like to edit?");
            String choosedmovie = sc.nextLine();
    
            boolean flag = false;
            int movieIndex;
            for (movieIndex = 0; movieIndex < movieArray.size(); movieIndex++) 
                if (flag = movieArray.get(movieIndex).getmovieName().equalsIgnoreCase(choosedmovie))
                    break;
            
            if (!flag) {
                System.out.println("\nWrong input, movie name does not exist\n");
                return;
            }
    
            // Scan for update choice
            System.out.println("\nWhat would you like to update? (Key in numbers only)");
            System.out.println("(1) Movie Type");
            System.out.println("(2) Movie Status");
            System.out.println("(3) Synopsis");
            System.out.println("(4) Age Rating");
            System.out.println("(5) Duration");
            System.out.println("(6) Movie Release Date");
            System.out.println("(7) Movie End Date");
            System.out.println("(8) Director");
            System.out.println("(9) Cast");
    
            int choosed = Integer.parseInt(sc.nextLine());
            
            String updateChoice;
            MovieStatus movieStatus;
    
            // date formatter for release and end dates
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
            switch (choosed) {
                case 1:
                    // movieType
                    System.out.println("\nWhat is the updated value?");
                    updateChoice = sc.nextLine();
    
                    movieArray.get(movieIndex).setType(MovieType.valueOf(updateChoice));
                    break;
    
                case 2:
                    // movieStatus
                    System.out.println("\nWhat is the updated value?");

                    System.out.println();
                    System.out.println("Movie Status: ");
                    System.out.println("1: Coming soon!");
                    System.out.println("2: Preview");
                    System.out.println("3: Now showing");
                    System.out.println("4: End of showing");
                    System.out.println("Enter your option:");
                    updateChoice = sc.nextLine();
                    switch (Integer.valueOf(updateChoice)) {
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
                    movieArray.get(movieIndex).setMovieStatus(movieStatus);
                    break;
    
                case 3:
                    // synopsis
                    System.out.println("\nWhat is the updated value?");
                    updateChoice = sc.nextLine();
                    movieArray.get(movieIndex).setSynopsis(updateChoice);
                    break;
                case 4:
                    // ageRating
                    System.out.println("\nWhat is the updated value?");
                    updateChoice = sc.nextLine();
                    movieArray.get(movieIndex).setageRating(updateChoice);
                    break;
                case 5:
                    // duration
                    System.out.println("\nWhat is the updated value?");
                    updateChoice = sc.nextLine();
                    movieArray.get(movieIndex).setDuration(Double.valueOf(updateChoice));
                    break;
                case 6:
                    // movieReleaseDate
                    System.out.println("\nWhat is the updated value? (Enter as: yyyy-MM-dd)");
                    updateChoice = sc.nextLine();
                    movieArray.get(movieIndex).setMovieReleaseDate(LocalDate.parse(updateChoice, formatter));
                    break;
                case 7:
                    // movieEndDate
                    System.out.println("\nWhat is the updated value? (Enter as: yyyy-MM-dd)");
                    updateChoice = sc.nextLine();
                    movieArray.get(movieIndex).setMovieEndDate(LocalDate.parse(updateChoice, formatter));
                    break;
                case 8:
                    // director
                    System.out.println("\nWhat is the updated value?");
                    updateChoice = sc.nextLine();
                    movieArray.get(movieIndex).setDirector(updateChoice);
                    break;
                case 9:
                    // castStr
                    System.out.println("\nWhat is the updated value? (Separated by commas)");
                    updateChoice = sc.nextLine();
                    String[] newCastSplit = updateChoice.split(",");
                    ArrayList<String> newCast = new ArrayList<>(Arrays.asList(newCastSplit));
                    movieArray.get(movieIndex).setCast(newCast);
                    break;
                default:
                    System.out.println("\nWrong input. Returning to MovieCRUD.");
                    break;
            }
            // deletes old file
            PrintWriter writer = new PrintWriter(movieFile);
            writer.print("");
            writer.close();
    
            for (Movie movie : movieArray) {
                movie.writeMovie();
            }
        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }
        
    }
}
