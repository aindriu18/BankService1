package com.transactionService;


import java.io.IOException;
import java.util.logging.Logger;

import com.jmdns.ServiceRegistration;
import com.transactionService.transactionServiceGrpc.transactionServiceImplBase;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class TransactionServer {
	
	//variable to store the server
	private static final Logger logger = java.util.logging.Logger.getLogger(TransactionServer.class.getName());


	public static void main(String[] args) {

		//instantiate the NewBankingServer
		final TransactionServer transactionServer = new TransactionServer();

		//set the port to 54
		int port4 = 50054;
		String service_type4 = "_grpc4._tcp.local.";
		String service_name = "TransactionServer";
		ServiceRegistration ssr = new ServiceRegistration();
		ssr.run(port4, service_type4, service_name);
	
			
		//build and start the server
		try {
			Server server = ServerBuilder.forPort(port4)
					.addService(new TransactionServerImpl())
					.build()
					.start();
			
			System.out.println("\nTransactionServer V1.2 Started");
			
			server.awaitTermination();
		} catch (IOException e) {
			System.out.println("Error starting the TransactionServer");
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println("Error starting the TransactionServer");
			e.printStackTrace();
		}
		logger.info("TransactionServer started, listening on " + port4);
	}
	
	//Extend base class for the implementation
	static class TransactionServerImpl extends transactionServiceImplBase {
		
		@Override//over ride the getLocation method to request the location
		public void getTransaction(containsTransaction request, StreamObserver<containsTransaction> responseObserver) {
			
			//find out what was sent by the client
			String transaction = request.getTransaction();
					//Calendar.getInstance().getTime().toString();
			
			System.out.println("Transaction: " +transaction);
			//now send something back to the client
			//build the response
			containsTransaction.Builder response = containsTransaction.newBuilder();
			response.setTransaction("Transaction 1 is: " + transaction);
			responseObserver.onNext(response.build());
			response.setTransaction("Transaction 2 is: " + transaction);
			responseObserver.onNext(response.build());
			response.setTransaction("Transaction 3 is: " + transaction);
			responseObserver.onNext(response.build());
			response.setTransaction("Transaction 4 is: " + transaction);
			responseObserver.onNext(response.build());
			response.setTransaction("Transaction 5 is: " + transaction);
			responseObserver.onNext(response.build());
			response.setTransaction("Transaction 6 is: " + transaction);
			responseObserver.onNext(response.build());
			response.setTransaction("Transaction 7 is: " + transaction);
			responseObserver.onNext(response.build());
			response.setTransaction("Transaction 8 is: " + transaction);
			responseObserver.onNext(response.build());
			response.setTransaction("Transaction 9 is: " + transaction);
			responseObserver.onNext(response.build());
			response.setTransaction("Transaction 10 is: " + transaction);
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		}
	}
}
