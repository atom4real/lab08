package se331.rest.dao;

import se331.rest.entity.Organizer;

import java.util.List;

public interface OrganizerDao {
    //ADD THE ORGANIZER
    Integer getOrganizerSize();
    List<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
}
