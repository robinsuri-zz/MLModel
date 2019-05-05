import com.jcraft.jsch.*;

import java.time.LocalDateTime;

public class Test {
  public static void main(String[] args) throws JSchException {
    String user = args[0];
    String host = args[1];
    int port = Integer.parseInt(args[2]);
    String filePath = args[3];
    System.out.println("user = " + user);
    System.out.println("host = " + host);
    System.out.println("port = " + port);
    System.out.println("filepath = " + filePath);
    int connectTimeOut = 20000;

    JSch jSch = new JSch();

    JSch.setLogger(new Logger() {
      @Override
      public boolean isEnabled(int level) {
        return true;
      }

      @Override
      public void log(int level, String message) {
        System.out.println("level = " + level + ",  message = " + message);
      }
    });
    filePath = "/Users/robin.su/Documents/Checkout/jsch-sftp-test-connect/src/main/java/rbl_dmr_portal";
    jSch.addIdentity(filePath);
    Session session = jSch.getSession(user, host, port);
    String message = String.format("client version = %s , alive count = %s, alive interval = %s, timeout = %s, username = %s",
        session.getClientVersion(), session.getServerAliveCountMax(),
        session.getServerAliveInterval(), session.getTimeout(), session.getUserName());
    System.out.println(message);
    while (true) {
      try {
        System.out.println("Session = " + session.toString());
//    session.setPassword(filePath);
        session.setConfig("StrictHostKeyChecking", "false");
        try {
          System.out.println("session.isConnected = "+session.isConnected()+"  time = "+LocalDateTime.now());
          if (session.isConnected() == false)
            session.connect(connectTimeOut);
          ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
          channelSftp.connect();
          System.out.println("channelSftp is connected : " + channelSftp.isConnected() + "  time=" + LocalDateTime.now());
          channelSftp.disconnect();
        } catch (Exception e) {
          String message2 = String.format("Inside Exception client version = %s , alive count = %s, alive interval = %s, timeout = %s, username = %s",
              session.getClientVersion(), session.getServerAliveCountMax(),
              session.getServerAliveInterval(), session.getTimeout(), session.getUserName());
          System.out.println(message2);
          session.disconnect();
          System.out.println("time before = " + LocalDateTime.now());
          session = jSch.getSession(user, host, port);
          session.connect(connectTimeOut);
          ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
          channelSftp.connect();
          System.out.println("channelSftp is connected : " + channelSftp.isConnected() + "  time=" + LocalDateTime.now());
          channelSftp.disconnect();
          System.out.println("time after = " + LocalDateTime.now());
        }
      } catch (Exception e) {
        System.out.println("Exception time = " + LocalDateTime.now() + "  message =" + e.getMessage());
        e.printStackTrace();
      }
      int mins = 1 * 60 * 1000;
      try {
        Thread.sleep(mins);
      } catch (InterruptedException e) {

      }
    }

  }
}
