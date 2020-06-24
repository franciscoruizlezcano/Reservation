package com.laikacode.reservation.resource;

import com.laikacode.reservation.config.MyUserDetailsService;
import com.laikacode.reservation.dto.AuthRequestDto;
import com.laikacode.reservation.dto.AuthResponseDto;
import com.laikacode.reservation.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Represent services web for authentication of system
 * @author Francisco
 * */

@RestController
@Api(tags = "auth")
@RequestMapping("/auth")
public class AuthResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @PostMapping
    @ApiOperation(value = "Authentication user", notes = "Authentication user of the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<AuthResponseDto> auth(@RequestBody AuthRequestDto authRequestDto) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDto.getUsername(), authRequestDto.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authRequestDto.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return new ResponseEntity<AuthResponseDto>(new AuthResponseDto(jwt), HttpStatus.CREATED);
    }

}
