// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: 2FactorAuth.proto

package com.factorAuthService;

public class factorAuthImpl {
  private factorAuthImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_containAuth_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_containAuth_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_containAuthVerification_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_containAuthVerification_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\0212FactorAuth.proto\"\036\n\013containAuth\022\017\n\007me" +
      "ssage\030\001 \001(\t\"*\n\027containAuthVerification\022\017" +
      "\n\007message\030\002 \001(\t2S\n\021factorAuthService\022>\n\016" +
      "sendFactorAuth\022\014.containAuth\032\030.containAu" +
      "thVerification\"\000(\0010\001B)\n\025com.factorAuthSe" +
      "rviceB\016factorAuthImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_containAuth_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_containAuth_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_containAuth_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_containAuthVerification_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_containAuthVerification_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_containAuthVerification_descriptor,
        new java.lang.String[] { "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
