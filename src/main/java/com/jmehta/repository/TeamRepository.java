package com.jmehta.repository;

import org.springframework.data.repository.CrudRepository;

import com.jmehta.Model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
	
	Team findByTeamName(String teamName);

}
