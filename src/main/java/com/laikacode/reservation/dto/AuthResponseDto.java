package com.laikacode.reservation.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String jwt;

    public AuthResponseDto() {
    }

    public AuthResponseDto(String jwt) {
        this.jwt = jwt;
    }
}
