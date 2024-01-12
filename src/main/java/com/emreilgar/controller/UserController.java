package com.emreilgar.controller;

import com.emreilgar.dto.UpdateResponseDto;
import com.emreilgar.dto.UserProfileDto;
import com.emreilgar.model.User;
import com.emreilgar.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usercontroller")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> userProfileList(@RequestBody @Validated UserProfileDto dto){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/createUser")
    public ResponseEntity<Boolean> userSave(@RequestBody @Validated UserProfileDto dto){
        return ResponseEntity.ok(service.createUser(dto));
    }

//    @PutMapping("/update")
//    public ResponseEntity<UpdateResponseDto> update(@RequestBody @Valid UpdateRequestDto dto){
//        return ResponseEntity.ok(service.updateProfile(dto));
//    }

}
