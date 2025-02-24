/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.foodie.foodviewapplication.vistas;

import com.foodie.foodviewapplication.modelo.Department;
import com.foodie.foodviewapplication.modelo.Town;
import com.foodie.foodviewapplication.modelo.User;
import com.foodie.foodviewapplication.postgresql.DatabaseConnection;
import com.foodie.foodviewapplication.service.DepartmentDAO;
import com.foodie.foodviewapplication.service.TownDAO;
import com.foodie.foodviewapplication.service.UserDAO;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author juan ortega
 */
public class Registro extends javax.swing.JPanel {

    JComboBox<Department> jboxDepartamento;
    JComboBox<Town> jboxCiudad;
    DepartmentDAO departmentDAO = new DepartmentDAO();
    TownDAO townDAO = new TownDAO();

    public Registro() {
        initComponents();
        inicializarComboBoxes();
        loadDepartments();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoRegistro = new javax.swing.JPanel();
        jtxtEmail = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jtxtApellido = new javax.swing.JTextField();
        jtxtPassw = new javax.swing.JPasswordField();
        jboxGenero = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jDate = new com.toedter.calendar.JDateChooser();
        jPanelBox = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        fondoRegistro.setBackground(new java.awt.Color(255, 255, 255));

        jtxtEmail.setForeground(new java.awt.Color(51, 0, 0));
        jtxtEmail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 1, 14), new java.awt.Color(51, 0, 0))); // NOI18N

        jtxtNombre.setForeground(new java.awt.Color(51, 0, 0));
        jtxtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 1, 14), new java.awt.Color(51, 0, 0))); // NOI18N

        jtxtApellido.setForeground(new java.awt.Color(51, 0, 0));
        jtxtApellido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Apellidos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 1, 14), new java.awt.Color(51, 0, 0))); // NOI18N

        jtxtPassw.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contraseña", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 1, 14), new java.awt.Color(51, 0, 0))); // NOI18N

        jboxGenero.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jboxGenero.setForeground(new java.awt.Color(51, 0, 0));
        jboxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Femenino", "Masculino", "Otro" }));
        jboxGenero.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Género", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Corbel", 1, 14), new java.awt.Color(51, 0, 0))); // NOI18N

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Entrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jDate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de nacimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Corbel", 1, 14), new java.awt.Color(51, 0, 0))); // NOI18N
        jDate.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N

        jPanelBox.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(241, 241, 241)));

        javax.swing.GroupLayout jPanelBoxLayout = new javax.swing.GroupLayout(jPanelBox);
        jPanelBox.setLayout(jPanelBoxLayout);
        jPanelBoxLayout.setHorizontalGroup(
            jPanelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        jPanelBoxLayout.setVerticalGroup(
            jPanelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Corbel", 1, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Gestiona tú información");

        javax.swing.GroupLayout fondoRegistroLayout = new javax.swing.GroupLayout(fondoRegistro);
        fondoRegistro.setLayout(fondoRegistroLayout);
        fondoRegistroLayout.setHorizontalGroup(
            fondoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoRegistroLayout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addGroup(fondoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoRegistroLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fondoRegistroLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(fondoRegistroLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(fondoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(fondoRegistroLayout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(jtxtPassw, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(fondoRegistroLayout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(jboxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(fondoRegistroLayout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(jPanelBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(fondoRegistroLayout.createSequentialGroup()
                .addGap(540, 540, 540)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(fondoRegistroLayout.createSequentialGroup()
                .addGap(550, 550, 550)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        fondoRegistroLayout.setVerticalGroup(
            fondoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoRegistroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(fondoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fondoRegistroLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(fondoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(20, 20, 20)
                .addGroup(fondoRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoRegistroLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fondoRegistroLayout.createSequentialGroup()
                        .addComponent(jtxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jtxtPassw, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jboxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanelBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jButton1)
                .addGap(7, 7, 7)
                .addComponent(jButton2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombre = jtxtNombre.getText();
        String apellido = jtxtApellido.getText();
        String email = jtxtEmail.getText();
        String genero = (String) jboxGenero.getSelectedItem();
        Town selectedTown = (Town) jboxCiudad.getSelectedItem();
        String ciudad = selectedTown.getName();  // Obtener el nombre de la ciudad desde el objeto Town
        String passw = new String(jtxtPassw.getPassword());
        Date fecha = jDate.getDate();

        int fkIdTown = townDAO.getTownIdByName(ciudad);

        User us = new User(nombre, apellido, email, genero, fecha, "Activo", fkIdTown, passw);

        UserDAO registro = new UserDAO();
        boolean isRegistered = registro.addUser(us);

        if (isRegistered) {
            JOptionPane.showMessageDialog(null, "Registro exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            ShowJPanel(new Login());
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ShowJPanel(new Login());
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void ShowJPanel(JPanel p) {
        p.setSize(1150, 647);
        p.setLocation(0, 0);

        fondoRegistro.removeAll();
        fondoRegistro.add(p, BorderLayout.CENTER);
        fondoRegistro.revalidate();
        fondoRegistro.repaint();
    }

    private void inicializarComboBoxes() {
        jPanelBox.setLayout(new GridLayout(2, 1));
        jboxDepartamento = new JComboBox<>();
        jboxCiudad = new JComboBox<>();
        // Puedes configurar los JComboBox según tus necesidades
        jboxDepartamento.setModel(new javax.swing.DefaultComboBoxModel<Department>());
        jboxCiudad.setModel(new javax.swing.DefaultComboBoxModel<Town>());
        jPanelBox.add(jboxDepartamento);
        jPanelBox.add(jboxCiudad);

        jboxDepartamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Department selectedDepartment = (Department) jboxDepartamento.getSelectedItem();
                if (selectedDepartment != null) {
                    loadCities(selectedDepartment.getIdDepartment());
                }
            }
        });

    }

    private void loadDepartments() {
        List<Department> departments = departmentDAO.getAllDepartments();
        if (departments != null) {
            for (Department dept : departments) {
                jboxDepartamento.addItem(dept);
            }
        } else {
            System.out.println("No se pudieron cargar los departamentos.");
        }
    }

    private void loadCities(int departmentId) {
        jboxCiudad.removeAllItems();
        List<Town> cities = townDAO.getCitiesByDepartment(departmentId);
        if (cities != null) {
            for (Town city : cities) {
                jboxCiudad.addItem(city);
            }
        } else {
            System.out.println("No se pudieron cargar las ciudades.");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel fondoRegistro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelBox;
    private javax.swing.JComboBox<String> jboxGenero;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JPasswordField jtxtPassw;
    // End of variables declaration//GEN-END:variables
}
