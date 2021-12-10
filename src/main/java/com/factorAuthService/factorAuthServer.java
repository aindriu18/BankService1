package com.factorAuthService;

import com.jmdns.ServiceRegistration;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import com.factorAuthService.*;

import java.io.IOException;
import java.util.logging.Logger;

public class factorAuthServer {

    private static final Logger logger = java.util.logging.Logger.getLogger(factorAuthServer.class.getName());

    public static void main(String[] args) {

        int port5 = 50055;
        String service_type5 = "_grpc5._tcp.local.";
        String service_name = "FactorAuthServer";
        ServiceRegistration sr = new ServiceRegistration();
        sr.run(port5, service_type5, service_name);

        //build and start the server
        try {
            Server server = ServerBuilder.forPort(port5)
                    .addService(new factorAuthServiceGrpc.factorAuthServiceImplBase())
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
        logger.info("Server started, listening on " + port5);



    }
}
