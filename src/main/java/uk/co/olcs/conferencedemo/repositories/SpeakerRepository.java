package uk.co.olcs.conferencedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.olcs.conferencedemo.models.Speaker;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
