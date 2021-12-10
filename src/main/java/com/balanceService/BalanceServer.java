package com.balanceService;


import java.io.IOException;
import java.util.logging.Logger;

import com.balanceService.balanceServiceGrpc.balanceServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import com.jmdns.*;


public class BalanceServer {
	
	//variable to store the server
	private static final Logger logger = java.util.logging.Logger.getLogger(BalanceServer.class.getName());


	public static void main(String[] args) {

		//instantiate the NewBankingServer
		final BalanceServer balanceServer = new BalanceServer();

		//set the port to 53
		int port3 = 50053;
		String service_type3 = "_grpc3._tcp.local.";
		String service_name = "BalanceServer";
		ServiceRegistration ssr = new ServiceRegistration();
		ssr.run(port3, service_type3, service_name);
	
			
		//build and start the server
		try {
			Server server = ServerBuilder.forPort(port3)
					.addService(new BalanceServerImpl())
					.build()
					.start();
			
			System.out.println("\nBalanceServer V1.2 Started");
			
			server.awaitTermination();
		} catch (IOException e) {
			System.out.println("Error starting the Balance server");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("Error starting the Balance server");
			e.printStackTrace();
		}
		logger.info("Balance Server started, listening on " + port3);
	}
	
	//Extend base class for the implementation
	static class BalanceServerImpl extends balanceServiceImplBase {
		
		@Override//over ride the getLocation method to request the location
		public void getBalance(containsBalance request, StreamObserver<containsBalance> responseObserver) {
			
			//find out what was sent by the client
			String balance = request.getBalance();
					//Calendar.getInstance().getTime().toString();
			
			System.out.println("Balance: " +balance);
			
			//now send something back to the client
			//build the response
			containsBalance.Builder response = containsBalance.newBuilder();

			response.setBalance("Checking your balance: " +balance);
			responseObserver.onNext(response.build());
			
			response.setBalance("€100,000");
			responseObserver.onNext(response.build());

			responseObserver.onCompleted();
		}
	}
}
