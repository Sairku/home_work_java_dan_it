import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class FamilyTest {
    private Family family;
    private Human mother;
    private Human father;
    private Human child1;
    private Human child2;
    private Human nonExistentChild;
    private Pet pet;

    @BeforeEach
    public void setUp() {
        mother = new Woman("Jane", "Doe", 1980);
        father = new Man("John", "Doe", 1975);
        family = new Family(mother, father);

        child1 = new Man("Anna", "Doe", 2005);
        child2 = new Man("Jake", "Doe", 2010);
        nonExistentChild = new Man("NoName", "None", 2000);

        Set<String> habits = new HashSet<>();
        habits.add("eat");
        habits.add("drink");
        habits.add("sleep");

        pet = new Dog("Rock", 5, 75, habits);
        family.getPets().add(pet);

        family.addChild(child1);
        family.addChild(child2);
    }

    @Test
    public void testToString() {
        String expected = "Family{mother=Human{name='Jane', surname='Doe', year=1980, iq=0, schedule={}}, father=Human{name='John', surname='Doe', year=1975, iq=0, schedule={}}, children=[Human{name='Anna', surname='Doe', year=2005, iq=0, schedule={}}, Human{name='Jake', surname='Doe', year=2010, iq=0, schedule={}}], pets=[Pet{species='DOG', nickname='Rock', age=5, trickLevel=75, habits=[]}]}";
        assertEquals(expected, family.toString());
    }

    @Test
    public void testDeleteChildByIndex_Positive() {
        assertTrue(family.deleteChild(0));
        assertFalse(family.getChildren().contains(child1));
        assertEquals(1, family.getChildren().size());
    }

    @Test
    public void testDeleteChildByIndex_Negative() {
        assertFalse(family.deleteChild(5));
        assertEquals(2, family.getChildren().size());
    }

    @Test
    public void testAddChild() {
        Human newChild = new Man("Tom", "Doe", 2015);
        family.addChild(newChild);
        assertEquals(3, family.getChildren().size());
        assertTrue(family.getChildren().contains(newChild));
        assertEquals(family, newChild.getFamily());
    }

    @Test
    public void testCountFamily() {
        assertEquals(4, family.countFamily());
    }
}
