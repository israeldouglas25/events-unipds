package br.com.israel.events.services;

import br.com.israel.events.domain.User;

import java.util.List;

public interface IUserService {
    User create(User user);
    User getById(Integer id);
    List<User> getAll();
    User update(User user);
    void delete(Integer id);
}
