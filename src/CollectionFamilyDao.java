import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements IFamilyDao{
    private List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return List.of();
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
}

