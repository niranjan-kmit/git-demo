package com.spglobal.rtservice;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


public class WSO2ManagerService {
	
	
	
	public String siddhiManagerUrl="https://api-platform-nlb-ae946719a7c2d254.elb.us-east-1.amazonaws.com/siddhi-apps";
	
	public WSO2ManagerService(){
		
	}
	public boolean deleteSiddhiAppfromManager(String siddhiAppId) {
		siddhiManagerUrl = siddhiManagerUrl + "/" + siddhiAppId;
		HttpDelete httpDelete = new HttpDelete(siddhiManagerUrl);

		httpDelete.addHeader("accept", "application/json");
		httpDelete.addHeader("Content-Type", "text/plain");
		httpDelete.addHeader("appkey", "realtime");
		httpDelete.addHeader("Host", "wso2sp-manager-1");

		try {

			try (CloseableHttpClient httpClient = HttpClients.createDefault();
					CloseableHttpResponse response = httpClient.execute(httpDelete)) {

				return response.getStatusLine().getStatusCode() == 200;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}
