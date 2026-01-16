package br.com.israel.events.services;

import br.com.israel.events.domain.Conference;

import java.util.List;

public interface IConferenceService {
    Conference create(Conference conference);
    Conference getById(Integer id);
    List<Conference> getAll();
}
