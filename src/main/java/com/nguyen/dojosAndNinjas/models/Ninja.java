package com.nguyen.dojosAndNinjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ninjas")
public class Ninja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Please enter ninja name.")
	@Size(min = 2, max = 45, message = "Ninja name must be between 2 and 45 characters.")
	private String ninjaName;

	@NotEmpty(message = "Please enter ninja type.")
	@Size(min = 2, max = 45, message = "Ninja type must be between 2 and 45 characters.")
	private String ninjaType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dojo_id")
	private Dojo dojo;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
	
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Ninja() {}
    
    public Ninja(String ninjaName, String ninjaType, Dojo dojo) {
    	this.ninjaName = ninjaName;
    	this.ninjaType = ninjaType;
    	this.dojo = dojo;
    }

	public String getNinjaName() {
		return ninjaName;
	}

	public void setNinjaName(String ninjaName) {
		this.ninjaName = ninjaName;
	}

	public String getNinjaType() {
		return ninjaType;
	}

	public void setNinjaType(String ninjaType) {
		this.ninjaType = ninjaType;
	}

	public Long getId() {
		return id;
	}

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
