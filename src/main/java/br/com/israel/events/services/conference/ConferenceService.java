package br.com.israel.events.services.conference;

import br.com.israel.events.domain.Conference;
import br.com.israel.events.exceptions.NotFoundException;
import br.com.israel.events.interfaces.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConferenceService implements IConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Override
    @Transactional
    public Conference create(Conference conference) {
        return conferenceRepository.save(conference);
    }

    @Override
    public Conference getById(Integer id) {
        return conferenceRepository.findById(id).orElseThrow(() -> new NotFoundException("Conference not found: " + id));
    }

    @Override
    public List<Conference> getAll() {
        return conferenceRepository.findAll();
    }
}
