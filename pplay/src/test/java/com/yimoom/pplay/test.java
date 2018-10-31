
package com.yimoom.pplay;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class test {
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
		try {
			
			List<String>front=Files.readAllLines(Paths.get(URLDecoder.decode((test.class.getResource("").getPath()+"front.txt").substring(1))));
			List<String>back=Files.readAllLines(Paths.get(URLDecoder.decode((test.class.getResource("").getPath()+"back.txt").substring(1))));
			for (int i = 0; i < front.size(); i++) {
				sb.append(front.get(i).trim()).append(back.get(i)).append("\n");
			}
			System.err.println(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
