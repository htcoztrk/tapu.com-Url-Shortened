package tapu.com.auctionshortenedurl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tapu.com.auctionshortenedurl.entities.Url;
import tapu.com.auctionshortenedurl.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	
}
