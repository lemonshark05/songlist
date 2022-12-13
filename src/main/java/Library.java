/**
 * CS 514
 * Zhimin meng
 */
import java.util.ArrayList;

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

    public void readXml(String filename) {
        filename = "src/"+filename;
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new FileInputStream(filename));

            Element root = doc.getDocumentElement();
            System.out.println(root.getTagName());
            Node curNode, subNode;
            Song song1;
            NodeList songlist = root.getElementsByTagName("song");

            for(int i=0;i<songlist.getLength();i++) {
                curNode = songlist.item(i);
                NodeList children = curNode.getChildNodes();
                song1 = new Song();
                for(int j = 0;j<children.getLength();j++) {
                    subNode = children.item(j);
                    if (subNode.getNodeType() == Node.ELEMENT_NODE) {
                        if (subNode.getNodeName().equals("title")) {
                            song1.setName(getContent(subNode));
                        } else if (subNode.getNodeName().equals("album")) {
                            int id = Integer.parseInt(subNode.getAttributes().getNamedItem("id").getNodeValue());
                            Album album1 = new Album(getContent(subNode), id);
                            song1.setAlbum(album1);
                        } else if (subNode.getNodeName().equals("artist")) {
                            int id = Integer.parseInt(subNode.getAttributes().getNamedItem("id").getNodeValue());
                            Artist artist1 = new Artist(getContent(subNode), id);
                            song1.setArtist(artist1);
                        }
                    }
                }
                System.out.println(song1.toString());
            }
        }catch (Exception e) {
            System.out.println("Reading Xml document have some problems: "+e);
        }
    }
}
