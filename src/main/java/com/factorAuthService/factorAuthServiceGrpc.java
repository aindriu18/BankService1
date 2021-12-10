package com.factorAuthService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: 2FactorAuth.proto")
public final class factorAuthServiceGrpc {

  private factorAuthServiceGrpc() {}

  public static final String SERVICE_NAME = "factorAuthService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.factorAuthService.containAuth,
      com.factorAuthService.containAuthVerification> getSendFactorAuthMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendFactorAuth",
      requestType = com.factorAuthService.containAuth.class,
      responseType = com.factorAuthService.containAuthVerification.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.factorAuthService.containAuth,
      com.factorAuthService.containAuthVerification> getSendFactorAuthMethod() {
    io.grpc.MethodDescriptor<com.factorAuthService.containAuth, com.factorAuthService.containAuthVerification> getSendFactorAuthMethod;
    if ((getSendFactorAuthMethod = factorAuthServiceGrpc.getSendFactorAuthMethod) == null) {
      synchronized (factorAuthServiceGrpc.class) {
        if ((getSendFactorAuthMethod = factorAuthServiceGrpc.getSendFactorAuthMethod) == null) {
          factorAuthServiceGrpc.getSendFactorAuthMethod = getSendFactorAuthMethod = 
              io.grpc.MethodDescriptor.<com.factorAuthService.containAuth, com.factorAuthService.containAuthVerification>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "factorAuthService", "sendFactorAuth"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.factorAuthService.containAuth.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.factorAuthService.containAuthVerification.getDefaultInstance()))
                  .setSchemaDescriptor(new factorAuthServiceMethodDescriptorSupplier("sendFactorAuth"))
                  .build();
          }
        }
     }
     return getSendFactorAuthMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static factorAuthServiceStub newStub(io.grpc.Channel channel) {
    return new factorAuthServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static factorAuthServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new factorAuthServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static factorAuthServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new factorAuthServiceFutureStub(channel);
  }

  /**
   */
  public static class factorAuthServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.factorAuthService.containAuth> sendFactorAuth(
        io.grpc.stub.StreamObserver<com.factorAuthService.containAuthVerification> responseObserver) {
      return asyncUnimplementedStreamingCall(getSendFactorAuthMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendFactorAuthMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.factorAuthService.containAuth,
                com.factorAuthService.containAuthVerification>(
                  this, METHODID_SEND_FACTOR_AUTH)))
          .build();
    }
  }

  /**
   */
  public static final class factorAuthServiceStub extends io.grpc.stub.AbstractStub<factorAuthServiceStub> {
    private factorAuthServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private factorAuthServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected factorAuthServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new factorAuthServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.factorAuthService.containAuth> sendFactorAuth(
        io.grpc.stub.StreamObserver<com.factorAuthService.containAuthVerification> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getSendFactorAuthMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class factorAuthServiceBlockingStub extends io.grpc.stub.AbstractStub<factorAuthServiceBlockingStub> {
    private factorAuthServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private factorAuthServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected factorAuthServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new factorAuthServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class factorAuthServiceFutureStub extends io.grpc.stub.AbstractStub<factorAuthServiceFutureStub> {
    private factorAuthServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private factorAuthServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected factorAuthServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new factorAuthServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_FACTOR_AUTH = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final factorAuthServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(factorAuthServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_FACTOR_AUTH:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendFactorAuth(
              (io.grpc.stub.StreamObserver<com.factorAuthService.containAuthVerification>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class factorAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    factorAuthServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.factorAuthService.factorAuthImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("factorAuthService");
    }
  }

  private static final class factorAuthServiceFileDescriptorSupplier
      extends factorAuthServiceBaseDescriptorSupplier {
    factorAuthServiceFileDescriptorSupplier() {}
  }

  private static final class factorAuthServiceMethodDescriptorSupplier
      extends factorAuthServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    factorAuthServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (factorAuthServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new factorAuthServiceFileDescriptorSupplier())
              .addMethod(getSendFactorAuthMethod())
              .build();
        }
      }
    }
    return result;
  }
}
