import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import com.cloudera.livy.LivyClient;
import com.cloudera.livy.LivyClientBuilder;


public class Submit {

	public void main(String []args){
	LivyClient client = null;
	try {
		client = new LivyClientBuilder()
		  .setURI(new URI("http://ip-172-31-21-112.ec2.internal:8998"))
		  .build();
		
		client.
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
	  System.err.printf("Uploading %s to the Spark context...\n", "jar location");
	  client.uploadJar(new File("jar location")).get();

	  System.err.printf("Running PiJob with %d samples...\n", 3);
	  double pi = client.submit(new PiJob(3)).get();

	  //System.out.println("Pi is roughly: " + pi);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
	  client.stop(true);
	}
}
}
