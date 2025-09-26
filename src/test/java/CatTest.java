import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
public class CatTest {

    @Test
    public void testGetSound() {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Predator predatorMock = Mockito.mock(Predator.class);
        Mockito.when(predatorMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Cat cat = new Cat(new Feline());
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}
