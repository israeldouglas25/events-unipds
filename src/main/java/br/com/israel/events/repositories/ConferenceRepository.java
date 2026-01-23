package br.com.israel.events.repositories;

import br.com.israel.events.domain.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, Integer> {
}
