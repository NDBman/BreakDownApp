package hu.unideb.inf.dandy.szd.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.unideb.inf.dandy.szd.jpa.entity.WinnerEntity;

@Repository
public interface WinnerRepository extends JpaRepository<WinnerEntity, Long> {

}
