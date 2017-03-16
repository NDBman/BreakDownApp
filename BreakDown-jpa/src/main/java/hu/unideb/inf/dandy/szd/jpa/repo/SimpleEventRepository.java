package hu.unideb.inf.dandy.szd.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.unideb.inf.dandy.szd.jpa.entity.SimpleEvent;

@Repository
public interface SimpleEventRepository extends JpaRepository<SimpleEvent, Long> {

}
