package com.codecool.musiclibrary.ui;

import com.codecool.musiclibrary.logger.Logger;
import com.codecool.musiclibrary.model.Song;
import com.codecool.musiclibrary.service.LibraryList;

import java.util.Scanner;

public class MusicLibraryUi {

    private final Logger logger;
    private final LibraryList libraryList;

    public MusicLibraryUi(Logger logger, LibraryList libraryList) {
        this.logger = logger;
        this.libraryList = libraryList;
    }

    public void run() {
        displayWelcomeMessage();

        int code = 0;

        while (code != 6) {
            displayMenu();
            code = getCode();

            switch (code) {
                case 1 -> addSong();
                case 2 -> viewLibrary();
                case 3 -> searchSong();
                case 4 -> removeSong();
                case 5 -> clearAll();
            }
        }
    }

    private void displayWelcomeMessage() {

        logger.logInfo("Welcome to Codecool Music Library.");
    }

    private void displayMenu() {
        logger.logInfo("1 - Add Song");
        logger.logInfo("2 - View Library");
        logger.logInfo("3 - Search Songs");
        logger.logInfo("4 - Remove Song");
        logger.logInfo("5 - Clear Library");
        logger.logInfo("6 - Exit");
    }

    private static int getCode() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private  void addSong() {
        Scanner scanner = new Scanner(System.in);
        logger.logInfo("Enter the title of the song: ");
        String title = scanner.nextLine();
        logger.logInfo("Enter the artist of the song: ");
        String artist = scanner.nextLine();
        logger.logInfo("Enter the length in seconds of the song: ");
        int lengthInSeconds = scanner.nextInt();
        Song song = new Song(title,artist,lengthInSeconds);
        libraryList.addMelody(song);
    }

    private void viewLibrary() {
        libraryList.songDisplayedAlphabeticalOrder();
    }

    private void searchSong(){
        Scanner scanner = new Scanner(System.in);
        logger.logInfo("Enter the name of artist you want to fine a song: ");
        String artistName = scanner.nextLine();
        libraryList.displayArtistSong(artistName);
    }

    private void removeSong(){
    Scanner scanner = new Scanner(System.in);
    logger.logInfo("Enter the title of the song you want to remove from the list");
    String titleToRemove = scanner.nextLine();
    libraryList.removeSongByName(titleToRemove);
    }

    private void clearAll(){
        libraryList.clearAll();
    }
}

