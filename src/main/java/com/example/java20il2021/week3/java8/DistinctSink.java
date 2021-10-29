package com.example.java20il2021.week3.java8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DistinctSink<T> implements ISink<T>  {
    private final ISink<T> downstream;
    private List<T> list;

    public DistinctSink(ISink<T> downstream) {
        this.downstream = downstream;
    }
    @Override
    public void begin(long size) {
        list = new ArrayList<>();
    }

    @Override
    public void end() {
        list = new ArrayList<>(new HashSet<>(list));
        downstream.begin(-1);
        list.forEach(t -> downstream.accept(t));
        downstream.end();


    }

    @Override
    public void accept(T t) {
        list.add(t);
    }
}
