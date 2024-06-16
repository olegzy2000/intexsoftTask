package model;
public class Bank {
    private int id;
    private String name;
    private float physCommission;
    private float jurCommission;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPhysCommission() {
        return physCommission;
    }

    public void setPhysCommission(float physCommission) {
        this.physCommission = physCommission;
    }

    public float getJurCommission() {
        return jurCommission;
    }

    public void setJurCommission(float jurCommission) {
        this.jurCommission = jurCommission;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bank{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", physCommission=").append(physCommission);
        sb.append(", jurCommission=").append(jurCommission);
        sb.append('}');
        return sb.toString();
    }
}
