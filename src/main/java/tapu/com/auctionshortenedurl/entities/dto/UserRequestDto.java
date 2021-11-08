package tapu.com.auctionshortenedurl.entities.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
	@NotNull(message = "username can not be empty")
    @NotBlank
    @Size(min=5, max=15,message = "username must be between 5-15 character")
	private String username;
	

	@NotNull(message = "Password can not be empty")
    @NotBlank
    @Size(min=5, max=10,message = "password must be between 5-15 character")
	private String password;
}
