/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package finance_department_gui;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Color;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Vector;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySql;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author GOLDEN FIELD
 */
public class AddExpences extends javax.swing.JFrame {

    // HashMap to store expences types and their IDs 
    private static HashMap<String, String> ExpencesTypesMap = new HashMap<>();

    /**
     * Creates new form AddExpences
     */
    public AddExpences() {
        initComponents();
        addPlaceholder(); //add textfield plcaeholder
        loadExpences();
        loadExpencesTypes();
    }

    //addplaceholder method
    private void addPlaceholder() {

        //Price Textfield placeholder and color
        ExpencesPriceTextField.setText("Enter Price");
        ExpencesPriceTextField.setForeground(Color.GRAY);
    }

    // Load expences types into the combo box
    private void loadExpencesTypes() {
        try {

            // Execute an SQL query to fetch all records from the "company_expences_types" table
            ResultSet resultSet = MySql.executeSearch("SELECT * FROM `company_expences_type` ");
            Vector<String> vector = new Vector<>();
            vector.add("Select Expences Type");// Placeholder item in combobox

            while (resultSet.next()) {
                vector.add(resultSet.getString("expences_type_name"));// Add type name to the vector
                ExpencesTypesMap.put(resultSet.getString("expences_type_name"), resultSet.getString("company_expences_type_id"));// Map type name to ID
            }

            // Show the combo box with expences types
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            ExpencesSelectComboBox.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //load to Expences into table
    private void loadExpences() {
        try {

            //Get data from databse table 
            ResultSet resultSet = MySql.executeSearch("SELECT * FROM `company_expences` "
                    + "INNER JOIN `company_expences_type` ON `company_expences` .`company_expences_type_company_expences_type_id`= `company_expences_type`.`company_expences_type_id`");

            //Clear existing rows
            DefaultTableModel model = (DefaultTableModel) ExpencesTable.getModel();
            model.setRowCount(0);

            //Show in the table
            while (resultSet.next()) {

                Vector<String> vector = new Vector<>();
                vector.add(resultSet.getString("company_expences_id"));
                vector.add(resultSet.getString("date"));
                vector.add(resultSet.getString("expences_type_name"));
                vector.add(resultSet.getString("price"));

                //Add the row to the table
                model.addRow(vector);

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

        headerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bodyPanel = new javax.swing.JPanel();
        ExpencesAddingPanel = new javax.swing.JPanel();
        ExpencesSelectComboBox = new javax.swing.JComboBox<>();
        DateChooser = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ExpencesPriceTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        addExpencesButton = new com.k33ptoo.components.KButton();
        updateExpencesButton = new com.k33ptoo.components.KButton();
        addButton = new com.k33ptoo.components.KButton();
        refreshButton = new javax.swing.JButton();
        BackToDashboardPanel = new javax.swing.JPanel();
        BackToDashboardButton = new javax.swing.JButton();
        printReportButton = new com.k33ptoo.components.KButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ExpencesTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        headerPanel.setBackground(new java.awt.Color(153, 153, 153));
        headerPanel.setPreferredSize(new java.awt.Dimension(714, 60));

        jLabel1.setFont(new java.awt.Font("Audiowide", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Expences");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        getContentPane().add(headerPanel, java.awt.BorderLayout.PAGE_START);

        bodyPanel.setLayout(new java.awt.BorderLayout());

        ExpencesAddingPanel.setPreferredSize(new java.awt.Dimension(695, 200));

        ExpencesSelectComboBox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ExpencesSelectComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ExpencesSelectComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ExpencesSelectComboBoxKeyPressed(evt);
            }
        });

        DateChooser.setDateFormatString("yyyy-MM-dd");
        DateChooser.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DateChooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DateChooserKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel2.setText("Select Date");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel3.setText("Expences Price");

        ExpencesPriceTextField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        ExpencesPriceTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ExpencesPriceTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ExpencesPriceTextFieldFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel4.setText("Select Type");

        addExpencesButton.setText("Add Expences");
        addExpencesButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addExpencesButton.setkEndColor(new java.awt.Color(0, 204, 204));
        addExpencesButton.setkHoverEndColor(new java.awt.Color(0, 102, 153));
        addExpencesButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        addExpencesButton.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        addExpencesButton.setkPressedColor(new java.awt.Color(0, 102, 153));
        addExpencesButton.setkSelectedColor(new java.awt.Color(0, 102, 153));
        addExpencesButton.setkStartColor(new java.awt.Color(0, 102, 153));
        addExpencesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExpencesButtonActionPerformed(evt);
            }
        });

        updateExpencesButton.setText("Update Expences");
        updateExpencesButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updateExpencesButton.setkEndColor(new java.awt.Color(0, 204, 204));
        updateExpencesButton.setkHoverEndColor(new java.awt.Color(0, 102, 153));
        updateExpencesButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        updateExpencesButton.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        updateExpencesButton.setkPressedColor(new java.awt.Color(0, 102, 153));
        updateExpencesButton.setkSelectedColor(new java.awt.Color(0, 102, 153));
        updateExpencesButton.setkStartColor(new java.awt.Color(0, 102, 153));
        updateExpencesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateExpencesButtonActionPerformed(evt);
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

        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh.png"))); // NOI18N
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ExpencesAddingPanelLayout = new javax.swing.GroupLayout(ExpencesAddingPanel);
        ExpencesAddingPanel.setLayout(ExpencesAddingPanelLayout);
        ExpencesAddingPanelLayout.setHorizontalGroup(
            ExpencesAddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(ExpencesAddingPanelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(ExpencesAddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpencesAddingPanelLayout.createSequentialGroup()
                        .addGroup(ExpencesAddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(12, 12, 12)
                        .addGroup(ExpencesAddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ExpencesPriceTextField)
                            .addComponent(ExpencesSelectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ExpencesAddingPanelLayout.createSequentialGroup()
                        .addComponent(addExpencesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(updateExpencesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(refreshButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        ExpencesAddingPanelLayout.setVerticalGroup(
            ExpencesAddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExpencesAddingPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(ExpencesAddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ExpencesAddingPanelLayout.createSequentialGroup()
                        .addGroup(ExpencesAddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ExpencesAddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ExpencesSelectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(ExpencesAddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ExpencesPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ExpencesAddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(ExpencesAddingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addExpencesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateExpencesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        bodyPanel.add(ExpencesAddingPanel, java.awt.BorderLayout.PAGE_START);

        BackToDashboardPanel.setBackground(new java.awt.Color(153, 153, 153));
        BackToDashboardPanel.setPreferredSize(new java.awt.Dimension(714, 50));

        BackToDashboardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/back-arrow.png"))); // NOI18N
        BackToDashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToDashboardButtonActionPerformed(evt);
            }
        });

        printReportButton.setText("Print Report");
        printReportButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        printReportButton.setkEndColor(new java.awt.Color(0, 204, 204));
        printReportButton.setkHoverEndColor(new java.awt.Color(0, 102, 153));
        printReportButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        printReportButton.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        printReportButton.setkPressedColor(new java.awt.Color(0, 102, 153));
        printReportButton.setkSelectedColor(new java.awt.Color(0, 102, 153));
        printReportButton.setkStartColor(new java.awt.Color(0, 102, 153));
        printReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printReportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackToDashboardPanelLayout = new javax.swing.GroupLayout(BackToDashboardPanel);
        BackToDashboardPanel.setLayout(BackToDashboardPanelLayout);
        BackToDashboardPanelLayout.setHorizontalGroup(
            BackToDashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackToDashboardPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(BackToDashboardButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 719, Short.MAX_VALUE)
                .addComponent(printReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        BackToDashboardPanelLayout.setVerticalGroup(
            BackToDashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackToDashboardPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(BackToDashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(printReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackToDashboardButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bodyPanel.add(BackToDashboardPanel, java.awt.BorderLayout.PAGE_END);

        ExpencesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Expences ID", "Date", "Type of Expences", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ExpencesTable.getTableHeader().setReorderingAllowed(false);
        ExpencesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExpencesTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(ExpencesTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        bodyPanel.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(bodyPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //signOut Button

    private void BackToDashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToDashboardButtonActionPerformed

        dispose();
        
    }//GEN-LAST:event_BackToDashboardButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        reset(); //refresh the frame
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void ExpencesPriceTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ExpencesPriceTextFieldFocusGained

        //check and set clear the current price textfield to enter data
        if (ExpencesPriceTextField.getText().equals("Enter Price")) {
            ExpencesPriceTextField.setText("");
            ExpencesPriceTextField.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_ExpencesPriceTextFieldFocusGained

    private void ExpencesPriceTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ExpencesPriceTextFieldFocusLost

        //set back the placeholder
        if (ExpencesPriceTextField.getText().isEmpty()) {
            ExpencesPriceTextField.setText("Enter Price");
            ExpencesPriceTextField.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_ExpencesPriceTextFieldFocusLost

    ////AddExpencesTypes frame open button in the current frame
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        
        AddExpencesTypes types = new AddExpencesTypes();
        types.setVisible(true); // Set the AddExpencesTypes GUI to be visible
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void ExpencesSelectComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ExpencesSelectComboBoxKeyPressed
        //Press Enter will then focus on textfield from combobox
        if (evt.getKeyCode() == 10) {
            DateChooser.grabFocus();
        }

    }//GEN-LAST:event_ExpencesSelectComboBoxKeyPressed

    private void DateChooserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DateChooserKeyPressed
        ExpencesPriceTextField.grabFocus();
    }//GEN-LAST:event_DateChooserKeyPressed

    private void addExpencesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExpencesButtonActionPerformed
        try {

            // Get input values
            String price = ExpencesPriceTextField.getText(); //Select price textfield
            String expencestype = String.valueOf(ExpencesSelectComboBox.getSelectedItem());
            Date DateChoose = DateChooser.getDate();//Select datechooser

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Validate expences type selection
            if (expencestype.equals("Select Expences Type")) {
                // Check if the user has selected a type
                JOptionPane.showMessageDialog(this, "Please select a Type", "Warning", JOptionPane.WARNING_MESSAGE);

                // Check if price is empty
            } else if (price.isEmpty() || price.equals("Enter Price")) {

                JOptionPane.showMessageDialog(this, "Please enter Price", "Warning", JOptionPane.WARNING_MESSAGE);

            } else {

                try {
                    double parsedPrice = Double.parseDouble(price); // Check if the price is a valid number
                    if (parsedPrice <= 0) {
                        JOptionPane.showMessageDialog(this, "Price must be a positive value", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Price must be a valid numeric value", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                //Validate Date
                if (DateChoose == null) {
                    JOptionPane.showMessageDialog(this, "Please select a Date", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    String date = dateFormat.format(DateChoose);

                    // Reset AUTO_INCREMENT value
                    MySql.executeUpdate("ALTER TABLE `company_expences` AUTO_INCREMENT = 1");

                    //Insert new expence
                    MySql.executeUpdate("INSERT INTO `company_expences` (`date`,`company_expences_type_company_expences_type_id`,`price`) VALUES ('" + date + "','" + ExpencesTypesMap.get(expencestype) + "','" + price + "')");

                    //load to table
                    loadExpences();
                    reset();// Clear the text field for the next entry

                    //focus on the type combobox again aftr adding the expence
                    ExpencesSelectComboBox.grabFocus();

                    //success message
                    JOptionPane.showMessageDialog(this, "Expences Added Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while adding the Expences", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_addExpencesButtonActionPerformed

    private void ExpencesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpencesTableMouseClicked
        // Get the index of the selected row in the table
        int row = ExpencesTable.getSelectedRow();

        if (row == -1) {

            JOptionPane.showMessageDialog(this, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            // Display the price of the selected row in the text field
            ExpencesPriceTextField.setText(String.valueOf(ExpencesTable.getValueAt(row, 3)));
            ExpencesSelectComboBox.setSelectedItem(ExpencesTable.getValueAt(row, 2));

            // Retrieve and parse the date string
            String dateChoose = String.valueOf(ExpencesTable.getValueAt(row, 1));
            try {
                //Set the parsed date into the DateChooser
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date = sdf.parse(dateChoose);
                DateChooser.setDate(date);

            } catch (ParseException e) {

                e.printStackTrace();

                JOptionPane.showMessageDialog(this, "Invalid date format in the table!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Disable the Add button while deleting
            addExpencesButton.setEnabled(false);

            // Check if the user double-clicked on a row
            if (evt.getClickCount() == 2) {

                String selectedExpencesID = String.valueOf(ExpencesTable.getValueAt(row, 0));

                // Asking to confirm before the deletion
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this Expence?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

                //If user confirms the deletion
                if (confirm == JOptionPane.YES_OPTION) {

                    try {

                        //Delete from database
                        MySql.executeUpdate("DELETE FROM `company_expences` WHERE `company_expences_id`='" + selectedExpencesID + "' ");

                        // Renumber remaining rows
                        MySql.executeUpdate("SET @row_number = 0");
                        MySql.executeUpdate("UPDATE `company_expences` "
                                + "SET `company_expences_id` = (@row_number := @row_number + 1) "
                                + "ORDER BY `company_expences_id`");

                        // Reset AUTO_INCREMENT value
                        MySql.executeUpdate("ALTER TABLE `company_expences` AUTO_INCREMENT = 1");

                        // Reload the jtable table 
                        loadExpences();
                        reset(); // Clear the text field for the next entry

                        //Success message
                        JOptionPane.showMessageDialog(this, "Expence Deleted Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

                    } catch (Exception e) {

                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Error occurred while deleting the Expence", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }

        }

    }//GEN-LAST:event_ExpencesTableMouseClicked

    //Update Button Function
    private void updateExpencesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateExpencesButtonActionPerformed
        int row = ExpencesTable.getSelectedRow(); // Get the selected row from JTable

        // Check if no row is selected
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please Select a Row", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Get input values
        String price = ExpencesPriceTextField.getText();
        String expencestype = String.valueOf(ExpencesSelectComboBox.getSelectedItem());
        Date DateChoose = DateChooser.getDate();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Get data from the selected row
        String selectedExpencesid = String.valueOf(ExpencesTable.getValueAt(row, 0));
        String existingType = String.valueOf(ExpencesTable.getValueAt(row, 2));
        String existingPrice = String.valueOf(ExpencesTable.getValueAt(row, 3));
        String existingDate = String.valueOf(ExpencesTable.getValueAt(row, 1));

        // Validate input fields
        if (expencestype.equals("Select Expences Type")) {
            JOptionPane.showMessageDialog(this, "Please select a Type", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (price.isEmpty() || price.equals("Enter Price")) {
            JOptionPane.showMessageDialog(this, "Please enter Price", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double parsedPrice = Double.parseDouble(price);
            if (parsedPrice <= 0) {
                JOptionPane.showMessageDialog(this, "Price must be a positive value", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Price must be a valid numeric value", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (DateChoose == null) {
            JOptionPane.showMessageDialog(this, "Please select a Date", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Format the selected date
        String newDate = dateFormat.format(DateChoose);

        // Check if any changes have been made
        if (existingType.equals(expencestype) && existingPrice.equals(price) && existingDate.equals(newDate)) {
            JOptionPane.showMessageDialog(this, "No changes detected to update", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Proceed with the update
        try {
            MySql.executeUpdate("UPDATE `company_expences` SET "
                    + "`company_expences_type_company_expences_type_id` = '" + ExpencesTypesMap.get(expencestype) + "', "
                    + "`date` = '" + newDate + "', "
                    + "`price` = '" + price + "' "
                    + "WHERE `company_expences_id` = '" + selectedExpencesid + "'");

            // Reload the table and reset the form
            loadExpences();
            reset();

            JOptionPane.showMessageDialog(this, "Expences Updated Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {

            e.printStackTrace();

            JOptionPane.showMessageDialog(this, "Error occurred while updating the Expences", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateExpencesButtonActionPerformed

    private void printReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printReportButtonActionPerformed
try {
            // Path to the compiled Jasper report
            String reportPath = "src/report/Add_Expences.jasper";

            // Create parameters map (if needed)
            HashMap<String, Object> parameters = new HashMap<>();

            // Create data source from JTable model
            JRTableModelDataSource dataSource = new JRTableModelDataSource(ExpencesTable.getModel());

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, parameters, dataSource);

            // Show the report in viewer
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error generating report: " + e.getMessage(), "Report Error", JOptionPane.ERROR_MESSAGE);
        }       
    }//GEN-LAST:event_printReportButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddExpences().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToDashboardButton;
    private javax.swing.JPanel BackToDashboardPanel;
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JPanel ExpencesAddingPanel;
    private javax.swing.JTextField ExpencesPriceTextField;
    private javax.swing.JComboBox<String> ExpencesSelectComboBox;
    private javax.swing.JTable ExpencesTable;
    private com.k33ptoo.components.KButton addButton;
    private com.k33ptoo.components.KButton addExpencesButton;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private com.k33ptoo.components.KButton printReportButton;
    private javax.swing.JButton refreshButton;
    private com.k33ptoo.components.KButton updateExpencesButton;
    // End of variables declaration//GEN-END:variables

    // Function to reset the input fields and table selection
    private void reset() {

        ExpencesPriceTextField.setText("");
        DateChooser.setDate(null);
        addExpencesButton.setEnabled(true);
        ExpencesSelectComboBox.setSelectedIndex(0);
        ExpencesTable.clearSelection();

        //Re-add the placeholder to refreshed textfield
        addPlaceholder();
    }
}
