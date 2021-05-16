package com.fragnostic.mr.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MsServiceYapTest extends AbstractTest {

    @Test
    void canSayYap() {
        assertEquals("yap", msServiceApi.yap());
    }
}
