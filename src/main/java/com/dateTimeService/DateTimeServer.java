package com.dateTimeService;


import java.io.IOException;

import com.dateTimeService.dateTimeServiceGrpc.dateTimeServiceImplBase;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.util.logging.Logger;
import com.jmdns.*;

public class DateTimeServer {
	

	private static final Logger logger = java.util.logging.Logger.getLogger(DateTimeServer.class.getName());

	public static void main(String[] args) {

		//instantiate the DateTimeServer
		DateTimeServer dateTimeServer = new DateTimeServer();
		
		int port1 = 50051;
		String service_type1 = "_grpc1._tcp.local.";
		String service_name = "DateTimeServer";
		ServiceRegistration sr = new ServiceRegistration();
		sr.run(port1, service_type1, service_name);
		
		
		//build and start the server
		try {
			Server server = ServerBuilder.forPort(port1)
					.addService(new DateTimeServerImpl())
					.build()
					.start();
			
			System.out.println("\nServer V1.2 Started");
			
			server.awaitTermination();
		} catch (IOException e) {
			System.out.println("Error starting the server");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("Error starting the server");
			e.printStackTrace();
		}
		logger.info("Server started, listening on " + port1);
		

	}
	
	//Extend base class for the implementation
	static class DateTimeServerImpl extends dateTimeServiceImplBase {
		
		@Override//over ride the getDateTime method to request the date and time
		public void getDateTime(containsDateTime request, StreamObserver<containsDateTime> responseObserver) {
			
			//find out what was sent by the client
			String dateTime = request.getDateTime();
			
			System.out.println("dateTime: " +dateTime);
			
			//now send something back to the client
			//build the response
			containsDateTime.Builder response = containsDateTime.newBuilder();
			
			response.setDateTime("The date and time is: " + dateTime);
			
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
			
			
		}
	}
}
