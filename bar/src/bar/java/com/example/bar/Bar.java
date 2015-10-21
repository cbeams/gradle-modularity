package com.example.bar;

import com.example.bar.internal.BarUtils;
import com.google.common.collect.ImmutableList;

public class Bar {
   public ImmutableList<String> getItems() {
	return ImmutableList.of("item1", "item2", "item3");
   }
}
