import java.util.ArrayList;

/**
 * CS 514 Lab3
 * Zhimin meng
 */
public class Playlist {
    private ArrayList<Song> songlist;

    public Playlist() { songlist = new ArrayList<Song>(); }

    public void addSong(Song s) { songlist.add(s); }

    public void deleteSong(Song s) {
        if (songlist.contains(s)){
            songlist.remove(s);
        } else {
            System.out.printf("%s is not in the playlist\n", s.toString());
        }
    }

    public String toXML(){
        String record = System.getProperty("user.dir")+"/src/test.xml";
        Scanner sc = getFileHandle(record);
        String xml = "<library>\n<songs>\n";
        for(Song s:songs){
            xml += s.toXML();
        }
        xml+="</songs>\n</library>";
        try {
            Files.write(Paths.get(record), xml.getBytes());
        }catch(IOException e){
            System.out.println(e);
            System.exit(-1);
        }
        return xml;
    }
}
