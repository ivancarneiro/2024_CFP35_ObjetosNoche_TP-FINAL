package cfp35.objetosnoche.tpfinal.tickersec.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    
    // MariaDB o MySQL 
    //private static String url="jdbc:mariadb://localhost:3306/colegio";

    // SQlite
    private static String url="jdbc:sqlite:./data/data";

    
    private static Connection conn=null;
    private Connector(){}

    public static Connection getConnection(){
        try {
            conn=DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;    
    }

    public static String getUrl() {
        return url;
    }
}
