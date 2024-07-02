import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FamilyTest {
    private Family family;
    private Human mother;
    private Human father;
    private Human child1;
    private Human child2;
    private Human nonExistentChild;

    @BeforeEach
    public void setUp() {
        mother = new Human("Jane", "Doe", 1980);
        father = new Human("John", "Doe", 1975);
        family = new Family(mother, father);

        child1 = new Human("Anna", "Doe", 2005);
        child2 = new Human("Jake", "Doe", 2010);
        nonExistentChild = new Human("NoName", "None", 2000);

        family.addChild(child1);
        family.addChild(child2);
    }
    @Test
    public void testToString() {
        String expected = "Family{mother=Human{name='Jane', surname='Doe', year=1980, iq=0, schedule=null}, " +
                "father=Human{name='John', surname='Doe', year=1975, iq=0, schedule=null}, " +
                "children=[Human{name='Anna', surname='Doe', year=2005, iq=0, schedule=null}, " +
                "Human{name='Jake', surname='Doe', year=2010, iq=0, schedule=null}], pet=null}";
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
        Human newChild = new Human("Tom", "Doe", 2015);
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
