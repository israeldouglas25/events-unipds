package br.com.israel.events.repositories;

import br.com.israel.events.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Integer> {
}
