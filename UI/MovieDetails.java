package UI;
import Model.*;
import java.util.*;
import java.io.*;


public class MovieDetails {
    /**
     * MovieDetails asks for user input to find a movie and returns the details of said movie
     * @param args null
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
		String input;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\nEnter \"esc\" to quit movie details UI");
			System.out.print("Enter a movie name: ");
			input = sc.nextLine();
			MovieDetails look = new MovieDetails();
			look.details(input);
		} while (!input.toLowerCase().equals("esc"));
	}

    public void details(String input) throws Exception{
        try{
            File file = new File("./Database/MovieCollectionNew.txt");
			Scanner sc = new Scanner(file).useDelimiter(",");
            Scanner sc1 = new Scanner(System.in);
            boolean flag = false;
            while(sc.hasNext()){
                String st = sc.nextLine();// To get current string with all Capitalisation
				String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
                
                String[] stToken = st2.split(",");

                if(flag = stToken[0].equals(input.toLowerCase())){
                    System.out.println("The movie details requested are as follows: \n");
                    System.out.println(st); 
                    String temp;

                    do{
                        System.out.println("Do you want to view this Movie's Reviews: " + stToken[0] + " (Y/N)");
                        temp = sc1.nextLine();
                        if(!temp.equals("Y") && !temp.equals("N"))
                            System.out.println("Wrong input!!! ");
                    }while(!temp.equals("Y") && !temp.equals("N"));
                    if(temp.equals("Y")){
                        Review rev = new Review();
                        rev.search(stToken[0]);
                    }
                    break;
                }
            }
            if(flag == false){
                System.out.println("Movie does not exist! ");
            }
            sc.close();
            sc1.close();
        }
        catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    }

}
