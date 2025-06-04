package hospitalpatientrecordsystem;

import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.List;
public class HospitalPatientRecordSystem {
    
    public static void main(String[] args) {
        // Create Hospital
          Hospital  hospital = new Hospital("Green Valley Hospital", 500, "New York");

        // Create Blocks
        HospitalBlock cardioBlock = new HospitalBlock("A", 1, "Cardiology");
        HospitalBlock pediatricBlock = new HospitalBlock("B", 2, "Pediatrics");
        HospitalBlock emergencyBlock = new HospitalBlock("E", 0, "Emergency");

        hospital.addBlock(cardioBlock);
        hospital.addBlock(pediatricBlock);
        hospital.addBlock(emergencyBlock);

        System.out.println(hospital.getHospitalInfo());
        hospital.displayBlocksInfo();

        System.out.println("\n---- Patient Details ----");

        List<Patient> patients = new ArrayList<>();
        patients.add(new Outpatient("Bob Johnson", 35, "Male", pediatricBlock, "2025-05-02", 120.0));
        patients.add(new EmergencyPatient("Chris Lee", 27, "Male", emergencyBlock, "High", 700.0));
        patients.add(new Inpatient("Alice Smith", 50, "Female", cardioBlock, 3, 300.0, "A101", "2025-05-01"));
        // Launch the JFrame and pass patients
        SwingUtilities.invokeLater(() -> {
            HospitalPatientRecordManager frame = new HospitalPatientRecordManager(hospital,patients);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        });
    }
}
