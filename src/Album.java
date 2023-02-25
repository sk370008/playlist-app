import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songs;

    public Album(String title, String artist) {
        this.name = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSong() {
        return songs;
    }

    public void setSongs(List<Song> song) {
        this.songs = songs;
    }

    //find song
    boolean findSong(String title){
        for(Song song:songs){
            if(song.getTitle().equals(title))
                return true;
        }
        return false;
    }

    //add song to album
    String addSongToAlbum(String title,double duration){
        Song s = new Song(title,duration);
        if(findSong(title) == false){
            songs.add(s);
            return "Song added to the album";
        }
        return "song already exists";
    }

    //add song to playlist from album using title
    String addSongToPlaylistFromAlbum(String title, List<Song> playList){
        if(findSong(title) == true){
            for (Song s:this.songs){
                if(s.getTitle().equals(title)){
                    playList.add(s);
                    return "Song added to your playlist";
                }
            }
        }
        return "Song not present in the album";
    }

    //add song to playlist from album using index number
    String addSongToPlaylistFromAlbum(int trackNo,List<Song> playList){
        int index = trackNo - 1;
        if(index>=0 && index<this.songs.size()){
            playList.add(this.songs.get(index));
            return "Song added to your playlist";
        }
        return "Invalid position of song";
    }

}








