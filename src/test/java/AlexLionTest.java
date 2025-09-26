import com.example.AlexLion;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AlexLionTest {

    private AlexLion alexLion;
    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        felineMock = Mockito.mock(Feline.class);
        alexLion = new AlexLion("Самец", felineMock); // Изменено на "Самец"
    }

    @Test
    public void getFriendsTest(){
        List<String> friends = alexLion.getFriends();
        assertNotNull(friends);
        assertEquals(3, friends.size());
        assertEquals("Marty zebra ", friends.get(0)); // Обратите внимание на пробел в конце
        assertEquals("Melman giraffe", friends.get(1));
        assertEquals("Gloria hippo", friends.get(2));
    }

    @Test
    public void getPlaceOfLivingTest(){
        String placeOfLiving = alexLion.getPlaceOfLiving();
        assertEquals("New York Zoo", placeOfLiving);
    }

    @Test
    public void testGetKittens() {
        int kittens = alexLion.getKittens();
        assertEquals(0, kittens);
    }
}