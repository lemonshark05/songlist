import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtistTest {

    Album album1, album2;
    Artist artist1;

    @BeforeAll

    @BeforeEach
    void setup() {
        album1 = new Album("Rubber Soul");
        album2 = new Album("22");
    }

    @Test
    void addAlbum() {
        Album a1 = new Album("Revolver");
        Artist art1 = new Artist("The Beatles");
        art1.addAlbum(a1);
        assertTrue(a1.songs.contains(a1));
    }
}