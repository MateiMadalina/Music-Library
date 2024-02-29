package com.codecool.musiclibrary.service;

import com.codecool.musiclibrary.model.Song;


public interface Library {
    public void addMelody(Song melody);

    public void songDisplayedAlphabeticalOrder();

    public void removeSongByName(String songName);

    public void displayArtistSong(String artistName);

    public void clearAll();
}
