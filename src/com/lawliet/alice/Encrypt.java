package com.lawliet.alice;

import java.io.File;
import java.io.IOException;

import com.lawliet.rsa.Base64;
import com.lawliet.rsa.RSAEncrypt;
import com.lawliet.rsa.ReadFiledata;
import com.lawliet.rsa.WriteFiledata;

public class Encrypt {

	public static void main(String[] args) throws Exception {
		
		
		String filepath="G:/";
		
		//需要加密的文件
        File file = new File("G:/MingWen.txt");
        String plainText = ReadFiledata.txt2String(file);  
        
        
        
        System.out.println("--------------公钥加密过程-------------------");  
      
        //公钥加密过程  
        byte[] cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),plainText.getBytes());  
        String cipher=Base64.encode(cipherData);  
        
        WriteFiledata.WriteFile(cipher, "G:/MiWen.txt");
	}
	
	
	
}
