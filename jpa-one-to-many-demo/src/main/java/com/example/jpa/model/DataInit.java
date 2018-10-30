package com.example.jpa.model;

import com.example.jpa.repository.CommentRepository;
import com.example.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataInit implements ApplicationRunner {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    @Autowired
    public DataInit(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Post post01 = new Post("Title01", "Description01", "Content01");
        Post post02 = new Post("Title02", "Description02", "Content02");
        Post post03 = new Post("Title03", "Description03", "Content03");
        postRepository.save(post01);
        postRepository.save(post02);
        postRepository.save(post03);

        commentRepository.saveAll(Stream.of(
                new Comment("comment0101", post01),
                new Comment("comment0102", post01),
                new Comment("comment0201", post02),
                new Comment("comment0201", post02),
                new Comment("comment0301", post03),
                new Comment("comment0301", post03)
        ).collect(Collectors.toList()));




    }
}
