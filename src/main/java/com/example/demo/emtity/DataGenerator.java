package com.example.demo.emtity;

import com.example.demo.model.*;
import com.example.demo.model.entities.friendstatus;
import com.example.demo.repository.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    private com.example.demo.repository.userRepository userRepository;

    @Autowired
    private postRepository postRepository;

    @Autowired
    private commentRepository commentRepository;

    @Autowired
    private com.example.demo.repository.likeRepository likeRepository;

    @Autowired
    private friendRepository friendRepository;

    @Autowired
    private meseageRepository messageRepository;

    private Faker faker = new Faker();

    // Generate random timestamp between 2021-01-01 and 2022-12-31
    private Timestamp getRandomTimestamp() {
        long offset = Timestamp.valueOf("2021-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2022-12-31 00:00:00").getTime();
        long diff = end - offset + 1;
        Timestamp randomTimestamp = new Timestamp(offset + (long)(Math.random() * diff));
        return randomTimestamp;
    }

    @Override
    public void run(String... args) throws Exception {
        // Generate users
        List<user> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            user user = new user();
            user.setUsername(faker.name().username());
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password());
            user.setProfilePicture(faker.internet().avatar());
            user.setBio(faker.lorem().sentence());
            user.setCreatedAt(getRandomTimestamp());
            user.setUpdatedAt(getRandomTimestamp());
            users.add(user);
        }
        userRepository.saveAll(users);

        // Generate posts
        List<post> posts = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            post post = new post();
            post.setUser(users.get(faker.random().nextInt(0, 9)));
            post.setContent(faker.lorem().paragraph());
            post.setPostImage(faker.internet().image());
            post.setCreatedAt(getRandomTimestamp());
            post.setUpdatedAt(getRandomTimestamp());
            posts.add(post);
        }
        postRepository.saveAll(posts);

        // Generate comments
        List<comment> comments = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            comment comment = new comment();
            comment.setUser(users.get(faker.random().nextInt(0, 9)));
            comment.setPost(posts.get(faker.random().nextInt(0, 49)));
            comment.setComment(faker.lorem().sentence());
            comment.setCreatedAt(getRandomTimestamp());
            comment.setUpdatedAt(getRandomTimestamp());
            comments.add(comment);
        }
        commentRepository.saveAll(comments);

        // Generate likes
        List<like> likes = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            like like = new like();
            like.setUser(users.get(faker.random().nextInt(0, 9)));
            like.setPost(posts.get(faker.random().nextInt(0, 49)));
            like.setCreatedAt(getRandomTimestamp());
            likes.add(like);
        }
        likeRepository.saveAll(likes);

        // Generate friends
        List<friend> friends = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            friend friend = new friend();
            friend.setUser1(users.get(faker.random().nextInt(0, 9)));
            friend.setUser2(users.get(faker.random().nextInt(0, 9)));
            friend.setStatus(friendstatus.values()[faker.random().nextInt(0, 2)]);
            friend.setActionUser(users.get(faker.random().nextInt(0, 9)));
            friend.setCreatedAt(getRandomTimestamp());
            friend.setUpdatedAt(getRandomTimestamp());
            friends.add(friend);
        }
        friendRepository.saveAll(friends);

        // Generate messages
        List<message> messages = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            message message = new message();
            message.setSender(users.get(faker.random().nextInt(0, 9)));
            message.setReceiver(users.get(faker.random().nextInt(0, 9)));
            message.setMessage(faker.lorem().sentence());
            message.setCreatedAt(getRandomTimestamp());
            message.setUpdatedAt(getRandomTimestamp());
            messages.add(message);
        }
        messageRepository.saveAll(messages);
    }
}