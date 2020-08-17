/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namdd.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author namdo
 */
public class MyConnection {

    public static Connection getMyConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1455;databaseName=CoffeeStore", "sa", "123");
        return conn;
    }
}
