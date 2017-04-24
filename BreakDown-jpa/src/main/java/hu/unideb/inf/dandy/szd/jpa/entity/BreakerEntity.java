package hu.unideb.inf.dandy.szd.jpa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BreakerEntity extends BaseId {

	private String name;
	private String username;
	private String password;
	private Long role;
	@Column(unique=true)
	private String email;
	
	@ManyToMany
	private List<CompetitionEntity> competitions;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<BreakEventEntity> winnedEvents;
	private Long gender;
	private Date birthday;
	@ElementCollection
	private List<String> interestedCities;
	
}
