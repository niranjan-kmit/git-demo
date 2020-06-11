package com.spglobal.rtservice;

import java.io.File;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class WSO2ManagerService {

	public String siddhiManagerUrl = "https://api-platform-nlb-ae946719a7c2d254.elb.us-east-1.amazonaws.com/siddhi-apps";

	public WSO2ManagerService() {

	}

	public boolean deleteSiddhiAppfromManager(String siddhiAppId) {
		siddhiManagerUrl = siddhiManagerUrl + "/" + siddhiAppId;
		HttpDelete httpDelete = new HttpDelete(siddhiManagerUrl);

		httpDelete.addHeader("accept", "application/json");
		httpDelete.addHeader("Content-Type", "text/plain");
		httpDelete.addHeader("appkey", "realtime");
		httpDelete.addHeader("Host", "wso2sp-manager-1");

		CredentialsProvider provider = new BasicCredentialsProvider();
		provider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("admin", "admin"));

		try {

			try (CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider)
					.build(); CloseableHttpResponse response = httpClient.execute(httpDelete)) {

				return response.getStatusLine().getStatusCode() == 200;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public void deleteSiddhiApp(String siddhiAppName) {
		// absolute file name with path
		String path = "/siddhi-files/" + siddhiAppName + ".siddhi";
		System.out.println("path===>" + path);
		File file = new File(path);
		if (file.delete()) {
			System.out.println(path + "File deleted");
		} else
			System.out.println("File" + path + " doesn't exist");

	}

	public void deletingFilesRecursively(File rootPath, String file) {
		file = file + ".siddhi";
		for (File subFile : rootPath.listFiles()) {
			if (subFile.isDirectory()) {
				deletingFilesRecursively(subFile, file);
			} else if (subFile.isFile() && subFile.getName().equals(file)) {
				subFile.delete();
			}
		}

	}

}
