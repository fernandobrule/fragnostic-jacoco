package com.fragnostic.mr.service;

import com.fragnostic.mr.service.api.MrServiceApi;
import com.fragnostic.mr.service.impl.MrServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MrServiceTest {

    MrServiceApi mrServiceApi = new MrServiceImpl();

    @Test
    public void canSayYep() {
        assertEquals(mrServiceApi.yep(), "yep");
    }
}
