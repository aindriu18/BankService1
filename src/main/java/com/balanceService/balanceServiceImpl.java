// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: balanceService.proto

package com.balanceService;

public final class balanceServiceImpl {
  private balanceServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_containsBalance_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_containsBalance_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024balanceService.proto\"\"\n\017containsBalanc" +
      "e\022\017\n\007balance\030\001 \001(\t2F\n\016balanceService\0224\n\n" +
      "GetBalance\022\020.containsBalance\032\020.containsB" +
      "alance\"\0000\001B*\n\022com.balanceServiceB\022balanc" +
      "eServiceImplP\001b\006proto3"
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
    internal_static_containsBalance_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_containsBalance_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_containsBalance_descriptor,
        new java.lang.String[] { "Balance", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}