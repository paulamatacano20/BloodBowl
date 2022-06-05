package com.paulamata.bloodbowlteams.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.paulamata.bloodbowlteams.entity.Incentivos;

public interface IIncentivosDAO extends CrudRepository<Incentivos, Long>{

}