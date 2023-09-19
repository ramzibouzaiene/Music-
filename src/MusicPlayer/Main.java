package MusicPlayer;

import java.util.*;

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
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("This playlist have no song");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("no song availble, reached to the end of the list");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("we are the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("we are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("now playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("now playing " + listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious())
                                System.out.println("now playing " + listIterator.previous().toString());

                        }
                    }
            }
        }

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