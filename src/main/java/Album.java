import java.util.ArrayList;

/**
 * @author zhimin
 * @version 1.1
 */
public class Album extends Entity {
    protected ArrayList<Song> songs;
    protected Artist artist;

    /**
     * @param name
     */
    public Album(String name) {
        super(name);
    }

    /**
     * @param id
     * @param name
     */
    public Album(int id,String name) {
        super(id,name);
    }

    /**
     * @param s
     */
    public void addSong(Song s) {
        songs.add(s);
    }

    /**
     * @return
     */
    public Artist getArtist() {
        return artist;
    }

    /**
     * @param artist
     */
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    /**
     * @param other
     * @return
     */
    public boolean equals(Album other){
        return (this.name.equals(other.name) && this.artist.equals(other.artist));
    }

    /**
     * @return
     */
    public String toString(){
        return super.toString() + "Artist" + artist.getName();
    }

    /**
     * @return
     */
    public String toXML(){
        return "<album id=\""+this.entityID +"\">\n"+this.getName()+"\n</album>\n";
    }

}
