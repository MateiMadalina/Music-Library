package com.codecool.musiclibrary.service;

import java.util.LinkedList;
import java.util.List;

import com.codecool.musiclibrary.model.Song;

public class LibraryList implements Library{
    private LinkedList<Song> melodies;

    public LibraryList(Song[] songs) {
        melodies = new LinkedList<>();
        for (Song song : songs) {
            melodies.add(song);
        }
    }

    public void addMelody(Song melody) {
        melodies.add(melody);
    }

    public void songDisplayedAlphabeticalOrder() {
        LinkedList<Song> sortedList = new LinkedList<>(melodies);

        sortedList.sort((song1, song2) -> song1.artist().compareToIgnoreCase(song2.artist()));

        for (Song song : sortedList) {
            System.out.println(song);
        }
    }

    public void removeSongByName(String songName) {
        List<Song> updatedList = new LinkedList<>(melodies);
        for (Song song : melodies) {
            if (song.title().equals(songName)) {
                updatedList.remove(song);
            }
        }
        melodies = (LinkedList<Song>) updatedList;

        // melodies.removeIf(song -> song.title().equals(songName));
    }

    public void displayArtistSong (String artistName){
        LinkedList<Song> copyList = new LinkedList<>();
        for(Song song : melodies){
            if(song.artist().equals(artistName)){
                copyList.add(song);
            }
        }

        for(Song song : copyList){
            System.out.println(song);
        }
    }

    public void clearAll(){
        melodies.clear();
    }


}
