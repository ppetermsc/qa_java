package tests;

import com.example.Animal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class AnimalParametrizedTest {

    private final String animalSpecies;
    private final List<String> expectedFood;
    private final Class<Exception> expectedException;

    private Animal animal;

    public AnimalParametrizedTest(String animalSpecies, List<String> expectedFood, Class<Exception> expectedException) {
        this.animalSpecies = animalSpecies;
        this.expectedFood = expectedFood;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters
    public static Object[][] parameters() {
        return new Object[][] {
                { "Травоядное", List.of("Трава", "Различные растения"), null },
                { "Хищник", List.of("Животные", "Птицы", "Рыба"), null },
                { "Неизвестный", null, Exception.class }
        };
    }

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void getFoodIsCorrectTest() throws Exception {
        if (expectedException != null) {
            Exception exception = assertThrows(expectedException, () -> animal.getFood(animalSpecies));
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        } else {
            List<String> food = animal.getFood(animalSpecies);
            assertEquals(expectedFood, food);
        }
    }

    @Test
    public void getFamilyIsCorrectTest() {
        String family = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", family);
    }
}