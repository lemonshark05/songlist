import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {
    Album album1, album2;
    Artist artist1;
    @BeforeAll
    static void startSetup() {

    }

    @BeforeEach
    void setup() {
        album1 = new Album("The White Album");
        album2 = new Album("22");
        artist1 = new Artist("Taylor Swift");
        album2.setArtist(artist1);
        album1.setArtist(artist1);
    }

    @Test
    void testEquals() {
        assertTrue(album1.equals(album2));
        Album album3 = new Album("The white album");
        album3.setArtist(artist1);
        assertFalse(album1.equals(album3));
    }

    @Test
    void testToString() {
        String expectedOutput = "1 The White AlbumArtistTaylor Swift";
        assertEquals(album1.toString(),expectedOutput);
    }

    @Test
    void toHTML() {
        String expectedOutput = "<b>The White Album</b><i>1</i>";
        assertEquals(album1.toHTML(), expectedOutput);
    }

    @Test
    void toXML() {
    }
}