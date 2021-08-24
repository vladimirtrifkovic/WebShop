package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable {
	
	private static final long serialVersionUID = 2431101329479799617L;

		@Id
	    @Column(name = "role_id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    
		@Column(nullable = false)
	    private String name;
	    public Integer getId() {
	        return id;
	    }
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return name + ", ";
		}
		
		
}
