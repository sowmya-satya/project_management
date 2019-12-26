package com.mindtree.projectmanagement.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class IgDto {

	private int igId;

	private String igName;

	List<AccountDto> accounts;
	
	

	public IgDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IgDto(int igId, String igName, List<AccountDto> accounts) {
		super();
		this.igId = igId;
		this.igName = igName;
		this.accounts = accounts;
	}

	public int getIgId() {
		return igId;
	}

	public void setIgId(int igId) {
		this.igId = igId;
	}

	public String getIgName() {
		return igName;
	}

	public void setIgName(String igName) {
		this.igName = igName;
	}

	public List<AccountDto> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDto> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "IgDto [igId=" + igId + ", igName=" + igName + ", accounts=" + accounts + "]";
	}


}
