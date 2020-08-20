package com.io.sponsorship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.io.sponsorship.exception.ResourceNotFoundException;
import com.io.sponsorship.model.Sponsor;
import com.io.sponsorship.repository.SponsorRepository;

/**
 * @author Mamta Soni
 * @date Aug 10, 2020
 * @version java 1.8
 * 
 */
@RestController
@RequestMapping("/sponsor")
public class SponsorController {
	
	@Autowired
	private SponsorRepository sponsorRepository;
	
	/**
	 * Method is used to register or create sponsor
	 * @param sponsor
	 * @return Sponsor
	 */
	@PostMapping("/register")
	public Sponsor createSponsor(@Validated @RequestBody Sponsor sponsor) {
		return sponsorRepository.save(sponsor);
	}
	
	/**
	 * Method is used to get all list of sponsors
	 * @return List<Sponsor>
	 */
	@GetMapping("/sponsor-list")
	public List<Sponsor> getAllSponsors() {
		return sponsorRepository.findAll();
	}

	/**
	 * Method is used to get sponsor by id
	 * @param sponsorId
	 * @return
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Sponsor> getSponsorsById(@PathVariable(value = "id") Long sponsorId) throws ResourceNotFoundException {
		Sponsor sponsor = sponsorRepository
							.findById(sponsorId)
							.orElseThrow(() -> new ResourceNotFoundException("Sponsor not found on :: " + sponsorId));
		return ResponseEntity.ok().body(sponsor);
	}
}
