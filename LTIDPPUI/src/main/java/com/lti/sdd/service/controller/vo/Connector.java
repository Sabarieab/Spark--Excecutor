package com.lti.sdd.service.controller.vo;

public class Connector {
	
	Integer nodeID;
	Integer connectorIndex;
	public Integer getNodeID() {
		return nodeID;
	}
	public void setNodeID(Integer nodeID) {
		this.nodeID = nodeID;
	}
	public Integer getConnectorIndex() {
		return connectorIndex;
	}
	public void setConnectorIndex(Integer connectorIndex) {
		this.connectorIndex = connectorIndex;
	}
	@Override
	public String toString() {
		return "Connector [nodeID=" + nodeID + ", connectorIndex=" + connectorIndex + "]";
	}	
	
}
