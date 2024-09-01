import java.util.*;
import java.util.stream.Collectors;

public class Family {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.pets = new HashSet<>();
        this.mother.setFamily(this);
        this.father.setFamily(this);
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

    public boolean deleteChild(int index) {
        if (index >= 0 && index < children.size()) {
            Human child = children.remove(index);
            if (child != null) {
                child.setFamily(null);
                return true;
            }
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
                ", pets=" + pets +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Family family = (Family) obj;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Objects.equals(children, family.children) &&
                Objects.equals(pets, family.pets);
    }


    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("family:\n")
                .append("\tmother: ").append(mother.prettyFormat()).append(",\n")
                .append("\tfather: ").append(father.prettyFormat()).append(",\n")
                .append("\tchildren:\n");
        for (Human child : children) {
            sb.append("\t\t").append(child.prettyFormat()).append("\n");
        }
        sb.append("\tpets: ").append(pets.stream()
                .map(Pet::prettyFormat)
                .collect(Collectors.joining(", ", "[", "]")));
        return sb.toString();
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pets);
    }
}

