package main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.javafiles.Address;
import com.javafiles.AddressType;
import com.javafiles.Contact;
import com.javafiles.Marks;
import com.javafiles.Student;
import com.json.app.Marshalling;
import com.json.app.Unmarshalling;


public class Main {

	public static void main(String[] args) throws IOException {
		int key = 0;
		System.out.println("Types of Operations are \n 1.Marshalling \n 2.Unmarshalling");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the choice of operation:");
		key = scanner.nextInt();
		switch (key) {
		case 1:
			Marshalling marshalling = new Marshalling();
			marshalling.domarshalling();
			break;
		case 2:
			Unmarshalling unmarshalling = new Unmarshalling();
			unmarshalling.doUnmarshalling();
			break;

		default:
			break;
		}

	}

}
