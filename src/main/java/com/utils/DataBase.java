package com.utils;

import java.sql.*;

public class DataBase {
    // Dependencies: sqljdbc4 JAR
// This method will connect to a SQL Server M.S. database and return a double array
    public static String[][] get(String query) throws SQLException {
        int numRows;
        int numCols = 4;
        String dataTable[][] = null;

        // Define connection string
        String connectionString;

		String server = "";
		String databaseName = "";
		String username = "";
		String password = "";

        connectionString = server + ";databasename=" + databaseName + ";username=" + username + ";password=" + password;

        // Write SQL statement to query the databse (override)
        // query = "select * from table";

        // Perform DB operations
        try {
            Connection oConnection = DriverManager.getConnection(connectionString);
            Statement oStatement = oConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet oResult = oStatement.executeQuery(query);

            // Set the size of the array
            oResult.last();
            numRows = oResult.getRow();
            dataTable = new String[numRows][numCols];

            // Read the DB file while there is a next element
            oResult.beforeFirst();
            int row = 0;
            while (oResult.next()) {
                dataTable[row][0] = oResult.getString(1);
                dataTable[row][1] = oResult.getString(2);
                dataTable[row][2] = oResult.getString(3);
                dataTable[row][3] = oResult.getString(4);
                row++;
            }

        } catch (SQLException e) {
            System.out.println("ERROR Handling SQL");
            e.printStackTrace();
        }

        return dataTable;
    }
}
