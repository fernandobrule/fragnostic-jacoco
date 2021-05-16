package com.fragnostic.mr.service.impl;

import com.fragnostic.mr.service.api.MrServiceApi;

public class MrServiceImpl implements MrServiceApi {

    @Override
    public String hi() {
        return "hi";
    }

    @Override
    public String ho() {
        return "ho";
    }

}
