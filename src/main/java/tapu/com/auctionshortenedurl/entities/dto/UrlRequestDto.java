package tapu.com.auctionshortenedurl.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlRequestDto {
	private int id;
  private String longUrl;
}
