package com.carBE.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Video {
  @Id @GeneratedValue private Long id;
  private String title;
  private String s3Url;        // the full S3 link
}
