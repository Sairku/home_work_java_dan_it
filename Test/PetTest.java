import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetTest {
    @Test
    public void testToString() {
        Pet pet = new Pet(Species.DOG, "Rock", 5, 75, new String[]{"eat", "drink", "sleep"});
        String expected = "Pet{species='DOG', nickname='Rock', age=5, trickLevel=75, habits=[eat, drink, sleep]}";
        assertEquals(expected, pet.toString());
    }
}
