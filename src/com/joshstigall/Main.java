package com.joshstigall;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        DBConnect testConnect = new DBConnect();

        testConnect.query("Penelope", 3);

    }
}
