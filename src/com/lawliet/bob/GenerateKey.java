package com.lawliet.bob;

import com.lawliet.rsa.RSAEncrypt;

public class GenerateKey {

	public static void main(String[] args) {
		
		//������ɵĹ�Կ��˽Կ�Ĵ��λ��
        String filepath="H:/tmp/";  
        
        //���ɹ�Կ��˽Կ
        RSAEncrypt.genKeyPair(filepath);  
        System.out.println("���ɹ�Կ��˽Կ�ɹ���");
	}

}
