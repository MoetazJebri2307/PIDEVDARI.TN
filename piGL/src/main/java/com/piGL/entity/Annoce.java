package com.piGL.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.piGL.enumerations.AdType;
import com.piGL.enumerations.Status;

import antlr.collections.List;

@Entity
@Table(name="ad")
public class Annoce {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	private String description ; 
	private String addresse ; 
	private float price ; 
	private int OwnerId; 
	private int roomsNumber; 
	private int bathroomsNumber  ; 
	private String image ;
	private boolean terrasse ; 
	private boolean garden ; 
	private boolean fournissed ;
	private float spaceCalcul ;
	private boolean swimmingPool ;
	
	private AdType adtype ; 
	
	private Status status ;
	
	
	@OneToMany(mappedBy = "annoce",cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
    
    private java.util.List<Comment> comments ;


	@Override
	public String toString() {
		return "Annoce [id=" + id + ", description=" + description + ", addresse=" + addresse + ", price=" + price
				+ ", OwnerId=" + OwnerId + ", roomsNumber=" + roomsNumber + ", bathroomsNumber=" + bathroomsNumber
				+ ", image=" + image + ", terrasse=" + terrasse + ", garden=" + garden + ", fournissed=" + fournissed
				+ ", spaceCalcul=" + spaceCalcul + ", swimmingPool=" + swimmingPool + ", adtype=" + adtype + ", status="
				+ status + ", comments=" + comments + "]";
	}


	public Annoce() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Annoce(String description, String addresse, float price, int ownerId, int roomsNumber, int bathroomsNumber,
			String image, boolean terrasse, boolean garden, boolean fournissed, float spaceCalcul, boolean swimmingPool,
			AdType adtype, Status status, java.util.List<Comment> comments) {
		super();
		this.description = description;
		this.addresse = addresse;
		this.price = price;
		OwnerId = ownerId;
		this.roomsNumber = roomsNumber;
		this.bathroomsNumber = bathroomsNumber;
		this.image = image;
		this.terrasse = terrasse;
		this.garden = garden;
		this.fournissed = fournissed;
		this.spaceCalcul = spaceCalcul;
		this.swimmingPool = swimmingPool;
		this.adtype = adtype;
		this.status = status;
		this.comments = comments;
	}


	public Annoce(Long id, String description, String addresse, float price, int ownerId, int roomsNumber,
			int bathroomsNumber, String image, boolean terrasse, boolean garden, boolean fournissed, float spaceCalcul,
			boolean swimmingPool, AdType adtype, Status status, java.util.List<Comment> comments) {
		super();
		this.id = id;
		this.description = description;
		this.addresse = addresse;
		this.price = price;
		OwnerId = ownerId;
		this.roomsNumber = roomsNumber;
		this.bathroomsNumber = bathroomsNumber;
		this.image = image;
		this.terrasse = terrasse;
		this.garden = garden;
		this.fournissed = fournissed;
		this.spaceCalcul = spaceCalcul;
		this.swimmingPool = swimmingPool;
		this.adtype = adtype;
		this.status = status;
		this.comments = comments;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getAddresse() {
		return addresse;
	}


	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getOwnerId() {
		return OwnerId;
	}


	public void setOwnerId(int ownerId) {
		OwnerId = ownerId;
	}


	public int getRoomsNumber() {
		return roomsNumber;
	}


	public void setRoomsNumber(int roomsNumber) {
		this.roomsNumber = roomsNumber;
	}


	public int getBathroomsNumber() {
		return bathroomsNumber;
	}


	public void setBathroomsNumber(int bathroomsNumber) {
		this.bathroomsNumber = bathroomsNumber;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public boolean isTerrasse() {
		return terrasse;
	}


	public void setTerrasse(boolean terrasse) {
		this.terrasse = terrasse;
	}


	public boolean isGarden() {
		return garden;
	}


	public void setGarden(boolean garden) {
		this.garden = garden;
	}


	public boolean isFournissed() {
		return fournissed;
	}


	public void setFournissed(boolean fournissed) {
		this.fournissed = fournissed;
	}


	public float getSpaceCalcul() {
		return spaceCalcul;
	}


	public void setSpaceCalcul(float spaceCalcul) {
		this.spaceCalcul = spaceCalcul;
	}


	public boolean isSwimmingPool() {
		return swimmingPool;
	}


	public void setSwimmingPool(boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}


	public AdType getAdtype() {
		return adtype;
	}


	public void setAdtype(AdType adtype) {
		this.adtype = adtype;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public java.util.List<Comment> getComments() {
		return comments;
	}


	public void setComments(java.util.List<Comment> comments) {
		this.comments = comments;
	}

	

}
