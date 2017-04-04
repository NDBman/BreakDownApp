package hu.unideb.inf.dandy.szd.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.dandy.szd.jpa.entity.CompetitionEntity;

@Repository
@Transactional
public interface CompetitionRepository extends JpaRepository<CompetitionEntity, Long> {

}
