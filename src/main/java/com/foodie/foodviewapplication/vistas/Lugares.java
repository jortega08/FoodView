/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.foodie.foodviewapplication.vistas;

import com.foodie.foodviewapplication.modelo.Place;
import com.foodie.foodviewapplication.modelo.PlaceList;
import com.foodie.foodviewapplication.service.FavoritePlacesDAO;
import com.foodie.foodviewapplication.service.PlaceDAO;
import com.foodie.foodviewapplication.service.PlaceListContentDAO;
import com.foodie.foodviewapplication.service.PlaceListDAO;
import com.foodie.foodviewapplication.service.ReviewDAO;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juan ortega
 */
public class Lugares extends javax.swing.JPanel {

    private Place selectedPlace;
    private PlaceDAO placeDAO;
    private PlaceListDAO placeListDAO;
    private PlaceListContentDAO content;
    private FavoritePlacesDAO favoritePlacesDAO;
    private ReviewDAO reviewDAO;

    public Lugares() {

        initComponents();

        selectedPlace = new Place();
        placeDAO = new PlaceDAO();
        content = new PlaceListContentDAO();
        placeListDAO = new PlaceListDAO();
        favoritePlacesDAO = new FavoritePlacesDAO();
        reviewDAO = new ReviewDAO();

        obtenerLugaresTable();
    }

    public void obtenerLugaresTable() {
        try {
            // Obtener todos los lugares desde el DAO
            List<Place> places = placeDAO.getAllPlaces();

            // Obtener el modelo de la tabla y resetear su contenido
            DefaultTableModel model = (DefaultTableModel) jRestaurantes.getModel();
            model.setRowCount(0);

            // Iterar sobre la lista de lugares y añadir filas al modelo de la tabla
            for (Place place : places) {
                try {
                    // Contar las listas de lugares para cada lugar
                    int placeListCount = content.countPlaceListsByPlace(place.getIdPlace());
                    int likes = favoritePlacesDAO.countLikesByPlace(place.getIdPlace());
                    float puntaje = reviewDAO.getAverageRatingForPlace(place.getIdPlace());
                    // Crear un array con los datos del registro
                    Object[] registro = {
                        place.getNamePlace(),
                        place.getEmail(),
                        place.getPhoneNumber(),
                        placeListCount,
                        puntaje,
                        likes
                    };

                    // Añadir el registro al modelo de la tabla
                    model.addRow(registro);
                } catch (Exception e) {
                    e.printStackTrace();
                    // Puedes añadir un mensaje de error a la tabla si lo deseas
                    Object[] registroError = {
                        place.getNamePlace(),
                        "Error al obtener el email",
                        "Error al obtener el número de teléfono",
                        "Error al contar las listas"
                    };
                    model.addRow(registroError);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Manejo de errores al obtener los lugares
            JOptionPane.showMessageDialog(null, "Error al obtener los lugares: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void obtenerNumPlaceListTable() {
        try {
            // Crear una instancia del DAO
            placeListDAO = new PlaceListDAO();

            // Obtener todas las listas de lugares desde el DAO
            List<PlaceList> placeLists = placeListDAO.getAllPlaceLists();

            // Obtener el modelo de la tabla y resetear su contenido
            DefaultTableModel model = (DefaultTableModel) jRestaurantes.getModel();
            model.setRowCount(0);

            // Iterar sobre la lista de PlaceList y añadir filas al modelo de la tabla
            for (PlaceList placeList : placeLists) {
                Object[] registro = {
                    placeList.getName()
                };
                model.addRow(registro);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Mostrar un mensaje de error en caso de que ocurra una excepción
            JOptionPane.showMessageDialog(null, "Error al obtener las listas de lugares: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ordenarPorNumPlaceList() {
        try {
            // Obtener todos los lugares
            List<Place> lugares = placeDAO.getAllPlaces();

            // Ordenar los lugares según el número de listas en las que se encuentran
            lugares.sort((lugar1, lugar2) -> {
                try {
                    int numPlaceLists1 = content.countPlaceListsByPlace(lugar1.getIdPlace());
                    int numPlaceLists2 = content.countPlaceListsByPlace(lugar2.getIdPlace());
                    return Integer.compare(numPlaceLists2, numPlaceLists1);
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0; // En caso de error, no cambiar el orden relativo
                }
            });

            // Actualizar el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) jRestaurantes.getModel();
            model.setRowCount(0);

            // Añadir los datos ordenados al modelo de la tabla
            for (Place lugar : lugares) {
                try {
                    int numPlaceLists = content.countPlaceListsByPlace(lugar.getIdPlace());
                    int likes = favoritePlacesDAO.countLikesByPlace(lugar.getIdPlace());
                    float puntaje = reviewDAO.getAverageRatingForPlace(lugar.getIdPlace());
                    Object[] registro = {
                        lugar.getNamePlace(),
                        lugar.getEmail(),
                        lugar.getPhoneNumber(),
                        numPlaceLists,
                        puntaje,
                        likes
                    };
                    model.addRow(registro);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ordenarPorLikes() {
        try {
            // Obtener todos los lugares
            List<Place> lugares = placeDAO.getAllPlaces();

            // Ordenar los lugares según el número de listas en las que se encuentran
            lugares.sort((lugar1, lugar2) -> {
                try {
                    int numLikes1 = favoritePlacesDAO.countLikesByPlace(lugar1.getIdPlace());
                    int numLikes2 = favoritePlacesDAO.countLikesByPlace(lugar2.getIdPlace());
                    return Integer.compare(numLikes1, numLikes2);
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0; // En caso de error, no cambiar el orden relativo
                }
            });

            // Actualizar el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) jRestaurantes.getModel();
            model.setRowCount(0);

            // Añadir los datos ordenados al modelo de la tabla
            for (Place lugar : lugares) {
                try {
                    int numPlaceLists = content.countPlaceListsByPlace(lugar.getIdPlace());
                    int likes = favoritePlacesDAO.countLikesByPlace(lugar.getIdPlace());
                    float puntaje = reviewDAO.getAverageRatingForPlace(lugar.getIdPlace());
                    Object[] registro = {
                        lugar.getNamePlace(),
                        lugar.getEmail(),
                        lugar.getPhoneNumber(),
                        numPlaceLists,
                        puntaje,
                        likes
                    };
                    model.addRow(registro);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ordenarPorPuntaje() {
        try {
            // Obtener todos los lugares
            List<Place> lugares = placeDAO.getAllPlaces();

            // Ordenar los lugares según la puntuación promedio de manera descendente
            lugares.sort((lugar1, lugar2) -> {
                try {
                    float puntaje1 = reviewDAO.getAverageRatingForPlace(lugar1.getIdPlace());
                    float puntaje2 = reviewDAO.getAverageRatingForPlace(lugar2.getIdPlace());
                    return Float.compare(puntaje2, puntaje1); // Cambio para ordenar de mayor a menor
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0; // En caso de error, no cambiar el orden relativo
                }
            });

            // Actualizar el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) jRestaurantes.getModel();
            model.setRowCount(0);

            // Añadir los datos ordenados al modelo de la tabla
            for (Place lugar : lugares) {
                try {
                    int numPlaceLists = content.countPlaceListsByPlace(lugar.getIdPlace());
                    int likes = favoritePlacesDAO.countLikesByPlace(lugar.getIdPlace());
                    float puntaje = reviewDAO.getAverageRatingForPlace(lugar.getIdPlace());
                    Object[] registro = {
                        lugar.getNamePlace(),
                        lugar.getEmail(),
                        lugar.getPhoneNumber(),
                        numPlaceLists,
                        puntaje,
                        likes
                    };
                    model.addRow(registro);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoLugares = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jRestaurantes = new javax.swing.JTable();
        jbtnMatch = new javax.swing.JButton();
        jbtnPuntuado = new javax.swing.JButton();
        jbtnPlaceList = new javax.swing.JButton();
        jbtnVerLugar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jbtnLikes = new javax.swing.JButton();

        fondoLugares.setBackground(new java.awt.Color(255, 255, 255));

        jRestaurantes.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jRestaurantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Email", "Telefono", "# PlaceList", "Puntuación", "Likes", "Match"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jRestaurantes.setGridColor(new java.awt.Color(255, 204, 153));
        jRestaurantes.setSelectionBackground(new java.awt.Color(255, 204, 153));
        jRestaurantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRestaurantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jRestaurantes);
        if (jRestaurantes.getColumnModel().getColumnCount() > 0) {
            jRestaurantes.getColumnModel().getColumn(2).setMaxWidth(400);
            jRestaurantes.getColumnModel().getColumn(3).setMaxWidth(100);
            jRestaurantes.getColumnModel().getColumn(4).setMaxWidth(100);
            jRestaurantes.getColumnModel().getColumn(5).setMaxWidth(100);
            jRestaurantes.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        jbtnMatch.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jbtnMatch.setForeground(new java.awt.Color(51, 0, 0));
        jbtnMatch.setText("Mayor Match");
        jbtnMatch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));

        jbtnPuntuado.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jbtnPuntuado.setForeground(new java.awt.Color(51, 0, 0));
        jbtnPuntuado.setText("Mejores Puntuados");
        jbtnPuntuado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));
        jbtnPuntuado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPuntuadoActionPerformed(evt);
            }
        });

        jbtnPlaceList.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jbtnPlaceList.setForeground(new java.awt.Color(51, 0, 0));
        jbtnPlaceList.setText("Más PlaceList");
        jbtnPlaceList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));
        jbtnPlaceList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPlaceListActionPerformed(evt);
            }
        });

        jbtnVerLugar.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jbtnVerLugar.setForeground(new java.awt.Color(51, 0, 0));
        jbtnVerLugar.setText("Ver Lugar");
        jbtnVerLugar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));
        jbtnVerLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVerLugarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Corbel", 1, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Elige la mejor opción y disfruta");

        jbtnLikes.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        jbtnLikes.setForeground(new java.awt.Color(51, 0, 0));
        jbtnLikes.setText("Más Likes");
        jbtnLikes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 0, 0)));
        jbtnLikes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLikesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoLugaresLayout = new javax.swing.GroupLayout(fondoLugares);
        fondoLugares.setLayout(fondoLugaresLayout);
        fondoLugaresLayout.setHorizontalGroup(
            fondoLugaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(fondoLugaresLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(fondoLugaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLugaresLayout.createSequentialGroup()
                        .addComponent(jbtnMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jbtnPuntuado, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jbtnPlaceList, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jbtnLikes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnVerLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(10, 10, 10))
        );
        fondoLugaresLayout.setVerticalGroup(
            fondoLugaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLugaresLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fondoLugaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnPuntuado, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(fondoLugaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnPlaceList, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnLikes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnVerLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoLugares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoLugares, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnPlaceListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPlaceListActionPerformed
        ordenarPorNumPlaceList();
    }//GEN-LAST:event_jbtnPlaceListActionPerformed

    private void jRestaurantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRestaurantesMouseClicked

    }//GEN-LAST:event_jRestaurantesMouseClicked

    private void jbtnVerLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVerLugarActionPerformed
        int selectedRow = jRestaurantes.getSelectedRow();

        // Verificar si se seleccionó una fila válida
        if (selectedRow != -1) {
            // Obtener el nombre del lugar desde la primera columna (columna 0)
            String selectedPlaceName = jRestaurantes.getValueAt(selectedRow, 0).toString();

            // Obtener el lugar utilizando el método getPlaceByName
            selectedPlace = placeDAO.getPlaceByName(selectedPlaceName);

            // Verificar si se encontró el lugar
            if (selectedPlace != null) {
                // El lugar se encontró, puedes usarlo como necesites
                System.out.println("Lugar seleccionado: " + selectedPlace.getNamePlace() + " " + selectedPlace.getEmail());

                ShowJPanel(new Lugar(selectedPlace.getNamePlace()));

            } else {
                // El lugar no se encontró, puedes manejar este caso según tus necesidades
                System.out.println("No se encontró el lugar seleccionado");
                // Por ejemplo, puedes mostrar un mensaje de error al usuario
            }
        }
    }//GEN-LAST:event_jbtnVerLugarActionPerformed

    private void jbtnLikesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLikesActionPerformed
        ordenarPorLikes();
    }//GEN-LAST:event_jbtnLikesActionPerformed

    private void jbtnPuntuadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPuntuadoActionPerformed
        ordenarPorPuntaje();
    }//GEN-LAST:event_jbtnPuntuadoActionPerformed

    public static void ShowJPanel(JPanel p) {
        p.setSize(1150, 647);
        p.setLocation(0, 0);

        fondoLugares.removeAll();
        fondoLugares.add(p, BorderLayout.CENTER);
        fondoLugares.revalidate();
        fondoLugares.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel fondoLugares;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTable jRestaurantes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnLikes;
    private javax.swing.JButton jbtnMatch;
    private javax.swing.JButton jbtnPlaceList;
    private javax.swing.JButton jbtnPuntuado;
    private javax.swing.JButton jbtnVerLugar;
    // End of variables declaration//GEN-END:variables
}
