import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class JServerSocket {

	private static ServerSocket serverSocket;
	
	public static void main(String[] args) throws Exception {
		serverSocket = new ServerSocket(45000);
		Socket socket = serverSocket.accept();
		saveFile(socket);
	}
	
	private static void saveFile(Socket socket) throws Exception {
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		FileOutputStream fos = new FileOutputStream("/home/patrizio/Downloads/eclipse.bin");
		
		byte[] buffer = new byte[4096];
		int read = 0;
		
		while ((read = dis.read(buffer)) >= 0) {
			fos.write(buffer, 0, read);
		}
		
		fos.close();
		dis.close();
	}

}
