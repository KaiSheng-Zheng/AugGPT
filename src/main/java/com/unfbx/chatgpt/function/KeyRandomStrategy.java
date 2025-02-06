package com.unfbx.chatgpt.function;

import cn.hutool.core.util.RandomUtil;

import java.util.List;



public class KeyRandomStrategy implements KeyStrategyFunction<List<String>, String> {

    @Override
    public String apply(List<String> apiKeys) {
        return RandomUtil.randomEle(apiKeys);
    }
}
