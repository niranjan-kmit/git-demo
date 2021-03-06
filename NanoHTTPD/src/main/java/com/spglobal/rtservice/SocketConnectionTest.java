package com.spglobal.rtservice;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "socketconnectiontest")
public class SocketConnectionTest {

	@DynamoDBHashKey(attributeName = "id")
	@DynamoDBAutoGeneratedKey
	private String id;

	@DynamoDBAttribute(attributeName = "channel")
	private String channelName;

	@DynamoDBAttribute(attributeName = "siddhi_id")
	private String siddhi_app_id;

	public SocketConnectionTest() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getSiddhi_app_id() {
		return siddhi_app_id;
	}

	public void setSiddhi_app_id(String siddhi_app_id) {
		this.siddhi_app_id = siddhi_app_id;
	}

}