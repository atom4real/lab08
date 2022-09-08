package se331.rest.dao;

import se331.rest.entity.Event;
import se331.rest.entity.Organizer;

import java.util.List;

public interface EventDao {
    Integer getEventSize();
    List<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);


    //ADD THE ORGANIZER
    Integer getOrganizerSize();
    List<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
}
