package com.unfbx.chatgpt.function;

import java.util.function.Function;



@FunctionalInterface
public interface KeyStrategyFunction<T, R> {

    

    R apply(T t);

}
