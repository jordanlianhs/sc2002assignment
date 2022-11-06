package UI;
import java.time.*;
import java.time.format.*;
import java.util.*;
import Model.*;
import java.io.*;

public class ListTop5UI {
    
    static ArrayList<Movie> movieList;
    

    public static void main() {
        Scanner sc = new Scanner(System.in);
        
        //scan movieList from movie.txt
        movieList = new ArrayList<Movie>();
        String filename = "./Database/MovieCollectionNew.txt";
        File file = new File(filename);
        try(Scanner fileReader = new Scanner(file)){
            while(fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                String[] parts = line.split(",");
                //movie values
                
                
                String movieName = parts[0]; 
                MovieType movieType = MovieType.valueOf(parts[1]); 
                MovieStatus movieStatus = MovieStatus.valueOf(parts[2]);
                String synopsis = parts[3]; 
                String ageRating = parts[4]; 
                float starRating = Float.valueOf(parts[5]);
                double duration = Double.valueOf(parts[6]);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate movieReleaseDate = LocalDate.parse(parts[7], formatter);
                LocalDate movieEndDate = LocalDate.parse(parts[8], formatter);
                String director = parts[9];
                int sales = Integer.valueOf(parts[10]);
                ArrayList<String> cast = new ArrayList<>(Arrays.asList(parts[11]));
                movieList.add(new Movie(movieName, movieType,movieStatus, synopsis, ageRating, starRating, duration, movieReleaseDate, movieEndDate, director, sales, cast));
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }       
        

        int choice = 0;
        do{
        System.out.println("1: List top 5 movies by ticket sales");
        System.out.println("2: List top 5 movies by overall ratings");
        System.out.println("3: Go back");
        System.out.println("Please enter your choice:");

        
        choice = sc.nextInt();
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
    
    public static void listTop5Sales(){        
        
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
        System.out.println("Top 5 movies by Sales");
        for(int i=0; i<numMovies; i++){
            System.out.print(movieList.get(i).getmovieName() + ": ");
            System.out.println(movieList.get(i).getSales() + " ticket sales");
        }
        System.out.println();
        
    }

    static class SortSales implements Comparator<Movie>{
        public int compare(Movie a, Movie b){
            //compares in reverse since collections sort in ascending and we want descending order
            return b.getSales() - a.getSales();
        }
    }

    public static void listTop5Ratings(){
        //sort (sort by collections by reading movie as objects using comparator)
        Collections.sort(movieList, new SortRatings());        
        int numMovies = 0;
        if(movieList.size()<5){
			numMovies = movieList.size();
		}
		else{
			numMovies = 5;
		}
        System.out.println("Top 5 movies by star ratings");
        for(int i=0; i<numMovies; i++){
            System.out.print(movieList.get(i).getmovieName() + ": ");
            System.out.println(movieList.get(i).getstarRating() + " star rating");
        }
        System.out.println();
    }
    static class SortRatings implements Comparator<Movie>{
        public int compare(Movie a, Movie b){
            //compares in reverse since collections sort in ascending and we want descending order
            if(b.getstarRating() - a.getstarRating() > 0){
                return 1;
            }
            else if(b.getstarRating() - a.getstarRating() < 0){
                return -1;
            }
            else{
                return 0;
            }
        }
    }

    

    

}
