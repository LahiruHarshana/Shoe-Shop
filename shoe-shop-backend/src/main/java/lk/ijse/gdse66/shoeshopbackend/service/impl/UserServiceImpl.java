package lk.ijse.gdse66.shoeshopbackend.service.impl;

import lk.ijse.gdse66.shoeshopbackend.dto.PaginationDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.UserDTO;
import lk.ijse.gdse66.shoeshopbackend.dto.UserPasswordDTO;
import lk.ijse.gdse66.shoeshopbackend.entity.User;
import lk.ijse.gdse66.shoeshopbackend.repository.UserRepository;
import lk.ijse.gdse66.shoeshopbackend.service.UserService;
import lk.ijse.gdse66.shoeshopbackend.util.CommonUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Integer saveUser(UserDTO userDTO) {

            System.out.println("User service"+userDTO);
            userDTO.setActive(true);
            userRepository.save(modelMapper.map(userDTO, User.class));
            return 200;
    }

    public Integer disable(String id) {
        User userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            userEntity.setActive(false);
            userRepository.save(userEntity);
            return 200;
        }
        return 500;
    }
    public Integer updateUser(UserDTO userDTO) {
        if (userRepository.existsById(userDTO.getUserId())) {
            User entity = modelMapper.map(userDTO, User.class);
            userRepository.save(entity);
            return 200;
        }
        return 500;
    }
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll().stream()
                .map(userEntity -> modelMapper.map(userEntity, UserDTO.class)).toList();
    }

    public Integer enable(String id) {
        User userEntity = userRepository.findById(id).orElse(null);
        if (userEntity != null) {
            userEntity.setActive(true);
            userRepository.save(userEntity);
            return 200;
        }
        return 500;
    }

    public List<UserDTO> paginationUsers(PaginationDTO paginationDTO) {
        return userRepository
                .findAll(CommonUtils.setPagination(paginationDTO.getOffset(), paginationDTO.getLimit(), paginationDTO.getColumnName()))
                .stream().map(userEntity -> modelMapper.map(userEntity, UserDTO.class)).toList();
    }
}
