package com.entry.entrydsm.info.controller;

import com.entry.entrydsm.common.response.ResponseModel;
import com.entry.entrydsm.common.security.jwt.JwtAuthRequired;
import com.entry.entrydsm.common.security.jwt.JwtAuthenticated;
import com.entry.entrydsm.info.domain.Info;
import com.entry.entrydsm.info.service.InfoService;
import com.entry.entrydsm.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/me/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping
    @JwtAuthRequired
    public ResponseModel<Info> getMyInfo(@JwtAuthenticated User user) {
        return ResponseModel.ofSuccess(infoService.getMyInfo(user), null);
    }
}
