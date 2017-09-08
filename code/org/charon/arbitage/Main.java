package org.charon.arbitage;

import org.charon.arbitage.lte.AnalyseThread;

public class Main {

	public static void main(String[] args) {
		try {
			while(true){
				//Thread.sleep(300000);
				new AnalyseThread().start();
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
