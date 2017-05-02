package hu.unideb.inf.dandy.szd.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Winner {

	private Long winnerId;
	private String winnerUsername;
	private Long winnedCompetitionId;
	private String winnedCompetitionName;
	private String description;
}
