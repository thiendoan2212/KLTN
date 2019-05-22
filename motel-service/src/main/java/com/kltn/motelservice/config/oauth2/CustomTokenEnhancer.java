package com.kltn.motelservice.config.oauth2;

import com.kltn.motelservice.entity.Role;
import com.kltn.motelservice.entity.User;
import com.kltn.motelservice.mapper.UserMapper;
import com.kltn.motelservice.model.UserDTO;
import com.kltn.motelservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Autowired
    private UserRepository userRepository;

    UserMapper mapper = UserMapper.INSTANCE;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication auth) {
        final Map<String, Object> additionalInfo = new HashMap<>();
        User user = userRepository.findByEmail(auth.getName()).get();
        UserDTO userDTO = mapper.entityToDTO(user);
        userDTO.setB64(null);
        userDTO.setFileType(null);
        userDTO.setRole(user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        additionalInfo.put("account", userDTO);
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
