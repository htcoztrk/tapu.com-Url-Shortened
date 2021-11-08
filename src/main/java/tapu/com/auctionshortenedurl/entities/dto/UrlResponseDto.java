package tapu.com.auctionshortenedurl.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlResponseDto {

	private int id;
	private String shortenedUrl;
}
