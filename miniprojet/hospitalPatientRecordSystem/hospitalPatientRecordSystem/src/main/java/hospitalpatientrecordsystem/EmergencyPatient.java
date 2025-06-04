package hospitalpatientrecordsystem;

public class EmergencyPatient extends Patient {
    private String severityLevel;
    private double emergencyTreatmentCost;

    public EmergencyPatient(String name, int age, String gender, HospitalBlock location, 
                            String severityLevel, double consultationFee) {
        super(name, age, gender, location);
        this.severityLevel = severityLevel;
        this.emergencyTreatmentCost = consultationFee;
    }

    // Getters
    public String getSeverityLevel() {
        return severityLevel;
    }

    public double getEmergencyTreatmentCost() {
        return emergencyTreatmentCost;
    }

    // Setters
    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }

    public void setEmergencyTreatmentCost(double emergencyTreatmentCost) {
        this.emergencyTreatmentCost = emergencyTreatmentCost;
    }

    // Override the displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the base class displayInfo method
        System.out.println("Severity Level: " + severityLevel);
        System.out.println("Emergency Treatment Cost: " + emergencyTreatmentCost);
    }
    @Override
    public double calculateBill() {
        return emergencyTreatmentCost;
    }
}
