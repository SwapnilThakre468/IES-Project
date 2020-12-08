package com.ashokit.ies.ar.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.ashokit.ies.ar.binding.EnrollResponse;
import com.ashokit.ies.ar.domain.ApplicationRegistration;
import com.ashokit.ies.ar.entity.AREntity;
import com.ashokit.ies.ar.repository.ARRepository;



@Service
public class ARServiceImpl implements ARService {
	@Autowired
	ARRepository applicationRepo;


	@Override
	public String saveApplication(ApplicationRegistration application) {
	
		String encodeSSN="";
		try {
			encodeSSN = URLEncoder.encode(application.getSsn().replace(",", "-"),StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String endPointUrl = "http://localhost:9898/verify?ssnEnroll=" + encodeSSN;
		
		/*String endPointUrl = "http://localhost:9898/verify?ssnEnroll=" + application.getSsn().replace(",", "");*/
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<EnrollResponse> forEntity = rt.getForEntity(endPointUrl, EnrollResponse.class);
		int statusCode = forEntity.getStatusCodeValue();
		if (statusCode == 200) {
			EnrollResponse body = forEntity.getBody();
			if (body.getState().toLowerCase().equals("kentuckey")) {

				AREntity applicationEntity = new AREntity();
				application.setSsn(application.getSsn().replace(",", ""));
				applicationEntity.setFirstName(application.getFirstName());
				applicationEntity.setLastName(application.getLastName());
				applicationEntity.setDob(formatDate(application.getDob()));
				applicationEntity.setGender(application.getGender());
				applicationEntity.setSsn(application.getSsn());
				applicationEntity.setPhoneNo(application.getPhoneNo());
				applicationEntity.setEmail(application.getEmail());
				applicationEntity.setStatus("Active");
				applicationEntity.setAppId(application.getAppId());

				AREntity saveEntity = applicationRepo.save(applicationEntity);

				if (saveEntity.getAppId() != null) {

					return "Application Saved Successfully " + saveEntity.getAppId();

				} 
			} else {

				return "You are not belong to kentuckey state,so you are not authorised for this plan . ";
			}
		} else if(statusCode==400) {

			return "Invalid SSN";
		}
		
			return "fail";
		

	}

	@Override
	public ApplicationRegistration getApplicationById(String appId) {
		Optional<AREntity> optional = applicationRepo.findById(appId);
		
		
		if (optional.isPresent()) {
			ApplicationRegistration application = new ApplicationRegistration();
			AREntity applicationEntity = optional.get();
			application.setFirstName(applicationEntity.getFirstName());
			application.setLastName(applicationEntity.getLastName());
			application.setDob(formatString(applicationEntity.getDob()));
			application.setGender(applicationEntity.getGender());
			application.setSsn(formatSSN(applicationEntity.getSsn()));
			application.setPhoneNo(applicationEntity.getPhoneNo());
			application.setEmail(applicationEntity.getEmail());
			application.setStatus(applicationEntity.getStatus());
			application.setAppId(applicationEntity.getAppId());
			return application;
		}
		return null;
	}

	@Override
	public String deleteApplication(String appId) {
		Optional<AREntity> optional = applicationRepo.findById(appId);
		AREntity applicationEntity = null;
		if (optional.isPresent()) {
			applicationEntity = optional.get();
			if (applicationEntity.getStatus().equals("Active")) {
				applicationEntity.setStatus("Inactive");

			} else {
				applicationEntity.setStatus("Active");
			}
			applicationRepo.save(applicationEntity);

		}
		return applicationEntity.getStatus();
	}

	@Override
	public List<ApplicationRegistration> getAllApplication() {
		List<AREntity> applicationEntityList = applicationRepo.findAll();
		List<ApplicationRegistration> applicationList = new ArrayList<ApplicationRegistration>();

		for (AREntity applicationEntity : applicationEntityList) {
			ApplicationRegistration application = new ApplicationRegistration();
			application.setFirstName(applicationEntity.getFirstName());
			application.setLastName(applicationEntity.getLastName());
			application.setDob(formatString(applicationEntity.getDob()));
			application.setGender(applicationEntity.getGender());
			application.setSsn(applicationEntity.getSsn());
			application.setPhoneNo(applicationEntity.getPhoneNo());
			application.setEmail(applicationEntity.getEmail());
			application.setStatus(applicationEntity.getStatus());
			application.setAppId(applicationEntity.getAppId());

			applicationList.add(application);
		}
		return applicationList;
	}

	@Override
	public String formatSSN(String ssnf) {
		char[] ssnCharArray = ssnf.toCharArray();
		String ssn = "";

		for (int i = 0; i < ssnCharArray.length; i++) {
			if (i == 2 | i == 4) {
				ssn = ssn + ssnCharArray[i];
				ssn = ssn + ",";
			} else {
				ssn = ssn + ssnCharArray[i];
			}

		}
		return ssn;
	}

	@Override
	public String formatString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		return strDate;
	}

	@Override
	public Date formatDate(String date) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date1;
	}

	@Override
	public boolean updateApplication(ApplicationRegistration application) {
		AREntity saveEntity=null;
		Optional<AREntity> optionalEntity=applicationRepo.findById(application.getAppId());
		if (optionalEntity.isPresent()) {
			
			AREntity applicationEntity = optionalEntity.get();
		application.setSsn(application.getSsn().replace(",", ""));
		applicationEntity.setFirstName(application.getFirstName());
		applicationEntity.setLastName(application.getLastName());
		applicationEntity.setDob(formatDate(application.getDob()));
		applicationEntity.setGender(application.getGender());
		applicationEntity.setSsn(application.getSsn());
		applicationEntity.setPhoneNo(application.getPhoneNo());
		applicationEntity.setEmail(application.getEmail());
		applicationEntity.setStatus(application.getStatus());
		applicationEntity.setAppId(application.getAppId());

		saveEntity = applicationRepo.save(applicationEntity);

		
	}
		return saveEntity.getAppId()!=null;
	}
}
