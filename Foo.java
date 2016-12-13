import java.net.URLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

public class Foo {
	public static void main(String[] args) throws Exception{
		URL url = new URL("https://api.stackexchange.com/2.2/info?site=stackoverflow&key=HZzuYOiIGQuqL7vHjPdBYw(("); // General info about Stack Overflow
		URLConnection connection =  url.openConnection();
		connection.connect();
		
		byte[] response = new byte[1000];
    // Everything returned by SE API is gzipped. We should therefore use a specialized stream to get something meaningful instead of gibberish
		try (GZIPInputStream in = new GZIPInputStream(connection.getInputStream())) {
      in.read(response);
    }
    
		System.out.println(new String(response, "utf8").trim());
	}	
}
