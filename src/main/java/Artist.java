import java.util.ArrayList;
/**
 * @author zhimin
 * @version 1.1
 */
public class Artist extends Entity {

    protected ArrayList<Song> songs;
    protected ArrayList<Album> albums;

    /**
     * @param name
     */
    public Artist(String name) {
        super(name);
    }
    public Artist(int id,String name) {
        super(id,name);
    }

    /**
     * @param a
     */
    public void addAlbum(Album a) {
        albums.add(a);
    }

    /**
     * @return
     */
    public String toXML() {
        return "<artist id=\""+this.entityID +"\">\n"+this.getName()+"\n</artist>\n";
    }

}
