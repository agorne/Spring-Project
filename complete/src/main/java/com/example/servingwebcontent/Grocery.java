package com.example.servingwebcontent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grocery {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private boolean isFruit;
	private boolean isMeat;
	private boolean isDairy;
	private String name;
	
	public Grocery() {
		super();
	}
	
	public Grocery(boolean isFruit, boolean isMeat, boolean isDairy, String name) {
		super();
		this.isFruit = isFruit;
		this.isMeat = isMeat;
		this.isDairy = isDairy;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public boolean getIsFruit() {
		return isFruit;
	}
	
	public void setIsFruit(boolean isFruit) {
		this.isFruit = isFruit;
	}
	
	public boolean getIsMeat() {
		return isMeat;
	}
	
	public void setIsMeat(boolean isMeat) {
		this.isMeat = isMeat;
	}
	
	public boolean getIsDairy() {
		return isDairy;
	}
	
	public void setIsDairy(boolean isDairy) {
		this.isDairy = isDairy;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
