package by.itacademy.database.entity;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void builder() {
        User userTest = User.builder()
                .id(1)
                .firstName("A")
                .secondName("B")
                .build();
        assertTrue(userTest instanceof User);
    }
}
