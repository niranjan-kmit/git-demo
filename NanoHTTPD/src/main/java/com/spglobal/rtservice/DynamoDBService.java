package com.spglobal.rtservice;

import org.springframework.stereotype.Service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.PrimaryKey;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;

@Service
public class DynamoDBService {
	
	public void deleteSiddhiApp(String channelName) {

		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withCredentials(new AWSStaticCredentialsProvider(
						new BasicAWSCredentials("<AccessKey>", "<SecretKey>")))
				.withRegion("<Region>").build();

		DynamoDB dynamoDB = new DynamoDB(client);

		Table table = dynamoDB.getTable("SidhhiTable");

		DeleteItemSpec deleteItemSpec = new DeleteItemSpec().withPrimaryKey(new PrimaryKey("channelName", channelName));

		table.deleteItem(deleteItemSpec);

	}
}
