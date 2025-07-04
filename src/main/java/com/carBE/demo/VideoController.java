package com.carBE.demo;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.carBE.demo.dto.Video;

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
    
    @GetMapping
    public List<Video> findAll() {
        return (List<Video>) videoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> findById(@PathVariable Long id) {
        return videoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /* --------------------  UPDATE  -------------------- */

    @PutMapping("/{id}")
    public ResponseEntity<Video> update(@PathVariable Long id,
                                        @RequestBody Video updated) {
        return videoRepository.findById(id)
                .map(existing -> {
                    existing.setTitle(updated.getTitle());
                    existing.setS3Url(updated.getS3Url());
                    Video saved = videoRepository.save(existing);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /* --------------------  DELETE  -------------------- */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (videoRepository.existsById(id)) {
            videoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
