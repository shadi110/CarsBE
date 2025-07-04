package com.carBE.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.carBE.demo.dto.Video;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long> { }
