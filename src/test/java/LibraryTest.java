/**
 * CS 514
 * Zhimin meng
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LibraryTest {
    Library lib;
    Song s1;
    Song s2;

    @BeforeEach
    void setup(){
        lib = new Library();
        s1 = new Song("My Generation");
        s1.setLiked(true);
        s2 = new Song("Whip it");
        lib.addSong(s1);
        lib.addSong(s2);
    }

    @Test
    void test1() {
        System.out.printf("Finding My Generation %s", lib.findSong("My Generation"));
        ArrayList<Song> liked = lib.getLinked();
        for (Song s:liked) {
            System.out.printf("%s\n", s.toString());
        }
    }

    @Test
    void testUrl() {
        //Test website : TheAudioDB
        lib = new Library();
        String json = lib.loadJson("https://theaudiodb.com/api/v1/json/2/discography.php?s=coldplay");
        System.out.println(json);
        lib.addFromJson(json,"artist");
    }
}
