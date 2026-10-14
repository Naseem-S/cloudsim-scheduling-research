package org.cloudbus.cloudsim.examples.container;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.cloudbus.cloudsim.Log;

/**
 * This Example is following the format for {@link org.cloudbus.cloudsim.examples.power.planetlab.Dvfs}
 * It specifically studies the initial placement of containers.
 *
 * @author Sareh Fotuhi Piraghaj
 */
public class NaseemsContainerInitialPlacementTest {


    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(String[] args) throws IOException {
        /**
         * The experiments can be repeated for (repeat - runtime +1) times.
         * Please set these values as the arguments of the main function or set them bellow:
         */
        int runTime = 1000;
        int repeat = 1001;
        for (int i = runTime; i < repeat; ++i) {
            boolean enableOutput = true;
            boolean outputToFile = true;
            /**
             * Getting the path of the planet lab workload that is included in the cloudSim Package
             */
            String inputFolder = ContainerOverbooking.class.getClassLoader().getResource("workload/planetlab").getPath();
            /**
             * The output folder for the logs. The log files would be located in this folder.
             */
            
            long timestamp = System.currentTimeMillis();
            String timestampString1 = new SimpleDateFormat("yyyyMMdd").format(new Date(timestamp));
            String timestampString2 = new SimpleDateFormat("HHmmss").format(new Date(timestamp));
            String outputFolder = NaseemsConstants.OUTPUT_FOLDER_NAME + "/" + timestampString1 + "/" + timestampString2;            
            /**
             * The allocation policy for VMs.
             */
            String vmAllocationPolicy = NaseemsConstants.VM_ALLOCATION_POLICY;
            /**
             * The selection policy for containers where a container migration is triggered.
             */
            String containerSelectionPolicy = NaseemsConstants.CONTAINER_SELECTION_POLICY;
            /**
             * The allocation policy used for allocating containers to VMs.
             */
            String containerAllocationPolicy = NaseemsConstants.CONTAINER_ALLOCATION_POLICY;
            /**
             * The host selection policy determines which hosts should be selected as the migration destination.
             */
            String hostSelectionPolicy = NaseemsConstants.HOST_SELECTION_POLICY;
            /**
             * The VM Selection Policy is used for selecting VMs to migrate when a host status is determined as
             * "Overloaded"
             */
            String vmSelectionPolicy = NaseemsConstants.VM_SELECTION_POLICY;
            /**
             * The container overbooking factor is used for overbooking resources of the VM. In this specific case
             * the overbooking is performed on CPU only.
             */

            int OverBookingFactor = NaseemsConstants.OVER_BOOKING_FACTOR;

            new RunnerInitiator(
                    enableOutput,
                    outputToFile,
                    inputFolder,
                    outputFolder,
                    vmAllocationPolicy,
                    containerAllocationPolicy,
                    vmSelectionPolicy,
                    containerSelectionPolicy,
                    hostSelectionPolicy,
                    OverBookingFactor, Integer.toString(i), outputFolder);
        }

    }
}
