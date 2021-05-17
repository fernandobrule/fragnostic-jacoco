package com.fragnostic.mr.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MsServiceYoTest extends AbstractTest {

    @Test
    void canSayYo() {
        assertEquals("yo", msServiceApi.yo());
    }
}
