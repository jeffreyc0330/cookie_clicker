import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *this class contains methods responsible for determining the file path and writing data to files
 * Made by: Vinson Zhang
 * Last edited: Jun 22, 2021
 */
public class WriteFile{

  private String path;
  private boolean appendToFile = false;

  /**
   *sets the file path

   *@filePath what the save file is called

   *precondition: filePath must be a string, the target file must exist
   *postcondition: the path variable will be set to the desired file name
   */ 
  public WriteFile(String filePath){
    path = filePath;
  }

  /**
   *overloaded constructor for WriteFile, with the filename and whether to overwrite the file or not

   *@filePath is what the save file is called
   *@appendValue is whether to overwrite (false) or add (true) values to the file

   *precondition: title must be a String, appendValue must be a boolean, the target file must exist
   *postcondition: the target file name will be set and the writing behavior of the object will be set
   */ 
  public WriteFile(String filePath, boolean appendValue){
    path = filePath;
    appendToFile = appendValue;
  }

  /**
   *writes a string to the target file

   *@textLine what text to write to the file

   *precondition: a WriteFile object must already have been created, the file path must have been declared, textLine must be a string
   *postcondition: textLine string will be written to the target file or an IOException will be thrown
   */ 
  public void writeToFile(String textLine) throws IOException{
    FileWriter write = new FileWriter(path, appendToFile);
    PrintWriter printLine = new PrintWriter(write);
    printLine.printf( "%s" + "%n" , textLine);
    printLine.close();
  }
}

