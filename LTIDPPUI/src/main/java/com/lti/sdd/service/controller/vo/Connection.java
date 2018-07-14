package com.lti.sdd.service.controller.vo;

public class Connection {
	String name;
	Connector source;
	Connector dest;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Connector getSource() {
		return source;
	}
	public void setSource(Connector source) {
		this.source = source;
	}
	public Connector getDest() {
		return dest;
	}
	public void setDest(Connector dest) {
		this.dest = dest;
	}
	@Override
	public String toString() {
		return "Connection [name=" + name + ", source=" + source + ", dest=" + dest + "]";
	}

}

