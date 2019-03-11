package com.wijjit.api.utility.manager.service;

import com.wijjit.api.utility.manager.dao.*;
import com.wijjit.api.utility.manager.exception.UserDataException;
import com.wijjit.api.utility.manager.models.CivicUserData;
import com.wijjit.api.utility.manager.models.StripeChargeResponse;
import com.wijjit.api.utility.manager.models.UserWallets;
import com.wijjit.api.utility.manager.models.WijjitPurchaseHistory;
import com.wijjit.jwt.api.security.model.AccountVerification;
import com.wijjit.jwt.api.security.model.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProfileManagerService {

    private static Logger logger = LoggerFactory.getLogger(UserProfileManagerService.class);

    private IUserProfileDao userProfileDao;
    private IWijjitPurchaseHistoryDao wijjitPurchaseHistoryDao;
    private IWijjitWalletDao wijjitWalletDao;
    private ICivicUserDataDao civicUserDataDao;
    private IStripeChargesDao stripeChargesDao;
    private String deleteMessage = "User account deleted successfully";

    public UserProfileManagerService(IUserProfileDao userProfileDao,
                                     IWijjitPurchaseHistoryDao wijjitPurchaseHistoryDao,
                                     IWijjitWalletDao wijjitWalletDao, ICivicUserDataDao civicUserDataDao, IStripeChargesDao stripeChargesDao) {
        this.userProfileDao = userProfileDao;
        this.wijjitPurchaseHistoryDao = wijjitPurchaseHistoryDao;
        this.wijjitWalletDao = wijjitWalletDao;
        this.civicUserDataDao = civicUserDataDao;
        this.stripeChargesDao = stripeChargesDao;
    }


    public List<String> deleteUser(String username) {
        List<String> deleteMessageList = new ArrayList<>();
        UserProfile userProfile = userProfileDao.findByUserId(username);
        if (userProfile != null) {
            userProfileDao.delete(userProfile);
            deleteMessageList.add("User Profile deleted");
        } else {
            logger.debug("User profile not found for username: " + username);
            deleteMessageList.add("User profile not found");
        }

        UserWallets wijjitWallet = wijjitWalletDao.findByUserName(username);
        if (wijjitWallet != null) {
            wijjitWalletDao.delete(wijjitWallet);
            deleteMessageList.add("User wallet deleted");
        } else {
            logger.debug("User wallet not found for username: " + username);
            deleteMessageList.add("User wallet not found");
        }

        List<WijjitPurchaseHistory> wijjitPurchaseHistoryList = wijjitPurchaseHistoryDao.findByUserName(username);
        if (wijjitPurchaseHistoryList.size() > 0) {
            wijjitPurchaseHistoryDao.deleteAll(wijjitPurchaseHistoryList);
            deleteMessageList.add("Wijjit purchase history deleted");
        } else {
            logger.debug("Wijjit purchase history not found for username: " + username);
            deleteMessageList.add("Wijjit purchase history not found");
        }

        List<StripeChargeResponse> stripeChargeResponseList = stripeChargesDao.findByUsername(username);
        if (stripeChargeResponseList.size() > 0) {
            stripeChargesDao.deleteAll(stripeChargeResponseList);
            deleteMessageList.add("Stripe charges deleted");
        } else {
            logger.debug("Wijjit purchase history not found for username: " + username);
            deleteMessageList.add("Stripe charges not found");
        }

        deleteMessageList.add(deleteCivicUserData(username));
        return deleteMessageList;
    }

    public String deleteCivicUserData(String username) {
        CivicUserData civicUserData = civicUserDataDao.findByUserName(username);
        if (civicUserData != null) {
            civicUserDataDao.delete(civicUserData);
            deleteMessage = "Civic user data deleted";
        } else {
            logger.debug("Civic user data not found for username: " + username);
            deleteMessage = "Civic user data not found";
        }
        return deleteMessage;
    }

    public Integer retrieveEmailConfirmationCode(String username) {

        UserProfile userProfile = userProfileDao.findByUserId(username);
        if(userProfile == null) {
            throw new UserDataException("User profile not found");
        }

        AccountVerification  acctVerification = userProfile.getAccountVerification();
        if (acctVerification == null) {
            throw new UserDataException("Verification details not found");
        }
        return acctVerification.getEmailVerificationCode();
    }

    public Integer retrieveConfirmationCode(String username) {

        UserProfile userProfile = userProfileDao.findByUserId(username);
        if(userProfile == null) {
            throw new UserDataException("User profile not found");
        }

        AccountVerification  acctVerification = userProfile.getAccountVerification();
        if (acctVerification == null) {
            throw new UserDataException("Verification details not found");
        }
        return acctVerification.getVerificationCode();
    }
}
