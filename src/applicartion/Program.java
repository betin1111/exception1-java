package applicartion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Room Number: ");
			int number = sc.nextInt();
			System.out.print("Check-in data (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(reservation);

			System.out.println("");
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in data (dd/MM/yyyy): ");
			Date checkIn1 = sdf.parse(sc.next());
			System.out.print("Check-out data (dd/MM/yyyy): ");
			Date checkOut1 = sdf.parse(sc.next());

			reservation.updateDates(checkIn1, checkOut1);
			System.out.println("Reservation " + reservation);
		} 
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: "+ e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		} 
		
		sc.close();

	}
}