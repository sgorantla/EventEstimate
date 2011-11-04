package com.eventestimator;

import java.io.InputStream;
import java.util.List;

/**
 * @author Ryan Heaton
 */
public interface ClientFlowService {

  /**   
   * Get the list of Sparklr photo ids for the current user.
   *
   * @param id of the resource
   * @return The list of photo ids for the current user.
   */
	public String getAppId(String envId);
}
