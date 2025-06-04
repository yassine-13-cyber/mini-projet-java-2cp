package hospitalpatientrecordsystem;

public class Outpatient extends Patient {
    private String appointmentDate;
    private double consultationFee;

    // Constructor
    public Outpatient(String name, int age, String gender, HospitalBlock location, String appointmentDate, double consultationFee) {
        super(name, age, gender, location);
        this.appointmentDate = appointmentDate;
        this.consultationFee = consultationFee;
    }

    // Getters
    public String getAppointmentDate() {
        return appointmentDate;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    // Setters
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    // Override displayInfo method
    @Override
    public void displayInfo() {
        super.displayInfo(); // Display patient details
        System.out.println("Appointment Date: " + appointmentDate);
        System.out.println("Consultation Fee: $" + consultationFee);
    }

    // Calculate Bill Method
    @Override
    public double calculateBill() {
        return consultationFee;
    }
}
