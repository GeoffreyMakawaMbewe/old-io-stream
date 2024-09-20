package com.exponentsoftwares.springbackendapplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.util.*;

@SpringBootApplication
public class SpringBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBackendApplication.class, args);
	}


//BufferedReader with InputStreamReader To Read from the console

//	{
//		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
//			String in = reader.readLine();
//			System.out.println(in);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	//BufferedWriter with FileWriter To Write to File

    {
        try {
            Writer  writer = new FileWriter("./written.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write("Nothing Written Here");
            bufferedWriter.flush();

		} catch (IOException e) {
           throw new RuntimeException(e);
        }
    }
    //BufferedReader To Read from a File
    //Reads Only One Line
    BufferedReader myReader;

    {
        try {
            myReader = new BufferedReader(new InputStreamReader(new FileInputStream("./read.txt")));
          String theString = myReader.readLine();
            System.out.println(theString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        //Reads Multiple Lines Regardless of whether there are spaces in between the lines
        {

            try {
               // FileInputStream fis = new FileInputStream("./read.txt");
                FileInputStream fis = new FileInputStream("C:/Users/HP/Desktop/BATTERY TESTING.txt");
                InputStreamReader inputStreamReader = new InputStreamReader(fis);
                BufferedReader multiLineBufferedReader = new BufferedReader(inputStreamReader);

                String strings;
                System.out.println("I read the following");
                while ((strings = multiLineBufferedReader.readLine()) != null){
                    System.out.println(strings);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    // Write to a file and read from the same and write to another file
    {
        try {
            //WRITING
            String fileName = "./testWrite.txt";
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            List<String> stringList = Arrays.asList("Hi", "Geoffrey", "Makawa", "How are you", "Doing", "This", "Night", "Here Is","Chisomo Mphande's Number 0881392378");

            writer.write("Testing Writing Here:\n   `");
            for (int i = 0; i < stringList.size() ; i++) {
                writer.write(stringList.get(i) + " ");
            }
            writer.flush();

            //READING
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line ;
            System.out.println("Reading ");
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e ){
            e.printStackTrace();
        }
    }
    //PRINTSTREAM
    {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           int size = Integer.parseInt( reader.readLine());
            System.out.println("size = " + size);

            String[] users = new String[size];
            for (int i = 0; i < users.length; i++) {
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                users[i] = input.readLine();
            }
            Map<Integer, String> map = new HashMap<Integer, String>();

            for (int i = 1; i <= users.length; i++){
                map.put(i, users[i-1]);
            }
            PrintStream printStream = new PrintStream("./printStream.txt");

            printStream.println("START");
            for (int i = 1; i <= map.size() ; i++) {
                printStream.println(i + " "+ map.get(i));
            }
            printStream.println("END");
            printStream.flush();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("./printStream.txt")));
            System.out.println(bufferedReader.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    {
        try{
            var printWriter = new PrintWriter(new FileOutputStream("./printWriter.txt"));
            printWriter.println("Hello World!" );
            printWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
