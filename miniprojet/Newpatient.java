/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hosppitalpatientrecordsystem;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author yassine
 */
public class NewPatient extends javax.swing.JFrame {
   
    private Hospital hospital;
    private ArrayList<Patient> patientList;
    public NewPatient(Hospital hospital, ArrayList<Patient> patientList) {
        this.hospital = hospital;
        this.patientList = patientList;
        initComponents();
        initializeBlockComboBox();
    }

     private void initializeBlockComboBox() {
        BlockLocationInput.removeAllItems();
        for (HospitalBlock block : hospital.getBlocks()) {
            BlockLocationInput.addItem(block.getBlockName());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        PatientNameInput = new javax.swing.JTextField();
        PatientAgeInput = new javax.swing.JTextField();
        isEmergencyInput = new javax.swing.JCheckBox();
        isInPatientInput = new javax.swing.JCheckBox();
        isOutPatientInput = new javax.swing.JCheckBox();
        GenderNameInput = new javax.swing.JComboBox<>();
        BlockLocationInput = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Patient Name ");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel2.setText("Add New Patient");

        jLabel3.setText("Age");

        jLabel4.setText("Gender");

        jLabel5.setText("Block Location");

        jLabel6.setText("Emergency Patient");

        jLabel7.setText("In patient");

        jLabel8.setText("Out patient");

        GenderNameInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        GenderNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderNameInputActionPerformed(evt);
            }
        });

        BlockLocationInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PatientNameInput)
                            .addComponent(PatientAgeInput)
                            .addComponent(GenderNameInput, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BlockLocationInput, 0, 197, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(isEmergencyInput)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isInPatientInput)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addGap(28, 28, 28)
                        .addComponent(isOutPatientInput)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(PatientNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(PatientAgeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(GenderNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(BlockLocationInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(isEmergencyInput)
                    .addComponent(isInPatientInput)
                    .addComponent(isOutPatientInput))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>                        

    private void GenderNameInputActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

        // TODO add your handling code here:
    try {
            String name = PatientNameInput.getText();
            int age = Integer.parseInt(PatientAgeInput.getText());
            String gender = (String) GenderNameInput.getSelectedItem();
            String blockName = (String) BlockLocationInput.getSelectedItem();
            
            HospitalBlock location = null;
            for (HospitalBlock block : hospital.getBlocks()) {
                if (block.getBlockName().equals(blockName)) {
                    location = block;
                    break;
                }
            }
            
            if (location == null) {
                JOptionPane.showMessageDialog(this, "Please select a valid block");
                return;
            }
            
            Patient newPatient;
            if (isEmergencyInput.isSelected()) {
                newPatient = new EmergencyPatient(name, age, gender, location, "Medium", 150.0);
            } else if (isInPatientInput.isSelected()) {
                newPatient = new Inpatient(name, age, gender, location, 1, 200.0, "Today", "Room 101");
            } else if (isOutPatientInput.isSelected()) {
                newPatient = new Outpatient(name, age, gender, location, "Today", 100.0);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a patient type");
                return;
            }
            
            patientList.add(newPatient);
            JOptionPane.showMessageDialog(this, "Patient added successfully!");
            this.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid age");
        }
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> BlockLocationInput;
    private javax.swing.JComboBox<String> GenderNameInput;
    private javax.swing.JTextField PatientAgeInput;
    private javax.swing.JTextField PatientNameInput;
    private javax.swing.JCheckBox isEmergencyInput;
    private javax.swing.JCheckBox isInPatientInput;
    private javax.swing.JCheckBox isOutPatientInput;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration                   
}

