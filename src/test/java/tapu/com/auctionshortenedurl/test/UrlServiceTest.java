package tapu.com.auctionshortenedurl.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.github.dozermapper.core.Mapper;

import tapu.com.auctionshortenedurl.entities.Url;
import tapu.com.auctionshortenedurl.entities.User;
import tapu.com.auctionshortenedurl.entities.dto.UrlRequestDto;
import tapu.com.auctionshortenedurl.entities.dto.UrlResponseDto;
import tapu.com.auctionshortenedurl.entities.dto.UserResponseDto;
import tapu.com.auctionshortenedurl.repository.UrlRepository;
import tapu.com.auctionshortenedurl.service.UrlService;
import tapu.com.auctionshortenedurl.service.UserService;
import tapu.com.auctionshortenedurl.util.exception.NotFoundException;

class UrlServiceTest {

	private UrlService urlService;

	private UrlRepository urlRepository;

	private Mapper dozerMapper;

	private UserService userService;

	@BeforeEach
	public void setUp() throws Exception {
		urlRepository = Mockito.mock(UrlRepository.class);
		dozerMapper = Mockito.mock(Mapper.class);
		userService = Mockito.mock(UserService.class);

		urlService = new UrlService(urlRepository, dozerMapper, userService);
	}

	
	  @Test void
	  createUrlCalledWithValidRequest_itShoultReturnValidUrlResponseDto() {
	  
	  User user=new User(); user.setId(1); user.setPassword("1245");
	  user.setUsername("username");
	  
	  Url url=new Url(); url.setId(1); url.setLongUrl("something");
	  url.setShortenedUrl(urlService.generateRandom()); url.setUser(user);
	  
	  UrlResponseDto responseDto=new UrlResponseDto(); responseDto.setId(1);
	  responseDto.setShortenedUrl("shorted");
	  Mockito.when(userService.getById(1)).thenReturn(user);
	  //Mockito.when(dozerMapper.map(urlRequestDto, Url.class)).thenReturn(url);
	  Mockito.when(urlRepository.save(url)).thenReturn(url);
	  Mockito.when(dozerMapper.map(url,
	  UrlResponseDto.class)).thenReturn(responseDto);
	  
	  UrlResponseDto result=urlService.create(1, "something");
	  assertEquals(result,responseDto);
	  
	  }
	 
	

	
	@Test
	void testGetUrlByUserId_whenUserIdExistReturnUrls() {
		User user = new User();
		user.setId(1);

		Url url = new Url();
		url.setId(1);
		url.setLongUrl("something");
		url.setShortenedUrl("something");
		url.setUser(user);

		Mockito.when(urlRepository.getByUser_Id(1)).thenReturn(List.of(url));

		List<Url> result = urlService.getUrlsByUserId(1);
		assertEquals(List.of(url), result);

	}

	@Test
	void getAllUrlTest() {
		Url url = new Url();
		Mockito.when(urlRepository.findAll()).thenReturn(List.of(url));

		List<Url> result = urlService.getAll();

		assertEquals(List.of(url), result);

	}
	@Test
	void getUrlByUrlId(){
		Url url=new Url();
		url.setId(1);
		url.setLongUrl("something");
		url.setShortenedUrl("shortened");
		
		Mockito.when(urlRepository.findById(1)).thenReturn(Optional.of(url));
	
		Url result=urlService.getById(1);
		assertEquals(result,url);
	}
	@Test
	void getUrlByUrlId_whenIdNotExistThrowNotFoundException(){
		
		Mockito.when(urlRepository.findById(1)).thenReturn(Optional.empty());
	
		assertThrows(NotFoundException.class, () -> urlService.getById(1));
		//assertThrows(NotFoundException.class,()->urlService.getById(1));
	}
}
