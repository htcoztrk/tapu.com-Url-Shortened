package tapu.com.auctionshortenedurl.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "url"})
public class User implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "username can not be empty")
    @NotBlank
    @Size(min=5, max=15,message = "username must be between 5-15 character")
	@Column(name="username")
	private String username;
	
	@NotNull(message = "Password can not be empty")
    @NotBlank
    @Size(min=5, max=10,message = "password must be between 5-15 character")
	@JsonIgnore
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<Url> url;

	

	
}
