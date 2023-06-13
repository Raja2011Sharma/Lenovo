package Factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    static Connection conn = null;
    public static Connection connect(){
        try{
            String url ="jdbc:postgresql://35.200.183.186:5432/staging_saral_db";
            String Username ="readonly";
            String Password ="ReaDev@20023";
            conn = DriverManager.getConnection(url,Username,Password);
        }catch (Exception e ){
            e.printStackTrace();
        }
        return conn;
    }

}
