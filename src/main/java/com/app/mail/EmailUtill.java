package com.app.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class EmailUtill {

	
	@Autowired
	private JavaMailSenderImpl sender;
	
	
	
	public boolean sendEmail(String to,String[] cc,String[] bcc,String subject,String text,CommonsMultipartFile file) {
		
		boolean flag = false;
		
		try {
			
			// calling mime messge object
			
			
			MimeMessage message    = sender.createMimeMessage();
			
			// create helper class
			
		              MimeMessageHelper helper = new MimeMessageHelper(message, file!=null?true:false);
		              
                // setting data
		              helper.setTo(to);
		              
		              helper.setFrom("satishgarapati1918@gmail.com");
		              
		              if (cc!=null && cc.length>0) 
		            	  
		            	  helper.setCc(cc);
		              
		              
		              if (bcc != null && bcc.length>0) 

		            	  
		            	  helper.setBcc(bcc);
					
		              
		              helper.setSubject(subject);

		              
		              helper.setText(text);
		              
		              
		              if(file != null) 
		            	  
		            	  
		            	  helper.addAttachment(file.getOriginalFilename(), file);
		            	  
		            	  
		            	  // 4 sending email
		            	  
		            	  sender.send(message);
		            	  
		            	  flag=true;
		              
		              
		}catch (Exception e) {
			
			flag=false;
			
			e.printStackTrace();
			
		}
		
		
		
		
		return flag;
	}
	
	
	// over-loaded methods
	
	public boolean sendEmail(String to, String subject, String text)
	
	{
		
		
		
		
		return sendEmail(to, null, null, subject, text, null);
	}
	
	// over loaded method
	
	// if we send with out cc,bcc and attachment and only with to and text
	
	
        public boolean sendEmail(String to, String text) {
        	
        	
        	
        	return sendEmail(to, null, null, null, text, null);
        }
}
