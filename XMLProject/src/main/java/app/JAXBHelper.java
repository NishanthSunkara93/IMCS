package app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.assigment.beans.Student;

public class JAXBHelper {


	public static void marshal(Student student, File selectedFile) throws IOException, JAXBException{

		JAXBContext context;
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(selectedFile));
		context = JAXBContext.newInstance(Student.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(student, writer);
		writer.close();
	}

	public static Student unmarshal(File importFile) throws JAXBException {
		Student student = null;
		JAXBContext context;

		context = JAXBContext.newInstance(Student.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		student = (Student) unmarshaller.unmarshal(importFile);

		return student;
	}
}
