package com.vitchennai.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String username;
    // HERE is our List! It's generic (List<Post>)
    private final List<Post> posts;

    public User(String username) {
        this.username = username;
        // We choose ArrayList: fast to add to the end (new posts)
        this.posts = new ArrayList<>();
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

    public String getUsername() {
        return username;
    }

    public List<Post> getPosts() {
        return posts;
    }
}