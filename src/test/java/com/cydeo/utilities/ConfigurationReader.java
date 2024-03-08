package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //1-create the properties object
    //"static is to make sure its created and loaded before everything else"
    private static Properties properties=new Properties();
    static {

        try {//2-open file using FileInputStream
            FileInputStream file=new FileInputStream("src/Configuration.properties");
            //3-Load the "properties" object with "file" (load properties)
            properties.load(file);
            //close the file
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File Not Found With Given Path!!!");
        }
    }
    //create a utility method to use the object to read
//4- use "properties" object to read from the file(read properties)
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);

    }


}
