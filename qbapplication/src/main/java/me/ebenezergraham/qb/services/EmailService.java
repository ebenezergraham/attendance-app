package me.ebenezergraham.qb.services;
/*
ebenezergraham created on 2/3/19
*/

import org.slf4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;

import java.io.File;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	public Logger logger;
	public JavaMailSender emailSender;
	public TemplateEngine templateEngine;
	
	public EmailService(Logger logger, JavaMailSender emailSender, TemplateEngine templateEngine) {
		this.logger = logger;
		this.emailSender = emailSender;
		this.templateEngine = templateEngine;
	}
	
	@Async
	public void sendPlainTextMail(String from, String[] to, String[] cc, String subject, String body) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText("Sessions Detials");
			FileSystemResource file
					= new FileSystemResource(new File("/home/ebenezergraham/Downloads/test_export_1549211865117.xlsx"));
			helper.addAttachment("test_export_1549211865117.xlsx", file);
			this.emailSender.send(message);
		} catch (Exception e) {
			logger.info(e.toString());
		}
	}
	
	@Async
	public void sendFormattedMail(String from,
	                              String[] to,
	                              String[] cc,
	                              String subject,
	                              Map<String, Object> message,
	                              String emailTemplate) {
		boolean withAttachemt = true;
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom(from);
			messageHelper.setTo(to);
			messageHelper.setCc(cc);
			messageHelper.setSubject(subject);
			String content = this.build(message, emailTemplate);
			messageHelper.setText(content, true);
			
			if(withAttachemt) {
				FileSystemResource file
						= new FileSystemResource(new File(""));
				messageHelper.addAttachment("Checkin", file);
			}
		};
		try {
			emailSender.send(messagePreparator);
		} catch (MailException e) {
			logger.error(e.getMessage());
		}
	}
	
	public String build(Map<String, Object> message, String template) {
		Context context = new Context();
		for(Map.Entry m:message.entrySet()){
			context.setVariable(m.getKey().toString(), m.getValue().toString());
		}
		return templateEngine.process(template, context);
	}
}
