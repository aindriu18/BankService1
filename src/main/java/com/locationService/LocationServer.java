package com.locationService;


import java.io.IOException;
import java.util.logging.Logger;

import com.jmdns.ServiceRegistration;
import com.locationService.locationServiceGrpc.locationServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class LocationServer {
	
	//variable to store the server
	private static final Logger logger = java.util.logging.Logger.getLogger(LocationServer.class.getName());


	public static void main(String[] args) {

		//instantiate the NewBankingServer
		final LocationServer locationServer = new LocationServer();

		//set the port to 52
		int port2 = 50052;
		String service_type2 = "_grpc2._tcp.local.";
		String service_name = "LocationServer";
		ServiceRegistration ssr = new ServiceRegistration();
		ssr.run(port2, service_type2, service_name);
	
			
		//build and start the server
		try {
			Server server = ServerBuilder.forPort(port2)
					.addService(new LocationServerImpl())
					.build()
					.start();
			
			System.out.println("\nLocationServer V1.2 Started");
			
			server.awaitTermination();
		} catch (IOException e) {
			System.out.println("Error starting the location server");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("Error starting the location server");
			e.printStackTrace();
		}
		logger.info("LocationServer started, listening on " + port2);
	}
	
	//Extend base class for the implementation
	static class LocationServerImpl extends locationServiceImplBase {
		
		@Override//over ride the getLocation method to request the location
		public void getLocation(containsLocation request, StreamObserver<containsLocation> responseObserver) {
			
			//find out what was sent by the client
			String location = request.getLocation();
					//Calendar.getInstance().getTime().toString();
			
			System.out.println("Location: " +location);
			
			//now send something back to the client
			//build the response
			containsLocation.Builder response = containsLocation.newBuilder();
			
			response.setLocation("Location is: " + location);
			
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
			
			
		}
	}
}
