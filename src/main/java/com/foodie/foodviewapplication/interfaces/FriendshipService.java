/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.foodie.foodviewapplication.interfaces;

import com.foodie.foodviewapplication.modelo.Friendship;
import java.util.List;

/**
 *
 * @author juan ortega
 */
public interface FriendshipService {
    public boolean addFriendship(Friendship friendship);
    public Friendship getFriendshipById(int idFriendship);
    public boolean updateFriendship(Friendship friendship);
    public boolean deleteFriendship(int idFriendship);
    public List<Friendship> getAllFriendship();
}
