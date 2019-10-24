package com.mavenmasters.digibooky.domain.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    void whenGivenCorrectInput_thenNewMemberIsCreated() {
        Assertions.assertDoesNotThrow(() -> new Member("123", new Email("test@test.test"), "Lastname", "City"));
    }

    @Test
    void whenGivenWrongEmail_thenErrorIsThrown() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Member("123", new Email("testtest.test"), "Lastname", "City"));
    }


}