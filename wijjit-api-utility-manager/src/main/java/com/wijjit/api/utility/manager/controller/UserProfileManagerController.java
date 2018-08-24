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

@RestController
public class UserProfileManagerController {
    private UserProfileManagerService profileManagerService;

    public UserProfileManagerController(UserProfileManagerService profileManagerService) {
        this.profileManagerService = profileManagerService;
    }

    @RequestMapping(value = "/deleteUser/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<IApiResponse> deleteUser(@PathVariable String username) {
        String message = profileManagerService.deleteUser(username);
        return new ResponseEntity<>(new SuccessResponse(message), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteCivicData/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<IApiResponse> deleteCivicData(@PathVariable String username) {
        String message = profileManagerService.deleteCivicUserData(username);
        return new ResponseEntity<>(new SuccessResponse(message), HttpStatus.OK);
    }
}
