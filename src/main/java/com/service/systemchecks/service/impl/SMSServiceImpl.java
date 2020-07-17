package com.service.systemchecks.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.systemchecks.domain.notification.NotificationConfig;
import com.service.systemchecks.model.SMSProxy;
import com.service.systemchecks.service.SMSService;

@Service
public class SMSServiceImpl implements SMSService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SMSServiceImpl.class);

	@Transactional
	@Override
	public boolean sendMsg91(NotificationConfig config,SMSProxy proxy) {
		URL obj = null;
		try {
			String message = proxy.getContent();;
			String url = config.getBaseUrl().concat("?mobiles=").concat(config.getCountryCode()).concat(proxy.getMobile()).concat("&authkey=").concat(URLEncoder.encode(config.getKey(),StandardCharsets.UTF_8.name())).concat("&route=").concat(config.getRoute().toString()).concat("&sender=").concat(config.getSender()).concat("&message=").concat(URLEncoder.encode(message,StandardCharsets.UTF_8.name())).concat("&country=").concat(config.getCountryCode());
			LOGGER.info("Url to Send SMS == >{0}", new Object[]{url});
			obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { //success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				return true;
			}
			return false;
		} catch (MalformedURLException e) {
			LOGGER.error("Error while Connecting to URL = >{0}", new Object[]{e});
		} catch (IOException e) {
			LOGGER.error("Error while Opening Url  = >{0}", new Object[]{e});
		}
		return false;
	}
	
}
