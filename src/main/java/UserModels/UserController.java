package UserModels;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/library")
public class UserController {
    public final UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    public record NewUser(
            String username,
            String password
    ){}
    @GetMapping("/get")
    public List<UserClass> getUserData(){
        return userService.getUserData();
    }
    @PostMapping("/save")
    public void postNewUser(@RequestBody NewUser request){
       UserClass userClass = new UserClass();
       userClass.setUsername(request.username());
       userClass.setPassword(request.password());
       userService.postNewUser(userClass);
    }
    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable ("userId") Integer Id){
    userService.deleteUser(Id);
    }
    @PutMapping("{userId}")
    public void updateUser(@PathVariable ("userId") Integer Id, @RequestBody NewUser request){
    userService.updateUser(Id,request);
    }
}
