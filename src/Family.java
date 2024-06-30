import java.util.ArrayList;
import java.util.List;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Pet pet;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        mother.setFamily(this);
        father.setFamily(this);
    }

    public void addChild(Human child) {
        children.add(child);
        child.setFamily(this);
    }

    public boolean deleteChild(Human child) {
        if (children.remove(child)) {
            child.setFamily(null);
            return true;
        }
        return false;
    }

    public int countFamily() {
        return 2 + children.size();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Family object is being deleted: " + this);
        super.finalize();
    }

    @Override
    public String toString() {
        return "Family{" +
                "mother=" + mother +
                ", father=" + father +
                ", children=" + children +
                ", pet=" + pet +
                '}';
    }

    private String childrenToString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < children.size(); i++) {
            sb.append(children.get(i).toString());
            if (i < children.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Family family) {
        if (this == family) return true;
        if (family == null) return false;
        return mother.equals(family.mother) &&
                father.equals(family.father) &&
                children.equals(family.children) &&
                (pet != null ? pet.equals(family.pet) : family.pet == null);
    }

    public int hashCode() {
        int result = mother.hashCode();
        result = 23 * result + father.hashCode();
        result = 23 * result + children.hashCode();
        result = 23 * result + (pet != null ? pet.hashCode() : 0);
        return result;
    }

    public Human getMother() {
        return mother;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getFather() {
        return father;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public List<Human> getChildren() {
        return children;
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }
    public Pet getPet() {
        return pet;
    }
    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
