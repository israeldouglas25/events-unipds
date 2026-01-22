package br.com.israel.events.domain.dto;

import br.com.israel.events.domain.User;

public record UserDetailsResponse(Integer idUser, String name, String email, String password) {
    public UserDetailsResponse(User user) {
        this(user.getIdUser(), user.getName(), user.getEmail(), "*********");
    }

}
