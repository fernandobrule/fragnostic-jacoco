package com.fragnostic.mr.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MsServiceHuTest extends AbstractTest {

    @Test
    void canSayHu() {
        assertEquals("hu", msServiceApi.hu());
    }
}
