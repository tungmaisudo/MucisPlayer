package com.tungmai.musicplayer.service.impl;

import com.tungmai.musicplayer.service.GreetingService;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet(String name) {
        return "Hello, " + name;
    }



}
