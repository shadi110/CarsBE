package com.carBE.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Video {
  @Id @GeneratedValue private Long id;
  private String title;
  private String s3Url;        // the full S3 link
}
