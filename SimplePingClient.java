import java.net.*;

public class SimplePingClient {
	public static void main(String[] args) {
		if (args.length != 1) { //prevent crash check in case of empty argument
			System.out.println("missing hostname");
			return;
		}

		String host = args[0]; //retrieve first commandline arg

		try {
			InetAddress addr = InetAddress.getByName(host);
			boolean reachable = addr.isReachable(3000); 
			// check if reachable within 3 seconds

			if (reachable) {
				System.out.println(host + " is reachable.");
			} else {
				System.out.println(host + " is not reachable.");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
