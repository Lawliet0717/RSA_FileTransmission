package com.lawliet.alice;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

import com.lawliet.rsa.ReadFiledata;
import com.lawliet.rsa.WriteFiledata;
/*
MD5(Message Digest algorithm 5����ϢժҪ�㷨) 
ͨ�����ǲ�ֱ��ʹ������MD5���ܡ�ͨ����MD5�������ֽ����齻��BASE64�ټ���һ�ѣ��õ���Ӧ���ַ���
Digest:���
*/
public class md5 {
    public static final String KEY_MD5 = "MD5";   

    public static  String  getResult(String inputStr){
    	
        System.out.println("=======����ǰ������:"+inputStr);
        BigInteger bigInteger=null;

        try {
        	MessageDigest md = MessageDigest.getInstance(KEY_MD5);
			byte[] inputData = inputStr.getBytes();
			md.update(inputData);
			bigInteger = new BigInteger(md.digest());
			
        } catch (Exception e) {
        	e.printStackTrace();
        }
        System.out.println("MD5���ܺ�:" + bigInteger.toString(16));   
        return bigInteger.toString(16);
        
    }

    public static void main(String args[]) throws IOException{
    	
    	File file = new File("G:/MiWen.txt");
        String inputStr = ReadFiledata.txt2String(file); 
    	
    	try {
    		String md5 = getResult(inputStr);
    		WriteFiledata.WriteFile(md5, "G:/md5.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
