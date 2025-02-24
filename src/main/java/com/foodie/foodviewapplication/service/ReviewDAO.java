/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.interfaces.ReviewService;
import com.foodie.foodviewapplication.modelo.Review;
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
public class ReviewDAO implements ReviewService {

    private Connection connection;

    public ReviewDAO() {
        connection = DatabaseConnection.getConnection();
    }

    @Override
    public boolean addReview(Review review) {
        String query = "INSERT INTO review (description, stars, date, fk_id_user, fk_id_place) VALUES (?, ?, ?, ?, ?)";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, review.getDescription());
            statement.setFloat(2, review.getStars());
            statement.setDate(3, new java.sql.Date(review.getDate().getTime()));
            statement.setInt(4, review.getFkIdUser());
            statement.setInt(5, review.getFkIdPlace());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Review getReviewById(int idReview) {
        String query = "SELECT * FROM review WHERE id_review = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idReview);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Review review = new Review();
                review.setIdReview(resultSet.getInt("id_review"));
                review.setDescription(resultSet.getString("description"));
                review.setStars(resultSet.getFloat("stars"));
                review.setDate(resultSet.getDate("date"));
                review.setFkIdUser(resultSet.getInt("fk_id_user"));
                review.setFkIdPlace(resultSet.getInt("fk_id_place"));
                return review;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateReview(Review review) {
        String query = "UPDATE review SET description = ?, stars = ?, date = ?, fk_id_user = ?, fk_id_place = ? WHERE id_review = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, review.getDescription());
            statement.setFloat(2, review.getStars());
            statement.setDate(3, new java.sql.Date(review.getDate().getTime()));
            statement.setInt(4, review.getFkIdUser());
            statement.setInt(5, review.getFkIdPlace());
            statement.setInt(6, review.getIdReview());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteReview(int idReview) {
        String query = "DELETE FROM review WHERE id_review = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, idReview);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Review> getAllReviewsForPlace(int fkIdPlace) {
        String query = "SELECT * FROM review WHERE fk_id_place_r = ?";
        List<Review> reviewList = new ArrayList<>();
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, fkIdPlace);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Review review = new Review();
                review.setIdReview(resultSet.getInt("id_review"));
                review.setDescription(resultSet.getString("description"));
                review.setStars(resultSet.getFloat("stars"));
                review.setDate(resultSet.getDate("date"));
                review.setFkIdUser(resultSet.getInt("fk_id_user_r"));
                review.setFkIdPlace(resultSet.getInt("fk_id_place_r"));
                reviewList.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviewList;
    }

    public int countReviewsByPlace(int placeId) {
        String query = "SELECT COUNT(*) FROM review WHERE fk_id_place_r = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, placeId);
            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al contar los PlaceLists: " + e.getMessage());
        }
        return 0;
    }

    public float getAverageRatingForPlace(int fkIdPlace) {
        String query = "SELECT AVG(stars) AS average_rating FROM review WHERE fk_id_place_r = ?";
        float averageRating = 0.0f;

        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, fkIdPlace);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    averageRating = resultSet.getFloat("average_rating");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al obtener la puntuación promedio del lugar: " + e.getMessage());
        }

        // Redondear a dos decimales
        averageRating = Math.round(averageRating * 100) / 100.0f;

        return averageRating;
    }
    
    public int countReviewsByUser(int userId) {
        String query = "SELECT COUNT(*) FROM review WHERE fk_id_user_r = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al contar las reseñas: " + e.getMessage());
        }
        return 0;
    }

}
