package tapu.com.auctionshortenedurl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tapu.com.auctionshortenedurl.entities.Url;
@Repository
public interface UrlRepository extends JpaRepository<Url,Integer> {

	Optional<Url> getByShortenedUrl(String shortenedUrl);
	//Url getByLongUrl(String longUrl);
	List<Url> getByUser_Id(int id);
}
