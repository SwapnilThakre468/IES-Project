package com.ashokit.ies.ar.service;

import java.util.Date;
import java.util.List;

import com.ashokit.ies.ar.domain.ApplicationRegistration;

public interface ARService {
	public String saveApplication(ApplicationRegistration application);
	public boolean updateApplication(ApplicationRegistration application);
	public ApplicationRegistration getApplicationById(String appId);
	public String deleteApplication(String appId);
	public List<ApplicationRegistration> getAllApplication();
	public String formatSSN(String ssn);
	public String formatString(Date date);
	public Date formatDate(String date);
	
}
