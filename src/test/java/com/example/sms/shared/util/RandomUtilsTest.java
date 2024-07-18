package com.example.sms.shared.util;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class RandomUtilsTest {

    @Autowired
    RandomUtils randomUtils;

    @Test
    void test_generateRandomId(){
        String id = randomUtils.generateRandomId();

        assertNotNull(id);
        assertEquals(32, id.length(), "Unexpected length of generated id");
    }
}
