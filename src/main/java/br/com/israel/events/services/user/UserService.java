package br.com.israel.events.services.user;

import br.com.israel.events.domain.User;
import br.com.israel.events.exceptions.BadRequestException;
import br.com.israel.events.exceptions.NotFoundException;
import br.com.israel.events.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User create(User user) {
        if (user.getName() == null || user.getEmail() == null) {
            throw new BadRequestException("Name and email are required");
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found: " + id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User update(User user, User updateUser) {
        if (updateUser.getName() != null) {
            user.setName(updateUser.getName());
        }
        if (updateUser.getEmail() != null) {
            user.setEmail(updateUser.getEmail());
        }
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        User user = getById(id);
        userRepository.delete(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found: " + email));
    }
}
