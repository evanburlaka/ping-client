import java.net.*;

public class TimedPingClient {
	public static void main(String[] args) {
		if (args.length != 1) { //prevent crash check in case of empty argument
			System.out.println("missing hostname");
			return;
		}
		String host = args[0];
		try {
			InetAddress addr = InetAddress.getByName(host); //take host IP as object
			DatagramSocket socket = new DatagramSocket(); //UDP socket
			socket.setSoTimeout(3000);
			System.out.println("Waiting...");
			// wait 3 seconds for response
			byte[] message = "hello1234".getBytes(); //send "hello1234" instead of empty packet
			DatagramPacket request = new DatagramPacket(message, message.length, addr, 7);
			//UDP packet created
			long trackSendTime = System.currentTimeMillis(); //Start tracking time to send
			socket.send(request); //UDP packet sent on port 7
			byte[] dataForResp = new byte[512]; //new buffer for response
			DatagramPacket response = new DatagramPacket(dataForResp, dataForResp.length);
			try {
				socket.receive(response); //waiting for response
				long trackRecTime = System.currentTimeMillis(); // track time for recieve
				long rtt = trackRecTime - trackSendTime; //total length of time (ms)
				System.out.println(host + " is reachable. RTT: " + rtt + " ms");
			} catch (SocketTimeoutException e) {
				System.out.println(host + " is not reachable.");
			}
			socket.close();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
