package se331.rest.service;

import org.springframework.context.annotation.Bean;
import se331.rest.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    //ADD THE ORGANIZER
    Integer getOrganizerSize();
    List<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
}
