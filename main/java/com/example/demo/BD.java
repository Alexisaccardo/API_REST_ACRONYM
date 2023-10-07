package com.example.demo;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BD {
    public BD() {
    }

    public Users Register(String code, String thirdapp, String relation, String acronym) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/register";
        String username = "root";
        String password = "";

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM thirdappTable");

            // Sentencia INSERT
            String sql = "INSERT INTO thirdappTable (codeId, thirdapp, RelationId, creationDate, updateDate, acronym) VALUES (?, ?, ?, ?, ?, ?)";

            // Preparar la sentencia
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, thirdapp);
            preparedStatement.setString(3, relation);
            preparedStatement.setString(4, String.valueOf(LocalDateTime.now()));
            preparedStatement.setString(5, "");
            preparedStatement.setString(6, acronym);

            // Ejecutar la sentencia
            int files = preparedStatement.executeUpdate();

            if (files > 0) {
                System.out.println("Empleado registrado de manera exitosa.");
                return new Users(code, thirdapp, relation, acronym);
            } else {
                System.out.println("No se pudo registrar el empleado");
            }

            preparedStatement.close();
            connection.close();
            statement.close();
            resultSet.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new Users(null, null, null, null);

    }

    public Users Edit(String code, String thirdapp, String relation, String acronym) throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/register";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        String consult = "UPDATE thirdappTable SET thirdapp = ?, RelationId = ?, acronym = ?, updateDate = ? WHERE codeId = ?";

        PreparedStatement preparedStatement = connection2.prepareStatement(consult);
        preparedStatement.setString(1, thirdapp);
        preparedStatement.setString(2, relation);
        preparedStatement.setString(3, acronym);
        preparedStatement.setString(4, String.valueOf(LocalDateTime.now()));
        preparedStatement.setString(5, code);

        int files = preparedStatement.executeUpdate();
        if (files > 0) {
            System.out.println("Operador actualizado de manera exitosa");
            return new Users (code, thirdapp,relation,acronym);
        } else {
            System.out.println("No se encontro el empleado para actualizar");
        }
        preparedStatement.close();
        connection2.close();
        return new Users(null, null, null, null);
    }

    public List<Users> Search_all() throws ClassNotFoundException, SQLException {

        String driver2 = "com.mysql.cj.jdbc.Driver";
        String url2 = "jdbc:mysql://localhost:3306/register";
        String username2 = "root";
        String pass2 = "";

        Class.forName(driver2);
        Connection connection2 = DriverManager.getConnection(url2, username2, pass2);

        Statement statement2 = connection2.createStatement();

        ResultSet resultSet2 = statement2.executeQuery("SELECT * FROM thirdappTable");

        List<Users> list = new ArrayList<>();

        while (resultSet2.next()) {
            String code = resultSet2.getString("codeId");
            String thirdapp = resultSet2.getString("thirdapp");
            String relation = resultSet2.getString("RelationId");
            String acronym = resultSet2.getString("acronym");
            String creationDate = resultSet2.getString("creationDate");

            LocalDateTime fechaactual = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSS");
            int endIndex = creationDate.indexOf('.') + 6;
            String fechaHoraTruncada = creationDate.substring(0, endIndex);
            LocalDateTime creacion = LocalDateTime.parse(fechaHoraTruncada, formatter);
            LocalDateTime days = creacion.plusDays(20);
            int comparisonResult = days.compareTo(fechaactual);
            if (comparisonResult>0){
                Users users = new Users(code, thirdapp, relation, acronym);

                list.add(users);
            }
        }
        return list;
    }

    public static String Select_acronym(String acronym) throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/register";
        String username = "root";
        String password = "";

        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);

        String consult_SQL = "SELECT * FROM acronymTable WHERE acronym = ?";

        PreparedStatement statement = connection.prepareStatement(consult_SQL);
        statement.setString(1, acronym); // Establecer el valor del parámetro

        // Ejecutar la consulta
        ResultSet resultSet2 = statement.executeQuery();

        // Procesar el resultado si existe
        if (resultSet2.next()) {

            String name = resultSet2.getString("name");

            return name;
        }
        // Cerrar recursos
        resultSet2.close();
        statement.close();
        connection.close();

        return "";
    }

    }


