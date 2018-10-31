/**
 * 
 */
package com.nagarro.pmp.PMPBackend.dao;

import java.util.List;

import com.nagarro.pmp.PMPBackend.dto.LoginDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;

/**
 * @author toshikagupta
 *
 */

public interface AdminDAO {

    LoginDTO validateCredentials(LoginDTO admin);
    List<SellerDTO> sortList(String classifier);
    /**
     * @param searchparam
     * @param classifier 
     * @return
     */
    List<SellerDTO> getSearchResult(String searchparam, String classifier);
    /**
     * @param status
     * @return
     */
    List<SellerDTO> filterbyStatus(String status);

}