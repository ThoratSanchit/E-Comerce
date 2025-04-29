
package E_comerce.example.E_comerce.services;

        import E_comerce.example.E_comerce.model.User;

public interface UserService {
    User registerUser(User user);
    User loginUser(String email, String password);
}
