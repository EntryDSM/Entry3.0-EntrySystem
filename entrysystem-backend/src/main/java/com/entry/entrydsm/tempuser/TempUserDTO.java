package com.entry.entrydsm.tempuser;

import com.entry.entrydsm.tempuser.TempUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class TempUserDTO {
    public String principal; // 이메일
    public String credentials; // 비밀번호
    public String code;

    public TempUser toEntity(){
        return TempUser.builder()
                .email(this.getPrincipal())
                .password(this.getCredentials())
                .code(this.getCode())
                .build();
    }
}
