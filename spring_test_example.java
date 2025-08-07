// ✅ Case Study: Spring Test - UserService

// 1. User.java (Entity)
public class User {
    private int id;
    private String name;
    private String email;

    // Constructors
    public User() {}
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

// 2. UserRepository.java (Interface)
public interface UserRepository {
    User findById(int id);
    void save(User user);
}

// 3. UserService.java
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int id) {
        return userRepository.findById(id);
    }

    public void registerUser(User user) {
        userRepository.save(user);
    }
}

// 4. UserServiceTest.java (JUnit + Mockito)
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserById() {
        User mockUser = new User(1, "Alice", "alice@example.com");
        when(userRepository.findById(1)).thenReturn(mockUser);

        User result = userService.getUserById(1);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
    }

    @Test
    public void testRegisterUser() {
        User newUser = new User(2, "Bob", "bob@example.com");
        userService.registerUser(newUser);

        verify(userRepository, times(1)).save(newUser);
    }
}
