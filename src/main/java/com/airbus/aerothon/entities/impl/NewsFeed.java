package com.airbus.aerothon.entities.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.airbus.aerothon.entities.AbstractBaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "NEWS_FEED")
public class NewsFeed extends AbstractBaseEntity{

	@Column(name="NEWS_HEADLINE")
	private String newsHeadline;
	
	@Column(name="NEWS_TEXT")
	private String newsText;
}
