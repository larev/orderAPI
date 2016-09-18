package ru.larev.orderapi.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.larev.orderapi.entity.User;
import ru.larev.orderapi.exception.UserNotFoundException;
import ru.larev.orderapi.service.UserService;

/**
 * @author Larev Pavel
 * @author http://telegram.me/larev
 */
@Component
public class CustomAuthProvider implements AuthenticationProvider {
    private final UserService userService;
    private final PasswordEncoder encoder;

    @Autowired
    public CustomAuthProvider(PasswordEncoder encoder, UserService userService) {
        this.encoder = encoder;
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        try {
            User user = userService.getUser(name);
            if (encoder.matches(password, user.getPasshash())) {
                return new UsernamePasswordAuthenticationToken(user, password, AuthorityUtils.NO_AUTHORITIES);
            }
            throw new BadCredentialsException("Wrong password");
        } catch (UserNotFoundException e) {
            throw new BadCredentialsException("The account " + e.getName() + " not found");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}