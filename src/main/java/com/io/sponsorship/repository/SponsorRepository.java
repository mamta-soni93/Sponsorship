package com.io.sponsorship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.io.sponsorship.model.Sponsor;

/**
 * @author Mamta Soni
 * @date Aug 10, 2020
 * @version java 1.8
 * 
 */

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Long> {
	
	Sponsor findByEmail(@Param("email")String email);

}
