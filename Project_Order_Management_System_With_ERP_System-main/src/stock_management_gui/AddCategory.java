/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package stock_management_gui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.event.KeyEvent;
import model.MySql;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Avishka
 */
public class AddCategory extends javax.swing.JFrame {

    /**
     * Creates new form AddCategory
     */
    public AddCategory() {
        initComponents();
        loadCategories();

    }

    // Load categories from the database
    private void loadCategories() {
        try {

            DefaultTableModel model = (DefaultTableModel) categoryTable.getModel();
            model.setRowCount(0);

            ResultSet resultSet = MySql.executeSearch("SELECT * FROM category");
            while (resultSet.next()) {
                int id = resultSet.getInt("category_id");
                String name = resultSet.getString("category_name");
                model.addRow(new Object[]{id, name});
            }
        } catch (Exception e) {

            e.printStackTrace();

        }
    }

//    private void addCategory() {
//
//        String categoryName = categoryTextField.getText();
//
//        if (categoryName.isEmpty()) {
//
//            JOptionPane.showMessageDialog(this, "Category name cannot be empty.");
//            return;
//
//        }
//
//        if (isCategoryExists(categoryName)) {
//
//            JOptionPane.showMessageDialog(this, "Category already exists.");
//            return;
//
//        }
//        
//        try {
//
//            String insertQuery = "INSERT INTO category (`category_name`) VALUES ('" + categoryName + "')";
//
//            MySql.executeUpdate(insertQuery);
//            
//            String resetQuery = "SET @num := 0; UPDATE category SET category_id = @num := (@num + 1); ALTER TABLE category AUTO_INCREMENT = 1;";
//
//            MySql.executeUpdate(resetQuery);
//            
//            JOptionPane.showMessageDialog(this, "Category added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
//
//            loadCategories();
//
//            reset();
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//        }
//    }
    // Check if category already exists in the database
    private boolean isCategoryExists(String categoryName) {

        try {

            String checkQuery = "SELECT * FROM category WHERE category_name = '" + categoryName + "'";
            ResultSet resultSet = MySql.executeSearch(checkQuery);
            return resultSet.next();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BackToDashboardPanel = new javax.swing.JPanel();
        BackToDashboardButton = new javax.swing.JButton();
        bodyPanel = new javax.swing.JPanel();
        addCategorySection = new javax.swing.JPanel();
        categoryLabel = new javax.swing.JLabel();
        categoryTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        addButton = new com.k33ptoo.components.KButton();
        categoryTablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(153, 153, 153));
        headerPanel.setPreferredSize(new java.awt.Dimension(720, 60));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Audiowide", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Category");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        getContentPane().add(headerPanel, java.awt.BorderLayout.PAGE_START);

        BackToDashboardPanel.setBackground(new java.awt.Color(153, 153, 153));
        BackToDashboardPanel.setPreferredSize(new java.awt.Dimension(50, 50));

        BackToDashboardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/back-arrow.png"))); // NOI18N
        BackToDashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToDashboardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackToDashboardPanelLayout = new javax.swing.GroupLayout(BackToDashboardPanel);
        BackToDashboardPanel.setLayout(BackToDashboardPanelLayout);
        BackToDashboardPanelLayout.setHorizontalGroup(
            BackToDashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackToDashboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackToDashboardButton)
                .addContainerGap(678, Short.MAX_VALUE))
        );
        BackToDashboardPanelLayout.setVerticalGroup(
            BackToDashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackToDashboardPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BackToDashboardButton)
                .addContainerGap())
        );

        getContentPane().add(BackToDashboardPanel, java.awt.BorderLayout.PAGE_END);

        bodyPanel.setLayout(new java.awt.BorderLayout());

        categoryLabel.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        categoryLabel.setText("Category");

        categoryTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                categoryTextFieldKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addButton.setkEndColor(new java.awt.Color(0, 204, 204));
        addButton.setkHoverEndColor(new java.awt.Color(0, 102, 153));
        addButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        addButton.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        addButton.setkPressedColor(new java.awt.Color(0, 102, 153));
        addButton.setkSelectedColor(new java.awt.Color(0, 102, 153));
        addButton.setkStartColor(new java.awt.Color(0, 102, 153));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addCategorySectionLayout = new javax.swing.GroupLayout(addCategorySection);
        addCategorySection.setLayout(addCategorySectionLayout);
        addCategorySectionLayout.setHorizontalGroup(
            addCategorySectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCategorySectionLayout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(categoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton1)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        addCategorySectionLayout.setVerticalGroup(
            addCategorySectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCategorySectionLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(addCategorySectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addCategorySectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(categoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        bodyPanel.add(addCategorySection, java.awt.BorderLayout.PAGE_START);

        categoryTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category ID", "Category Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        categoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(categoryTable);

        javax.swing.GroupLayout categoryTablePanelLayout = new javax.swing.GroupLayout(categoryTablePanel);
        categoryTablePanel.setLayout(categoryTablePanelLayout);
        categoryTablePanelLayout.setHorizontalGroup(
            categoryTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoryTablePanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );
        categoryTablePanelLayout.setVerticalGroup(
            categoryTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoryTablePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        bodyPanel.add(categoryTablePanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(bodyPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackToDashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToDashboardButtonActionPerformed
        
        dispose();
        
    }//GEN-LAST:event_BackToDashboardButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        reset();

    }//GEN-LAST:event_jButton1MouseClicked

    private void categoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryTableMouseClicked

        if (evt.getClickCount() == 2) {

            int row = categoryTable.getSelectedRow(); // Get the selected row from the table

            String category_ID = String.valueOf(categoryTable.getValueAt(row, 0));

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to delete this category?",
                    "Delete Category",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                try {

                    String deleteQuery = "DELETE FROM category WHERE category_id = " + category_ID;

                    MySql.executeUpdate(deleteQuery);  // Delete from database

                    MySql.executeUpdate("SET @num := 0");
                    
                    MySql.executeUpdate("UPDATE category SET category_id = @num := (@num + 1)");
                    
                    MySql.executeUpdate("ALTER TABLE category AUTO_INCREMENT = 1");

                    JOptionPane.showMessageDialog(this, "Category deleted successfully.");

                    loadCategories();

                } catch (Exception e) {

                    e.printStackTrace();

                }

            }

        }

    }//GEN-LAST:event_categoryTableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        String categoryName = categoryTextField.getText();

        if (categoryName.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Category name cannot be empty.");
            return;

        }

        // Check if category already exists
        if (isCategoryExists(categoryName)) {

            JOptionPane.showMessageDialog(this, "Category already exists.");
            return;

        }

        // Insert category into the database
        try {

            MySql.executeUpdate("SET @num := 0");

            MySql.executeUpdate("UPDATE category SET category_id = @num := (@num + 1)");

            MySql.executeUpdate("ALTER TABLE category AUTO_INCREMENT = 1");

            String insertQuery = "INSERT INTO category (`category_name`) VALUES ('" + categoryName + "')";

            MySql.executeUpdate(insertQuery);

            JOptionPane.showMessageDialog(this, "Category added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);

            loadCategories();

            reset();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }//GEN-LAST:event_addButtonActionPerformed

    private void categoryTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoryTextFieldKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            addButton.doClick();
            
        }
        
    }//GEN-LAST:event_categoryTextFieldKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCategory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToDashboardButton;
    private javax.swing.JPanel BackToDashboardPanel;
    private com.k33ptoo.components.KButton addButton;
    private javax.swing.JPanel addCategorySection;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JTable categoryTable;
    private javax.swing.JPanel categoryTablePanel;
    private javax.swing.JTextField categoryTextField;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void reset() {

        categoryTextField.setText("");

    }
}
