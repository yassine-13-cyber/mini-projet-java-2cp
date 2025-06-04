package hospitalpatientrecordsystem;
import java.util.ArrayList;

class Hospital {
    private String name;
    private int maxPatients;
    private String state;
    private ArrayList<HospitalBlock> blocks;

    public Hospital(String name, int maxPatients, String state) {
        this.name = name;
        this.maxPatients = maxPatients;
        this.state = state;
        this.blocks = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getMaxPatients() {
        return maxPatients;
    }

    public String getState() {
        return state;
    }

    public ArrayList<HospitalBlock> getBlocks() {
        return blocks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMaxPatients(int maxPatients) {
        this.maxPatients = maxPatients;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setBlocks(ArrayList<HospitalBlock> blocks) {
        this.blocks = blocks;
    }

    // Methods
    public void addBlock(HospitalBlock block) {
        blocks.add(block);
    }

    public String getHospitalInfo() {
        return "Hospital Name: " + name + "\n" +
               "Max Patients: " + maxPatients + "\n" +
               "State: " + state + "\n" +
               "Number of Blocks: " + blocks.size();
    }

    public void displayBlocksInfo() {
        System.out.println("Blocks in " + name + ":");
        for (HospitalBlock block : blocks) {
            System.out.println(block.toString());
        }
    }
}
