package UI;

import java.util.*;
import java.io.*;

/**
 * This is the main class of DisplayMovie
 */
public class DisplayMovie {

    /**
     * Main function driving the view
     * 
     * @param args null argument can be used to drive the function
     * @throws Exception Throws Exception
     */
    public void main(){
        try {
            displayMovie(false);
		} 
        catch (Exception e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    }

    /**
     * Display all movies in the database
     * @throws Exception Throws Exception
     */
	public void displayMovie(boolean userView) {
		try {
			File file = new File("./Database/MovieCollectionNew.txt");
			Scanner sc = new Scanner(file);
			boolean test;


			sc.useDelimiter(",");
			System.out.println("\nList of Movies: \n");
			System.out.println("Movie         |Movie Type    |Movie Status  |Synopsis      |Age Rating    |Star Rating   |Movie Duration|");
			System.out.println("---------------------------------------------------------------------------------------------------------");
			while (sc.hasNext()) {
				String st = sc.nextLine(); // To get current string with all Capitalisation
				String[] stToken = st.split(",");
				int i=0;

				if (userView == true) // User viewing conditions
				{
					// Skips the movie if it is not showing
					test = !(stToken[2].equals("ENDOFSHOWING"));
				} else
					test = true;

				if (test){
					
					for(String s:stToken){
						if (i<7){
							if(s.equals("-1.0") || s.equals("-1")){
									System.out.print("NA            |");
							}
							else{
								if (s.length()<=13) {
									System.out.print(s);
									int j = 15-s.length();
									while(j!=0){
										if (j==1) System.out.print("|");
										else System.out.print(" ");
										j--;
									}
								}
								else{
								System.out.print(s.substring(0, 10) + "... |");
								}
							}
						}
						else break;
						i++;
					}
					System.out.println();
				}
			}

			
			Scanner sn = new Scanner(file);
			System.out.println("\n");
			System.out.println("Movie         |Release Date  |End Date      |Director      |Sales         |Cast Size     |Cast");
			System.out.println("---------------------------------------------------------------------------------------------------------");
			while (sn.hasNext()) {
				String st = sn.nextLine(); // To get current string with all Capitalisation
				String[] stToken = st.split(",");
				int i=0;
				for(String s:stToken){
					if (i>=7 || i==0){
						if(s.equals("-1.0") || s.equals("-1")){
							System.out.print("NA            |");
					}
					else{
						if (i==12) System.out.print(s);
						else if (i>12) System.out.print(", " + s);
						else if (s.length()<=13) {
							System.out.print(s);
							int j = 15-s.length();
							while(j!=0){
								if (j==1) System.out.print("|");
								else System.out.print(" ");
								j--;
							}
						}
						else{
							System.out.print(s.substring(0, 10) + "... |");
						}
					}
				}
					i++;
				}
				System.out.println();
			}


			System.out.println("\n");
			sc.close();
			sn.close();

			String temp;
            Scanner sc1 = new Scanner(System.in);
			do{
				System.out.println("Do you want to view individual movie details? (Y/N)");
				temp = sc1.nextLine();
				if(!temp.equals("Y") && !temp.equals("N"))
					System.out.println("Wrong input!!! ");
			}while(!temp.equals("Y") && !temp.equals("N"));

			String temp1;
			if(temp.equals("Y")){
				do{
					MovieDetails.details(chooseMovie(userView), false);
					do{
						System.out.println("Would you like to view another movie's details? (Y/N)");
						temp1 = sc1.nextLine();
						if(!temp1.equals("Y") && !temp1.equals("N"))
							System.out.println("Wrong input!!! ");
					}while(!temp1.equals("Y") && !temp1.equals("N"));

				} while (temp1.equals("Y"));
			}

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	/**
	 * Prompts user to select a movie
	 * @param userView True if used in UserUI, False if used in Admin UI
	 * @return chosenOne Movie title input by user
	 */
	public static String chooseMovie(boolean userView)
	{
		String chosenOne="";
		try{
			File file = new File("./Database/MovieCollectionNew.txt");
			Scanner sc = new Scanner(file).useDelimiter(",");
			Scanner sc2 = new Scanner(file).useDelimiter(",");
			Scanner sc1 = new Scanner(System.in);
            boolean flag = false;
			String st="";
			String st2 = "";
			String[] stToken;
			boolean test;

			System.out.println("Which movie would you like to select? (Enter title of movie)");
			while(sc.hasNext()){
				st = sc.nextLine();
				stToken = st.split(",");

				if (userView == true) // User viewing conditions
				{
					// Skips the movie if it is not showing
					test = !(stToken[2].equals("ENDOFSHOWING"));
				} else
					test = true;

				if (test==true) System.out.println(String.valueOf(stToken[0]));
			}
			System.out.println();

			sc.close();

			chosenOne = sc1.nextLine();
			while(sc2.hasNext()){
				st = sc2.nextLine();
				st2 = st.toLowerCase().toString();
				stToken = st2.split(",");
				if (chosenOne.toLowerCase().equals(stToken[0])) flag=true;
			}
			
			// if(flag == false){
            //     System.out.println("Movie does not exist! ");
            // }
		}

		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		return chosenOne;
	}
}
