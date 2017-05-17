package app;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import com.assigment.beans.Address;
import com.assigment.beans.AddressType;
import com.assigment.beans.Contact;
import com.assigment.beans.Marks;
import com.assigment.beans.Student;

public class Main {

	public static void main(String[] args) {
        int type=0;
		AddressType addressType = new AddressType("ColonialGrand", null);
		
		Address address = new Address("Irving", "McArthur Blvd", 77306, "USA",Arrays.asList(addressType));
		
		Marks marks = new Marks(Arrays.asList("JAVA","SQL"), Arrays.asList(90,95) , 90);
		
		Contact communication = new Contact(227926, 350245, null);
		
		Student student = new Student(1, "Nishanth", "Sunkara", Arrays.asList(marks), communication, address);
		
        System.out.println("Types of Operations are \n 1.Marshalling \n 2.Unmarshalling");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the choice of operation:");
		type = scanner.nextInt();
		switch (type) {
		case 1:
			try {
				JAXBHelper.marshal(student, new File("C:\\Users\\nisha\\workspace\\XMLProject\\src\\main\\java\\output\\MarshalledStudent.xml"));
				
			} catch (IOException | JAXBException e) {
				e.printStackTrace();
			}
			break;
         case 2:
        	 try {
				Student output = JAXBHelper.unmarshal(new File("C:\\Users\\nisha\\workspace\\XMLProject\\src\\main\\java\\output\\MarshalledStudent.xml"));
				System.out.println(output);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
        	 break;
		default:
			break;
		}
		

	}

}
