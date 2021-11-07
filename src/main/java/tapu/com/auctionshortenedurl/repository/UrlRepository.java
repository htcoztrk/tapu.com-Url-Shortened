package tapu.com.auctionshortenedurl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tapu.com.auctionshortenedurl.entities.Url;

public interface UrlRepository extends JpaRepository<Url,Integer> {

	
}
