package br.com.israel.events.services.user;

import br.com.israel.events.domain.User;
import br.com.israel.events.exceptions.NotFoundException;
import br.com.israel.events.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
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
    public User update(User user) {
        User newUser = new User();
        if (user.getName() != null) {
            newUser.setName(user.getName());
        }
        if (user.getEmail() != null) {
            newUser.setEmail(user.getEmail());
        }
        return userRepository.save(newUser);
    }

    @Override
    public void delete(Integer id) {
        User user = getById(id);
        userRepository.delete(user);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("User not found: " + email));
    }
}
