package org.cloudbus.cloudsim.container.containerPlacementPolicies;

import org.cloudbus.cloudsim.Log;
import org.cloudbus.cloudsim.container.core.ContainerVm;

import java.util.List;
import java.util.Set;

/**
 * Created by Naseem Sultana on 23/Nov/2023.
 * For container placement Naseem's policy.
 */
public class NaseemsContainerPlacementPolicy extends ContainerPlacementPolicy{

    @Override
    public ContainerVm getContainerVm(List<ContainerVm> vmList, Object obj, Set<? extends ContainerVm> excludedVmList) {
        Log.printLine("Container Policy Used: Naseem");
        ContainerVm selectedVm = null;
        double minMips = Double.MAX_VALUE;
        for (ContainerVm containerVm1 : vmList) {
            if (excludedVmList.contains(containerVm1)) {
                continue;
            }
            double containerUsage = containerVm1.getContainerScheduler().getAvailableMips();
            float ramSize = containerVm1.getRam();
            Log.print(">>>>>>>>>VM ID: " + containerVm1.getId());
            Log.printLine("RAM Size: " + ramSize + "<<<<<<<<<<<<");
            if ( containerUsage < minMips ) {
                minMips = containerUsage;
                selectedVm = containerVm1;

            }
           }
        return selectedVm;
    }
}
