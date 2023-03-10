package com.app.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "artist")

public class Artist extends BaseEntity {

	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastName;
	@Column(length = 10)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(length = 30)
	@Enumerated(EnumType.STRING)
	private ArtistsType art_Type;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "artists")
	@JsonIgnore
	private Set<Content> contents = new HashSet<Content>();

	public Artist() {
		// TODO Auto-generated constructor stub
	}

	public Artist(String firstName, String lastName, Gender gender, ArtistsType art_Type) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.art_Type = art_Type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ArtistsType getArt_Type() {
		return art_Type;
	}

	public void setArt_Type(ArtistsType art_Type) {
		this.art_Type = art_Type;
	}

	public Set<Content> getContents() {
		return contents;
	}

	public void setContents(Set<Content> contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Artist [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", art_Type="
				+ art_Type + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(art_Type, firstName, gender, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artist other = (Artist) obj;
		return art_Type == other.art_Type && Objects.equals(firstName, other.firstName) && gender == other.gender
				&& Objects.equals(lastName, other.lastName);
	}
	
	

}
