package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> allcomment(long id);

    Comment add(long userId, long goodId, String mycomment);
}
