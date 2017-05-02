package hu.unideb.inf.dandy.szd.jpa.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WinnerEntity extends BaseId{

	private Long winnerId;
	private String winnerUsername;
	private Long winnedCompetitionId;
	private String winnedCompetitionName;
	private String description;
}
