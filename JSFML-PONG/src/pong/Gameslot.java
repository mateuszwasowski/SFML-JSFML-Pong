package pong;

import java.io.*;

public class Gameslot {
	
	 public
	        Gameslot(String n) {
		 name = n + ".txt";
	 			}
	        void open() {
	        	account = new File(name);

			}
	       // void close() {
	       // 	.close();
		//	}
	        void save(String time, int p1scor , int p2scor){
	        	
	        	FileWriter fileWriter = null;
				try {
					fileWriter = new FileWriter(account,true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        	try {
	        		fileWriter.write(System.getProperty("line.separator"));
					fileWriter.write("Time: "  + time + " | Score : " +p1scor +" : "+ p2scor);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	
	        	try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        };

	  private
	        String name;
	        File account;


}
