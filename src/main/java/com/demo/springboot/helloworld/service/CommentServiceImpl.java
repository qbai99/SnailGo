package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Comment;
import com.demo.springboot.helloworld.common.domain.CommentExample;
import com.demo.springboot.helloworld.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> allcomment(long id) {

        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andGoodsIdEqualTo(id);
        List<Comment> list=commentMapper.selectByExample(commentExample);
        return list;
    }

    @Override
    public Comment add(long userId, long goodId, String mycomment) {
        Comment comment=new Comment();
        comment.setUserId(userId);
        comment.setGoodsId(goodId);
        comment.setCom(mycomment);
        commentMapper.insert(comment);
        System.out.println(comment);
       CommentExample example=new CommentExample();
        example.createCriteria().andGoodsIdEqualTo(goodId);

        return comment;
    }
}
