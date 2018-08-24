package com.wijjit.api.utility.manager.service;

import com.wijjit.api.utility.manager.dao.ICivicUserDataDao;
import com.wijjit.api.utility.manager.dao.IUserProfileDao;
import com.wijjit.api.utility.manager.dao.IWijjitPurchaseHistoryDao;
import com.wijjit.api.utility.manager.dao.IWijjitWalletDao;
import com.wijjit.api.utility.manager.models.CivicUserData;
import com.wijjit.api.utility.manager.models.UserWallets;
import com.wijjit.api.utility.manager.models.WijjitPurchaseHistory;
import com.wijjit.jwt.api.security.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileManagerService {

    private static Logger logger = LoggerFactory.getLogger(UserProfileManagerService.class);

    private IUserProfileDao userProfileDao;
    private IWijjitPurchaseHistoryDao wijjitPurchaseHistoryDao;
    private IWijjitWalletDao wijjitWalletDao;
    private ICivicUserDataDao civicUserDataDao;
    private String deleteMessage = "User account deleted successfully";

    public UserProfileManagerService(IUserProfileDao userProfileDao,
                                     IWijjitPurchaseHistoryDao wijjitPurchaseHistoryDao,
                                     IWijjitWalletDao wijjitWalletDao, ICivicUserDataDao civicUserDataDao) {
        this.userProfileDao = userProfileDao;
        this.wijjitPurchaseHistoryDao = wijjitPurchaseHistoryDao;
        this.wijjitWalletDao = wijjitWalletDao;
        this.civicUserDataDao = civicUserDataDao;
    }


    public String deleteUser(String username) {
        UserProfile userProfile = userProfileDao.findByUserName(username);
        if (userProfile != null) {
            userProfileDao.delete(userProfile);
        } else {
            logger.debug("User profile not found for username: " + username);
            deleteMessage = "User profile not found";
        }

        UserWallets wijjitWallet = wijjitWalletDao.findByUserName(username);
        if (wijjitWallet != null) {
            wijjitWalletDao.delete(wijjitWallet);
        } else {
            logger.debug("User wallet not found for username: " + username);
            deleteMessage = "User wallet not found";
        }

        List<WijjitPurchaseHistory> wijjitPurchaseHistoryList = wijjitPurchaseHistoryDao.findByUserName(username);
        if (wijjitPurchaseHistoryList.size() > 0) {
            wijjitPurchaseHistoryDao.deleteAll(wijjitPurchaseHistoryList);
        } else {
            logger.debug("Wijjit purchase history not found for username: " + username);
            deleteMessage = "Wijjit purchase history not found";
        }

        deleteCivicUserData(username);
        return deleteMessage;
    }

    public String deleteCivicUserData(String username) {
        CivicUserData civicUserData = civicUserDataDao.findByUserName(username);
        if (civicUserData != null) {
            civicUserDataDao.delete(civicUserData);
        } else {
            logger.debug("Civic user data not found for username: " + username);
            deleteMessage = "Civic user data not found";
        }
        return deleteMessage;
    }

}
