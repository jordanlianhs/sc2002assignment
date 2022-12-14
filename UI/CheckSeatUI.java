package UI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Booking;
import Model.Cineplex;
import Model.Guest;
import Model.MovieStatus;
import Model.Session;

/**
 * UI for the user to check the seats available for a movie
 */
public class CheckSeatUI {

	/**
	 * Cineplex Object for Ang Mo Kio
	 */
	private Cineplex A;
	
	/**
	 * Cineplex Object for Bukit Batok
	 */
	private Cineplex B;

	/**
	 * Cineplex Object for Choa Chu Kang
	 */
	private Cineplex C;


	/**
	 * Main function driving the view
	 * @param user is the person that the booking belongs to
	 */
	public void main(Guest user){
		A = new Cineplex("Ang Mo Kio", "AMK");
        B = new Cineplex("Bukit Batok", "BBK");
        C = new Cineplex("Choa Chu Kang", "CCK");
		Scanner s = new Scanner(System.in);
		boolean k = true;
		int choice;
		while (k) {
			do{
				System.out.println("(1) View Available Seat");
				System.out.println("(2) Book Seat");
				System.out.println("(3) Exit SeatUI");
				choice = s.nextInt();
	
				switch (choice) {
					case 1:
						checkAvailableSeat(A,B,C);
						break;
					case 2:
						bookSeat(user,A,B,C);
						break;
					case 3:
						saveSeatBooking(A,B,C);
						System.out.println("Exit SeatUI");
						k = false;
						break;
				}
			}while(choice!=3);

		}

	}

	/**
	 * Display seating plan of specific session
	 * @param A is Ang Mo Kio Cineplex
	 * @param B is Bukit Batok Cineplex
	 * @param C is Choa Chu Kang Cineplex
	 */
	public static void checkAvailableSeat(Cineplex A, Cineplex B, Cineplex C) {
		//sessiono.getSeatPlan().printLayout();
		Scanner s = new Scanner(System.in);
		String cpCode;
		do{
			System.out.println("Enter your Cineplex Code");
			cpCode = s.next();
		}
		while(!cpCode.equals("AMK")&&!cpCode.equals("BBK")&&!cpCode.equals("CCK"));


		int number = 0;
		ArrayList<Session> temp;
		if(cpCode.equals("AMK")){
			temp =  A.getSessionList();
		}

		else if(cpCode.equals("BBK")){
			temp =  A.getSessionList();
		}

		else{
			temp =  C.getSessionList();
		}
		int size = temp.size();
		int count =0;
		while(count <size){
			System.out.print(count+1);
			temp.get(count).printSession();
			count++;
		}
		
		do{
			System.out.println("Choose your Session");
			number = s.nextInt();
		}
		while(number==0 || number>count);

		temp.get(number-1).getSeatPlan().printLayout();
	}

	/**
	 * Book seat of specific session
	 * @param user is the person the booking belongs to
	 * @param A is Ang Mo Kio Cineplex
	 * @param B is Bukit Batok Cineplex
	 * @param C is Choa Chu Kang Cineplex
	 */
	public void bookSeat(Guest user, Cineplex A, Cineplex B, Cineplex C){
		Scanner s = new Scanner(System.in);
		Boolean c = true;
		String cpCode;
		do{
			System.out.println("Enter Cineplex Code (AMK, BBK, CCK): ");
			cpCode = s.next();
		}
		while(!cpCode.equals("AMK")&&!cpCode.equals("BBK")&&!cpCode.equals("CCK"));

		int i = 0;
		int number = 0;
		ArrayList<Session> temp;
		if(cpCode.equals("AMK")){
			temp =  A.getSessionList();
		}

		else if(cpCode.equals("BBK")){
			temp =  B.getSessionList();
		}

		else{
			temp =  C.getSessionList();
		}
		int size = temp.size();
		int count =0;
		while(count <size){
			System.out.print((count+1) + " ");
			temp.get(count).printSession();
			count++;
		}

		
		MovieStatus moviestatus;
		do{
			try{
				do{
					do{
						System.out.println("Choose your Session");
						System.out.println("Enter 0 to quit");
						number = s.nextInt();
					}
					while(number>count);
					if(number == 0){
						return;
					}
					moviestatus = temp.get(number-1).getMovie().getMovieStatus();
		
					if(moviestatus.equals(MovieStatus.ENDOFSHOWING)){
						System.out.println("Movie has ended, no longer available!!!");	
					}
					else if(moviestatus.equals(MovieStatus.COMINGSOON)){
						System.out.println("Movie is coming soon, not available!!!");
						}
				}while(moviestatus.equals(MovieStatus.ENDOFSHOWING) || moviestatus.equals(MovieStatus.COMINGSOON));
				break;
			}catch (Exception e) {
					System.out.println("Enter an integer!");
					System.out.println();
					s.nextLine();
					continue;
			}

		}while(true);

		char seatR;
		int seatC;
		do{
			System.out.println("Choose your Seat");
			
			do{
				System.out.println("Enter row (A to J)");
				seatR = s.next().charAt(0);
			}while(seatR<'A' || seatR>'J');
			
			do{
				try{
					do{
						System.out.println("Enter column (1 to 16)");
						seatC = s.nextInt();
					}while(seatC<1 || seatC>16);
					break;
				}catch (Exception e) {
					System.out.println("Enter an integer!");
					System.out.println();
					s.nextLine();
					continue;
				}
			}while(true);


			if(!temp.get(number-1).getSeatPlan().getSeat((seatR-'J')*-1, seatC-1).checkTaken()){
				temp.get(number-1).getSeatPlan().assign(seatR, seatC);
				c = true;
				break;
			}
			else{
				System.out.println("Seat is taken!");
				c = false;
			}
		}while(temp.get(number-1).getSeatPlan().getSeat((seatR-'J')*-1, seatC-1).checkTaken());
		
		
		String adam = seatR+String.valueOf(seatC);	

		
		if(c){
			Booking book = new Booking(user, temp.get(number-1), adam, temp.get(number-1).getCinemaCode());
			book.writebookingstatement();
			//increment sales in movie.txt
			changeMovieSales(temp.get(number-1).getMovie().getmovieName());
	
	
			TicketPrice calculator = new TicketPrice();
			double ticketPrice = calculator.calculateTix(user, temp.get(number-1), book);
			System.out.println("Ticket Price = $" + ticketPrice);
		}

	}

	/**
	 * Write booking records into database when booking seat UI ends
	 * @param A is Ang Mo Kio Cineplex
	 * @param B is Bukit Batok Cineplex
	 * @param C is Choa Chu Kang Cineplex
	 */
	public static void saveSeatBooking(Cineplex A, Cineplex B, Cineplex C){
		try{
			// Note need to add options for deleting
			ArrayList<Session> temp1, temp2, temp3;
			temp1 =  A.getSessionList();
			temp2 =  B.getSessionList();
			temp3 =  C.getSessionList();

			String fileName1= "Database/SessionRecordAMK.txt";
			String fileName2= "Database/SessionRecordBBK.txt";
			String fileName3= "Database/SessionRecordCCK.txt";
			PrintWriter writer1 = new PrintWriter(fileName1);
			writer1.print("");
			writer1.close();
			PrintWriter writer2 = new PrintWriter(fileName2);
			writer2.print("");
			writer2.close();
			PrintWriter writer3 = new PrintWriter(fileName3);
			writer3.print("");
			writer3.close();


			int size = temp1.size();
			int count =0;
			while(count <size){
				temp1.get(count).writeSession("AMK");
				count++;
			}
			size = temp2.size();
			count =0;
			while(count <size){
				temp2.get(count).writeSession("BBK");
				count++;
			}
			size = temp3.size();
			count =0;
			while(count <size){
				temp3.get(count).writeSession("CCK");
				count++;
			}
		}catch (Exception e) {
			System.out.println("Error in saving booking records" + e.getLocalizedMessage());
		}
		
		
	}

	/**
	 * Write booking records into database when booking seat UI ends
	 * @param movieName is the name of the movie
	 */
	public void changeMovieSales(String movieName){
    try {
      // append movie.txt
      String file1 = "./Database/MovieCollectionNew.txt";
      String tempFile1 = "./Database/temp1.txt";
      File oldFile1 = new File(file1);
      File newFile1 = new File(tempFile1);

      FileWriter fw1 = new FileWriter(newFile1, true); // appends to movie.txt
      BufferedWriter bw1 = new BufferedWriter(fw1);
      PrintWriter pw1 = new PrintWriter(bw1);
      Scanner y = new Scanner(new File(file1));
      y.useDelimiter("[,\n]");

      String text;

      while (y.hasNextLine()) {
        
        text = y.nextLine();
        String[] elements = text.split(",");
        String movietitle1 = elements[0];
        String movieType = elements[1];
        String movieStatus = elements[2];
        String synopsis = elements[3];
        String ageRating = elements[4];
        String starRating = elements[5];
        String duration = elements[6];
        String movieReleaseDate = elements[7];
        String movieEndDate = elements[8];
        String director = elements[9];
        String salesOld = elements[10];
        String sizeOfCast = elements[11];
        ArrayList<String> cast = new ArrayList<>();
        for(int u=12; u<(Integer.valueOf(sizeOfCast)+12); u++){
            cast.add(elements[u]);
        }
        String castStr= String.join(",", cast);
		int salesInt = Integer.valueOf(salesOld);        
		salesInt = salesInt + 1;       
		String salesNew = String.valueOf(salesInt);
        

        if (movietitle1.toLowerCase().equals(movieName.toLowerCase())) {
          pw1.print(movieName + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
              + "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + salesNew + "," + sizeOfCast + "," + castStr + "\n");
          pw1.flush();
        }

        else {
          pw1.print(movietitle1 + "," + movieType + "," + movieStatus + "," + synopsis + "," + ageRating + "," + starRating + "," + duration
              + "," + movieReleaseDate + "," + movieEndDate + "," + director + "," + salesOld + "," + sizeOfCast + "," + castStr + "\n");
          pw1.flush();
        }

      }

      y.close();
      pw1.close();
      bw1.close();
      fw1.close();

      oldFile1.delete();
      File dump1 = new File(file1);
      newFile1.renameTo(dump1);
    }

    catch (Exception e) {
      e.printStackTrace();
    }

  }

}
