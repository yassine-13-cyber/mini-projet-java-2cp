package hospitalpatientrecordsystem;

public class HospitalBlock {
    private String blockName;
    private int floorNumber;
    private String speciality;

    // Constructor
    public HospitalBlock(String blockName, int floorNumber, String speciality) {
        this.blockName = blockName;
        this.floorNumber = floorNumber;
        this.speciality = speciality;
    }

    // Getters
    public String getBlockName() {
        return blockName;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public String getSpeciality() {
        return speciality;
    }

    // Setters
    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    // ToString Method (for easy printing)
    @Override
    public String toString() {
        return "Block Name: " + blockName + ", Floor: " + floorNumber + ", Speciality: " + speciality;
    }
}
