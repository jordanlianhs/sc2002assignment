package UI;
import java.util.*;
import Model.*;

public class ListTop5UI {
    

    public void main() {
        Scanner sc = new Scanner(System.in);

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
        //sort
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
