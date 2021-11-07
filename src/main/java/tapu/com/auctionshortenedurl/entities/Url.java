package tapu.com.auctionshortenedurl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="url")
public class Url {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="long_url")
	private String longUrl;
	
	@Column(name="shortened_url")
	private String shortenedUrl;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	User user;
	
	public Url() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	public String getShortenedUrl() {
		return shortenedUrl;
	}
	public void setShortenedUrl(String shortenedUrl) {
		this.shortenedUrl = shortenedUrl;
	}

}
