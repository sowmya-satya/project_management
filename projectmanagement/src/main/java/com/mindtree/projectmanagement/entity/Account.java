package com.mindtree.projectmanagement.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account implements Comparable<Account>{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	
	private String accountName;
	
	private int revenue;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Project> projects;
	
	

	public Account() {
		super();
	}



	public Account(int accountId, String accountName, int revenue, List<Project> projects) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.revenue = revenue;
		this.projects = projects;
	}



	public int getAccountId() {
		return accountId;
	}



	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}



	public String getAccountName() {
		return accountName;
	}



	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}



	public int getRevenue() {
		return revenue;
	}



	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}



	public List<Project> getProjects() {
		return projects;
	}



	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}



	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", revenue=" + revenue
				+ ", projects=" + projects + "]";
	}



	@Override
	public int compareTo(Account a) {
		// TODO Auto-generated method stub
		if(this.getRevenue()==a.getRevenue()) {
			return this.getAccountName().compareTo(a.getAccountName());
		}
		else {
			return this.getRevenue()-a.getRevenue();
		}
		
	}
	
	
	
	
}

