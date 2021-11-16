package com.melnikov.mainDir.utils;

import com.melnikov.mainDir.sourceFiles.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class RSPrinter {
    public static void printMyRS(ResultSet resultSet) throws SQLException {
        System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
    }

    private static void sayHello(){
        System.out.println("Hello, worlds!");
    }
}
