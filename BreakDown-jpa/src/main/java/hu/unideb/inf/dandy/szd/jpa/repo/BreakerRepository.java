package hu.unideb.inf.dandy.szd.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakerEntity;

@Repository
@Transactional
public interface BreakerRepository extends JpaRepository<BreakerEntity, Long>{

	public BreakerEntity findByUsername(String bname);
	public BreakerEntity findByEmail(String email);
	public BreakerEntity findByPassword(String password);
}
