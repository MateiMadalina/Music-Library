package com.codecool.musiclibrary.ui;

import com.codecool.musiclibrary.logger.Logger;

public class ConsoleLogger implements Logger {
    public void logInfo(String message) {
        logMessage(message, "INFO");
    }

    public void logError(String message) {
        logMessage(message, "ERROR");
    }

    private void logMessage(String message, String type) {
        System.out.println(message);
    }
}
