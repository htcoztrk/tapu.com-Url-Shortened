package tapu.com.auctionshortenedurl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tapu.com.auctionshortenedurl.entities.Url;
import tapu.com.auctionshortenedurl.entities.User;
import tapu.com.auctionshortenedurl.exception.NotFoundException;
import tapu.com.auctionshortenedurl.repository.UrlRepository;

@Service
public class UrlService {

	private final UrlRepository urlRepository;

	public UrlService(UrlRepository urlRepository) {
		this.urlRepository = urlRepository;

	}

	public int add(Url url) {
		this.urlRepository.save(url);
		return url.getId();
	}

	public Url update(Url url) {
		Optional<Url> result = urlRepository.findById(url.getId());
		if (result.isPresent()) {
			urlRepository.save(result.get());
		}
		throw new NotFoundException("There is no such id in our system!!");
	}

	public String delete(int userId) {
		Optional<Url> url = urlRepository.findById(userId);
		if (url.isPresent()) {
			urlRepository.delete(url.get());
		}
		throw new NotFoundException("There is no such id in our system!!");
	}

	public List<Url> getAll() {
		return urlRepository.findAll();
	}

	public Url getById(int userId) {
		Optional<Url> url = urlRepository.findById(userId);
		if (url.isPresent()) {
			return url.get();
		}
		throw new NotFoundException("There is no such id in our system!!");
	}
}