import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class LionTest {

    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самка", felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        int kittens = lion.getKittens();
        assertEquals("Количество котят должно быть 1", 1, kittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(expectedFood, lion.getFood());
    }

    @Test(expected = Exception.class)
    public void testInvalidLionSex() throws Exception {
        new Lion("Неправильный пол", felineMock);
    }
}