package tapu.com.auctionshortenedurl.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tapu.com.auctionshortenedurl.entities.Url;
import tapu.com.auctionshortenedurl.service.UrlService;

@RestController
@RequestMapping(value="/url")
public class UrlController {

	private final UrlService urlService;
	public UrlController(UrlService urlService) {
		this.urlService = urlService;	
	}
	@GetMapping(value="/getall")
	public ResponseEntity<?>getAll(){
		return ResponseEntity.ok(urlService.getAll());
	}
	@GetMapping(value="/get/{id}")
	public ResponseEntity<?>getById(@PathVariable int id){
		return ResponseEntity.ok(urlService.getById(id));
	}
	@GetMapping(value="/add")
	public ResponseEntity<?>add(@PathVariable Url url){
		return ResponseEntity.ok(urlService.add(url));
	}
}
