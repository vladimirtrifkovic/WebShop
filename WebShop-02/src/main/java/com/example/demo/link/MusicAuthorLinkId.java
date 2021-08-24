package com.example.demo.link;

import java.io.Serializable;

public class MusicAuthorLinkId implements Serializable {
	
	private static final long serialVersionUID = 3697349301764204047L;

	private Integer musicId;
	
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MusicAuthorLinkId other = (MusicAuthorLinkId) obj;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		if (musicId == null) {
			if (other.musicId != null)
				return false;
		} else if (!musicId.equals(other.musicId))
			return false;
		return true;
	}

}
