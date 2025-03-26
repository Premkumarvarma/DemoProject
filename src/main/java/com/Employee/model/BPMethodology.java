package com.Employee.model;

import java.util.List;

public class BPMethodology {
	
	private String _id;
	private String methodologyCode;
	private String methodologyName;
	private String orgcode;
	private String orgName;
	private String year;
	private String period;
	private List<String> methodoliges;
	private MethodologyInfo methodologyInfo;
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getMethodologyCode() {
		return methodologyCode;
	}

	public void setMethodologyCode(String methodologyCode) {
		this.methodologyCode = methodologyCode;
	}

	public String getMethodologyName() {
		return methodologyName;
	}

	public void setMethodologyName(String methodologyName) {
		this.methodologyName = methodologyName;
	}

	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public List<String> getMethodoliges() {
		return methodoliges;
	}

	public void setMethodoliges(List<String> methodoliges) {
		this.methodoliges = methodoliges;
	}

	public MethodologyInfo getMethodologyInfo() {
		return methodologyInfo;
	}

	public void setMethodologyInfo(MethodologyInfo methodologyInfo) {
		this.methodologyInfo = methodologyInfo;
	}

	public static class MethodologyInfo{
		
		private String methCode;
		private String methName;
		private String productName;
		private String productType;
		public String getMethCode() {
			return methCode;
		}
		public void setMethCode(String methCode) {
			this.methCode = methCode;
		}
		public String getMethName() {
			return methName;
		}
		public void setMethName(String methName) {
			this.methName = methName;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductType() {
			return productType;
		}
		public void setProductType(String productType) {
			this.productType = productType;
		}
		
	}
	

}
