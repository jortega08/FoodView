/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.foodie.foodviewapplication.vistas;

import com.foodie.foodviewapplication.modelo.User;
import com.foodie.foodviewapplication.service.UserDAO;
import com.foodie.foodviewapplication.service.UsuarioSesion;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author juan ortega
 */
public class Login extends javax.swing.JPanel {

    UserDAO userDAO = new UserDAO();
    User user = new User();
    private Principal principal;

    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoInicio = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxtEmail = new javax.swing.JTextField();
        jtxtPassw = new javax.swing.JPasswordField();
        jbtnEntrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        fondoInicio.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Corbel", 1, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inicia Sesión");

        jtxtEmail.setForeground(new java.awt.Color(51, 0, 0));
        jtxtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 1, 14), new java.awt.Color(51, 0, 0))); // NOI18N

        jtxtPassw.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseña", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 1, 14), new java.awt.Color(51, 0, 0))); // NOI18N

        jbtnEntrar.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jbtnEntrar.setForeground(new java.awt.Color(51, 0, 0));
        jbtnEntrar.setText("Entrar");
        jbtnEntrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0)));
        jbtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEntrarActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 0, 0));
        jButton2.setText("Quiero registrarme");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoInicioLayout = new javax.swing.GroupLayout(fondoInicio);
        fondoInicio.setLayout(fondoInicioLayout);
        fondoInicioLayout.setHorizontalGroup(
            fondoInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoInicioLayout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(fondoInicioLayout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(fondoInicioLayout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(jtxtPassw, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(fondoInicioLayout.createSequentialGroup()
                .addGap(530, 530, 530)
                .addComponent(jbtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(259, 259, 259))
        );
        fondoInicioLayout.setVerticalGroup(
            fondoInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoInicioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jtxtPassw, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jbtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEntrarActionPerformed
        String email = jtxtEmail.getText();
        String passw = String.valueOf(jtxtPassw.getPassword());

        User user = userDAO.getUserByEmailAndPassword(email, passw);
        if (user != null) {
            System.out.println("Inicio de sesión exitoso para el usuario: " + user.getEmail());
            UsuarioSesion.setUsuarioActual(user);
            ShowJPanel(new Principal());

        } else {
            // Credenciales incorrectas
            System.out.println("Credenciales incorrectas. No se encontró ningún usuario con el correo electrónico y contraseña proporcionados.");
            // Aquí puedes mostrar un mensaje de error al usuario o realizar otras acciones necesarias
        }

    }//GEN-LAST:event_jbtnEntrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ShowJPanel(new Registro());
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void ShowJPanel(JPanel p) {
        p.setSize(1150, 647);
        p.setLocation(0, 0);

        fondoInicio.removeAll();
        fondoInicio.add(p, BorderLayout.CENTER);
        fondoInicio.revalidate();
        fondoInicio.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel fondoInicio;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtnEntrar;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JPasswordField jtxtPassw;
    // End of variables declaration//GEN-END:variables
}
