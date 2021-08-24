package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.link.CartBookLink;
import com.example.demo.link.CartMusicLink;
import com.example.demo.link.CartVideoLink;

@Entity
@Table(name = "carts")
public class Cart implements Serializable{

	private static final long serialVersionUID = -7175863043530635326L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_date")
    private Date createdDate;

    private boolean submitted = false;
    
    private Date submittedDate;
    
    @OneToMany(mappedBy="cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartBookLink> booksLink = new ArrayList<CartBookLink>();
    
    @OneToMany(mappedBy="cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartVideoLink> videosLink = new ArrayList<CartVideoLink>();
    
    @OneToMany(mappedBy="cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartMusicLink> musicsLink = new ArrayList<CartMusicLink>();
    
    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private Buyer buyer;
    
	
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}
	
	public Date getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Date submittedDate) {
		this.submittedDate = submittedDate;
	}

	public List<CartBookLink> getBooksLink() {
		return booksLink;
	}

	public void setBooksLink(List<CartBookLink> booksLink) {
		this.booksLink = booksLink;
	}
	
	public List<CartVideoLink> getVideosLink() {
		return videosLink;
	}

	public void setVideosLink(List<CartVideoLink> videosLink) {
		this.videosLink = videosLink;
	}

	public List<CartMusicLink> getMusicsLink() {
		return musicsLink;
	}

	public void setMusicsLink(List<CartMusicLink> musicsLink) {
		this.musicsLink = musicsLink;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
}
