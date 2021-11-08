package tapu.com.auctionshortenedurl.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.github.dozermapper.core.Mapper;

import junit.framework.Assert;
import tapu.com.auctionshortenedurl.entities.User;
import tapu.com.auctionshortenedurl.entities.dto.UserRequestDto;
import tapu.com.auctionshortenedurl.entities.dto.UserResponseDto;
import tapu.com.auctionshortenedurl.repository.UserRepository;
import tapu.com.auctionshortenedurl.service.UserService;
import tapu.com.auctionshortenedurl.util.exception.NotFoundException;

class UserServiceTest {

	private UserService userService;

	private UserRepository userRepository;

	private Mapper dozerMapper;

	@BeforeEach
	public void setUp() throws Exception {
		userRepository = Mockito.mock(UserRepository.class);
		dozerMapper = Mockito.mock(Mapper.class);

		userService = new UserService(userRepository, dozerMapper);
	}

	@Test
	void whenCreateUserCalledWithValidRequest_itShoultReturnValidUserResponseDto() {
		UserRequestDto userRequestDto = new UserRequestDto();
		userRequestDto.setPassword("1234");
		userRequestDto.setUsername("hatice");
		User user = new User();
		user.setId(1);
		user.setPassword("1234");
		user.setUsername("hatice");

		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setId(1);

		Mockito.when(dozerMapper.map(userRequestDto, User.class)).thenReturn(user);
		Mockito.when(userRepository.save(user)).thenReturn(user);
		Mockito.when(dozerMapper.map(user, UserResponseDto.class)).thenReturn(userResponseDto);

		UserResponseDto response = userService.add(userRequestDto);

		assertEquals(userResponseDto, response);

	}

	@Test
	void testGetByUserId_whenUserIdExistShouldReturnUserResponseDto() {
		User user = new User();
		user.setId(1);
		user.setPassword("1234");
		user.setUsername("hatice");

		Mockito.when(userRepository.findById(1)).thenReturn(Optional.of(user));

		User result = userService.getById(1);
		assertEquals(result, user);

	}

	@Test
	void testGetByUserId_whenUserIdNotExistShouldThorwNotFoundException() {

		Mockito.when(userRepository.findById(1)).thenReturn(Optional.empty());

		assertThrows(NotFoundException.class, () -> userService.getById(1));

	}

	@Test
	void getAllUserTest() {
		User user = new User();
		UserResponseDto dto = new UserResponseDto();
		Mockito.when(dozerMapper.map(user, UserResponseDto.class)).thenReturn(dto);
		Mockito.when(userRepository.findAll()).thenReturn(List.of(user));

		List<UserResponseDto> result = userService.getAll();
		assertEquals(result, List.of(dto));
	}
}
