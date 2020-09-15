package uk.co.olcs.conferencedemo.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.olcs.conferencedemo.models.Session;
import uk.co.olcs.conferencedemo.models.Speaker;
import uk.co.olcs.conferencedemo.repositories.SpeakerRepository;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakerController {

    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerRepository.getOne(id);
    }


    @PostMapping
    public Speaker Create(@RequestBody final Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }


    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // Also need to check for children records before deleting.
        speakerRepository.deleteById(id);
    }


    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        // because this is a PUT, we expect all attributes to be passed. A PATCH would only nees what is changed
        //TODO:  Add validation that all attributes are passed in, otherwise return a 400 payload
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
