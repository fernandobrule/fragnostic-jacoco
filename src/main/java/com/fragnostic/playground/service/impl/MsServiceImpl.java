package com.fragnostic.playground.service.impl;

import com.fragnostic.playground.glue.SomeAccesors;
import com.fragnostic.playground.service.api.MsServiceApi;

public class MsServiceImpl implements MsServiceApi {

    @Override
    public String yo() {
        return "yo";
    }

    @Override
    public String tu() {
        return "tu";
    }

    @Override
    public String el() {
        return "el";
    }

    @Override
    public String nosotros() {
        return "nosotros";
    }

    @Override
    public String vosotros() {
        return "vosotros";
    }

    @Override
    public String ellos() {
        SomeAccesors someAccesors = new SomeAccesors();
        someAccesors.setFieldOne("one");
        someAccesors.setFieldTwo("two");
        return someAccesors.toString();
    }

}
