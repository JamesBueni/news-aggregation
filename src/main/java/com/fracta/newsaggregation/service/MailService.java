package com.fracta.newsaggregation.service;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fracta.newsaggregation.exception.NewsAggregationException;
import com.fracta.newsaggregation.model.NotificationEmail;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
	
	private final JavaMailSender emailSender;
	private final MailContentBuilder emailContentBuilder;
	
	@Async
	public void sendEmail(NotificationEmail notificationEmail) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
			mimeMessageHelper.setFrom("hi@fractaline.com");
			mimeMessageHelper.setTo(notificationEmail.getRecipient());
			mimeMessageHelper.setSubject(notificationEmail.getSubject());
			mimeMessageHelper.setText(emailContentBuilder.build(notificationEmail.getBody()));
		};
		
		try {
			emailSender.send(messagePreparator);
			log.info("Activation email sent!");
		} catch(MailException e) {
			log.error("Exception occured while sending email.", e);
			throw new NewsAggregationException(String.format(
					"Exception occured while sending email to %s.", notificationEmail.getRecipient()), e);
		}
	}
}
