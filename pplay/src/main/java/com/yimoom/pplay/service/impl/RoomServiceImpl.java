package com.yimoom.pplay.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.yimoom.pplay.constants.NumberConstants;
import com.yimoom.pplay.service.RoomService;
@Service
public class RoomServiceImpl implements RoomService{
	public static int initial_num=0;
	private final Lock r = new ReentrantLock() ;
	static List<Integer>list=new ArrayList<Integer>();
	static {
		for (int i = NumberConstants.MIN_ROOM_TOKENID; i <= NumberConstants.MAX_ROOM_TOKENID; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
	}
	@Scheduled(cron = "0 0 0 * * ?")
	public void resetInitialNum() {
		initial_num=0;
	}
	@Override
	public long getRoomNo() {
		long result=new Random().nextInt(NumberConstants.MAX_ROOM_TOKENID);
		try {
			r.lock();
			result=Long.parseLong(String.format("%05d",list.get(initial_num)));
			initial_num++;
		}finally {
			r.unlock();
		}
		
		return  result;
	}

}
