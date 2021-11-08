package tapu.com.auctionshortenedurl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.github.dozermapper.core.Mapper;

import tapu.com.auctionshortenedurl.entities.User;
import tapu.com.auctionshortenedurl.entities.dto.UserRequestDto;
import tapu.com.auctionshortenedurl.entities.dto.UserResponseDto;
import tapu.com.auctionshortenedurl.repository.UserRepository;
import tapu.com.auctionshortenedurl.util.exception.NotFoundException;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final Mapper dozerMapper;

	public UserService(UserRepository userRepository, Mapper dozerMapper) {
		this.userRepository = userRepository;
		this.dozerMapper = dozerMapper;

	}

	public UserResponseDto add(UserRequestDto userReqDto) {
		User user = dozerMapper.map(userReqDto, User.class);
		userRepository.save(user);
		return dozerMapper.map(user, UserResponseDto.class);

	}

	public List<UserResponseDto> getAll(){
		List<UserResponseDto> response=new ArrayList<UserResponseDto>();
		userRepository.findAll().forEach(user->{
			response.add(dozerMapper.map(user, UserResponseDto.class));
		});
		return response;
	}

	public User getById(int id) {
		Optional<User> user =userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
			
		
		throw new NotFoundException("There is no such id in our system!!");
	}

}