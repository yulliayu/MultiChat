/*
 * �� Ŭ������ �����ͺ��̽� ���̺� �� Chat �̶�� ���̺��� 
 * ���ڵ� 1���� ��� ���� Ŭ�����μ� �̷��� ������ ��ü�� ������ DTO, VO
 * 
 * <���ǿ� �����ϴ� �繰�� ���� ǥ��>
 * ���          DB
 * Class --> ���̺�
 * instance   ���ڵ�
 * �Ӽ�          �÷�
 */
package multi.client;

public class Chat { // <-->���̺�
	
	private int chat_id;
	private String name;
	private String ip;
	
	public Chat() {
		
	}

	public int getChat_id() {
		return chat_id;
	}

	public void setChat_id(int chat_id) {
		this.chat_id = chat_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


}
