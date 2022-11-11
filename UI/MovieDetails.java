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
            if(!input.equals("esc")){
                MovieDetails look = new MovieDetails();
                look.details(input);
            }			
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
                
                String[] stToken1 = st.split(",");
                String[] stToken = st2.split(",");

                // Skips the movie if it is not showing
                if((flag = stToken[0].equals(input.toLowerCase())) && !(stToken1[2].equals("ENDOFSHOWING"))){
                    System.out.println("The movie details requested are as follows: \n");
                    
                    int i = 0;
                    for (String s:stToken1)
                    {
						if(s.equals("-1.0") || s.equals("-1")){
								s = "NA";
						}
                        switch(i){
                            case 0: System.out.print("Movie:  "); break;
                            case 1: System.out.print("\nMovie Type:  "); break;
                            case 2: System.out.print("\nMovie Status:  "); break;
                            case 3: System.out.print("\nSynopsis:  "); break;
                            case 4: System.out.print("\nAge Rating:  "); break;
                            case 5: System.out.print("\nStar Rating:  "); break;
                            case 6: System.out.print("\nMovie Duration:  "); break;
                            case 7: System.out.print("\nRelease Date:  "); break;
                            case 8: System.out.print("\nEnd Date:  "); break;
                            case 9: System.out.print("\nDirector:  "); break;
                            case 10: System.out.print("\nSales:  "); break;
                            case 11: System.out.print("\nCast Size:  "); break;
                            case 12: System.out.print("\nCast:  "); break;
                            default: break;

                        }

                        if (i<13){
                            System.out.print(s);
                            i++;
                        }
                        else System.out.println(", " + s);
					}
				    System.out.println();
                    
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
        }
        catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    }

}
