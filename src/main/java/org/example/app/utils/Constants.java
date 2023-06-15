package org.example.app.utils;

import org.example.app.database.PassReader;

public final class Constants {

    // DB
    public final static String DB_DRIVER = "jdbc:mysql://localhost:3306/";
    public final static String DB_NAME = "shop_online";

    public final static String PATH_MYSQL_CREDS = "mysql_creds/";
    public final static String DB_USER = "root";
    public final static String DB_PASS = PassReader.readPass();

    public final static String TABLE_POSITIONS = "positions";
    public final static String TABLE_EMPLOYEES = "employees";

    public final static String INCORRECT_VALUE_MSG = ">> Incorrect value! Try again...";
    public final static String APP_CLOSE_MSG = "\n>> App closed.";
    public final static String INPUT_REQ_MSG = "Input required.";
    public final static String SMTH_WRONG_MSG = "Something wrong.";
    public final static String DATA_INSERT_MSG = "\n>> Created.";
    public final static String DATA_ABSENT_MSG = "\n>> No data!";


}
