import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private String sex;
    private boolean expectedHasMane;
    private Lion lion;
    private Feline felineMock;

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    public LionParametrizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Before
    public void setUp() throws Exception {
        felineMock = mock(Feline.class);
        lion = new Lion(sex, felineMock);
        when(felineMock.getKittens()).thenReturn(1);
    }

    @Test
    public void lionHasManeTest() throws Exception {
        lion = new Lion("Самец", felineMock);
        Assert.assertTrue("У самца есть грива", lion.hasMane());    }

    @Test
    public void lionessHasNoManeTest() throws Exception {
        lion = new Lion("Самка", felineMock);
        Assert.assertFalse("У самки нет гривы", lion.hasMane());
    }

    @Test
    public void getKittensTest() throws Exception {
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
    when(felineMock.eatMeat()).thenReturn(expectedFood);
    Lion lion = new Lion("Самец", felineMock);
    assertEquals(expectedFood, lion.getFood());
    }
}