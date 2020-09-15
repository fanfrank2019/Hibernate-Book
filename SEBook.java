package com.junfan.books;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "book_id")
public class SEBook extends Book{
	
	private String special_feature;
	
	public SEBook() {}

	public String getSpecial_feature() {
		return special_feature;
	}

	public void setSpecial_feature(String special_feature) {
		this.special_feature = special_feature;
	}
	
	
}
