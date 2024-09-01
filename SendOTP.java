package com.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class SendOTP {
	static String otptxt;
	static String phone;
	public SendOTP(String phone)
	{
		this.phone=phone;
	}
	public void sentOtp() {
		// TODO Auto-generated method stub
		System.out.println("Program Started.......");
		OTP otp=new OTP();
		String otpMessage=otp.generateOTP(4);
		setOtp(otpMessage);
		System.out.println("Generated otp="+otpMessage);
		String apiKey="e34B9wzZt4LXwfhhyJgNP3hcX0wyyeZPe617rmuP9y8bPvQKrD9zio6FgKhq";
		String number=phone;
		
		sendOTP(otpMessage,number,apiKey);
	}
	public static void sendOTP(String message, String number, String apiKey)
	{
		try {
			message=URLEncoder.encode(message,"UTF-8");
			String myUrl="https://www.fast2sms.com/dev/bulkV2?authorization=e34B9wzZt4LXwfhhyJgNP3hcX0wyyeZPe617rmuP9y8bPvQKrD9zio6FgKhq&variables_values="+message+"&route=otp&numbers=9766188736";
			URL url=new URL(myUrl);
			HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User=Agent", "Mozilla/5.0");
			con.setRequestProperty("cache-control","no-cache");
			System.out.println("Wait...........");
			int responseCode=con.getResponseCode();
			System.out.println("Response code:"+responseCode);
			
			StringBuffer response=new StringBuffer();
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			while(true)
			{
				String line=br.readLine();
				if(line==null)
				{
					break;
				}
				response.append(line);
			}
			System.out.println(response);
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void setOtp(String otp) {
		otptxt=otp;
	}
	public static String getOtp() {
		return otptxt;
	}
	

}
