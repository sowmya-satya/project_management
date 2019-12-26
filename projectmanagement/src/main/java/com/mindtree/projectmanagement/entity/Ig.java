package com.mindtree.projectmanagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ig {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int igId;

	private String igName;

	@OneToMany(cascade = CascadeType.ALL)
	List<Account> accounts;

	public Ig() {
		super();
	}

	public Ig(int igId, String igName, List<Account> accounts) {
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

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Ig [igId=" + igId + ", igName=" + igName + ", accounts=" + accounts + "]";
	}
	
	

	

	

}
