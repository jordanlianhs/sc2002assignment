package UI;

import java.util.*;
import java.io.*;


public class DisplayMovie {

    /**
     * Main function driving the view
     * 
     * @param args null argument can be used to drive the function
     * @throws Exception Throws Exception
     */
    public static void main(String[] args) throws Exception{
        try {
			DisplayMovie dm = new DisplayMovie();
            dm.displayMovie();
		} 
        catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    }

    /**
     * Display all movies in the database
     * @throws Exception Throws Exception
     */
	public void displayMovie() throws Exception {
		try {
			File file = new File("./Database/MovieCollectionNew.txt");
			Scanner sc = new Scanner(file);

			sc.useDelimiter(",");
			System.out.println("\nList of Movies: \n");
			System.out.println("Movie         |Movie Type    |Movie Status  |Synopsis      |Age Rating    |Star Rating   |Movie Duration|");
			System.out.println("---------------------------------------------------------------------------------------------------------");
			while (sc.hasNext()) {
				String st = sc.nextLine(); // To get current string with all Capitalisation
				String[] stToken = st.split(",");
				int i=0;
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
			if(temp.equals("Y")){

				MovieDetails.details(chooseMovie(), false);
			}

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public String chooseMovie()
	{
		try{
			String chosenOne;
			File file = new File("./Database/MovieCollectionNew.txt");
			Scanner sc = new Scanner(file).useDelimiter(",");
			Scanner sc1 = new Scanner(System.in);
			int i = 1;

			System.out.println("Which movie would you like to select? (Enter title of movie)");
			while(sc.hasNext()){
				String st = sc.nextLine();// To get current string with all Capitalisation
				String st2 = st.toLowerCase().toString(); // Changes it to lowercase and string for searching
				
				String[] stToken = st2.split(",");
				System.out.println(String.valueOf(i) + String.valueOf(stToken[0]));
				i++;
			}

			sc.close();

			chosenOne = sc1.nextLine();
			return chosenOne;
		}

		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
