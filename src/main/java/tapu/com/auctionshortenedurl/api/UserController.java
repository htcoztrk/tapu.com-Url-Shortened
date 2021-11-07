package tapu.com.auctionshortenedurl.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tapu.com.auctionshortenedurl.entities.User;
import tapu.com.auctionshortenedurl.entities.dto.UserRequestDto;
import tapu.com.auctionshortenedurl.service.UrlService;
import tapu.com.auctionshortenedurl.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	private final UserService userService;
	private final UrlService urlService;
	
	public UserController(UserService userService, UrlService urlService) {
		this.userService = userService;
		this.urlService = urlService;
		
	}
	@PostMapping(value="/signup")
	public ResponseEntity<?> add(UserRequestDto user) {
		return ResponseEntity.ok(userService.add(user));
	}
	@PostMapping(value="/{id}/url/create")
	public ResponseEntity<?> createUrl(@PathVariable int id,@RequestParam String url) {
		
		return ResponseEntity.ok(urlService.add(null));
	}
	
}
