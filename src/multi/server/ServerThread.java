/*
 * 접속한 클라이언트와 1:1로 대화를 나눌 쓰레드
 */
package multi.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JTextArea;

public class ServerThread extends Thread{
	
	Socket  socket;
	BufferedReader  buffr;
	BufferedWriter  buffw;
	JTextArea  area;
	ServerMain  main;
	boolean flag=true;
	
	// 서버로 부터 소켓을 받아오자.
	public ServerThread(Socket  socket, ServerMain  main) {
		this.socket = socket;
		this.main = main;
		
		try {
			buffr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// 클라이언트의 메세지 받기
	public void listen(){
		String msg=null;
		try {
			msg = buffr.readLine();
			main.area.append(msg+"\n");
			send(msg); // 다시 보내기
			
		} catch (IOException e) {
			flag=false; // 현재 쓰레드를 죽이기.
			//백터에서 이 쓰레드를 제거
			main.list.remove(this);
			
			main.area.append("1명 퇴장 후 현재 접속자 "+main.list.size()+"\n");
			//e.printStackTrace();
			System.out.println("읽기 불가");
		}
	}
	
	// 말하기
	public void send(String msg){
		try {
			// 현재 접속한자 전부
			for (int i=0; i<main.list.size(); i++){
				ServerThread  st=main.list.elementAt(i);
				if (st!=null){
					System.out.println("Server : "+st);
					st.buffw.write(msg+"\n");
					st.buffw.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (flag){
			listen();
		}
	}

}
