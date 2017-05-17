package com.json.app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javafiles.Address;
import com.javafiles.AddressType;
import com.javafiles.Contact;
import com.javafiles.Marks;
import com.javafiles.Student;

public class Marshalling {

	public void domarshalling() throws IOException{	

		AddressType addressType = new AddressType("ColonialGrand", null);
		Address address = new Address("Irving", "McArthur Blvd", "USA", 773, Arrays.asList(addressType));
		Marks marks = new Marks(Arrays.asList("JAVA","SQL"), Arrays.asList(90,95), Arrays.asList(100,100));
		Contact communication = new Contact("227926", "350245");
		Student student = new Student(1, "Nishanth", "Sunkara", Arrays.asList(marks), Arrays.asList(address), Arrays.asList(communication) );

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		File file=new File("C:\\Users\\nisha\\workspace\\MyJSONApp\\src\\main\\resources\\Student.json");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileWriter fileWriter = new FileWriter(file);
		objectMapper.writeValue(fileWriter, student);
		System.out.println("Marshalling Completed");
	}
}
