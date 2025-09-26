import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class LionTest {
    private Lion lion;
    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        felineMock = Mockito.mock(Feline.class);
        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void lionHasManeTest() {
        Assert.assertTrue("У самца есть грива", lion.hasMane());
    }

    @Test
    public void lionessHasNoManeTest() throws Exception {
        lion = new Lion("Самка", felineMock);
        Assert.assertFalse("У самки нет гривы", lion.hasMane());
    }

    @Test
    public void getKittensTest() throws Exception {
        Mockito.when(felineMock.getKittens()).thenReturn(3);
        int kittens = lion.getKittens();
        Assert.assertEquals("Количество котят должно быть 3", 3, kittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Мясо");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> food = lion.getFood();
        Assert.assertEquals("Лев ест мясо", expectedFood, food);
    }

    @Test(expected = Exception.class)
    public void testInvalidLionSex() throws Exception {
        new Lion("Неправильный пол", felineMock);
    }
}