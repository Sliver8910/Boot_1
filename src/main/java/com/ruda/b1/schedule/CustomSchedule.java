package com.ruda.b1.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class CustomSchedule {

		//@Scheduled(fixedRate = 1000)
		//@Scheduled(fixedRateString = "1000")
		public void fixRateSchedule() throws Exception{
			System.out.println("fixrate : "+ Thread.currentThread().getName());
			Thread.sleep(2000);
		}
		
		//@Scheduled(fixedDelay = 1000)
		//@Scheduled(fixedDelayString = "1000", initialDelay = 1000 )
		public void fixdDelaySchedule() throws Exception{
			System.out.println("FixDelay : "+ Thread.currentThread().getName());
			Thread.sleep(2000);
		}
	
		
		//@Scheduled(cron = " */3 * * * * * " )
		public void cronSchedule()throws Exception{
			System.out.println("cron : "+ Thread.currentThread().getName());
		}
}
