package com.fragnostic.mr.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MrServiceYepTest extends AbstractTest {

    @Test
    void canSayYep() {
        assertEquals(mr, mrServiceApi.speak());
    }

}
