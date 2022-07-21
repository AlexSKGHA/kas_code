package kas_code.minecraft;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Spammer {
	
	/**
	 * The program is for sending broadcast packets that carry data
	 * required for Minecraft client to identify a server and figure out
	 * its destination on the LAN network.
	 * 
	 * The message that a client receives from Spammer instance is
	 * represented as two rows (lines) of text which denote server's
	 * name (could be anything) and port respectively.
	 * Minecraft client if it is unable to find host on the Spammer given port
	 * uses default port which is 25565 for establishing a connection with the server. 
	 * So as long as the server is open on such port
	 * second row could also be anything as well as first row.
	 * 
	 * Method deploy() sends out Spammer's prepared packet data over the LAN
	 * allowing for gamers to find dedicated server.
	 * 
	 * MOTD (Minecraft term) in this class definition has alternative name "first row",
	 * and port "second row".
	 * 
	 * Passing null references to methods would cause NullPointerException to be thrown.
	 */
	
	private static final String BROADCAST_IP = "224.0.2.60";
	private static final String payloadTemplate = "[MOTD]%s[/MOTD][AD]%s[/AD]";
	private static final int PORT = 4445;
	
	private DatagramSocket socket;
	private DatagramPacket packet;
	
	private String firstRow;
	private String secondRow;
	private boolean isClosed;
	
	public Spammer (String motd, String port, DatagramSocket socket) {
		this.socket = socket;
		this.packet = Spammer.obtainPacket(makePayload(motd, port).getBytes());
		this.firstRow = motd;
		this.secondRow = port;
	}
	
	public void setFirstRow(String motd) {
		if (motd == null)
			throw new NullPointerException();
		setRows(motd, secondRow);
	}
	
	public void setSecondRow(String at) { 
		if (at == null)
			throw new NullPointerException();
		setRows(firstRow, at);
	}
	
	public void setRows(String motd, String at) {
		if ((motd == null) || (at == null))
			throw new NullPointerException();
		packet.setData(makePayload(motd, at).getBytes());
		firstRow = motd;
		secondRow = at;
	}
	
	public boolean deploy() {
		try {
			socket.send(packet);
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
	public String getFirstRow() {
		return firstRow;
	}
	
	public String getSecondRow() {
		return secondRow;
	}
	
	public String[] getRows() {
		return new String[] {firstRow, secondRow};
	}
	
	public boolean isClosed() {
		return isClosed;
	}
	
	private static String makePayload(String firstRow, String secondRow) {
		return String.format(Spammer.payloadTemplate, firstRow, secondRow);
	}
	
	private static DatagramPacket obtainPacket(byte[] payload) {
		try {
			return new DatagramPacket(payload, payload.length,
					InetAddress.getByName(Spammer.BROADCAST_IP), Spammer.PORT);
		} catch (IOException ex) {}
		return null;
	}
	
	public void close() {
		socket = null;
		packet = null;
		firstRow = null;
		secondRow = null;
		isClosed = true;
	}
}
