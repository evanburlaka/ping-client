# Instructions – Ping Client Project (Java 11)

Files Included:
- SimplePingClient.java → Ping a host using InetAddress
- TimedPingClient.java → Measure round-trip time (RTT) using UDP packets

How to Run SimplePingClient:
  java SimplePingClient.java <hostname>

Examples:
  java SimplePingClient.java google.com
  java SimplePingClient.java 8.8.8.8
  
  - Checks if the given host is reachable
  - Displays if the host is reachable or not

How to Run TimedPingClient:
  java TimedPingClient.java <hostname>

Examples:
  java TimedPingClient.java 1.1.1.1
  java TimedPingClient.java dns.google
  
  - Sends a UDP packet to the host
  - Measures and displays round-trip time (RTT) if reachable

Testing Notes:
- For TimedPingClient, testing was primarily performed using a local UDP Echo Server on port 7.
- When testing with public DNS servers (port 53), some UDP packets may be filtered or blocked, depending on network conditions.
- If no response is received, the program will report the host as unreachable.
- Recommended targets for external testing: 1.1.1.1 (Cloudflare DNS), 8.8.8.8 (Google DNS).
- Local echo server testing ensures consistent responses without relying on external networks.

Acknowledgment:
- Developed as part of a networking fundamentals course at California State University, Sacramento.
