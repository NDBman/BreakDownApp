package hu.unideb.inf.dandy.szd.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.dandy.szd.jpa.entity.Breaker;

@Repository
@Transactional
public interface BreakerRepository extends JpaRepository<Breaker, Long>{

	public Breaker findByBboyName(String bname);
	public Breaker findByEmail(String email);
}
