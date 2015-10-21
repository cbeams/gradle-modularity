package com.example.bar;

import com.example.bar.internal.BarUtils;
import com.google.common.collect.ImmutableList;

public class Bar {
   public ImmutableList<String> getItems() {
        String[] items = itemsInternal();
	return ImmutableList.of(items[0], items[1], items[2]);
   }

   private String[] itemsInternal() {
	return new String[] { "item1", "item2", "item3" };
   }
}
