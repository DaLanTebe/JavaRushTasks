package com.javarush.task.sql.task07.task0708;

import java.sql.*;
import java.time.LocalDateTime;

/* 
Получение даты
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", "root", "root");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT name, created FROM employee")){
            while (resultSet.next()){
                String name = resultSet.getString("name");
                LocalDateTime localDateTime = resultSet.getObject("created", LocalDateTime.class);
                System.out.println(name + " " + localDateTime);
            }
        }
    }
}
