package com.example.restservice;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class DAL {
    private static final Logger log = LoggerFactory.getLogger(DAL.class);

  public static void main(String[] args) {

    File storage = new File("./BackEnd/src/main/java/com/example/restservice/storage.txt");
    if (storage.exists()) {
      System.out.println("File name: " + storage.getName());
      System.out.println("Absolute path: " + storage.getAbsolutePath());
      System.out.println("Writeable: " + storage.canWrite());
      System.out.println("Readable " + storage.canRead());
      System.out.println("File size in bytes " + storage.length());
    } else {
      System.out.println("The file does not exist. Creating new storage file...");
        try {
            if (storage.createNewFile()) {
                System.out.println("New storage file successfully created.");
            }
            } catch (IOException e) {
                System.out.println("An error occurred. New storage file not created");
                e.printStackTrace();
        }
        }
    }

    public Boolean AddPostToStorage(Post postToAdd){
        try {
            FileWriter storageWriter = new FileWriter("storage.txt");

            //TODO: generate unique ID based on highest ID recorded in file?
            String convertedPost = "[ID,"+postToAdd.author()+","+postToAdd.content()+"]";

            storageWriter.write(convertedPost);
            storageWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
        return true;
    }    

    public ArrayList<Post> GetPosts(){
        ArrayList<Post> posts = new ArrayList<Post>();
        log.info("Working Directory = " + System.getProperty("user.dir"));
        // Open the file
        try {
            FileInputStream input = new FileInputStream("./BackEnd/src/main/java/com/example/restservice/storage.txt");
                  // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(input);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String strLine;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                System.out.println (strLine);

                //TODO parse content in the line

                posts.add(new Post(strLine, strLine, null));
        }

        //Close the input stream
        in.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return posts;
    } 
}