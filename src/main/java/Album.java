import java.util.ArrayList;

public class Album extends Entity {
    protected ArrayList<Song> songs;
    protected Artist artist;

    public Album(String name) {
        super(name);
    }

    public Album(int id,String name) {
        super(id,name);
    }

    public void addSong(Song s) {
        songs.add(s);
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public boolean equals(Album other){
        return (this.name.equals(other.name) && this.artist.equals(other.artist));
    }

    public String toString(){
        return super.toString() + "Artist" + artist.getName();
    }

    public String toXML(){
        return "<album id=\""+this.entityID +"\">\n"+this.getName()+"\n</album>\n";
    }

}
