package com.lawliet.bob;

import java.io.File;
import java.io.IOException;

import com.lawliet.rsa.Base64;
import com.lawliet.rsa.RSAEncrypt;
import com.lawliet.rsa.ReadFiledata;
import com.lawliet.rsa.WriteFiledata;

public class Decrypt {
	
	public static void main(String[] args) throws Exception {
		
		//随机生成的公钥和私钥的存放位置
        String filepath="H:/tmp/";  
  
        //RSAEncrypt.genKeyPair(filepath);  
          
        System.out.println("--------------公钥加密私钥解密过程-------------------");  
        
        File file = new File("H:/MiWen.txt");
        String cipher = ReadFiledata.txt2String(file);
        
        //私钥解密过程  
        byte[] res=RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)), Base64.decode(cipher));  
        String restr=new String(res);  
        
        
        WriteFiledata.WriteFile(restr, "H:/MingWen.txt");
		
		
	}
}
