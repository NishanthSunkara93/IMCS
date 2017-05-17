package com.json.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javafiles.Student;

public class Unmarshalling {

	public void doUnmarshalling() throws JsonParseException, JsonMappingException, IOException{
	byte[] jsonData = null;
	try {
		jsonData = Files.readAllBytes(Paths.get("C:\\Users\\nisha\\workspace\\MyJSONApp\\src\\main\\resources\\Student.json"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	ObjectMapper objectMapper = new ObjectMapper();
	Student student = objectMapper.readValue(jsonData, Student.class);
	System.out.println(student);
	System.out.println("Unmarshalling completed");
	}
}
