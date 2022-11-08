package UI;

import Model.*;
import java.util.*;
import java.io.*;

public class CheckSeatUI {

	//private static Session sessiono= new Session();

	//private static Guest user = new Guest();

	//private static String cinemaCode = null;

	//public CheckSeatUI(Guest user, Session SessionNo, String cinemaCode) {
	//	this.user = user;
	//	sessiono = SessionNo;
	//	this.cinemaCode = cinemaCode;
	//}

	public static void checkAvailableSeat(Cineplex A, Cineplex B, Cineplex C) {
		//sessiono.getSeatPlan().printLayout();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your Cineplex Code");
		String cpCode = s.next();
		int i = 0;
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
			System.out.print(i+1);
			temp.get(count).printSession();
			count++;
		}
		
		System.out.println("Choose your Session");
		number = s.nextInt();

		temp.get(number-1).getSeatPlan().printLayout();
	}

	public static void bookSeat(Guest user, Cineplex A, Cineplex B, Cineplex C) throws IOException, Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your Cineplex Code");
		String cpCode = s.next();
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
		
		System.out.println("Choose your Session");
		number = s.nextInt();
		
		
		System.out.println("Choose your Seat");
		System.out.println("Enter row (A to J)");
		char seatR = s.next().charAt(0);
		System.out.println("Enter row (0 to 15)");
		int seatC = s.nextInt();
		temp.get(number-1).getSeatPlan().assign(seatR, seatC);
		String adam = seatR+String.valueOf(seatC);	

		

		Booking book = new Booking(user, temp.get(number-1), adam, temp.get(number-1).getCinemaCode());
		book.writebookingstatement();
		//increment sales in movie.txt
		changeMovieSales(temp.get(number-1).getMovie().getmovieName());


		TicketPrice calculator = new TicketPrice();
		double ticketPrice = calculator.calculateTix(user, temp.get(number-1), book);
		System.out.println("Ticket Price = $" + ticketPrice);
	}

	public static void cancelSeat(Cineplex A, Cineplex B, Cineplex C) {
		Scanner s = new Scanner(System.in);
		System.out.println("Choose your Seat");
		System.out.println("Enter row (A to J)");
		char seatR = s.next().charAt(0);
		System.out.println("Enter row (0 to 15)");
		int seatC = s.nextInt();
		//sessiono.getSeatPlan().unassign(seatR, seatC);

	}

	public static void main(String[] args, Guest user) throws IOException, Exception{
		Cineplex A = new Cineplex("Ang Mo Kio", "AMK");
        Cineplex B = new Cineplex("Bukit Batok", "BBK");
        Cineplex C = new Cineplex("Choa Chu Kang", "CCK");
		Scanner s = new Scanner(System.in);
		boolean k = true;

		while (k) {
			System.out.println("(1) View Available Seat");
			System.out.println("(2) Book Seat");
			System.out.println("(3) Cancel Seat");
			System.out.println("(4) Exit SeatUI");
			int choice = s.nextInt();

			switch (choice) {
				case 1:
					checkAvailableSeat(A,B,C);
					break;
				case 2:
					bookSeat(user,A,B,C);
					break;
				case 3:
					cancelSeat(A,B,C);
					break;
				case 4:
				    saveSeatBooking(A,B,C);
					System.out.println("Exit SeatUI");
					k = false;
					break;
			}

		}

	}

	public static void saveSeatBooking(Cineplex A, Cineplex B, Cineplex C) throws IOException,FileNotFoundException {

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
		
	}

	public static void changeMovieSales(String movieName)
  {
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
