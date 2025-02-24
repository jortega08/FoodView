/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.interfaces.FriendshipService;
import com.foodie.foodviewapplication.modelo.Friendship;
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
public class FriendshipDAO implements FriendshipService {

    private Connection connection;

    public FriendshipDAO() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean addFriendship(Friendship friendship) {
        String query = "INSERT INTO friendship (fk_id_user_send, fk_id_user_receive, status) VALUES (?, ?, ?)";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, friendship.getFkIdUserSend());
            statement.setInt(2, friendship.getFkIdUserReceive());
            statement.setString(3, friendship.getStatus());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Friendship getFriendshipById(int idFriendship) {
        String query = "SELECT * FROM friendship WHERE id_friendship = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idFriendship);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Friendship friendship = new Friendship();
                friendship.setIdFriendship(resultSet.getInt("id_friendship"));
                friendship.setFkIdUserSend(resultSet.getInt("fk_id_user_send"));
                friendship.setFkIdUserReceive(resultSet.getInt("fk_id_user_receive"));
                friendship.setStatus(resultSet.getString("status"));
                return friendship;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateFriendship(Friendship friendship) {
        String query = "UPDATE friendship SET fk_id_user_send = ?, fk_id_user_receive = ?, status = ? WHERE id_friendship = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, friendship.getFkIdUserSend());
            statement.setInt(2, friendship.getFkIdUserReceive());
            statement.setString(3, friendship.getStatus());
            statement.setInt(4, friendship.getIdFriendship());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteFriendship(int idFriendship) {
        String query = "DELETE FROM friendship WHERE id_friendship = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idFriendship);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Friendship> getAllFriendship() {
        String query = "SELECT * FROM friendship";
        List<Friendship> friendshipList = new ArrayList<>();
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Friendship friendship = new Friendship();
                friendship.setIdFriendship(resultSet.getInt("id_friendship"));
                friendship.setFkIdUserSend(resultSet.getInt("fk_id_user_send"));
                friendship.setFkIdUserReceive(resultSet.getInt("fk_id_user_receive"));
                friendship.setStatus(resultSet.getString("status"));
                friendshipList.add(friendship);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return friendshipList;
    }

    public int countFriends(int userId) {
        String query = "SELECT COUNT(*) AS friendCount FROM friendship WHERE (fk_id_user_send = ?) AND status = 'Aceptada'";
        int friendCount = 0;
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setInt(2, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                friendCount = resultSet.getInt("friendCount");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return friendCount;
    }
}
