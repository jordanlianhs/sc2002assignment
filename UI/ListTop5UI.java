package UI;
import java.util.*;
import Model.*;

public class ListTop5UI {
    

    public void main() {
        Scanner sc = new Scanner(System.in);

        //reading movie file
        String filename = "./Database/movie.txt";
        try(Scanner fileReader = new Scanner(filename)){
            while(fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                String[] parts = line.split(",");
                //TODO
                // get sales                
                // int sales = Integer.valueOf(parts[]);
                // get user ratings
                // int ratings = Integer.valueOf(parts[]);
            }
            
        } catch(Exception e){
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
        //read movie txt sales number
        //sort (sort by collections by reading movie as objects using comparator)
        //print
        ;
    }

    public void listTop5Ratings(){
        //read movie txt rating number
        //sort
        //print
        ;
    }

}
