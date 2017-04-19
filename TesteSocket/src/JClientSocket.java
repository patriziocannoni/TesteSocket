
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class JClientSocket {

	private static Socket socket;
	
	public static void main(String[] args) throws Exception {
		socket = new Socket("localhost", 45000);
		sendFile(new File("/home/patrizio/Downloads/eclipse-cpp-neon-2-linux-gtk-x86_64.tar.gz"));
	}
	
	private static void sendFile(File file) throws Exception {
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		FileInputStream fis = new FileInputStream(file);
		
		byte[] buffer = new byte[4096];
		int read = 0;
		
		while ((read = fis.read(buffer)) >= 0) {
			dos.write(buffer, 0, read);
		}
		
		fis.close();
		dos.close();
	}

}
