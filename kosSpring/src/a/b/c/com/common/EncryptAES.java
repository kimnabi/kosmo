package a.b.c.com.common;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

//import javax.crypto.BadPaddingException;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.security.InvalidAlgorithmParameterException;

import org.apache.commons.codec.binary.Base64;

public class EncryptAES {
	
	final static String secretKey = "shplab123456789abcdefghijk999999"; // 32bit	
    static String IV = secretKey.substring(0, 16); // 16bit

    // 싱글톤 패턴 적용 : 객체를 하나만 사용하세요 : 객체는 항상 메모리에 하나만 있어야 한다. 
    //=================================================================
    private EncryptAES() {    
    }
    
    public static EncryptAES getInstance() {
    	return SingletonLazyHolder.INSTANCE;
    }
    
    private static class SingletonLazyHolder {
    	private static final EncryptAES INSTANCE = new EncryptAES();
    }
    //=================================================================

    /*
     	ASE256암호화 양방향 
     	인코딩 : String aesEncode(String str)
     	디코딩 : String aesDecode(String str)

		스트림 암호는 이진화된 평문 스트림과 이진 키 스트림의 XOR 연산으로 암호문을 생성
    */
    // 암호화
    public String aesEncode(String str){
    	
		String enStr = "";
		
		try {
			
			byte[] keyData = secretKey.getBytes(); //이진화된 암호문 생성
			SecretKey secureKey = new SecretKeySpec(keyData, "AES");
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			//c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes()));
			// 이진화된 평문 스트림과 이진 키 스트림의 XOR연산를 통한 스트림 암호문 생성
			 c.init(Cipher.ENCRYPT_MODE, secureKey);
			// charset이 ISO-8859-1로 인코딩된한글 평문일 경우 데이타 손실이 발생됨
			byte[] encrypted = c.doFinal(str.getBytes("UTF-8")); //스트림 암호문를  인코딩 UTF -8 시킴 
			
			enStr = new String(Base64.encodeBase64(encrypted)); //디코딩
			
		}catch(Exception e) {
		}
		
		return enStr;
	}

    // 복호화 (암호문 --> 평문)
    public String aesDecode(String str){
    	
    	String deStr = "";
        
		try {
			
			byte[] keyData = secretKey.getBytes();
			SecretKey secureKey = new SecretKeySpec(keyData, "AES");
			Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, secureKey);
			 //c.init(Cipher.ENCRYPT_MODE, secureKey);
			byte[] byteStr = Base64.decodeBase64(str.getBytes()); 
			
			deStr = new String(c.doFinal(byteStr), "UTF-8");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return deStr;
    }
      
	public static void main(String args[]) {
    	
    	String id = "골통123";
    	
    	EncryptAES ase = EncryptAES.getInstance();
    	String enId = ase.aesEncode(id);
        String desId = ase.aesDecode(enId);
        
        System.out.println("enId >>> : " + enId);
        System.out.println("desId >>> : " + desId);
    }
} 
