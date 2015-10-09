package com.example.foo;

import com.example.bar.Bar;
import com.example.bar.internal.BarUtils;

public class Foo {
    private final Bar bar;

    public Foo(Bar bar) {
        this.bar = bar;
    }
}
