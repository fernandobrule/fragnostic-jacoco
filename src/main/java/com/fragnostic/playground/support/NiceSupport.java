package com.fragnostic.playground.support;

public interface NiceSupport {

    default String format(final String text) {
        return String.format("\u0027%s\u0027", text);
    }

}
