package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.testng.Reporter;

public class XmlCombiner {
	public static void xmlscombine() throws IOException  
    {
 
         
        // create instance of directory
        File dir = new File("XMLFiles");
 
        // PrintWriter object for combinedXml.xml
        PrintWriter pw = new PrintWriter("combinedXml.xml");
 
        // Get list of all the files in form of String Array
        String[] fileNames = dir.list();
 
        // loop for reading the contents of all the files  
        // in the directory GeeksForGeeks
        for (String fileName : fileNames) {
            Reporter.log("Reading from " + fileName);
 
            // create instance of file from Name of  
            // the file stored in string Array
            File f = new File(dir, fileName);
 
            // create object of BufferedReader
            BufferedReader br = new BufferedReader(new FileReader(f));
            pw.println();
 
            // Read from current file
            String line = br.readLine();
            while (line != null) {
 
                // write to the output file
                pw.println(line);
                line = br.readLine();
            }
            pw.flush();
        }
        Reporter.log("Reading from all files" +  
        " in directory " + dir.getName() + " Completed");
    }
} 
