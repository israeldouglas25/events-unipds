package br.com.israel.events.services.user;

import br.com.israel.events.domain.User;
import br.com.israel.events.domain.dto.UserDetailsResponse;

import java.util.List;

public interface IUserService {
    UserDetailsResponse create(User user);
    UserDetailsResponse getById(Integer id);
    List<UserDetailsResponse> getAll();
    UserDetailsResponse update(Integer id, User updateUser);
    void delete(Integer id);
    UserDetailsResponse getByEmail(String email);
}
