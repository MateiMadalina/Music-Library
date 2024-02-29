package com.codecool.musiclibrary.model;

import java.util.Objects;

public record Song(String title, String artist, int lengthInSeconds) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Song) obj;
        return Objects.equals(this.title, that.title) &&
                Objects.equals(this.artist, that.artist) &&
                this.lengthInSeconds == that.lengthInSeconds;
    }

    @Override
    public String toString() {
        return "Song[" +
                "title=" + title + ", " +
                "artist=" + artist + ", " +
                "lengthInSeconds=" + lengthInSeconds + ']';
    }
}
