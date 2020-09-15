package uk.co.olcs.conferencedemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.olcs.conferencedemo.models.Session;

public interface SessionRepository  extends JpaRepository<Session, Long> {
}
