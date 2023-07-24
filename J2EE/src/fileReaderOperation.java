import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class fileReaderOperation {
        public static void main(String[] args) {
            Properties prop =new Properties();  // object of Properties class
            FileReader frd=null;  //object to read file

            try {
                //to locate file
                frd=new FileReader("D:\\J2EE\\demo.properties");
                //to load data from file
                prop.load(frd);
                //to read data from file
                String username=prop.getProperty("user");
                String password=prop.getProperty("password");
                //to print data from file
                System.out.println(username);
                System.out.println(password);
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
            finally {
                try {
                    //to close connection
                    frd.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

        }
    }
