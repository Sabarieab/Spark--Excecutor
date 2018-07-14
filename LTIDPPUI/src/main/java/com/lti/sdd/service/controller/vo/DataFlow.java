package com.lti.sdd.service.controller.vo;

import java.util.List;

public class DataFlow {
	List<Node> nodes;
	List<Connection> connections;
	@Override
	public String toString() {
		return "DataFlow [nodes=" + nodes + ", connections=" + connections + "]";
	}
}
