package com.example.restservice;
import java.io.File;  // Import the File class
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DAL { 
  public static void main(String[] args) {
    File storage = new File("storage.txt");
    if (storage.exists()) {
      System.out.println("File name: " + myObj.getName());
      System.out.println("Absolute path: " + myObj.getAbsolutePath());
      System.out.println("Writeable: " + myObj.canWrite());
      System.out.println("Readable " + myObj.canRead());
      System.out.println("File size in bytes " + myObj.length());
    } else {
      System.out.println("The file does not exist.");
    }
  }

    public Boolean AddPostToStorage(Post postToAdd){
        //TODO
        return true;
    }

    public Post[] RetrievePosts(){
        String fileName= "Test.txt";
        FileInputStream fin = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fin);
        IHandler iHandler= (IHandler) ois.readObject();
        ois.close();
        return iHandler;
    }
}