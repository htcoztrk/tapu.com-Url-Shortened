package tapu.com.auctionshortenedurl.controller;

import javax.validation.Valid;

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
	public ResponseEntity<?> add(@Valid UserRequestDto user) {
		return ResponseEntity.ok(userService.add(user));
	}
	@GetMapping(value="/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(userService.getAll());
	}
	@GetMapping(value="/getbyid/{id}")
	public ResponseEntity<?> getAll(@PathVariable int id){
		return ResponseEntity.ok(userService.getById(id));
	}
	/*@PostMapping(value="/{id}/url/create")
	public ResponseEntity<?> createUrl(@PathVariable("id") int id,@RequestParam("url") String url) {	
		return ResponseEntity.ok(urlService.getById(id));
	}*/
	
}
