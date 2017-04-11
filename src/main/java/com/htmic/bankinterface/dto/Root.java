package com.htmic.bankinterface.dto;

import java.io.Serializable;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonRootName;  

@JsonRootName("root")
public class Root implements Serializable{
	private Head head;
	private Body body;
	
	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}
}
