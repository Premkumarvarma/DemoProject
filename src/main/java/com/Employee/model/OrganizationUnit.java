package com.Employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="organization")
public class OrganizationUnit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String _id;
	private String orgCode;
	private String orgName;
	private String orgCodeName;
	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}
	/**
	 * @return the orgCode
	 */
	public String getOrgCode() {
		return orgCode;
	}
	/**
	 * @param orgCode the orgCode to set
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	/**
	 * @return the orgCodeName
	 */
	public String getOrgCodeName() {
		return orgCodeName;
	}
	/**
	 * @param orgCodeName the orgCodeName to set
	 */
	public void setOrgCodeName(String orgCodeName) {
		this.orgCodeName = orgCodeName;
	}
	
	

}
