package com.vitchennai.services;

import com.vitchennai.models.Post;
import com.vitchennai.models.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevConnectService {
    // HERE is our Map! It's generic (Map<String, User>)
    private final Map<String, User> users;

    public DevConnectService() {
        // We choose HashMap: fast O(1) lookups by username
        this.users = new HashMap<>();
    }

    public void createUser(String username) {
        // putIfAbsent is a clean way to add only if the key is new
        if (users.putIfAbsent(username, new User(username)) == null) {
            System.out.println("LOG: User '" + username + "' created.");
        }
    }

    public void addPost(String username, String content) {
        // Fast lookup from the Map!
        User user = users.get(username);
        if (user != null) {
            user.addPost(new Post(content));
        } else {
            System.out.println("ERROR: User " + username + " not found.");
        }
    }

    public void displayUserFeed(String username) {
        System.out.println("\n--- FEED FOR " + username.toUpperCase() + " ---");
        // Fast lookup from the Map!
        User user = users.get(username);
        if (user != null) {
            // Get the List of posts
            List<Post> posts = user.getPosts();
            if (posts.isEmpty()) {
                System.out.println("  No posts yet.");
            } else {
                // The List guarantees they print in order!
                for (Post post : posts) {
                    System.out.println("  -> " + post);
                }
            }
        } else {
            System.out.println("  User not found.");
        }
    }
}