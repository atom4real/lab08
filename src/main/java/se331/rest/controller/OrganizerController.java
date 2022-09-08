package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.Organizer;
import se331.rest.service.EventService;
import se331.rest.service.OrganizerService;

import java.util.List;

@Controller
public class OrganizerController {
    @GetMapping("organizer")
    public ResponseEntity<?> getOrganizerLists(@RequestParam(value = "_limit",
            required = false)Integer perPage
            , @RequestParam(value = "_page", required = false)Integer page) {
        List<Organizer> output = null;
        Integer eventSize = eventService.getOrganizerSize();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(eventSize));
        try {
            output = eventService.getOrganizers(perPage, page);
            return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);
        } catch (IndexOutOfBoundsException ex) {
            return new ResponseEntity<>(output, responseHeader, HttpStatus.OK);
        }
    }
    @GetMapping("organizer/{id}")
    public ResponseEntity<?> getOrganizer(@PathVariable("id") Long id) {
        Organizer output = eventService.getOrganizer(id);
        if(output != null) {
            return ResponseEntity.ok(output);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given " +
                    "id is not found");
        }
    }
    @Autowired
    OrganizerService eventService;
}
