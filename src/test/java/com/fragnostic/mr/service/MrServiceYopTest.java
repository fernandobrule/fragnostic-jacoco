package com.fragnostic.mr.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MrServiceYopTest extends AbstractTest {

    @Test
    void canSayYop() {
        assertEquals("yop", mrServiceApi.yop());
    }

}
