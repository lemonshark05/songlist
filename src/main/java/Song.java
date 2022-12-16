import java.sql.ResultSet;
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
        xml +="<genre>"+this.genre+"</genre>";
        return xml+"</song>\n";
    }

    public static void main(String[] args) {
        Library lib = new Library();
        ExeSql exe = new ExeSql();
        int option = 1;
        //clean the data
        exe.getSql("delete from songs where id>99",0);
        exe.getSql("delete from artists where id>112020",0);
        exe.getSql("delete from albums where id>99",0);
        // loop:
        while(option>0){
            System.out.println("Please select your option (you have 3 options): ");
            System.out.println("  1. Display all songs, artists, and albums. ");
            System.out.println("  2. Partially specify a song, artist, or album. ");
            System.out.println("  3. Generate a XML file contains a playlist based on genre. ");
            Scanner in = new Scanner(System.in);
            String choice1 = in.nextLine();
            if(choice1.equals("1")){
                exe.showSql("select s.id as id, s.name as name, a.name as artist, b.name as album, b.genre as " +
                        "genre from songs as s left join artists as a on a.id =s.artist left join albums as b " +
                        "on s.album = b.id;");
            }else if(choice1.equals("2")){
                System.out.println("Please select your second option (you have 3 options): ");
                System.out.println("  1. Song ");
                System.out.println("  2. Artist ");
                System.out.println("  3. Album ");
                Scanner in2 = new Scanner(System.in);
                int c2 = in2.nextInt();
                String json = "";
                if(c2==1){
                    System.out.println("Please input artistid and show all songs about it:(e.g. 112020) ");
                    Scanner in3 = new Scanner(System.in);
                    String c3 = in3.nextLine();
                    //https://theaudiodb.com/api/v1/json/2/mvid.php?i=112020
                    json = lib.loadJson("https://theaudiodb.com/api/v1/json/2/mvid.php?i="+c3);
                    System.out.println(json);
                    System.out.println("Do you want to insert this information into songs? (Y/N)");
                    Scanner in4 = new Scanner(System.in);
                    String c4 = in4.nextLine();
                    if(c4.equals("Y")) {
                        lib.addFromJson(json,"song");
                    }
                }else if(c2==2){
                    System.out.println("Please input artist name and show the detail: (e.g. coldplay)");
                    Scanner in3 = new Scanner(System.in);
                    String c3 = in3.nextLine();
                    //https://www.theaudiodb.com/api/v1/json/2/search.php?s=coldplay
                    json = lib.loadJson("https://www.theaudiodb.com/api/v1/json/2/search.php?s="+c3);
                    System.out.println(json);
                    System.out.println("Do you want to insert this information into artists? (Y/N)");
                    Scanner in4 = new Scanner(System.in);
                    String c4 = in4.nextLine();
                    if(c4.equals("Y")) {
                        lib.addFromJson(json,"artist");
                    }
                }else if(c2==3){
                    System.out.println("Please input artist name and show all albums about it:(e.g. 112020) ");
                    Scanner in3 = new Scanner(System.in);
                    String c3 = in3.nextLine();
                    //https://theaudiodb.com/api/v1/json/2/album.php?i=112020
                    json = lib.loadJson("https://theaudiodb.com/api/v1/json/2/album.php?i="+c3);
                    System.out.println(json);
                    System.out.println("Do you want to insert this information into artists? (Y/N)");
                    Scanner in4 = new Scanner(System.in);
                    String c4 = in4.nextLine();
                    if(c4.equals("Y")) {
                        lib.artistname = c3;
                        lib.addFromJson(json, "album");
                    }
                }
            }else if(choice1.equals("3")){
                System.out.println("Generate a xml file ( ^-^ )");
                Playlist play = exe.getSqllist("select s.id as id, s.name as name, a.id as artistid, a.name as artist, " +
                        "b.id as albumid,b.name as album, b.genre as genre from songs as s left join artists as a " +
                        "on a.id =s.artist left join albums as b on s.album = b.id;");
                play.createXML();
            }else{
                System.out.println("The input is error!!!");
                System.out.println("Do you want to try it again?(Y/N)");
                Scanner in2 = new Scanner(System.in);
                String choice2 = in2.nextLine();
                if(choice2.equals("Y")){
                    option = 1;
                }else {
                    option = 0;
                }
            }
        }
    }
}
