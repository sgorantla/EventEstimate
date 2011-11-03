package org.springframework.security.oauth.examples.ctctOAuth2WebClient;

import java.io.InputStream;
import java.util.List;

/**
 * @author Ryan Heaton
 */
public interface SparklrService {

  /**   
   * Get the list of Sparklr photo ids for the current user.
   *
   * @param id of the resource
   * @return The list of photo ids for the current user.
   */
  List<String> getPhotoIds(String resourceId) throws org.springframework.security.oauth.examples.ctctOAuth2WebClient.SparklrException;

  /**
   * Loads the Sparklr photo for the current user.
   *
   * @param id the id or the photo.
   * @return The sparklr photo.
   */
  InputStream loadSparklrPhoto(String resourceId, String id) throws org.springframework.security.oauth.examples.ctctOAuth2WebClient.SparklrException;
}
