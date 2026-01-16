package br.com.israel.events.services;

import br.com.israel.events.domain.Conference;
import br.com.israel.events.interfaces.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService implements IConferenceService{

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Override
    public Conference create(Conference conference) {
        return conferenceRepository.save(conference);
    }

    @Override
    public Conference getById(Integer id) {
        return conferenceRepository.findById(id).orElseThrow(() -> new RuntimeException("Conferencia não encontrada"));

    }

    @Override
    public List<Conference> getAll() {
        return conferenceRepository.findAll();
    }
}
