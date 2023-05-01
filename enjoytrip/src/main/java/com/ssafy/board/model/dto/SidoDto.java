package com.ssafy.board.model.dto;

public class SidoDto {
	String code;
	String name;
	
	public SidoDto() {}

	public SidoDto(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SidoDto [code=" + code + ", name=" + name + "]";
	}
	
}
