/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.foodie.foodviewapplication.interfaces;

import com.foodie.foodviewapplication.modelo.Review;
import java.util.List;

/**
 *
 * @author juan ortega
 */
public interface ReviewService {
    public boolean addReview(Review review);
    public Review getReviewById(int idReview);
    public boolean updateReview(Review review);
    public boolean deleteReview(int idReview);
    public List<Review> getAllReviewsForPlace(int fkIdPlace);
}
