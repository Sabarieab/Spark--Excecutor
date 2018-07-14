package com.lti.sdd.service.controller.vo;

import java.util.List;


public class Node {
	String name;
	Integer id;
	Integer x;
	Integer y;
	Integer width;
	List<InputConnector> inputConnectors;
	List<OutputConnector> outputConnectors;
	@Override
	public String toString() {
		return "Node [name=" + name + ", id=" + id + ", x=" + x + ", y=" + y + ", width=" + width + ", inputConnectors="
				+ inputConnectors + ", outputConnectors=" + outputConnectors + "]";
	}
}

