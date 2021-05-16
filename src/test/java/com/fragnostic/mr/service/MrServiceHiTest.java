package com.fragnostic.mr.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MrServiceHiTest extends AbstractTest {

    @Test
    void canSayHi() {
        assertEquals("hi", mrServiceApi.hi());
    }

}
