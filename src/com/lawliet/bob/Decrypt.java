package com.lawliet.bob;

import java.io.File;
import java.io.IOException;

import com.lawliet.rsa.Base64;
import com.lawliet.rsa.RSAEncrypt;
import com.lawliet.rsa.ReadFiledata;
import com.lawliet.rsa.WriteFiledata;

public class Decrypt {
	
	public static void main(String[] args) throws Exception {
		
		//������ɵĹ�Կ��˽Կ�Ĵ��λ��
        String filepath="H:/tmp/";  
  
        //RSAEncrypt.genKeyPair(filepath);  
          
        System.out.println("--------------��Կ����˽Կ���ܹ���-------------------");  
        
        File file = new File("H:/MiWen.txt");
        String cipher = ReadFiledata.txt2String(file);
        
        //˽Կ���ܹ���  
        byte[] res=RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)), Base64.decode(cipher));  
        String restr=new String(res);  
        
        
        WriteFiledata.WriteFile(restr, "H:/MingWen.txt");
		
		
	}
}
