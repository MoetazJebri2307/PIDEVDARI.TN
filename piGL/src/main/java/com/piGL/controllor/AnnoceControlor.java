package com.piGL.controllor;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piGL.entity.Annoce;
import com.piGL.exception.RessourceNotFoundException;
import com.piGL.service.AnnoceService;

@RestController
@RequestMapping("/annoce")
public class AnnoceControlor {
	
	@Autowired
	AnnoceService annoceService;
	
	@PostMapping("/ajouter")
	public Annoce ajouterAnnoce(@RequestBody Annoce annoce) {
		return annoceService.ajouterAnnoce(annoce);
	}
	@GetMapping("/all")
	public List<Annoce> getAll() {
		return annoceService.getAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Annoce> getAdById(@PathVariable (value = "id")Long id) throws RessourceNotFoundException {
		return annoceService.getAdById(id);
	}

	
	@PutMapping("/update")
	public Annoce updateAnnoce(@RequestBody Annoce annoce) {
		return annoceService.updateAnnoce(annoce);
	}

	@GetMapping("/allByAdresse/{addresse}")
	
	public List<Annoce> getAnnoceByAddresse(@PathVariable (value = "addresse")String addresse) {
		return annoceService.getAnnoceByAddresse(addresse);
	}
	
	@DeleteMapping("/delete/{idad}")
	public Map<String, Boolean> delateAd(@PathVariable (value = "idad") Long idad) throws RessourceNotFoundException {
		return annoceService.delateAd(idad);
	}
}
