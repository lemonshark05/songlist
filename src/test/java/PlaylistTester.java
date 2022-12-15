import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlaylistTester {
    Playlist p;
    Song s1;
    Song s2;

    @BeforeEach
    void setup(){
        p = new Playlist();
        s1 = new Song("Yellow Submarine");
        s2 = new Song("Yesterday");
        p.addSong(s1);
        p.addSong(s2);
    }

    @Test
    void test() {
        System.out.println(p.toString());
        p.deleteSong(s1);
        p.deleteSong(s1);
        System.out.println(p.toString());
    }

    @Test
    void testXmllist(){
        p.createXML();
    }
}
