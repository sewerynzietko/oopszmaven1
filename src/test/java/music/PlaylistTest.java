package music;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {
    @Test
    public void testIfNewListIsEmpty(){
        Playlist playlist = new Playlist();
        assertTrue(playlist.isEmpty());
    }
    @Test
    public void testIfAfterAddingFirstOneSizeIsOne(){
        Playlist playlist = new Playlist();
        Song song = new Song(" "," ",0);
        playlist.add(song);
        assertEquals(1, playlist.size());
    }
    @Test
    public void testIfAddedSongIsTheSameObjectInList(){
        Playlist playlist = new Playlist();
        Song songToAdd = new Song(" "," ",0);
        playlist.add(songToAdd);
        assertTrue(playlist.get(0) == songToAdd);
    }
    @Test
    public void testIfAddedSongHaveTheSameFields(){
        Playlist playlist = new Playlist();
        Song songToAdd = new Song(" "," ",0);
        playlist.add(songToAdd);
        assertTrue(playlist.get(0).equals(songToAdd));
    }
    @Test
    public void testAtSecond(){
        Playlist playlist = new Playlist();
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> playlist.atSecond(35));
        Song songToAdd1 = new Song(" "," ",120);
        Song songToAdd2 = new Song(" "," ",120);
        playlist.add(songToAdd1);
        playlist.add(songToAdd2);
        assertTrue(playlist.atSecond(180)==songToAdd2);
        assertNull(playlist.atSecond(-10));
        assertNull(playlist.atSecond(360));
    }

}