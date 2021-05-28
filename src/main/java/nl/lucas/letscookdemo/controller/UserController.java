package nl.lucas.letscookdemo.controller;

import nl.lucas.letscookdemo.model.User;
import nl.lucas.letscookdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") long id) {
      User user = userService.getUser(id);

      if (user == null) {
          return ResponseEntity.notFound().build();
      } else {
          return ResponseEntity.ok().body(user);
      }
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok().body("Added");
    }
}
