package com.wijjit.api.utility.manager.controller;

import com.wijjit.api.utility.manager.models.IApiResponse;
import com.wijjit.api.utility.manager.models.SuccessResponse;
import com.wijjit.api.utility.manager.service.UserProfileManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserProfileManagerController {
    private UserProfileManagerService profileManagerService;

    public UserProfileManagerController(UserProfileManagerService profileManagerService) {
        this.profileManagerService = profileManagerService;
    }

    @RequestMapping(value = "/deleteUser/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<List> deleteUser(@PathVariable String username) {
        List<String> messageList = profileManagerService.deleteUser(username);
        return new ResponseEntity<>(messageList, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteCivicData/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<IApiResponse> deleteCivicData(@PathVariable String username) {
        String message = profileManagerService.deleteCivicUserData(username);
        return new ResponseEntity<>(new SuccessResponse(message), HttpStatus.OK);
    }

    @RequestMapping(value = "/emailConfirmationCode/{username}", method = RequestMethod.GET)
    public ResponseEntity<IApiResponse> getEmailConfirmationCode(@PathVariable String username) {
        Integer code = profileManagerService.retrieveEmailConfirmationCode(username);
        return new ResponseEntity<>(new SuccessResponse(String.valueOf(code)), HttpStatus.OK);
    }

    @RequestMapping(value = "/confirmationCode/{username}", method = RequestMethod.GET)
    public ResponseEntity<IApiResponse> getConfirmationCode(@PathVariable String username) {
        Integer code = profileManagerService.retrieveConfirmationCode(username);
        return new ResponseEntity<>(new SuccessResponse(String.valueOf(code)), HttpStatus.OK);
    }
}
