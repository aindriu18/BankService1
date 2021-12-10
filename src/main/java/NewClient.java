
import com.dateTimeService.*;
import com.dateTimeService.dateTimeServiceGrpc.dateTimeServiceBlockingStub;
import com.balanceService.*;
import com.transactionService.*;
import com.locationService.*;
import com.factorAuthService.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import com.jmdns.*;
import io.grpc.stub.StreamObserver;

import javax.jmdns.ServiceInfo;
import javax.swing.*;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewClient implements ActionListener {

    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();
    static String dateTime = dtf.format(now);
    static String location = "23 faketown drive";
    static double balance = 146.93;
    static double spendingLimit = 2000;

    static double[] transactions = new double[10];

    private JFrame frame;
    private JPanel panel;
    private JLabel label1, label2, label3, label4, label5;
    private JButton button1, button2, button3, button4, button5;

    public NewClient() {

        frame = new JFrame();

        button1 = new JButton("Date and time");
// button1.setPreferredSize(new Dimension(40, 40));
        button1.addActionListener(this);
        button2 = new JButton("Location");
        button2.addActionListener(this);
        button3 = new JButton("Balance");
        button3.addActionListener(this);
        button4 = new JButton("Spending Limit");
        button4.addActionListener(this);
        button5 = new JButton("Past transactions");
        button5.addActionListener(this);

        label1 = new JLabel("The date and time is: ");
        label2 = new JLabel("The location is: ");
        label3 = new JLabel("The balance is: ");
        label4 = new JLabel("The spending limit is: ");
        label5 = new JLabel("Your past transactions: ");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
//panel.setPreferredSize(new Dimension(150,150));
        panel.setLayout(new GridLayout(5,2));
        panel.add(button1);
        panel.add(label1);
        panel.add(button2);
        panel.add(label2);
        panel.add(button3);
        panel.add(label3);
        panel.add(button4);
        panel.add(label4);
        panel.add(button5);
        panel.add(label5);

        frame.add(panel, BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(1000, 700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Bank");
        frame.pack();
        frame.setVisible(true);

        transactions[0] = 4.99;
        transactions[1] = 5.99;
        transactions[2] = 9.99;
        transactions[3] = 1.99;
        transactions[4] = 2.99;
        transactions[5] = 8.99;
        transactions[6] = 3.99;
        transactions[7] = 2.99;
        transactions[8] = 4.99;
        transactions[9] = 30.99;

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button1) {
            label1.setText("The date and time is: "+dateTime);
        }
        else if(e.getSource()==button2) {
            label2.setText("The location is: "+location);
        }
        if(e.getSource()==button3) {
            label3.setText("The balance is: "+balance);
        }
        else if(e.getSource()==button4) {
            label4.setText("The spending limit is: "+spendingLimit);
        }
        else if(e.getSource()==button5) {
        	String transactionString = "\n";
        	for (int i =0; i<10; i++) {
        		transactionString += (" ("+(i+1) +")" +String.valueOf(transactions[i])+",");
        	}
        	
            label5.setText("Your past transactions: "+transactionString);
        }

    }

    private static final Logger logger = Logger.getLogger(NewClient.class.getName());

    public static void main(String[] args) throws Exception {
        new NewClient();

        ServiceInfo serviceInfo1;
        ServiceInfo serviceInfo2;
        //ServiceInfo serviceInfo3;
        ServiceInfo serviceInfo4;
        ServiceInfo serviceInfo5;
        String service_type1 = "_grpc1._tcp.local.";//for dateTime
        String service_type2 = "_grpc2._tcp.local.";//for location
        String service_type3 = "_grpc3._tcp.local.";//for balance
        String service_type4 = "_grpc4._tcp.local.";// for transaction
        String service_type5 = "_grpc5._tcp.local.";// for 2fa
        serviceInfo1 = ServiceDiscovery.run(service_type1);
        serviceInfo2 = ServiceDiscovery.run(service_type2);
        //serviceInfo3 = ServiceDiscovery.run(service_type3);
        serviceInfo4 = ServiceDiscovery.run(service_type4);
        serviceInfo5 = ServiceDiscovery.run(service_type5);

        //Ports
        int port1 = serviceInfo1.getPort();//datetime
        int port2 = serviceInfo2.getPort();//location
        //int port3 = serviceInfo3.getPort();//balance
        int port4 = serviceInfo4.getPort();//transaction
        int port5 = serviceInfo5.getPort();//2fa

        String host = "localhost";

        //plaintext not secure if using production service
        //this is generic code
        ManagedChannel newChannel1 = ManagedChannelBuilder.forAddress(host, port1).usePlaintext().build();//datetime
        ManagedChannel newChannel2 = ManagedChannelBuilder.forAddress(host, port2).usePlaintext().build();//location
        //ManagedChannel newChannel3 = ManagedChannelBuilder.forAddress(host, port3).usePlaintext().build();//balance
        ManagedChannel newChannel4 = ManagedChannelBuilder.forAddress(host, port4).usePlaintext().build();//transaction
        ManagedChannel newChannel5 = ManagedChannelBuilder.forAddress(host, port5).usePlaintext().build();//2fa

        ///to call rpc we use stubs
        dateTimeServiceBlockingStub blockingStubDateTime = dateTimeServiceGrpc.newBlockingStub(newChannel1);
        //dateTimeServiceGrpc.dateTimeServiceBlockingStub blockingStubDateTime = dateTimeServiceGrpc.newBlockingStub(newChannel1);//datetime
        locationServiceGrpc.locationServiceBlockingStub blockingStubLocation = locationServiceGrpc.newBlockingStub(newChannel2);//location
        //balanceServiceGrpc.balanceServiceBlockingStub balanceServiceStub = balanceServiceGrpc.newBlockingStub(newChannel3);//balance
        transactionServiceGrpc.transactionServiceBlockingStub transactionServiceStub = transactionServiceGrpc.newBlockingStub(newChannel4);//transaction
        //locationServiceGrpc.locationServiceStub locationServiceStub = locationServiceGrpc.newStub(newChannel4);
        factorAuthServiceGrpc.factorAuthServiceStub factorAuthServiceStub = factorAuthServiceGrpc.newStub(newChannel5);




        try {

            containsDateTime dateTimeRequest = containsDateTime.newBuilder().setDateTime(dateTime).build();

            containsDateTime dateTimeResponse = blockingStubDateTime.getDateTime(dateTimeRequest);

            logger.info("DateTime: "+ dateTimeResponse.getDateTime());

            //newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (StatusRuntimeException e){
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;

        }
        try {

            
            containsLocation locationRequest = containsLocation.newBuilder().setLocation("Checking location").build();
            containsLocation locationResponse = blockingStubLocation.getLocation(locationRequest);

            logger.info("Location: "+ locationResponse.getLocation());

            //newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (StatusRuntimeException e){
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;

        }
        try {
            

            containsBalance balanceRequest = containsBalance.newBuilder().setBalance("Checking balance").build();

            //Iterator<containsBalance> balanceResponse = balanceServiceStub.getBalance(balanceRequest);

            //logger.info("Balance: "+  ((containsBalanceOrBuilder) balanceResponse).getBalance());



             
        }
        catch (StatusRuntimeException e){
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;

        }
        
        try {
            

            containsTransaction transactionRequest = containsTransaction.newBuilder().setTransaction("Checking Transactions").build();

            Iterator<containsTransaction> transactionResponse = transactionServiceStub.getTransaction(transactionRequest);

            //.info("DateTime: "+  ((containsTransactionOrBuilder) transactionResponse).getTransaction());



             
        }
        catch (StatusRuntimeException e){
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return;

        }
        finally {
            newChannel1.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            newChannel2.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            //newChannel3.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            newChannel4.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
