import java.util.ArrayList;

public class Artist extends Entity {

    protected ArrayList<Song> songs;
    protected ArrayList<Album> albums;

    public Artist(String name) {
        super(name);
    }
    public Artist(int id,String name) {
        super(id,name);
    }

    public void addSong(Song s) {
        songs.add(s);
    }

    public void addAlbum(Album a) {
        albums.add(a);
    }

    public String toXML() {
        return "<artist id=\""+this.entityID +"\">\n"+this.getName()+"\n</artist>\n";
    }

}
