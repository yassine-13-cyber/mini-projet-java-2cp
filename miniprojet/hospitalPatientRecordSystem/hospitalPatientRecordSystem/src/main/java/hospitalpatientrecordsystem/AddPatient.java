/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hospitalpatientrecordsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 *
 * @author yassine
 */
public class AddPatient extends javax.swing.JFrame {
    
    
    // Panels for different patient types
    private JPanel emergencyPanel;
    private JPanel inpatientPanel;
    private JPanel outpatientPanel;
    
    // Emergency fields
    private JLabel severityLabel;
    private JComboBox<String> severityLevelInput;
    private JLabel emergencyCostLabel;
    private JTextField emergencyCostInput;
    
    // Inpatient fields
    private JLabel roomNumberLabel;
    private JTextField roomNumberInput;
    private JLabel admissionDateLabel;
    private JTextField admissionDateInput;
    private JLabel dailyChargeLabel;
    private JTextField dailyChargeInput;
    private JLabel daysAdmittedLabel;
    private JTextField daysAdmittedInput;
    
    // Outpatient fields
    private JLabel appointmentDateLabel;
    private JTextField appointmentDateInput;
    private JLabel consultationFeeLabel;
    private JTextField consultationFeeInput;
    
    
    
    List<HospitalBlock> hospitalBlocks;
    List<Patient> patientList;
    private HospitalPatientRecordManager parentFrame; // Add this line
    
    // Update the constructor to accept the parent frame
    public AddPatient(HospitalPatientRecordManager parentFrame) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.patientList = parentFrame.patientList;
        this.hospitalBlocks = parentFrame.hospital.getBlocks();
        this.parentFrame = parentFrame;
        initializeBlockComboBox();
        createDynamicPanels();
        setupCheckBoxListeners();
    }
    private void initializeBlockComboBox() {
        DefaultComboBoxModel<HospitalBlock> model = new DefaultComboBoxModel<>();
        for (HospitalBlock block : hospitalBlocks) {
            model.addElement(block);
        }
        blockComboBoxx.setModel(model);
        
        blockComboBoxx.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, 
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof HospitalBlock) {
                    setText(((HospitalBlock)value).getBlockName());
                }
                return this;
            }
        });
    }
    
    private void createDynamicPanels() {
        // Create dynamic panels for each patient type
        emergencyPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inpatientPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        outpatientPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        
        // Emergency panel components
        severityLabel = new JLabel("Severity Level:");
        severityLevelInput = new JComboBox<>(new String[]{"Low", "Medium", "High", "Critical"});
        emergencyCostLabel = new JLabel("Treatment Cost:");
        emergencyCostInput = new JTextField();
        
        emergencyPanel.add(severityLabel);
        emergencyPanel.add(severityLevelInput);
        emergencyPanel.add(emergencyCostLabel);
        emergencyPanel.add(emergencyCostInput);
        
        // Inpatient panel components
        roomNumberLabel = new JLabel("Room Number:");
        roomNumberInput = new JTextField();
        admissionDateLabel = new JLabel("Admission Date:");
        admissionDateInput = new JTextField();
        dailyChargeLabel = new JLabel("Daily Charge:");
        dailyChargeInput = new JTextField();
        daysAdmittedLabel = new JLabel("Days Admitted:");
        daysAdmittedInput = new JTextField();
        
        inpatientPanel.add(roomNumberLabel);
        inpatientPanel.add(roomNumberInput);
        inpatientPanel.add(admissionDateLabel);
        inpatientPanel.add(admissionDateInput);
        inpatientPanel.add(dailyChargeLabel);
        inpatientPanel.add(dailyChargeInput);
        inpatientPanel.add(daysAdmittedLabel);
        inpatientPanel.add(daysAdmittedInput);
        
        // Outpatient panel components
        appointmentDateLabel = new JLabel("Appointment Date:");
        appointmentDateInput = new JTextField();
        consultationFeeLabel = new JLabel("Consultation Fee:");
        consultationFeeInput = new JTextField();
        
        outpatientPanel.add(appointmentDateLabel);
        outpatientPanel.add(appointmentDateInput);
        outpatientPanel.add(consultationFeeLabel);
        outpatientPanel.add(consultationFeeInput);
        
        // Set borders for panels
        emergencyPanel.setBorder(BorderFactory.createTitledBorder("Emergency Patient Details"));
        inpatientPanel.setBorder(BorderFactory.createTitledBorder("Inpatient Details"));
        outpatientPanel.setBorder(BorderFactory.createTitledBorder("Outpatient Details"));
        
        // Initially hide all panels
        emergencyPanel.setVisible(false);
        inpatientPanel.setVisible(false);
        outpatientPanel.setVisible(false);
        
        // Add panels to form
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        // Create a main panel to hold the original form
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(createOriginalFormPanel(), BorderLayout.NORTH);
        
        // Create a panel for the dynamic content
        JPanel dynamicContentPanel = new JPanel();
        dynamicContentPanel.setLayout(new BoxLayout(dynamicContentPanel, BoxLayout.Y_AXIS));
        dynamicContentPanel.add(emergencyPanel);
        dynamicContentPanel.add(inpatientPanel);
        dynamicContentPanel.add(outpatientPanel);
        
        mainPanel.add(dynamicContentPanel, BorderLayout.CENTER);
        
        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(jButton1);  // Add button
        
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Add the main panel to the frame
        setContentPane(mainPanel);
        pack();
    }
    
    private JPanel createOriginalFormPanel() {
        // Create a panel with the original form fields
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(jLabel1, gbc);
        
        // Patient Name
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(jLabel2, gbc);
        gbc.gridx = 1;
        panel.add(PatientNameInput, gbc);
        
        // Age
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(jLabel3, gbc);
        gbc.gridx = 1;
        panel.add(PatientAgeInput, gbc);
        
        // Gender
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(jLabel4, gbc);
        gbc.gridx = 1;
        panel.add(GenderNameInput, gbc);
        
        // Block location
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(jLabel5, gbc);
        gbc.gridx = 1;
        panel.add(blockComboBoxx, gbc);
        
        // Patient type checkboxes
        JPanel checkboxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        checkboxPanel.add(isEmergencyInput);
        checkboxPanel.add(isInPatientInput);
        checkboxPanel.add(isOutPatientInput);
        
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(checkboxPanel, gbc);
        
        return panel;
    }
    
    private void setupCheckBoxListeners() {
        // Add action listeners to checkboxes for exclusive selection
        ActionListener checkBoxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox selected = (JCheckBox) e.getSource();
                
                if (selected == isEmergencyInput && selected.isSelected()) {
                    isInPatientInput.setSelected(false);
                    isOutPatientInput.setSelected(false);
                    emergencyPanel.setVisible(true);
                    inpatientPanel.setVisible(false);
                    outpatientPanel.setVisible(false);
                } else if (selected == isInPatientInput && selected.isSelected()) {
                    isEmergencyInput.setSelected(false);
                    isOutPatientInput.setSelected(false);
                    emergencyPanel.setVisible(false);
                    inpatientPanel.setVisible(true);
                    outpatientPanel.setVisible(false);
                } else if (selected == isOutPatientInput && selected.isSelected()) {
                    isEmergencyInput.setSelected(false);
                    isInPatientInput.setSelected(false);
                    emergencyPanel.setVisible(false);
                    inpatientPanel.setVisible(false);
                    outpatientPanel.setVisible(true);
                } else {
                    // If unchecked, hide the panel
                    if (selected == isEmergencyInput) emergencyPanel.setVisible(false);
                    else if (selected == isInPatientInput) inpatientPanel.setVisible(false);
                    else if (selected == isOutPatientInput) outpatientPanel.setVisible(false);
                }
                
                pack();  // Resize the frame to fit the content
            }
        };
        
        isEmergencyInput.addActionListener(checkBoxListener);
        isInPatientInput.addActionListener(checkBoxListener);
        isOutPatientInput.addActionListener(checkBoxListener);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PatientNameInput = new javax.swing.JTextField();
        PatientAgeInput = new javax.swing.JTextField();
        blockComboBoxx = new javax.swing.JComboBox<>();
        GenderNameInput = new javax.swing.JComboBox<>();
        isEmergencyInput = new javax.swing.JCheckBox();
        isOutPatientInput = new javax.swing.JCheckBox();
        isInPatientInput = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Add New Patient ");

        jLabel2.setText("Patient Name ");

        jLabel3.setText("Age");

        jLabel4.setText("Gender");

        jLabel5.setText("Blocklocation");

        PatientNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientNameInputActionPerformed(evt);
            }
        });

        PatientAgeInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientAgeInputActionPerformed(evt);
            }
        });

        blockComboBoxx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockComboBoxxActionPerformed(evt);
            }
        });

        GenderNameInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        isEmergencyInput.setText("Emergency Patinet");
        isEmergencyInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isEmergencyInputActionPerformed(evt);
            }
        });

        isOutPatientInput.setText("Out patient");
        isOutPatientInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isOutPatientInputActionPerformed(evt);
            }
        });

        isInPatientInput.setText("In patinet");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(blockComboBoxx, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PatientNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GenderNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PatientAgeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(isEmergencyInput)
                .addGap(26, 26, 26)
                .addComponent(isInPatientInput, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(isOutPatientInput, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(PatientNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(PatientAgeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(GenderNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(blockComboBoxx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isEmergencyInput)
                    .addComponent(isOutPatientInput)
                    .addComponent(isInPatientInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PatientAgeInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientAgeInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatientAgeInputActionPerformed

    private void PatientNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatientNameInputActionPerformed

    private void isEmergencyInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isEmergencyInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isEmergencyInputActionPerformed

    private void isOutPatientInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isOutPatientInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isOutPatientInputActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String name = PatientNameInput.getText().trim();
        String ageText = PatientAgeInput.getText().trim();
        String gender = (String) GenderNameInput.getSelectedItem();
        HospitalBlock selectedBlock = (HospitalBlock) blockComboBoxx.getSelectedItem();

        // Validate required fields
        if (name.isEmpty() || ageText.isEmpty() || gender == null || selectedBlock == null) {
            JOptionPane.showMessageDialog(this, 
                    "Please fill in all required fields", 
                    "Input Error", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int age;
        try {
            age = Integer.parseInt(ageText);
            if (age <= 0 || age > 120) {  
                JOptionPane.showMessageDialog(this, 
                        "Age must be between 1 and 120", 
                        "Input Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, 
                    "Age must be a valid number", 
                    "Input Error", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create appropriate patient type
        Patient newPatient;
        try {
            if (isEmergencyInput.isSelected()) {
                // Validate emergency fields
                String severityLevel = (String) severityLevelInput.getSelectedItem();
                String emergencyCostText = emergencyCostInput.getText().trim();
                
                if (emergencyCostText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, 
                            "Please enter emergency treatment cost", 
                            "Input Error", 
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                double emergencyCost;
                try {
                    emergencyCost = Double.parseDouble(emergencyCostText);
                    if (emergencyCost < 0) {
                        JOptionPane.showMessageDialog(this, 
                                "Treatment cost cannot be negative", 
                                "Input Error", 
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, 
                            "Treatment cost must be a valid number", 
                            "Input Error", 
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                newPatient = new EmergencyPatient(name, age, gender, selectedBlock, severityLevel, emergencyCost);
                
            } else if (isInPatientInput.isSelected()) {
                // Validate inpatient fields
                String roomNumber = roomNumberInput.getText().trim();
                String admissionDate = admissionDateInput.getText().trim();
                String dailyChargeText = dailyChargeInput.getText().trim();
                String daysAdmittedText = daysAdmittedInput.getText().trim();
                
                if (roomNumber.isEmpty() || admissionDate.isEmpty() || 
                    dailyChargeText.isEmpty() || daysAdmittedText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, 
                            "Please fill in all inpatient fields", 
                            "Input Error", 
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                double dailyCharge;
                int daysAdmitted;
                
                try {
                    dailyCharge = Double.parseDouble(dailyChargeText);
                    if (dailyCharge < 0) {
                        JOptionPane.showMessageDialog(this, 
                                "Daily charge cannot be negative", 
                                "Input Error", 
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, 
                            "Daily charge must be a valid number", 
                            "Input Error", 
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                try {
                    daysAdmitted = Integer.parseInt(daysAdmittedText);
                    if (daysAdmitted <= 0) {
                        JOptionPane.showMessageDialog(this, 
                                "Days admitted must be a positive number", 
                                "Input Error", 
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, 
                            "Days admitted must be a valid number", 
                            "Input Error", 
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                newPatient = new Inpatient(name, age, gender, selectedBlock, daysAdmitted, dailyCharge, admissionDate, roomNumber);
                
            } else if (isOutPatientInput.isSelected()) {
                // Validate outpatient fields
                String appointmentDate = appointmentDateInput.getText().trim();
                String consultationFeeText = consultationFeeInput.getText().trim();
                
                if (appointmentDate.isEmpty() || consultationFeeText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, 
                            "Please fill in all outpatient fields", 
                            "Input Error", 
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                double consultationFee;
                try {
                    consultationFee = Double.parseDouble(consultationFeeText);
                    if (consultationFee < 0) {
                        JOptionPane.showMessageDialog(this, 
                                "Consultation fee cannot be negative", 
                                "Input Error", 
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, 
                            "Consultation fee must be a valid number", 
                            "Input Error", 
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                newPatient = new Outpatient(name, age, gender, selectedBlock, appointmentDate, consultationFee);
                
            } else {
                JOptionPane.showMessageDialog(this, 
                        "Please select a patient type", 
                        "Input Error", 
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Let the parent frame handle adding the patient
            if (parentFrame != null) {
                parentFrame.onPatientAdded(newPatient);
            }
            
            JOptionPane.showMessageDialog(this, 
                    "Patient added successfully!", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);

            // Close the add patient frame
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                    "Error creating patient: " + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void blockComboBoxxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blockComboBoxxActionPerformed

    }//GEN-LAST:event_blockComboBoxxActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> GenderNameInput;
    private javax.swing.JTextField PatientAgeInput;
    private javax.swing.JTextField PatientNameInput;
    private javax.swing.JComboBox<HospitalBlock> blockComboBoxx;
    private javax.swing.JCheckBox isEmergencyInput;
    private javax.swing.JCheckBox isInPatientInput;
    private javax.swing.JCheckBox isOutPatientInput;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
