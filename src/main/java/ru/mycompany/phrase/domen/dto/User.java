package ru.mycompany.phrase.domen.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String nickname;
    private String encryptPassword;
    private String accessToken;
}
