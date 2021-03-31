package com.piGL.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.piGL.entity.Annoce;
import com.piGL.exception.RessourceNotFoundException;
import com.piGL.notification.Sms;
import com.piGL.notification.SmsService;
import com.piGL.repository.AnnoceRepository;

@Service
public class AnnoceService {

	@Autowired
	AnnoceRepository annoceReository;
	@Autowired
	SmsService
	smsService;
	//@Autowired
//	SmsService smsService;
	
	public Annoce ajouterAnnoce(Annoce annoce)
	
	{
		
		String msg = "Dari.TN";
		Sms s =new Sms("+216 95988670","Votre annoce est ajouter avec succes "+msg);
		this.smsService.send(s);
		return this.annoceReository.save(annoce);
		
		
	}
	
	public List<Annoce> getAll()
	{
		return this.annoceReository.findAll();
	}
	
	public ResponseEntity<Annoce> getAdById(Long id) throws RessourceNotFoundException {
		Annoce Ad = annoceReository.findById(id).
				orElseThrow(()-> new RessourceNotFoundException("Ad not found"));
	 return ResponseEntity.ok().body(Ad);
	}
	
	//delete Comment
	public Map<String,Boolean > delateAd (Long idad) throws RessourceNotFoundException {
		Annoce Ad = annoceReository.findById(idad).
				orElseThrow(()-> new RessourceNotFoundException("Ad not found"));
			
		annoceReository.delete(Ad);
		Map<String , Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	//modifier 
	
	/*public ResponseEntity<Annoce> updateAd(Long id,Annoce Ad) {
		System.out.print("Update Ad");
		
		 Optional<Annoce> AdInfo = annoceReository.findById(id);
		 
		 if(AdInfo.isPresent()) {
			 Annoce ad = AdInfo.get();
			 ad.setAddresse(Ad.getAddresse());
			 ad.setDescription(Ad.getAddresse());
			 ad.setPrice(Ad.getPrice());
			 ad.setOwnerId(Ad.getOwnerId());
			 ad.setRoomsNumber(Ad.getRoomsNumber());
			 ad.setBathroomsNumber(Ad.getBathroomsNumber());
			 ad.setImage(Ad.getImage());
			ad.setStatus(Ad.getStatus());
			ad.setSpaceCalcul(Ad.getSpaceCalcul());
			ad.setAdtype(Ad.getAdtype());
			 
		
			 return new ResponseEntity<>(annoceReository.save(Ad),HttpStatus.OK);
		 }else 
		 {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }

	}*/
	
	
	///fct recuper Annoce par addresse
	public List<Annoce> getAnnoceByAddresse(String addresse) {
		return annoceReository.findByAddresse(addresse);
	}
	
	
	// update annoce
	public Annoce updateAnnoce(Annoce annoce) {
		if (annoce.getId() != 0) {
			Annoce an = annoceReository.findById(annoce.getId()).get();
			if (an != null) {
				annoceReository.save(annoce);
			}
		}
		return annoce;
	}

	
	
}
