package com.emreilgar.service;

import com.emreilgar.dto.UpdateResponseDto;
import com.emreilgar.dto.UserProfileDto;
import com.emreilgar.exception.ErrorType;
import com.emreilgar.exception.UserProfileMicroserviceException;
import com.emreilgar.mapper.IMapper;
import com.emreilgar.model.User;
import com.emreilgar.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final IUserRepository repository;
    private final IMapper mapper;
    public List<User> findAll(){
        /**findById ile verdiğimiz userid yi repo da aratıyoruz, varsa Optional UserProfile Listesini açıyoruz*/
        List<User> userProfileList = repository.findAll();
        if (userProfileList.isEmpty())
            throw new UserProfileMicroserviceException(ErrorType.UNAUTHORIZED_REQUEST);
        return userProfileList;
    }
    public UserService(IUserRepository repository, IMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public Boolean createUser(UserProfileDto dto) {
        Optional<User> optionalUser= repository.findByEmail(dto.getEmail());
        if(optionalUser.isEmpty()){
            User user= new User();
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setPhone(dto.getPhone());
            repository.save(user);
            return true;
        } throw new UserProfileMicroserviceException(ErrorType.BAD_REQUEST_ERROR);

    }

}
