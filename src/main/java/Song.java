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
        return "Name: "+this.name+" ID: "+this.entityID+" Artist:"+
                this.artist.name+" Album: "+this.album.name+"genre: "+this.genre;
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

    }

    public static void main(String[] args) {
        int option = 1;
        // loop:
        while(option>0){
            System.out.println("Please select your option (you have 3 options): ");
            System.out.println("  1. Display all songs, artists, and albums. ");
            System.out.println("  2. Partially specify a song, artist, or album. ");
            System.out.println("  3. Generate a XML file contains a playlist based on genre. ");
            Scanner in = new Scanner(System.in);
            int choice1 = in.nextInt();
            if(choice1 == 1){

            }else if(choice1 ==2){

            }else if(choice1 ==3){

            }else{
                System.out.println("The input is error!!!");
                System.out.println("Do you want to try it again?(Y/N)");
                Scanner in2 = new Scanner(System.in);
                String choice2 = in.nextLine();
                if(choice2.equals("Y")){
                    option = 1;
                }else {
                    option = 0;
                }
            }
            // the guess is right?
        }
    }
}
