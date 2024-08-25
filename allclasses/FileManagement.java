package allclasses;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileManagement {
    public File mainfile;
    public Logger logger = Logger.getLogger(FileManagement.class.getName());
    public FileHandler fh;
    public FileWriter fw;
    public String FILEPATH = "./temp/data.txt";

    public FileManagement(String _fp) {
        addLogger();
        logger.info("Created class FileManagement, ran constructor");
        FILEPATH = _fp;
    }

    public FileManagement() {
        addLogger();
        logger.info("Created class FileManagement, ran constructor");
    }

    public void addLogger(){
        try {
            fh = new FileHandler("./temp/logs.txt"); // log file
            logger.addHandler(fh); // setting logger to use log file
            SimpleFormatter sf = new SimpleFormatter(); // setting formatter
            fh.setFormatter(sf); // setting logger to use formatter
            logger.setUseParentHandlers(false); // remove logs in console
        } catch(IOException e) {
            logger.severe(e.toString()); // all errors go to logger?
        }
        logger.info("Added logger");
    }

    public void COFile(boolean nowipe) { // create or open files
        COMF();
        try{
            fw = new FileWriter(FILEPATH, nowipe);
            if (mainfile.length() != 0){
                fw.write("\n");
            }
        } catch(IOException e) {
            logger.warning(e.toString());
        }
        
    }

    public void COMF(){
        mainfile = new File(FILEPATH);
        if (mainfile.exists()){ 
            logger.info("File exists: " + FILEPATH); // if file exists dont createNewFile()
        } else {
            try {
                mainfile.createNewFile(); // create file cuz no exist
                logger.info("Created file: " + FILEPATH);
            } catch (IOException e) {
                logger.log(Level.WARNING, "IOException occured while trying to create/open: " + FILEPATH); // any errors go to logger
            }
        }
    }

    public void delFile(){
        COMF();
        try{
            fw.close();
        } catch(Exception e) {
            logger.warning("Unable to close FileWriter: " + e);
        }
        mainfile.delete();
        logger.info("Deleted file: " + FILEPATH);
    }

    public void writeData(String data) {
        COFile(true);
        try {
            fw.write(data);
            fw.close();
        } catch(IOException e) {
            logger.warning(e.toString());
        }
    }

    public void writeData(String data, boolean nowipe) {
        COFile(nowipe);
        try {
            fw.write(data);
            fw.close();
        } catch(IOException e) {
            logger.warning(e.toString());
        }
    }

    public String readData() {
        COFile(true);
        // read file somehow cuz i have no idea how
        String data = "";
        try {
            Scanner reader = new Scanner(mainfile);
            if (reader.hasNextLine()){
                data = reader.nextLine();
            }
            reader.close();
        } catch(FileNotFoundException e) {
            logger.warning("rah no file found");
        }
    
        return data; 
    }
    public static void main(String[] args){
        System.out.println("FILE");
    }
}
