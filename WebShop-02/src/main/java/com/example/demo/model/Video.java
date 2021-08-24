package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "video")
public class Video extends Item {

	private static final long serialVersionUID = 8597141412833009880L;

	private String director;
	
	@ManyToMany(targetEntity = Actor.class, cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
	@JoinTable(
		    name = "videoActorLink",
		    joinColumns = @JoinColumn(name = "videoId"),
		    inverseJoinColumns = @JoinColumn(name = "actorId")
		)
	private List<Actor> actors = new ArrayList<Actor>();
	
	private int duration;
	
	private int dvdNumber;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date publishDate;

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDvdNumber() {
		return dvdNumber;
	}

	public void setDvdNumber(int dvdNumber) {
		this.dvdNumber = dvdNumber;
	}
	
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getActorNames() {
		List<String> actorNames = actors.stream().map(Actor::getName).collect(Collectors.toList());
		return String.join(", ", actorNames);
	}
	
}
