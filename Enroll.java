package com.model;

public class Enroll {
		long phone;
		String otp;
		public Enroll(long phone2, String otp) {
			super();
			this.phone = phone2;
			this.otp = otp;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		public String getOtp() {
			return otp;
		}
		public void setOtp(String otp) {
			this.otp = otp;
		}
		
}
