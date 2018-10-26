package com.tungmai.musicplayer.service.impl;

import com.tungmai.musicplayer.model.Song;
import com.tungmai.musicplayer.repository.SongRepository;
import com.tungmai.musicplayer.service.SongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class SongServiceImpl implements SongService {

    private final Logger log = LoggerFactory.getLogger(SongService.class);


    @Autowired
    private SongRepository songRepository;

    @Override
    public Set<Song> getAll() {
        log.debug("Get all");
        List<Song> list = (List<Song>) songRepository.findAll();
        Set<Song> set = new HashSet<>(list);
        return set;
    }
}
