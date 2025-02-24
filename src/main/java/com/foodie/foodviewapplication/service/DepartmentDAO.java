/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.modelo.Department;
import com.foodie.foodviewapplication.postgresql.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan ortega
 */
public class DepartmentDAO {

    private Connection connection;

    public DepartmentDAO() {
        connection = DatabaseConnection.getConnection();
    }

    public List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String query = "SELECT id_department, name FROM foodview.department";

        try ( PreparedStatement statement = connection.prepareStatement(query);  ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Department department = new Department();
                department.setIdDepartment(resultSet.getInt("id_department"));
                department.setName(resultSet.getString("name"));
                departments.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener los departamentos: " + e.getMessage());
        }

        return departments;
    }

    public Department getDepartmentById(int departmentId) {
        String query = "SELECT id_department, name FROM foodview.department WHERE id_department = ?";
        Department department = null;

        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, departmentId);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    department = new Department();
                    department.setIdDepartment(resultSet.getInt("id_department"));
                    department.setName(resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener el departamento por ID: " + e.getMessage());
        }

        return department;
    }

}
