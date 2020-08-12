package demo.server.controller.access;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.server.model.User;
import demo.server.payload.JsonResponse;
import demo.server.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired UserService userService;

/* --------------------------------------------------------------------------------------------- */

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id)
    {
        JsonResponse res = userService.getUser(id);
        return new ResponseEntity<Object>(res.getBody(), res.getStatus());
    }

/* --------------------------------------------------------------------------------------------- */

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user)
    {
        JsonResponse res = userService.createUser(user);
        return new ResponseEntity<Object>(res.getBody(), res.getStatus());
    }

/* --------------------------------------------------------------------------------------------- */

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user)
    {
        JsonResponse res = userService.updateUser(user);
        return new ResponseEntity<Object>(res.getBody(), res.getStatus());
    }

/* --------------------------------------------------------------------------------------------- */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id)
    {
        JsonResponse res = userService.deleteUser(id);
        return new ResponseEntity<Object>(res.getBody(), res.getStatus());
    }

/* --------------------------------------------------------------------------------------------- */

}
