/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ABDUL WAQAR
 */
public class DBConnectionUtil {
    private static final String URL="jdbc:mysql://localhost:3306/student";
    private static final String USER="root";
    private static final String PASSWORD="";
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static Connection connection=null;
    
    
    public static Connection openConnection() throws SQLException
    {
        if(connection !=null){
        return connection;
                }
        else{
            try {
                Class.forName(DRIVER);
                connection=(Connection) DriverManager.getConnection(URL,USER,PASSWORD);
                
                } catch (ClassNotFoundException ex) {    
                Logger.getLogger(DBConnectionUtil.class.getName()).log(Level.SEVERE, null, ex);
            }    
            }
return connection;
    }

                            }