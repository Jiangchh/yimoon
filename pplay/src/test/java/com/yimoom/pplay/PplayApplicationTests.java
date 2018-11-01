package com.yimoom.pplay;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PplayApplicationTests {
	
	@Test
	public void contextLoads() {

		List<Integer>list=new ArrayList<Integer>();
		for (int i = 0; i < 99999; i++) {
			list.add(99999-list.size());
		}
		Collections.shuffle(list);
		System.err.println(String.format("%05d",list.get(0)));
	
	}
	@Test
	public void printPath() {
		File path;
		try {
			path = new File(ResourceUtils.getURL("classpath:").getPath());
			if(!path.exists()) path = new File("");
			System.out.println("path:"+path.getAbsolutePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

}
