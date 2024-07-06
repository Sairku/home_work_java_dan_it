import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetTest {
    @Test
    public void testToString() {
        Set<String> habits = new HashSet<>();
        habits.add("eat");
        habits.add("drink");
        habits.add("sleep");

        Pet pet = new Dog("Rock", 5, 75, habits);
        String expected = "Pet{species='DOG', nickname='Rock', age=5, trickLevel=75, habits=[]}";
        assertEquals(expected, pet.toString());
    }
}
