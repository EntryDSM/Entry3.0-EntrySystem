package com.entry.entrydsm.user;

import com.entry.entrydsm.tempuser.TempUserRepository;
import com.entry.entrydsm.mail.EmailServiceImpl;
import com.entry.entrydsm.security.ApiProvider;
import com.entry.entrydsm.security.ApiUser;
import com.entry.entrydsm.Domain.DTO.TempUserDTO;
import com.entry.entrydsm.security.Crypto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private ApiProvider apiProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private TempUserRepository tempUserRepository;

    @Autowired
    private Crypto crypto;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> createToken(@RequestBody TempUserDTO requestToken) {

        Authentication authentication = new ApiUser(requestToken.getPrincipal(), requestToken.getCredentials(), null);
        authentication = apiProvider.authenticate(authentication);
        return new ResponseEntity<>(authentication, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    private void signup(@RequestBody TempUserDTO tempUserDTO, HttpServletResponse response) {
        if (userRepository.existsUserByEmail(String.valueOf(tempUserDTO.getPrincipal())) || tempUserRepository.existsTempUserByEmail(String.valueOf(tempUserDTO.getPrincipal()))) {
            response.setStatus(403);
            return;
        }
        tempUserDTO.setCredentials(crypto.encode(tempUserDTO.getCredentials()));
        tempUserDTO.setCode(UUID.randomUUID().toString().substring(0, 6));
        emailService.sendMessage(tempUserDTO.getPrincipal(), "EntryDSM 인증 메일", "인증 코드 : " + tempUserDTO.getCode());
        tempUserRepository.save(tempUserDTO.toEntity());
    }
}
