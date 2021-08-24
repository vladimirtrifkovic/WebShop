package com.example.demo.link;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(MusicAuthorLinkId.class)
@Table(name = "musicAuthorLink")
public class MusicAuthorLink implements Serializable {
	
	private static final long serialVersionUID = -3824344147888089657L;

	@Id
	private Integer musicId;
	
	@Id
	private Integer authorId;

	public Integer getMusicId() {
		return musicId;
	}

	public void setMusicId(Integer musicId) {
		this.musicId = musicId;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
}
