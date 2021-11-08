package tapu.com.auctionshortenedurl.controller;

import java.net.URISyntaxException;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import tapu.com.auctionshortenedurl.entities.Url;
import tapu.com.auctionshortenedurl.entities.dto.UrlRequestDto;
import tapu.com.auctionshortenedurl.service.UrlService;

@RestController
@RequestMapping(value = "/api")
public class UrlController {

	private final UrlService urlService;
	private final RestTemplate restTemplate;
	public UrlController(UrlService urlService, RestTemplate restTemplate) {
		this.urlService = urlService;
		this.restTemplate = restTemplate;
	}

	@GetMapping(value = "/url/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(urlService.getAll());
	}

	@GetMapping(value = "/url/get/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {
		return ResponseEntity.ok(urlService.getById(id));
	}

	/*
	 * @PostMapping(value="/deneme/user/{id}/url/create") public ResponseEntity<?>
	 * create(@PathVariable("id") int id, @RequestBody UrlRequestDto url) { return
	 * ResponseEntity.ok(urlService.create(id, url)); }
	 */
	@GetMapping("/{shortenedurl}")
	public ResponseEntity<?> redirect(@PathVariable String shortenedurl)  {
		return ResponseEntity.ok(urlService.redirectToLongUrl(shortenedurl));
	}

	@GetMapping(value = "/url/getbyuserid/{id}")
	public ResponseEntity<?> getUrlsByUserId(@PathVariable int id) {
		return ResponseEntity.ok(urlService.getUrlsByUserId(id));
	}

	@PostMapping(value = "/user/{id}/url/create")
	public ResponseEntity<?> create(@Valid @PathVariable("id") int id, @RequestParam String longUrl) {
		return ResponseEntity.ok(urlService.create(id, longUrl));
	}

	@PutMapping(value = "/url/update")
	public ResponseEntity<?> update(@RequestBody UrlRequestDto requestDto) {
		return ResponseEntity.ok(urlService.update(requestDto));
	}

	@DeleteMapping(value = "/url/delete")
	public ResponseEntity<?> delete(int urlId) {
		return ResponseEntity.ok(urlService.delete(urlId));
	}
	
	
	/* @GetMapping(value = "/{url}", produces = { "application/json" })
	    public ResponseEntity<?> getRedirectInfo(@PathVariable String url) {
	        HttpHeaders headers = new HttpHeaders();
	        HttpEntity entity = new HttpEntity(headers);
	        return restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<Map<String, Object>>(){});
	    }*/
}
