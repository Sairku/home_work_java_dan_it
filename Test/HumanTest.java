import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {
    @Test
    public void testToString() {
        Human mother = new Human("Jane", "Doe", 1980);
        Human father = new Human("John", "Doe", 1975);
        Family family = new Family(mother, father);

        Human human = new Human("Anna", "Doe", 2005, 120, new String[][]{
                {DayOfWeek.MONDAY.name(), "gym"},
                {DayOfWeek.TUESDAY.name(), "music"}
        }, family);

        String expected = "Human{name='Anna', surname='Doe', year=2005, iq=120, schedule=[[MONDAY, gym], [TUESDAY, music]]}";
        assertEquals(expected, human.toString());
    }
}
