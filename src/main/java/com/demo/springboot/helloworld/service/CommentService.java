package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    List<Comment> allcomment(long id);
}
