package org.thrust_java;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;


/**
 * ThrustShell REPLY
 *
 */
public class ThrustShell {
	
	Process process;
	OutputStream out;
	BufferedReader in;
	
	public ThrustShell(){
		
		new Thread(new Runnable() {
			public void run() {
				
				boolean cont = true;
				while(cont){
					try {
						String reply = in.readLine();
						if(reply!=null){
							if(reply.contains("reply")){
								//REPLY CLASS
							}
						}
					} catch (IOException e) {}
				}
				
			}
		}).start();
		
	}
	
	public void process() throws FileNotFoundException, IOException{
		Properties conf = new Properties();
		conf.load(new FileInputStream("properties.conf"));
		ProcessBuilder pb = new ProcessBuilder(conf.getProperty("thrust_path"));
		pb.redirectErrorStream(true);
		process = pb.start();
	}
	
	public void cleanup(){
		process.destroy();
	}
	
	public void in(){
		in = new BufferedReader(new InputStreamReader(process.getInputStream()));
	}
	
	public void out(){
		out = process.getOutputStream();
	}
	
	
	public MessageId getMessageId(){
		return new MessageId();
	}

	class MessageId {
		Integer id;

		public MessageId() {
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
	}
	
}
