package demo.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.server.model.User;
import demo.server.payload.JsonResponse;
import demo.server.repository.UserRepository;
import demo.server.security.UserCredentials;

@Service
public class UserService implements UserDetailsService
{
    @Autowired UserRepository userRepository;
    @Autowired ValidationService validationService;
    @Autowired PasswordEncoder passwordEncoder;

/* --------------------------------------------------------------------------------------------- */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        }

        return new UserCredentials(user);
    }

/* --------------------------------------------------------------------------------------------- */

    public JsonResponse getUser(long id)
    {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            return new JsonResponse(user);
        }

        return new JsonResponse(HttpStatus.NOT_FOUND);
    }

/* --------------------------------------------------------------------------------------------- */

    public JsonResponse createUser(User user)
    {
        String error = validationService.validate(user);

        if (error != null) {
            return new JsonResponse(error, HttpStatus.BAD_REQUEST);
        }

        User found = userRepository.findByUsername(user.getUsername());

        if (found != null) {
            return new JsonResponse("{\"unique\":false}", HttpStatus.BAD_REQUEST);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return new JsonResponse(HttpStatus.CREATED);
    }

/* --------------------------------------------------------------------------------------------- */

    @Transactional
    public JsonResponse updateUser(User user)
    {
        if (user.getId() == null) {
            return new JsonResponse(HttpStatus.NOT_FOUND);
        }

        User found = userRepository.findById(user.getId()).orElse(null);

        if (found == null) {
            return new JsonResponse(HttpStatus.NOT_FOUND);
        }

        String error = validationService.validate(user);

        if (error != null) {
            return new JsonResponse(error, HttpStatus.BAD_REQUEST);
        }

        found.setUsername(user.getUsername());
        found.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(found);
        return new JsonResponse();
    }

/* --------------------------------------------------------------------------------------------- */

    public JsonResponse deleteUser(Long id)
    {
        try
        {
            userRepository.deleteById(id);
            return new JsonResponse();
        }
        catch(Exception e) {
            return new JsonResponse(HttpStatus.NOT_FOUND);
        }
    }

/* --------------------------------------------------------------------------------------------- */

}
