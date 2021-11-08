package tapu.com.auctionshortenedurl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="url")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","user"})
public class Url {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotNull(message="url can not be empty")
	@Column(name="long_url")
	private String longUrl;
	
	@Column(name="shortened_url")
	private String shortenedUrl;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	User user;
	
	
}
