package com.example.demo.link;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(VideoActorLinkId.class)
@Table(name = "videoActorLink")
public class VideoActorLink implements Serializable {

	private static final long serialVersionUID = 4196133759159117922L;

	@Id
	private Integer videoId;
	
	@Id
	private Integer actorId;

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}
}
