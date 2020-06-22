package com.demo.springboot.helloworld.service;

import com.demo.springboot.helloworld.common.domain.Userlevel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserlevelService {

    List<Userlevel> level(String userEmail);

}
