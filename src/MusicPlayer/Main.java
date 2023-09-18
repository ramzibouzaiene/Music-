package MusicPlayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args){
        Album album = new Album("All Eyez on Me", "Tupac");

        album.addSong("California Love", 4.45);
        album.addSong("2 of Amerikaz Most Wanted", 4.05);
        album.addSong("Only God Can Judge Me", 4.57);
        albums.add(album);

        Album album2 = new Album("Eminem", "Recovery");
        album2.addSong("Not Afraid", 4.20);
        album2.addSong("No Love", 5.00);
        album2.addSong(	"25 to Life", 4.01);
        albums.add(album2);

        // Creating the Playlist for the songs from the albums
        LinkedList<Song> playlist_1 = new LinkedList<>();

        albums.get(0).addToPlaylist("California Love", playlist_1);
        albums.get(0).addToPlaylist("Only God Can Judge Me", playlist_1);
        albums.get(1).addToPlaylist("Not Afraid", playlist_1);
        albums.get(1).addToPlaylist("25 to Life", playlist_1);

        play(playlist_1);
    }
    private static void play(LinkedList<Song> playList){

    }
    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list of all songs\n" +
                "5 - print all available options\n" +
                "6 - delete current song"
                );
    }
    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("--------------------");

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("--------------------");
    }
}