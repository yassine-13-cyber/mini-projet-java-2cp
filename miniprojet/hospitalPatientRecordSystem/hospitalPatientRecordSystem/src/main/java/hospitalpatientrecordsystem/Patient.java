package hospitalpatientrecordsystem;

public class Patient {
    private String name;
    private int age;
    private String gender;
    private HospitalBlock location;

    // Constructor
    public Patient(String name, int age, String gender, HospitalBlock location) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public HospitalBlock getLocation() {
        return location;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLocation(HospitalBlock location) {
        this.location = location;
    }
    
    
    // Display patient information
    public void displayInfo() {
        System.out.println("Patient Information:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Hospital Block: " + (location != null ? location.toString() : "Not Assigned"));
    }

    // Default billing method (should be overridden in subclasses)
    public double calculateBill() {
        return 0; // Default bill
    }
}
