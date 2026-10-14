package org.cloudbus.cloudsim.examples.container;

import java.util.HashMap;
import java.util.Map;

import org.cloudbus.cloudsim.container.containerPlacementPolicies.ContainerPlacementPolicyFirstFit;
import org.cloudbus.cloudsim.container.containerPlacementPolicies.ContainerPlacementPolicyLeastFull;
import org.cloudbus.cloudsim.container.containerPlacementPolicies.ContainerPlacementPolicyMostFull;
import org.cloudbus.cloudsim.container.containerPlacementPolicies.ContainerPlacementPolicyRandomSelection;
import org.cloudbus.cloudsim.container.containerPlacementPolicies.NaseemsContainerPlacementPolicy;
import org.cloudbus.cloudsim.container.resourceAllocators.ContainerAllocationPolicy;
import org.cloudbus.cloudsim.container.resourceAllocators.ContainerAllocationPolicyRS;
import org.cloudbus.cloudsim.container.resourceAllocators.PowerContainerAllocationPolicySimple;

public class NaseemsConstants {
  public static int NO_OF_CLOUD_USERS = 2;
  public static boolean TRACE_FLAG = false;  
  public static int NUMBER_HOSTS = 20;
  public static int NUMBER_VMS = 25;
  public static int NUMBER_CLOUDLETS = 50;
  public static double THRESHOLD_OVER_UTILIZATION = 0.80;
  public static double THRESHOLD_UNDER_UTILIZATION = 0.70;
  public static int OVER_BOOKING_FACTOR = 50;
  public static final String OUTPUT_FOLDER_NAME = "Results";
  public static Map<Integer,Float> containerVMsRam = new HashMap<Integer,Float>();

  //Algorithms
  public static String VM_ALLOCATION_POLICY = "MSThreshold-Under_0.80_0.70";//[MSThreshold-Under_0.80_0.70, MSThreshold-Over_0.80_0.70, VMThreshold-Under_0.80_0.70]
  public static String CONTAINER_SELECTION_POLICY = "MaxUsage"; //[MaxUsage, Cor]
  public static String CONTAINER_ALLOCATION_POLICY = "FirstFit"; //[LeastFull, MostFull, FirstFit, Random]
  public static String HOST_SELECTION_POLICY = "FirstFit";//[FirstFit, LeastFull, MostFull, RandomSelection]
  public static String VM_SELECTION_POLICY = "VmMaxC";//[VmMaxC, VmMaxU]
  public static String CONTAINER_PLACEMENT_POLICY = "Naseem"; //[Naseem, LeastFull, MostFull, FirstFit, Random]

  public static void setToDefaults(){
    NO_OF_CLOUD_USERS = 2;
    TRACE_FLAG = false;
    NUMBER_HOSTS = 20;
    NUMBER_VMS = 25;
    NUMBER_CLOUDLETS = 50;
    THRESHOLD_OVER_UTILIZATION = 0.80;
    THRESHOLD_UNDER_UTILIZATION = 0.70;
    OVER_BOOKING_FACTOR = 50;
    CONTAINER_PLACEMENT_POLICY = "Naseem";
    VM_ALLOCATION_POLICY = "MSThreshold-Under_0.80_0.70";
    CONTAINER_SELECTION_POLICY = "MaxUsage";
    CONTAINER_ALLOCATION_POLICY = "MostFull";
    HOST_SELECTION_POLICY = "FirstFit";
    VM_SELECTION_POLICY = "VmMaxC";
  }

  public static ContainerAllocationPolicy getContainerAllocationPolicy() {
    ContainerAllocationPolicy containerAllocationPolicy;
    switch (CONTAINER_PLACEMENT_POLICY) {      
      case "Simple":
        containerAllocationPolicy = new PowerContainerAllocationPolicySimple();
        break;
      case "LeastFull":
        containerAllocationPolicy = new ContainerAllocationPolicyRS(new ContainerPlacementPolicyLeastFull());
        break;
      case "MostFull":
        containerAllocationPolicy = new ContainerAllocationPolicyRS(new ContainerPlacementPolicyMostFull());
        break;
      case "FirstFit":
        containerAllocationPolicy = new ContainerAllocationPolicyRS(new ContainerPlacementPolicyFirstFit());
        break;
      case "Random":
        containerAllocationPolicy = new ContainerAllocationPolicyRS(new ContainerPlacementPolicyRandomSelection());
        break;
      case "Naseem":
        containerAllocationPolicy = new ContainerAllocationPolicyRS(new NaseemsContainerPlacementPolicy());
        break;
      default:
        containerAllocationPolicy = new PowerContainerAllocationPolicySimple();
        break;
    }
    return containerAllocationPolicy;
  }
}
