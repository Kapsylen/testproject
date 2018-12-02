package com.example.demo.Main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class App {


    ObjectMapper mapper;



    public void getById(String arg) throws IOException {
        mapper = new ObjectMapper();

        try {
            URL url = new URL ("http://localhost:8080/user/"+arg);

            Person person = mapper.readValue(url, Person.class);

            System.out.println("WriteValueAsString: "+ mapper.writeValueAsString(person));

            System.out.println(person);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Person> getAll(String arg) throws IOException {
        mapper = new ObjectMapper();
        try {

            List<Person> getUserList = mapper.readValue(new URL("http://localhost:8080/user/"+arg), new TypeReference<List<Person>>(){});
            return getUserList;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) throws IOException {
        //JsonFactory jsonFactory = new JsonFactory();
        //JsonGenerator jsonGenerator = jsonFactory.


        List<Person> listOfPerson = new App().getAll("get");
        listOfPerson.forEach(p -> System.out.println(p));
    }

}
