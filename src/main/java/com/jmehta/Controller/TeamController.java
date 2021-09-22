package com.jmehta.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jmehta.Model.Team;
import com.jmehta.repository.MatchRepository;
import com.jmehta.repository.TeamRepository;

@RestController
public class TeamController {
	
	@Autowired
	private TeamRepository teamRepo;
	
	@Autowired
	private MatchRepository matchRepo;
	
	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		
		Team team =  teamRepo.findByTeamName(teamName);
		
		team.setMatches(matchRepo.findLatestMatchesByTeam(teamName, 4));
		
		return team;
	}

}
