package com.ashkSoft.services;

import com.ashkSoft.managers.PuppetMaster;
import com.ashkSoft.models.InputFilter;
import com.ashkSoft.models.Operate;
import com.ashkSoft.models.OutputData;

import java.util.List;

public class Services {

    PuppetMaster puppetMaster;

    public Services() {
        this.puppetMaster = new PuppetMaster();
    }

    public OutputData getCustomizedData(InputFilter filter){
        if (filter.isDef()) {
            //TODO return the whole dataset
        }

        return puppetMaster.getRequestedData(filter);

    }
}
