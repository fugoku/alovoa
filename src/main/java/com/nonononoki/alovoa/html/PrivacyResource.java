package com.nonononoki.alovoa.html;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nonononoki.alovoa.service.PublicService;

@Controller
public class PrivacyResource {
	
	@Autowired
	private PublicService publicService;
	
	@Value("${app.company.name}")
	private String companyName;
	
	@Value("${app.privacy.update-date}")
	private String privacyUpdateDate;
	
	private final String COMPANY_NAME = "COMPANY_NAME";
	private final String PRIVACY_UPDATE_DATE = "PRIVACY_UPDATE_DATE";
	
	@GetMapping("/privacy")
	public ModelAndView termsConditions() throws Exception {
		ModelAndView mav = new ModelAndView("privacy");
		String content = publicService.text("backend.privacy");
		content = content.replaceAll(COMPANY_NAME, companyName);
		content = content.replaceAll(PRIVACY_UPDATE_DATE, privacyUpdateDate);
		mav.addObject("content", content);
		return mav;
	}
}
