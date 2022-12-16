import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private ArrayList<Song> songlist;

    public Playlist() { songlist = new ArrayList<Song>(); }

    public void addSong(Song s) { songlist.add(s); }

    public void toStirng() {
        for(Song s:songlist){
            System.out.println(s.toString());
        }
    }

    public void deleteSong(Song s) {
        if (songlist.contains(s)){
            songlist.remove(s);
        } else {
            System.out.printf("%s is not in the playlist\n", s.toString());
        }
    }

    public String createXML(){
        String record = System.getProperty("user.dir")+"/src/test.xml";
        Scanner sc = getFileHandle(record);
        String xml = "<library>\n<songs>\n";
        for(Song s:songlist){
            xml += s.toXML();
        }
        xml+="</songs>\n</library>";
        try {
            Files.write(Paths.get(record), xml.getBytes());
            System.out.println(xml);
        }catch(IOException e){
            System.out.println(e);
            System.exit(-1);
        }
        return xml;
    }

    public Scanner getFileHandle(String filename) {
        //needs to be initialized
        Scanner sc = new Scanner(System.in);
        try {
            File inputFile = new File(filename);
            sc = new Scanner(inputFile);
        }catch(FileNotFoundException e){
            System.out.println("no such a file. ");
            System.exit(-1);
        }
        return sc;
    }

    public void getInfo(ResultSet rs){
        try{
            while (rs.next()) {
                Song s1 = new Song(rs.getString("name"));
                s1.entityID = rs.getInt("id");
                s1.genre = rs.getString("genre");
                s1.setArtist(new Artist(rs.getInt("artistid"),rs.getString("artist")));
                s1.setAlbum(new Album(rs.getInt("albumid"),rs.getString("album")));
                songlist.add(s1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
