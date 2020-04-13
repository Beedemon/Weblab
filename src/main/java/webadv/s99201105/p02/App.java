package webadv.s99201105.p02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.codec.digest.DigestUtils;
public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("请输入账户：");
        String acc = scan.nextLine();
        System.out.println("请输入密码：");
        String key = scan.nextLine();
        
        scan.close();
        
        System.out.println(sha256hex(acc,key));
    }
    public static String sha256hex(String acc,String key) {
    	
		ArrayList<String> arrayList = new ArrayList<>();
		try {
			InputStreamReader fr =  new InputStreamReader(new FileInputStream("D:\\springworkplace\\p02\\src\\main\\java\\webadv\\s99201105\\p02\\keyFiles\\accountKeys.txt"), "utf-8"); 
			BufferedReader bf = new BufferedReader(fr);
			String str;
			// 按行读取字符串
			while ((str = bf.readLine()) != null) {
				arrayList.add(str);
			}
			bf.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 对ArrayList中存储的字符串进行处理
		int length = arrayList.size();
		String[] array = new String[length];
		for (int i = 0; i < length; i++) {
			String s = arrayList.get(i);
			array[i] = s;
		}
		
		for(int i=0;(i+2)<=length;i+=2) {
			
			if(array[i].equals(acc)) {
				if(DigestUtils.sha256Hex(key).equals(array[i+1])) {
					return "登录成功";
				}
					else {
						System.out.println(DigestUtils.sha256Hex(array[i+1]));
						return "密码错误";
					}
			}
				
		}
    	
        return "账号不存在！";
    }
}

