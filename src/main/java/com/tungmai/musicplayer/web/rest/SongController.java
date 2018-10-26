package com.tungmai.musicplayer.web.rest;

import com.tungmai.musicplayer.model.Song;
import com.tungmai.musicplayer.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/song")
public class SongController {

    @Autowired
    private SongService songService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Set<Song> getAll(){
        return songService.getAll();
    }

}
