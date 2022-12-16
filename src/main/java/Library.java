/**
 * CS 514
 * Zhimin meng
 */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Node;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Library {
    private ArrayList<Song> songs;
    private ExeSql exe;
    public String artistname;

    public Library() { songs = new ArrayList<Song>(); exe = new ExeSql();}

    public void addSong(Song s) {
        songs.add(s);
    }

    public Song findSong(String n) {
        for(int i=0;i<songs.size();i++){
            if(songs.get(i).getName().equals(n)){
                return songs.get(i);
            }
        }
        return null;
    }
    public ArrayList<Song> getLinked() {
        ArrayList<Song> likedSongs = new ArrayList<Song>();
        for(int i = 0;i<songs.size();i++){
            if (songs.get(i).isLiked()) {
                likedSongs.add(songs.get(i));
            }
        }
        return likedSongs;
    }

    public String getContent(Node n) {
        Node child = n.getFirstChild();
        return child.getNodeValue().trim();
    }

    public String loadJson(String urlstr){
        StringBuilder json = new StringBuilder();
        try{
            URL urljson = new URL(urlstr);
            URLConnection uc = urljson.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));
            String line = null;
            while((line = in.readLine())!=null) {
                json.append(line);
            }
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
            return json.toString();
    }

    public void addFromJson(String json, String type) {
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;
            String sql = "";
            int initid = 100;

            if(type.equals("song")){
                JSONArray songArray = (JSONArray) jsonObject.get("mvids");
                for(Object song:songArray){
                    JSONObject jsong = (JSONObject) song;
                    sql = "insert into songs (id, name, artist, album) values("+(initid++)+",\""+jsong.get("strTrack")
                            +"\","+jsong.get("idArtist")+","+jsong.get("idAlbum")+");";
                    System.out.println("Artist id: " + jsong.get("idArtist"));
                    System.out.println("Album id: " + jsong.get("idAlbum"));
                    System.out.println("Track id: " +jsong.get("idTrack"));
                    System.out.println("Truck name: " + jsong.get("strTrack"));
                    exe.getSql(sql,1);
                }
            }else if(type.equals("artist")){
                JSONArray songArray = (JSONArray) jsonObject.get("artists");
                for(Object song:songArray){
                    JSONObject jsong = (JSONObject) song;
                    sql = "insert into artists (id, nAlbums, name, nSongs) values("+jsong.get("idArtist")+","+0
                            +",\""+jsong.get("strArtist")+"\","+0+");";
                    System.out.println("Artist id: " + jsong.get("idArtist"));
                    System.out.println("Artist name: " + jsong.get("strArtist"));
                    exe.getSql(sql,1);
                }
            }else if(type.equals("album")){
                JSONArray songArray = (JSONArray) jsonObject.get("album");
                for(Object song:songArray){
                    JSONObject jsong = (JSONObject) song;
                    sql = "insert into albums (id, name, nSongs, artist, genre) values("+jsong.get("idAlbum")+",\""+jsong.get("strAlbum")
                            +"\","+0+","+jsong.get("idArtist")+",\""+jsong.get("strGenre")+"\");";
                    System.out.println("Album id: " + jsong.get("idAlbum"));
                    System.out.println("Album name: " + jsong.get("strAlbum"));
                    System.out.println("Artist id: " + jsong.get("idArtist"));
                    exe.getSql(sql,1);
                }
            }
        }catch (Exception e){
           e.printStackTrace();
        }
    }
}
