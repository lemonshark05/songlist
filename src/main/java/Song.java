/**
 * CS 514
 * Zhimin meng
 */

public class Song extends Entity {
    protected Album album;
    protected Artist performer;
    protected SongInterval interval;
    protected String genre;
    protected boolean liked;

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public Song(String name) {
        super(name);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLength(int length) {
        interval = new SongInterval(length);
    }

    public SongInterval getInterval() {
        return interval;
    }

    public boolean equals(Song other){
        return (this.name.equals(other.name) &&
                this.performer.equals(other.performer) &&
                this.album.equals(other.album));
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getPerformer() {
        return performer;
    }

    public void setPerformer(Artist performer) {
        this.performer = performer;
    }

    public String toString(){
        return "Name: "+this.name+" ID: "+this.entityID;
    }

    public String toXML(){

        String xml = "<song id=\""+this.entityID +"\">\n<title>\n"+this.name+"</title>\n";
        if(this.artist!=null){
            xml+=artist.toXML();
        }
        if(this.album!=null) {
            xml+= album.toXML();
        }
        return xml+"</song>\n";
    }

    public static void main(String[] args) throws MalformedURLException {
        String record = System.getProperty("user.dir");
        File file = new File("/test1.flac");
        URL url = null;
        if (file.canRead()) {url = file.toURI().toURL();}
        System.out.println(url);
        AudioClip clip = Applet.newAudioClip(url);
        clip.play();
        System.out.println("should've played by now");
    }
}
