package com.example.foo;

import com.example.bar.Bar;
import com.google.common.collect.ImmutableList;

public class Foo {
    private final Bar bar;
    private final ImmutableList<String> items;

    public Foo(Bar bar) {
        this.bar = bar;
        this.items = bar.getItems();
    }
}
