import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements IFamilyDao{
    private List<Family> families = new ArrayList<>();
    private static final String FILE_NAME = "families_data.ser";

    @Override
    public List<Family> getAllFamilies() {
        return new ArrayList<>(families);
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index >= 0 && index < families.size()) {
            return families.get(index);
        }
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index >= 0 && index < families.size()) {
            families.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFamily(Family family) {
        return false;
    }

    @Override
    public void saveFamily(Family family) {
        if (!families.contains(family)) {
            families.add(family);
        } else {
            int index = families.indexOf(family);
            families.set(index, family);
        }
    }

    @Override
    public int count() {
        return 0;
    }
    public void saveDataToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(families);
            System.out.println("Data has been saved to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDataFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            families = (List<Family>) in.readObject();
            System.out.println("Data has been loaded from the file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

