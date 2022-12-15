import java.util.Scanner;

/**
 * CS 514
 * Zhimin meng
 */

public class Song extends Entity {
    protected Album album;
    protected Artist artist;
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public SongInterval getInterval() {
        return interval;
    }

    public boolean equals(Song other){
        return (this.name.equals(other.name) &&
                this.artist.equals(other.artist) &&
                this.album.equals(other.album));
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getPerformer() {
        return artist;
    }

    public void setPerformer(Artist performer) {
        this.artist = performer;
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

    public void deleteSong(){
        String result = "";
        // set a counter for the number of guesses so far.
        int trytime = 6;
        String path = System.getProperty("user.dir")+"/src/";
        String file = path+"wordleWords";
        System.out.println("The secret word is generated. ");

        // loop:
        while(trytime>0){
            System.out.println("Please input your guess word (you have "+trytime+" attempts): ");
            Scanner in = new Scanner(System.in);
            String guess = in.nextLine();
            if(true){

            }else{
                System.out.println("Warning: Be sure to enter a "
                        +" letter word! ");
            }
            trytime--;
            // the guess is right?
            if(result.equals("!!!!!")){
                System.out.println("Congratulation! You guessed it correct answer.");

                trytime = 0;
            }else{
                System.out.println("You didn't guess the correct answer. ");

                // Show the letters guessed so far
                System.out.println("Notice: your guessed letters is ");

            }
        }
    }

    public static void main(String[] args) {
        String record = System.getProperty("user.dir");

    }
}
