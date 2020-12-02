package com.voice.common;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:applicationResponse.properties")
@ConfigurationProperties(prefix="response")
public class ResponseMessages {
	
	private String infoStored;

	public String getInfoStored() {
		return infoStored;
	}

	public void setInfoStored(String infoStored) {
		this.infoStored = infoStored;
	}
}
