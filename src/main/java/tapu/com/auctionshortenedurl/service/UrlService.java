package tapu.com.auctionshortenedurl.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;

import tapu.com.auctionshortenedurl.entities.Url;
import tapu.com.auctionshortenedurl.entities.User;
import tapu.com.auctionshortenedurl.entities.dto.UrlRequestDto;
import tapu.com.auctionshortenedurl.entities.dto.UrlResponseDto;
import tapu.com.auctionshortenedurl.exception.AlreadyExist;
import tapu.com.auctionshortenedurl.exception.NotFoundException;
import tapu.com.auctionshortenedurl.repository.UrlRepository;

@Service
public class UrlService {

	private final UrlRepository urlRepository;
	private final Mapper dozerMapper;
	private final UserService userService;

	public UrlService(UrlRepository urlRepository, Mapper dozerMapper, UserService userService) {
		this.urlRepository = urlRepository;
		this.dozerMapper = dozerMapper;
		this.userService = userService;

	}

	public UrlResponseDto create(int userId, String longUrl) {

		User user = dozerMapper.map(userService.getById(userId), User.class);
		Url url = new Url();
		url.setUser(user);
		url.setLongUrl(longUrl);
		String shortened = generateRandom();
		url.setShortenedUrl(shortened);
		urlRepository.save(url);
		return dozerMapper.map(url, UrlResponseDto.class);

	}

	public UrlResponseDto update(UrlRequestDto requestDto ) {
		
		Optional<Url> result = urlRepository.findById(requestDto.getId());
		if (result.isPresent()) {
			result.get().setLongUrl(requestDto.getLongUrl());
			urlRepository.save(result.get());
		}
		throw new NotFoundException("There is no such Url in our system!!");
	}

	public String delete(int id) {
		Optional<Url> url = urlRepository.findById(id);
		if (url.isPresent()) {
			urlRepository.delete(url.get());
			return "Url deleted successfully.";
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

	public List<Url> getUrlsByUserId(int id){
		return urlRepository.getByUser_Id(id);
	}
	public boolean CheckIfShortenedUrlExist(String shortenedUrl) {
		Optional<Url> url = urlRepository.getByShortenedUrl(shortenedUrl);
		if (url.isPresent()) {
			return true;
		}
		return false;
	}

	public String generateRandom() {
		// create a string of uppercase and lowercase characters and numbers
		String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		// combine all strings
		String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

		// create random string builder
		StringBuilder sb = new StringBuilder();

		// create an object of Random class
		Random random = new Random();

		// specify length of random string
		int length = 10;
		for (int i = 0; i < length; i++) {

			// generate random index number
			int index = random.nextInt(alphaNumeric.length());

			// get character specified by index
			// from the string
			char randomChar = alphaNumeric.charAt(index);

			// append the character to string builder
			sb.append(randomChar);
		}

		String randomString = sb.toString();
		if (CheckIfShortenedUrlExist(randomString)) {
			return generateRandom();
		}

		return randomString;

	}

}