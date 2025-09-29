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
        alexLion = new AlexLion("Самец", felineMock);
    }

    @Test
    public void getFriendsNotNullTest() {
        List<String> friends = alexLion.getFriends();
        assertNotNull(friends);
    }

    @Test
    public void getFriendsSizeTest() {
        List<String> friends = alexLion.getFriends();
        assertEquals(3, friends.size());
    }

    @Test
    public void getFriendsContentTest() {
        List<String> expectedFriends = List.of("Marty zebra", "Melman giraffe", "Gloria hippo");
        List<String> friends = alexLion.getFriends();
        assertEquals(expectedFriends, friends);
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