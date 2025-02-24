/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.foodie.foodviewapplication.service;

import com.foodie.foodviewapplication.modelo.User;

/**
 *
 * @author juan ortega
 */
public class UsuarioSesion {
    private static User usuarioActual;

    public static void setUsuarioActual(User usuario) {
        usuarioActual = usuario;
    }

    public static User getUsuarioActual() {
        return usuarioActual;
    }
}

