package UI;
import java.time.*;
import java.time.format.*;
import java.util.*;
import Model.*;

public class ListTop5UI {
    
    private ArrayList<Movie> movieList;

    public void main() {
        Scanner sc = new Scanner(System.in);
        //Movie arraylist
        movieList = new ArrayList<Movie>();
        //scan movieList from movie.txt
        String filename = "./Database/movies.txt";
        try(Scanner fileReader = new Scanner(filename)){
            while(fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                String parts[] = line.split(",");
                //movie values
                String movieName = parts[0]; 
                MovieType movieType = MovieType.valueOf(parts[1]); 
                String synopsis = parts[2]; 
                String ageRating = parts[3]; 
                float starRating = Float.valueOf(parts[4]);
                double duration = Double.valueOf(parts[5]);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate movieReleaseDate = LocalDate.parse(parts[6], formatter);
                LocalDate movieEndDate = LocalDate.parse(parts[7], formatter);
                String director = parts[8];
                int sales = Integer.valueOf(parts[9]);
                ArrayList<String> cast = new ArrayList<>(Arrays.asList(parts[10]));
                movieList.add(new Movie(movieName, movieType, synopsis, ageRating, starRating, duration, movieReleaseDate, movieEndDate, director, sales, cast));
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
        

        System.out.println("1: List top 5 movies by ticket sales");
        System.out.println("2: List top 5 movies by overall ratings");
        System.out.println("3: Go back");

        int choice = 0;
        choice = sc.nextInt();
        do{
            switch(choice){
                case 1:
                    //list by sales
                    listTop5Sales();
                    break;
                case 2:
                    //list by ratings
                    listTop5Ratings();
                    break;
            }

        } while (choice != 3);
    }
    
    public void listTop5Sales(){
        
        
        //sort (sort by collections by reading movie as objects using comparator)
        Collections.sort(movieList, new SortSales());
        //print
        int numMovies = 0;
        if(movieList.size()<5){
			numMovies = movieList.size();
		}
		else{
			numMovies = 5;
		}
        for(int i=0; i<numMovies; i++){
            System.out.println(movieList.get(i).getmovieName());
        }
        
    }

    class SortSales implements Comparator<Movie> {
        public int compare(Movie a, Movie b) {            
            int salesA = 0, salesB = 0;
            //read booking statements file
            String filename = "./Database/BookingStatement.txt";
            try(Scanner fileReader = new Scanner(filename)){
                while(fileReader.hasNextLine()){
                    String line = fileReader.nextLine();
                    String[] parts = line.split(",");
                    String movieTitle = parts[3];
                    if(a.getmovieName().equals(movieTitle)){
                        salesA++;
                    }  
                    if(b.getmovieName().equals(movieTitle)){
                        salesB++;
                    }              
                    // int sales = Integer.valueOf(parts[]);
                    // get user ratings
                    // int ratings = Integer.valueOf(parts[]);
                }
                
            } catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
                return salesA - salesB;
            }
    }

    public void listTop5Ratings(){
        //read movie txt rating number
        //sort
        //print
        ;
    }

}
