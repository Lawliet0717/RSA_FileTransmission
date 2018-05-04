package com.lawliet.bob;

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
public class md5Test {
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
    	
    	File file = new File("H:/MiWen.txt");
        String inputStr = ReadFiledata.txt2String(file); 
    	
        File file2 = new File("H:/md5.txt");
        String Alice_md5 = ReadFiledata.txt2String(file2);
        
        
        
    	try {
    		String Bob_md5 = getResult(inputStr);
    		
    		if(Alice_md5.equals(Bob_md5)){
    			System.out.println("ǩ��У��ɹ���");
    		}else{
    			System.out.println("ǩ��У��ʧ�ܣ�");
    		}
    		
    		
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
