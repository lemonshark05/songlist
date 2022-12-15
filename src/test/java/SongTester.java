/**
 * CS 514
 * Zhimin meng
 */
public class SongTester {
    public static void main(String[] args) {
        Song s1 = new Song("Yesterday");
        Song s2 = new Song("Love me do");
        System.out.printf("%d %d\n", s1.getEntityID(), s2.getEntityID());
        System.out.println(s1.getDataCreated());
        s1.setLength(533);
        System.out.println(s1.getInterval());
        // test equals
        Artist a1 = new Artist("The Beatles");
        Artist a2 = new Artist("The Beatles");
        Artist a3 = new Artist("Bob Dylan");
        if(a1.equals(a2)){
            System.out.println("equality work");
        }else{
            System.out.println("equality doesn't work.");
        }
        if(a3.equals(a2)){
            System.out.println("equality doesn't work.");
        }else{
            System.out.println("equality work");
        }

        Album album1 = new Album("Rubber Soul");
        album1.setArtist(a1);
        Album album2 = new Album("Rubber Soul");
        album2.setArtist(a1);
        if(album1.equals(album2)){
            System.out.println("equal work");
        }else{
            System.out.println("equal doesn't work.");
        }
        album2.setArtist(a2);
        if(album1.equals(album2)){
            System.out.println("equal doesn't work.");
        }else{
            System.out.println("equals");
        }
        album2.setArtist(a1);
        album2.setName("White Album");
        if(album1.equals(album2)){
            System.out.println("equal doesn't work.");
        }else{
            System.out.println("equals");
        }

        Song s3 = new Song("Mike");
        Song s4 = new Song("Mike");
        s3.setPerformer(a1);
        s4.setPerformer(a1);
        s3.setAlbum(album1);
        s4.setAlbum(album1);
        if(s3.equals(s4)) {
            System.out.println("Song equality works");
        }
        s3.setPerformer(a2);
        if (!s3.equals(s4)){
            System.out.println("Song equality works");
        }
        s3.setPerformer(a1);
        s3.setAlbum(album2);
        if (!s3.equals(s4)){
            System.out.println("Song equality works");
        }
    }
}
