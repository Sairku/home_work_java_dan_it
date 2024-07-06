import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanTest {
    @Test
    public void testToString() {
        Map<String, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.MONDAY.name(), "gym");
        schedule.put(DayOfWeek.TUESDAY.name(), "coding");

        Human human = new Human("Anna", "Doe", 2005, 120, schedule, null);
        String expected = "Human{name='Anna', surname='Doe', year=2005, iq=120, schedule={MONDAY=gym, TUESDAY=coding}}";
        assertEquals(expected, human.toString());
    }
}
