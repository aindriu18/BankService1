import java.util.concurrent.TimeUnit;

import com.dateTimeService.containsDateTime;
import com.dateTimeService.dateTimeServiceGrpc;
import com.dateTimeService.dateTimeServiceGrpc.dateTimeServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class BankClient {

	public static void main(String[] args) {
		
		//build a channel
		int port = 50051;
		String host = "localhost";
		
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		//the code above is generic
		
		//build a message
		containsDateTime cString = containsDateTime.newBuilder().setDateTime("15:37").build();
		
		//create a stub
		//the stub is specific to the service
		
		dateTimeServiceBlockingStub bstub = dateTimeServiceGrpc.newBlockingStub(newChannel);
		containsDateTime response = bstub.getDateTime(cString);
		System.out.println(response);
		
		try {
			newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}