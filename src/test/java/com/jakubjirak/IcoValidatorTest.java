package com.jakubjirak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IcoValidatorTest {
    private IcoValidator icoValidator;
    private IcoGenerator icoGenerator;

    @BeforeEach
    public void setUp() {
        icoValidator = new IcoValidator();
        icoGenerator = new IcoGenerator();
    }

    @ParameterizedTest
    @DisplayName("Just check validity of given IČOs")
    @ValueSource(strings = {"27082440","2708244","270824401","27082444",""}) // five icos
    void checkArrayOfIco(String ico) {
        assertTrue(icoValidator.check(ico));
    }

    @ParameterizedTest
    @DisplayName("Just check validity of null as input")
    @NullSource
    void checkNullInput(String ico) {
        assertTrue(icoValidator.check(ico));
    }

    @Test
    @DisplayName("Check ICO generator that it returns always valid IČO")
    @RepeatedTest(5000)
    void checkIcoGenerator() {
        assertTrue(icoValidator.check(icoGenerator.generate()));
    }
}
