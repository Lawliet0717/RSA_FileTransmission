package com.lawliet.bob;

import com.lawliet.rsa.RSAEncrypt;

public class GenerateKey {

	public static void main(String[] args) {
		
		//随机生成的公钥和私钥的存放位置
        String filepath="H:/tmp/";  
        
        //生成公钥和私钥
        RSAEncrypt.genKeyPair(filepath);  
        System.out.println("生成公钥和私钥成功！");
	}

}
