/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.foodie.foodviewapplication.vistas;

import com.foodie.foodviewapplication.modelo.Place;
import com.foodie.foodviewapplication.modelo.Review;
import com.foodie.foodviewapplication.modelo.User;
import com.foodie.foodviewapplication.service.FriendshipDAO;
import com.foodie.foodviewapplication.service.PlaceDAO;
import com.foodie.foodviewapplication.service.ReviewDAO;
import com.foodie.foodviewapplication.service.UsuarioSesion;

/**
 *
 * @author juan ortega
 */
public class Perfil extends javax.swing.JPanel {

    private UsuarioSesion userSesion;
    private User user;
    private Review review;
    private ReviewDAO reviewDAO;
    private FriendshipDAO friendshipDAO;
    
    public Perfil() {
        userSesion = new UsuarioSesion();
        user = new User();
        review = new Review();
        reviewDAO = new ReviewDAO();
        friendshipDAO = new FriendshipDAO();
        initComponents();
        initLabels();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPerfil = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanelUsuario = new javax.swing.JPanel();
        jLabelNumReseñas = new javax.swing.JLabel();
        jLabelNombreUsuario = new javax.swing.JLabel();
        jLabelNumPlaceList = new javax.swing.JLabel();
        jLabelNumFoodieFriends = new javax.swing.JLabel();
        jLabelEmailUsuario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jReseñas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jFoodieFriends = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPlaceList = new javax.swing.JTable();

        jPanelPerfil.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Corbel", 1, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("¡Configura tu perfil! ");

        jPanelUsuario.setBackground(new java.awt.Color(255, 236, 220));

        jLabelNumReseñas.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabelNumReseñas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumReseñas.setText("#");
        jLabelNumReseñas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reseñas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Corbel", 0, 18), new java.awt.Color(86, 1, 1))); // NOI18N

        jLabelNombreUsuario.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        jLabelNombreUsuario.setText("Nombre del usuario");

        jLabelNumPlaceList.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabelNumPlaceList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumPlaceList.setText("#");
        jLabelNumPlaceList.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PlaceList", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Corbel", 0, 18), new java.awt.Color(86, 1, 1))); // NOI18N

        jLabelNumFoodieFriends.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabelNumFoodieFriends.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNumFoodieFriends.setText("#");
        jLabelNumFoodieFriends.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FoodieFriends", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Corbel", 0, 18), new java.awt.Color(86, 1, 1))); // NOI18N

        jLabelEmailUsuario.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jLabelEmailUsuario.setText("Email");

        jButton1.setBackground(new java.awt.Color(72, 0, 0));
        jButton1.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Editar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelUsuarioLayout = new javax.swing.GroupLayout(jPanelUsuario);
        jPanelUsuario.setLayout(jPanelUsuarioLayout);
        jPanelUsuarioLayout.setHorizontalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 1099, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabelEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(jLabelNumReseñas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabelNumFoodieFriends, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabelNumPlaceList, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(181, 181, 181)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelUsuarioLayout.setVerticalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNumReseñas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNumFoodieFriends, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNumPlaceList, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabelEmailUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jReseñas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Puntuación", "Fecha", "Restaurante"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jReseñas);
        if (jReseñas.getColumnModel().getColumnCount() > 0) {
            jReseñas.getColumnModel().getColumn(0).setMaxWidth(100);
            jReseñas.getColumnModel().getColumn(1).setMaxWidth(200);
        }

        jFoodieFriends.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jFoodieFriends);

        jPlaceList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de la PlaceList"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jPlaceList);

        javax.swing.GroupLayout jPanelPerfilLayout = new javax.swing.GroupLayout(jPanelPerfil);
        jPanelPerfil.setLayout(jPanelPerfilLayout);
        jPanelPerfilLayout.setHorizontalGroup(
            jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
                .addGap(180, 180, 180))
            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPerfilLayout.createSequentialGroup()
                        .addComponent(jPanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelPerfilLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(34, 34, 34))))
        );
        jPanelPerfilLayout.setVerticalGroup(
            jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPerfilLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(56, 56, 56)
                .addGroup(jPanelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void initLabels(){
        user = UsuarioSesion.getUsuarioActual();
        jLabelNombreUsuario.setText(user.getGivenName()+" "+user.getFamilyName());
        jLabelEmailUsuario.setText(user.getEmail());
    }
        
    private void contarReview(int idUser){
        int reviews = reviewDAO.countReviewsByPlace(user.getIdUser());
        String reviewsSt = String.valueOf(reviews);
        jLabelNumReseñas.setText(reviewsSt);
    }
    
    private void contarFoodieFriedns(int idUser){
        int foodieFriends = friendshipDAO.countFriends(user.getIdUser());
        String foodieFriendsSt = String.valueOf(foodieFriends);
        jLabelNumReseñas.setText(foodieFriendsSt);
    }
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTable jFoodieFriends;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabelEmailUsuario;
    public javax.swing.JLabel jLabelNombreUsuario;
    public javax.swing.JLabel jLabelNumFoodieFriends;
    public javax.swing.JLabel jLabelNumPlaceList;
    public javax.swing.JLabel jLabelNumReseñas;
    private javax.swing.JPanel jPanelPerfil;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JTable jPlaceList;
    private javax.swing.JTable jReseñas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
