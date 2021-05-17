package com.fragnostic.mr.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MrServiceEuTest extends AbstractTest {

    @Test
    void canSayEu() {
        assertEquals("eu", mrServiceApi.eu());
    }

}
