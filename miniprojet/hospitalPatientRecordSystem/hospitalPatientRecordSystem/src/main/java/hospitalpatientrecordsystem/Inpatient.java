package hospitalpatientrecordsystem;

public class Inpatient extends Patient {
    private String roomNumber;
    private String admissionDate;
    private double dailyCharge;
    private int numberOfDaysAdmitted;

    // Constructor
    public Inpatient(
        String name,
        int age,
        String gender,
        HospitalBlock location,
        int numberOfDaysAdmitted,
        double dailyCharge,
        String admissionDate,
        String roomNumber
    ) {
        super(name, age, gender, location);
        this.numberOfDaysAdmitted = numberOfDaysAdmitted;
        this.dailyCharge = dailyCharge;
        this.admissionDate = admissionDate;
        this.roomNumber = roomNumber;
    }

    // Getters
    public String getRoomNumber() {
        return roomNumber;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public double getDailyCharge() {
        return dailyCharge;
    }

    public int getNumberOfDaysAdmitted() {
        return numberOfDaysAdmitted;
    }

    // Setters
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public void setDailyCharge(double dailyCharge) {
        this.dailyCharge = dailyCharge;
    }

    public void setNumberOfDaysAdmitted(int numberOfDaysAdmitted) {
        this.numberOfDaysAdmitted = numberOfDaysAdmitted;
    }

    // Display inpatient details
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Daily Charge: $" + dailyCharge);
        System.out.println("Number of Days Admitted: " + numberOfDaysAdmitted);
    }

    // Calculate total bill for inpatient
    @Override
    public double calculateBill() {
        return dailyCharge * numberOfDaysAdmitted;
    }
}
