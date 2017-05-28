package com.assessment2.imcs.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.assessment2.imcs.classes.Passenger;

public class PassengerUtil {
	private static Scanner scanner ;//= new Scanner(System.in);

	public static int chooseOperation() throws InputMismatchException {
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.println("   ||| MENU |||   ");
		System.out.println("1. Create PassangerProfile");
		System.out.println("2. Read(View) PassangerProfile");
		System.out.println("3. Update PassangerProfile");
		System.out.println("4. Delete PassangerProfile");
		System.out.println("5. Exit");


		System.out.print("Select a choice :");

		int id=scanner.nextInt();
		return id;
	}

	public static Passenger readPassanger() throws Exception{
		scanner = new Scanner(System.in);
		boolean flag=true;
		while(flag==true){

			try{
				System.out.print("Enter passenger id:");
				int profile_id = scanner.nextInt();
				
				System.out.print("Enter passenger password:");
				String password = scanner.next();

				System.out.print("Enter passenger firstname:");
				String first_name = scanner.next();

				System.out.print("Enter passenger lastname:");
				String last_name = scanner.next();

				System.out.print("Enter passenger telNum: ");
				double tel_no = scanner.nextDouble();
				
				System.out.print("Enter passenger Address: ");
				String address = scanner.next();

				System.out.print("Enter passenger emailId: ");
				String email_id = scanner.next();

				
			return new Passenger(profile_id, password, first_name, last_name, email_id, tel_no, address);
			}
			catch(InputMismatchException e){
				throw new Exception("Please enter valid data ");
			}

		}
		return null;
	}
}
