package com.Sociopool.Assignment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TravellerRepo extends JpaRepository<Traveller, Long> {

	@Query(value = "select * from traveller where username=:username and unix= :unix", nativeQuery = true)
	public Traveller findByUnix(String username,int unix);

	@Modifying(clearAutomatically = true)
	@Query(value = "update Traveller set distance=:distance where username=:username and unix=:unix")
	public void updateTraveller(String username, String distance, String unix);

	@Query(value = "select * from traveller where username=:username and unix>= :startTime and unix<= :endTime", nativeQuery = true)
	public List<Traveller> getTotalDistance(String username, int startTime, int endTime);

}
