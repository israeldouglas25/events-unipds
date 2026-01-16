package br.com.israel.events.interfaces;

import br.com.israel.events.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
