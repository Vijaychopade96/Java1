import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class filewriterOperation {
    public static void main(String[] args) {
        Properties prop=new Properties();
        FileWriter wrt=null;

        try {
            wrt=new FileWriter("D:\\J2EE\\demo2.properties");//give location to save file

            prop.setProperty("username","nikhil");//to write data
            prop.setProperty("Password","1234");
            prop.store(wrt,"data");  //to store data

            System.out.println("file created");

        } catch (IOException e) {
            System.out.println(e);
        }
        finally {
            try {
                wrt.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
