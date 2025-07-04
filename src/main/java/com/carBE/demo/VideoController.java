package com.carBE.demo;

import com.carBE.demo.Video;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/videos")
public class VideoController {

	private final VideoRepository videoRepository;

    /** POST /videos
     *  Body JSON:
     *  {
     *    "title": "My clip",
     *    "s3Url": "https://bucket.s3.amazonaws.com/clip.mp4"
     *  }
     */
    @PostMapping
    public ResponseEntity<Video> create(@RequestBody Video video) {
    	System.out.println("the vide object is");
    	System.out.println(video);
        Video saved = videoRepository.save(video);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // keep your /hello endpoint if you like
}
