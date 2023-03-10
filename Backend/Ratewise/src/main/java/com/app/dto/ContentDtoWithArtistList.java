package com.app.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.entity.BaseEntity;
import com.app.entity.ContentType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Entity
//@Table(name = "content")
//@NoArgsConstructor 
//@Getter 
//@Setter
//@ToString
//@AllArgsConstructor
public class ContentDtoWithArtistList extends BaseEntity{

	@Column
	@Enumerated(EnumType.STRING)
	private ContentType type;
	@Column(length = 50)
	private String name;
	@Column(length = 500)
	private String posterLink;
	@Column(length = 30)
	private Double length;
	@Column
	private String genre;
	
	@Column
	@JsonProperty(access = Access.READ_ONLY)
	private double avgRating;
	
	public double getAvgRating() {
		return avgRating;
	}


	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}


	private List<Integer> artistsId = new ArrayList<>();
	
	
	
	
	
	public ContentDtoWithArtistList() {
		// TODO Auto-generated constructor stub
	}


	public ContentDtoWithArtistList(ContentType type, String name, String posterLink, Double length, String genre) {
		super();
		this.type = type;
		this.name = name;
		this.posterLink = posterLink;
		this.length = length;
		this.genre = genre;
	}


	public ContentType getType() {
		return type;
	}


	public void setType(ContentType type) {
		this.type = type;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPosterLink() {
		return posterLink;
	}


	public void setPosterLink(String posterLink) {
		this.posterLink = posterLink;
	}


	public Double getLength() {
		return length;
	}


	public void setLength(Double length) {
		this.length = length;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}



	public List<Integer> getArtistsId() {
		return artistsId;
	}


	public void setArtistsId(List<Integer> artistsId) {
		this.artistsId = artistsId;
	}


	@Override
	public String toString() {
		return "Content [type=" + type + ", name=" + name + ", posterLink=" + posterLink + ", length=" + length
				+ ", genre=" + genre + ", avgRating=" + avgRating + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(avgRating, genre, length, name, posterLink, type);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContentDtoWithArtistList other = (ContentDtoWithArtistList) obj;
		return Double.doubleToLongBits(avgRating) == Double.doubleToLongBits(other.avgRating)
				&& Objects.equals(genre, other.genre) && Objects.equals(length, other.length)
				&& Objects.equals(name, other.name) && Objects.equals(posterLink, other.posterLink)
				&& type == other.type;
	}
	
	
	
}
