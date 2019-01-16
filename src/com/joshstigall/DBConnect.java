package com.joshstigall;

import java.sql.*;
import java.sql.PreparedStatement;

public class DBConnect {

    public void query(String name, int limit) {
        try {

            // CONNECT TO DATABASE
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/sakila", "root", "root");

            // CREATE STATEMENT TO SEND TO DATABASE. '?' = VARIABLES
            PreparedStatement myStatement = myConn.prepareStatement("SELECT * FROM actor WHERE first_name = ? LIMIT ?");

            // SET VARIABLES TO PARAMETERS PASSED IN TO METHOD
            //myStatement.setString(1, columnName);
            myStatement.setString(1, name);
            myStatement.setInt(2, limit);

            // EXECUTE THE QUERY
            ResultSet myResult = myStatement.executeQuery();

            // LOOP THROUGH RESULT AND PRINT
            while (myResult.next()) {
                System.out.println(myResult.getString("first_name") + " " + myResult.getString("last_name"));
            }

            // CLOSE THE CONNECTION AND STATEMENT AFTER RUNNING
            myConn.close();
            myStatement.close();

        } catch (
                SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    public void insert(String firstName, String lastName) {
        try {
            // CONNECT TO DATABASE
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/sakila", "root", "root");

            // CREATE STATEMENT TO SEND TO DATABASE.
            PreparedStatement myStatement = myConn.prepareStatement("INSERT INTO actor (first_name, last_name) VALUES (?, ?)");

            // SET VALUES TO PARAMETERS PASSED IN TO METHOD
            myStatement.setString(1, firstName);
            myStatement.setString(2, lastName);

            // EXECUTE THE INSERT
            myStatement.executeUpdate();

            // CLOSE THE CONNECTION AND STATEMENT AFTER RUNNING
            myConn.close();
            myStatement.close();

        } catch (
                SQLException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}


