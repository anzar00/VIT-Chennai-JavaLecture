package com.vitchennai.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private final String content;
    private final LocalDateTime timestamp;

    public Post(String content) {
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        // Formats the time like "18:30"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return "'" + content + "' (at " + timestamp.format(formatter) + ")";
    }
}