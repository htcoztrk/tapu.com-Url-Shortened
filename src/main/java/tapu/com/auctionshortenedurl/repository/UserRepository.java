package tapu.com.auctionshortenedurl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tapu.com.auctionshortenedurl.entities.Url;
import tapu.com.auctionshortenedurl.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	
}
