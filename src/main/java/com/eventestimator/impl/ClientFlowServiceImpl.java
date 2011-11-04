package com.eventestimator.impl;

import java.util.HashMap;

import com.eventestimator.ClientFlowService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Ryan Heaton
 */
public class ClientFlowServiceImpl implements ClientFlowService {

	HashMap<String, String> envData = new HashMap<String, String>();
    
    protected static Log logger = LogFactory.getLog(ClientFlowServiceImpl.class);
    
    ClientFlowServiceImpl()
    {
    	envData.put("prod", "5204d963-d686-4696-bc20-c444c23c0b33");
    	envData.put("s1", "0700b68f-af14-42be-94b9-8ae36f10f990");
    	envData.put("l1", "2ef92d12-c13c-4467-b90d-d1822eb32e43");
    	envData.put("f1", "74ed0005-a09f-4cf6-8df8-70135a7ed9d4");
    	envData.put("f2", "b4fc79f6-870b-49b7-81ad-faaae4a978cd");
    	envData.put("d1", "145d3f5b-387d-4ff6-a25a-734477270dd6");
    }
    
    public String getAppId(String envId) {
    	return envData.get(envId);
    }
    
    public HashMap everything()
    {
    	return envData;
    }

}
