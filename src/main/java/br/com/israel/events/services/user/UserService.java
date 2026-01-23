package br.com.israel.events.services.user;

import br.com.israel.events.domain.User;
import br.com.israel.events.domain.dto.UserDetailsResponse;
import br.com.israel.events.exceptions.BadRequestException;
import br.com.israel.events.exceptions.NotFoundException;
import br.com.israel.events.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetailsResponse create(User user) {
        if (user.getName() == null || user.getEmail() == null) {
            throw new BadRequestException("Name and email are required");
        }
        String passEncode = passwordEncoder.encode(user.getPassword());
        User saved = userRepository.save(new User(user.getName(), user.getEmail(), passEncode));
        return new UserDetailsResponse(saved);
    }

    @Override
    public UserDetailsResponse getById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found: " + id));
        return new UserDetailsResponse(user);
    }

    @Override
    public List<UserDetailsResponse> getAll() {
        return userRepository.findAll().stream().map(UserDetailsResponse::new).toList();
    }

    @Override
    @Transactional
    public UserDetailsResponse update(Integer id, User updateUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found: " + id));
        if (updateUser.getName() != null) {
            user.setName(updateUser.getName());
        }
        if (updateUser.getEmail() != null) {
            user.setEmail(updateUser.getEmail());
        }
        return new UserDetailsResponse(userRepository.save(user));
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found: " + id));
        userRepository.delete(user);
    }

    @Override
    public UserDetailsResponse getByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found: " + email));
        return new UserDetailsResponse(user);
    }
}
