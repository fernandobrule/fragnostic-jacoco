package com.fragnostic.mr.service.impl;

import com.fragnostic.mr.service.api.MsServiceApi;

public class MsServiceImpl implements MsServiceApi {

    @Override
    public String hi() {
        return "hi";
    }

    @Override
    public String ho() {
        return "ho";
    }

    @Override
    public String hu() {
        return "hu";
    }
}
