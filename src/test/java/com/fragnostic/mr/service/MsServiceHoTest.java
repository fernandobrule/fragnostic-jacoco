package com.fragnostic.mr.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MsServiceHoTest extends AbstractTest {

    @Test
    void canSayHo() {
        assertEquals("ho", msServiceApi.ho());
    }
}
