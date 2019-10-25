package com.mavenmasters.digibooky.domain.users.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemberTest {
    @Test
    void whenGivenCorrectInput_thenNewMemberIsCreated() {
        Assertions.assertDoesNotThrow(() -> new Member("123", new Email("test@test.test"), "First", "Lastname", "City"));
    }

    @Test
    void whenGivenWrongEmail_thenErrorIsThrown() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> new Member("123", new Email("testtest.test"), "First", "Lastname", "City"));
    }


}