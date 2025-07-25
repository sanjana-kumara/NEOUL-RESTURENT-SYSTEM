/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package finance_department_gui;

import java.sql.ResultSet;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.util.HashMap;
import javax.swing.RowFilter;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.MySql;

/**
 *
 * @author sanja
 */
public class PayrollManagement extends javax.swing.JFrame {

    // Hashmap  for department
    private static HashMap<String, String> departmentMap = new HashMap<>();

    /**
     * Creates new form Payroll_Management
     */
    public PayrollManagement() {

        initComponents();

        LoadPayrollTable();

        loadDepartment();
        
        initializeRowSorter();

        SearchEmployeeTextField.grabFocus();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //load department type in to JComboBox
    public void loadDepartment() {

        try {

            ResultSet resultSet = MySql.executeSearch("SELECT * FROM `department`");

            Vector<String> vector = new Vector<>();
            vector.add("Select Department");

            while (resultSet.next()) {
                vector.add(resultSet.getString("department_name"));

                departmentMap.put(resultSet.getString("department_name"), resultSet.getString("department_id"));

            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            SelectDepartmentComboBox.setModel(model);

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    private DefaultTableModel tablemodel;
    private DefaultComboBoxModel model;

    //Viwe data form the table
    private void LoadPayrollTable() {

        try {

            ResultSet resultSet = MySql.executeSearch("SELECT * FROM `basic_salary` INNER JOIN `employee` ON"
                    + " `employee`.`employee_id` = `basic_salary`.`employee_employee_id` INNER JOIN `department` "
                    + "ON `department`.`department_id` = `basic_salary`.`department_department_id` INNER JOIN `employee_position` "
                    + "ON `employee_position`.`employee_position_id` = `basic_salary`.`employee_position_employee_position_id` ");

            DefaultTableModel PayrolldefaultTableModel = (DefaultTableModel) PayrollManagementTable.getModel();
            PayrolldefaultTableModel.setRowCount(0);

            while (resultSet.next()) {

                Vector<String> vector = new Vector<>();

                vector.add(resultSet.getString("basic_id"));
                vector.add(resultSet.getString("employee_employee_id"));
                vector.add(resultSet.getString("employee_name"));
                vector.add(resultSet.getString("department.department_name"));
                vector.add(resultSet.getString("employee_position.position_name"));
                vector.add(resultSet.getString("basic"));

                PayrolldefaultTableModel.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private TableRowSorter<DefaultTableModel> rowSorter;

    private void initializeRowSorter() {

        // get ManageEmployeeTable as DefaultTableModel
        tablemodel = (DefaultTableModel) PayrollManagementTable.getModel();

        // create new row sorter to tablemodel
        rowSorter = new TableRowSorter<>(tablemodel);

        // add row sorter to table
        PayrollManagementTable.setRowSorter(rowSorter);

    }

    private void filterTableByDepartment() {

        // variable for get combobox selected item
        String selectedDepartment = (String) SelectDepartmentComboBox.getSelectedItem();

        // checks string value null or default
        if (selectedDepartment == null || selectedDepartment.equals("Select Department")) {

            // Show all rows if "Select Department" is chosen
            rowSorter.setRowFilter(null);

            return;

        }

        rowSorter.setRowFilter(RowFilter.regexFilter(selectedDepartment, 3));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeaderPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BodyPanel = new javax.swing.JPanel();
        SearchPanel = new javax.swing.JPanel();
        SearchEmployeeTextField = new javax.swing.JTextField();
        RefreshButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        searchButton = new com.k33ptoo.components.KButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        kButton1 = new com.k33ptoo.components.KButton();
        ViewPanel = new javax.swing.JPanel();
        BackToDashboardPanel = new javax.swing.JPanel();
        BackToDashboardButton = new javax.swing.JButton();
        TableViewPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PayrollManagementTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        SelectDepartmentComboBox = new javax.swing.JComboBox<>();
        ViewPayrollDetails = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        HeaderPanel.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Audiowide", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Payroll Management");

        javax.swing.GroupLayout HeaderPanelLayout = new javax.swing.GroupLayout(HeaderPanel);
        HeaderPanel.setLayout(HeaderPanelLayout);
        HeaderPanelLayout.setHorizontalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
        );
        HeaderPanelLayout.setVerticalGroup(
            HeaderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        getContentPane().add(HeaderPanel, java.awt.BorderLayout.PAGE_START);

        BodyPanel.setLayout(new java.awt.BorderLayout());

        SearchPanel.setPreferredSize(new java.awt.Dimension(855, 150));

        SearchEmployeeTextField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        SearchEmployeeTextField.setPreferredSize(new java.awt.Dimension(64, 32));
        SearchEmployeeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchEmployeeTextFieldActionPerformed(evt);
            }
        });

        RefreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/refresh.png"))); // NOI18N
        RefreshButton.setToolTipText("");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel3.setText("Enter Employee ID");

        searchButton.setText("Search");
        searchButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        searchButton.setkEndColor(new java.awt.Color(0, 204, 204));
        searchButton.setkHoverEndColor(new java.awt.Color(0, 102, 153));
        searchButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        searchButton.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        searchButton.setkPressedColor(new java.awt.Color(0, 102, 153));
        searchButton.setkSelectedColor(new java.awt.Color(0, 102, 153));
        searchButton.setkStartColor(new java.awt.Color(0, 102, 153));
        searchButton.setPreferredSize(new java.awt.Dimension(185, 32));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel6.setText("Basic Salary");

        kButton1.setText("Add");
        kButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kButton1.setkEndColor(new java.awt.Color(0, 204, 204));
        kButton1.setkHoverEndColor(new java.awt.Color(0, 102, 153));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        kButton1.setkPressedColor(new java.awt.Color(0, 102, 153));
        kButton1.setkSelectedColor(new java.awt.Color(0, 102, 153));
        kButton1.setkStartColor(new java.awt.Color(0, 102, 153));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchPanelLayout = new javax.swing.GroupLayout(SearchPanel);
        SearchPanel.setLayout(SearchPanelLayout);
        SearchPanelLayout.setHorizontalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchPanelLayout.createSequentialGroup()
                .addContainerGap(131, Short.MAX_VALUE)
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(12, 12, 12)
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(SearchPanelLayout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addComponent(SearchEmployeeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(RefreshButton)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        SearchPanelLayout.setVerticalGroup(
            SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(RefreshButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchEmployeeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(SearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BodyPanel.add(SearchPanel, java.awt.BorderLayout.PAGE_START);

        ViewPanel.setLayout(new java.awt.BorderLayout());

        BackToDashboardPanel.setBackground(new java.awt.Color(153, 153, 153));
        BackToDashboardPanel.setAutoscrolls(true);
        BackToDashboardPanel.setPreferredSize(new java.awt.Dimension(855, 50));

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
                .addContainerGap(882, Short.MAX_VALUE))
        );
        BackToDashboardPanelLayout.setVerticalGroup(
            BackToDashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackToDashboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackToDashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ViewPanel.add(BackToDashboardPanel, java.awt.BorderLayout.PAGE_END);

        PayrollManagementTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Employee ID", "Employee Name", "Department", "Position", "Basic"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        PayrollManagementTable.getTableHeader().setReorderingAllowed(false);
        PayrollManagementTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PayrollManagementTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(PayrollManagementTable);

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel4.setText("Select Department");

        SelectDepartmentComboBox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        SelectDepartmentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Department", "HR Department", "Finance Department", "Product Department" }));
        SelectDepartmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectDepartmentComboBoxActionPerformed(evt);
            }
        });

        ViewPayrollDetails.setText("View Payroll Details");
        ViewPayrollDetails.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ViewPayrollDetails.setkEndColor(new java.awt.Color(0, 204, 204));
        ViewPayrollDetails.setkHoverEndColor(new java.awt.Color(0, 102, 153));
        ViewPayrollDetails.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        ViewPayrollDetails.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        ViewPayrollDetails.setkPressedColor(new java.awt.Color(0, 102, 153));
        ViewPayrollDetails.setkSelectedColor(new java.awt.Color(0, 102, 153));
        ViewPayrollDetails.setkStartColor(new java.awt.Color(0, 102, 153));
        ViewPayrollDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewPayrollDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TableViewPanelLayout = new javax.swing.GroupLayout(TableViewPanel);
        TableViewPanel.setLayout(TableViewPanelLayout);
        TableViewPanelLayout.setHorizontalGroup(
            TableViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TableViewPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1)
                .addGap(25, 25, 25))
            .addGroup(TableViewPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(SelectDepartmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 350, Short.MAX_VALUE)
                .addComponent(ViewPayrollDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        TableViewPanelLayout.setVerticalGroup(
            TableViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TableViewPanelLayout.createSequentialGroup()
                .addGroup(TableViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectDepartmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TableViewPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(ViewPayrollDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        ViewPanel.add(TableViewPanel, java.awt.BorderLayout.CENTER);

        BodyPanel.add(ViewPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(BodyPanel, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackToDashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToDashboardButtonActionPerformed

        dispose();

    }//GEN-LAST:event_BackToDashboardButtonActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed

        String basicSalary = jTextField1.getText();

        //.replace(",", "").trim()
        String empId = SearchEmployeeTextField.getText();

        // Validate the input to ensure it's not empty or non-numeric
        if (basicSalary.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please enter a valid salary.", "Error", JOptionPane.ERROR_MESSAGE);

        } else if (empId.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please enter a valid Employee ID.", "Error", JOptionPane.ERROR_MESSAGE);

        } else {

            try {

                ResultSet rs = MySql.executeSearch("SELECT *FROM `basic_salary` WHERE `employee_employee_id` = '" + empId + "' ");

                if (rs.next()) {

                    JOptionPane.showMessageDialog(this, "Already added basic", "Warning", JOptionPane.WARNING_MESSAGE);

                } else {

                    ResultSet nrs = MySql.executeSearch("SELECT * FROM `employee` INNER JOIN `department` "
                            + "ON `department`.`department_id` = `employee`.`department_department_id` INNER JOIN `employee_position`"
                            + " ON `employee_position`.`employee_position_id` = `employee`.`employee_position_employee_position_id` WHERE `employee_id` = '" + empId + "' ");

                    if (nrs.next()) {

                        String fullName = nrs.getString("first_name") + " " + nrs.getString("last_name");

                        String department = nrs.getString("department.department_name");

                        String position = nrs.getString("employee_position.employee_position_id");

                        //double salary = Double.parseDouble(basicSalary);
                        // Construct the SQL insert query to add the basic salary
                        MySql.executeUpdate("INSERT INTO `basic_salary` (`employee_employee_id`,`employee_name`,`department_department_id` ,`employee_position_employee_position_id`,`basic`) "
                                + "VALUES ( '" + empId + "' , '" + fullName + "' , '" + departmentMap.get(department) + "', '" + position + "', '" + basicSalary + "')");

                        LoadPayrollTable();

                        // Show success message
                        JOptionPane.showMessageDialog(this, "Payroll Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                        reset();

                    }

                }

            } catch (Exception e) {
                // Handle any other errors
                e.printStackTrace();

                JOptionPane.showMessageDialog(this, "An error occurred while adding the payroll.", "Error", JOptionPane.ERROR_MESSAGE);

            }

        }


    }//GEN-LAST:event_kButton1ActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        reset();
    }//GEN-LAST:event_RefreshButtonActionPerformed

    private void SearchEmployeeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchEmployeeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchEmployeeTextFieldActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // Capture the input from the text field
        String employeeID = SearchEmployeeTextField.getText().trim();

        if (employeeID.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Please enter an employee ID to search.", "Warning", JOptionPane.WARNING_MESSAGE);

            return;

        }

        try {
            // Query the database for the employee
            String query = "SELECT * FROM employee INNER JOIN `department` "
                    + "ON `department`.`department_id` = `employee`.`department_department_id` INNER JOIN "
                    + "`employee_position` ON `employee_position`.`employee_position_id` = `employee`.`employee_position_employee_position_id`"
                    + "  WHERE `employee_id` = '" + employeeID + "' ";

            ResultSet resultSet = MySql.executeSearch(query);

            if (resultSet.next()) {
                // Display the employee details in a popup
                String employeeDetails = "Employee ID: " + resultSet.getString("employee_id")
                        + "\nFirst Name: " + resultSet.getString("employee.first_name")
                        + "\nLast Name: " + resultSet.getString("employee.last_name")
                        + "\nDepartment: " + resultSet.getString("department.department_name")
                        + "\nPosition: " + resultSet.getString("employee_position.position_name");

                int choice = JOptionPane.showConfirmDialog(this, employeeDetails + "\n\nIs this the correct employee?", "Employee Details", JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    // Navigate to the next step (e.g., adding a basic salary)
                    String employeeId = resultSet.getString("employee_id");

                }
            } else {
                JOptionPane.showMessageDialog(this, "No employee found with the \"" + employeeID + "\".", "Not Found", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {

            e.printStackTrace();

        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void PayrollManagementTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PayrollManagementTableMouseClicked

        // Check if it's a double-click
        if (evt.getClickCount() == 2) {
            int selectedRow = PayrollManagementTable.getSelectedRow();

            if (selectedRow != -1) {
                // Optional: Get ID or other details from selected row
                String Empname = PayrollManagementTable.getValueAt(selectedRow, 2).toString();

                String Empposition = PayrollManagementTable.getValueAt(selectedRow, 4).toString();

                String Empdepartment = PayrollManagementTable.getValueAt(selectedRow, 3).toString();

                String Empid = PayrollManagementTable.getValueAt(selectedRow, 1).toString();

                String Empbasicsalary = PayrollManagementTable.getValueAt(selectedRow, 5).toString();

                // Create and show the JDialog
                PayrollDetailes dialog = new PayrollDetailes(this, true); // 'this' is parent frame, true = modal

                // Optional: Pass selected ID or data to JDialog
                dialog.loadEmpname(Empname, Empposition, Empdepartment, Empid, Empbasicsalary); // If you have such a method

                dialog.loadPayrollDataToTable();

                dialog.setLocationRelativeTo(this);
                dialog.setVisible(true);
            }
        }

    }//GEN-LAST:event_PayrollManagementTableMouseClicked

    private void ViewPayrollDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewPayrollDetailsActionPerformed

        PayrollDetailes payrollDetailes = new PayrollDetailes(this, rootPaneCheckingEnabled);
        payrollDetailes.setVisible(true);

    }//GEN-LAST:event_ViewPayrollDetailsActionPerformed

    private void SelectDepartmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectDepartmentComboBoxActionPerformed

        filterTableByDepartment();        

    }//GEN-LAST:event_SelectDepartmentComboBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PayrollManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToDashboardButton;
    private javax.swing.JPanel BackToDashboardPanel;
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JTable PayrollManagementTable;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JTextField SearchEmployeeTextField;
    private javax.swing.JPanel SearchPanel;
    private javax.swing.JComboBox<String> SelectDepartmentComboBox;
    private javax.swing.JPanel TableViewPanel;
    private javax.swing.JPanel ViewPanel;
    private com.k33ptoo.components.KButton ViewPayrollDetails;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton searchButton;
    // End of variables declaration//GEN-END:variables

    private void reset() {

        PayrollManagementTable.clearSelection();
        jTextField1.setText("");
        SearchEmployeeTextField.setText("");
        SearchEmployeeTextField.grabFocus();
        SelectDepartmentComboBox.setSelectedIndex(0);

    }

}
