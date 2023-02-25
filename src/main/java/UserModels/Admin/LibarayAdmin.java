package UserModels.Admin;

import UserModels.UserClass;
import UserModels.UserController;
import UserModels.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/api/library")
public class LibarayAdmin {
    public  final UserService userService;

    public LibarayAdmin(UserService userService) {
        this.userService = userService;
    }
    record NewUser(
            String username,
            String password
    ){}
    @GetMapping("/get")
    public List<UserClass> getAllUserDetails(){
        return userService.getAllUserDetails();
    }
    @PostMapping()
    public void adminPostNewUser(@RequestBody NewUser request){
        UserClass userClass = new UserClass();
        userClass.setUsername(request.username());
        userClass.setPassword(request.password());
        userService.adminPostNewUser(userClass);
    }
    @DeleteMapping("{userId}")
    public void adminDeleteUser(@PathVariable("userId") Integer Id){
        userService.adminDeleteUser(Id);
    }
    @PutMapping("{userId}")
    public void adminUpdateUser(@PathVariable ("userId") Integer Id, @RequestBody UserController.NewUser request){
        userService.adminUpdateUser(Id,request);
    }

}
