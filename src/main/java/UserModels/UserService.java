package UserModels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class UserService {

    @Autowired
    public final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserClass> getUserData() {
     return    userRepo.findAll();
    }

    public void postNewUser(UserClass userClass) {
        userRepo.save(userClass);
    }

    public void deleteUser(Integer Id) {
        userRepo.deleteById(Long.valueOf(Id));
    }

    public void updateUser(Integer Id, UserController.NewUser request) {
        UserClass userClass= userRepo.getById(Long.valueOf(Id));
        userClass.setUsername(request.username());
        userClass.setPassword(request.password());
        userRepo.save(userClass);
    }

    public List<UserClass> getAllUserDetails() {
        return userRepo.findAll();
    }

    public void adminPostNewUser(UserClass userClass) {
        userRepo.save(userClass);
    }

    public void adminDeleteUser(Integer id) {
        userRepo.deleteById(Long.valueOf(id));
    }

    public void adminUpdateUser(Integer id, UserController.NewUser request) {
        UserClass userClass = userRepo.getById(Long.valueOf(id));
        userClass.setUsername(request.username());
        userClass.setPassword(request.username());
        userRepo.save(userClass);
    }
}
