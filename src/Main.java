import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Udd gaye","Ritviz");
        album1.addSongToAlbum("Song 1",5.3);
        album1.addSongToAlbum("Song 2",4.3);
        album1.addSongToAlbum("Song 3",3.4);

        Album album2 = new Album("moosa","Sidhu Moosewala");
        album2.addSongToAlbum("Old School",5.3);
        album2.addSongToAlbum("Same beef",4.3);
        album2.addSongToAlbum("So high",3.4);


        List<Song> myPlayList = new LinkedList<>();
        System.out.println(album2.addSongToPlaylistFromAlbum("Old School",myPlayList));
        System.out.println(album1.addSongToPlaylistFromAlbum(2,myPlayList));
        System.out.println(album2.addSongToPlaylistFromAlbum("Same beef",myPlayList));

        play(myPlayList);

    }
    public static void play(List<Song> playList){

        ListIterator<Song> itr = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("playlist is empty");
            return;
        }

        boolean isNext;

        System.out.println("Currently playing");
        System.out.println(itr.next());

        isNext = true;

        Scanner sc = new Scanner(System.in);

        printMenu();
        while (true){
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();

            switch (choice){
                case 1://play next song
                    if(!isNext){
                        itr.next();
                        isNext = true;
                    }
                    if(itr.hasNext()){
                        System.out.println("Now playing:");
                        System.out.println(itr.next());
                        isNext = true;
                    }else System.out.println("you have reached the end of list");
                    break;
                case 2: //play prev song
                    if(isNext){
                        itr.previous();
                        isNext = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now playing");
                        System.out.println(itr.previous());
                        isNext = false;
                    }else System.out.println("you are at first song already");
                    break;
                case 3: //play curr song again
                    System.out.println(itr.previous());
                    itr.next();
                    break;
                case 4: //delete curr song

                    if(playList.size()<=0){
                        System.out.println("playlist is empty");
                    }
                    if(playList.size()>=1){
                        itr.remove();
                        System.out.println("Song deleted");
                        if(playList.size()==0){
                            System.out.println("playlist is empty");
                            return;
                        }
//                    if(!itr.hasPrevious()){
//                        itr.next();
//                    }
                }
                    break;
                case 5: //print all songs
                    printAllSongs(playList);
                    break;
                case 6: //to see menu again
                    printMenu();
                    break;
                case 7: //exit
                    return;
            }
        }

    }

    static void printAllSongs(List<Song> playList){
        for(Song song:playList){
            System.out.println(song);
        }
        return;
    }
    static void printMenu(){
        System.out.println("1. Play next song\n" +
                "2. Play previous song\n" +
                "3. Play current song again\n" +
                "4. Delete current song\n" +
                "5. Show all songs\n" +
                "6. Show menu again\n" +
                "7. Exit\n");
    }
}