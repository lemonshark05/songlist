/**
 * CS 514
 * Zhimin meng
 */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Song> songs;

    public Library() { songs = new ArrayList<Song>();}

    public void addSong(Song s) {songs.add(s);}

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

    public void readFromJson(String json) {
        try{
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray songArray = (JSONArray) jsonObject.get("songs");
            for(Object song:songArray){
                JSONObject jsong = (JSONObject) song;
                System.out.println(jsong.get("title"));
            }
        }catch (Exception e){
           e.printStackTrace();
        }
    }
}
