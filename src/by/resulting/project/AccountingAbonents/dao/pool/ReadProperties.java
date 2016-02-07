package by.resulting.project.AccountingAbonents.dao.pool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * Implements connection with DataBase
 */
public class ReadProperties {

	private  String dbURL=null;
    private  String driverClassName=null;
    private  String login=null;
    private  String password=null;

    public ReadProperties(){

        Properties properties = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("by.resulting.project.AccountingAbonents.properties.database.properties");
            properties.load(inputStream);
            dbURL = properties.getProperty("dbURL");
            driverClassName = properties.getProperty("driverClassName");
            login = properties.getProperty("login");
            password = properties.getProperty("password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
