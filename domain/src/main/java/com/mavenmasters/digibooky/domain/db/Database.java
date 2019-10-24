package com.mavenmasters.digibooky.domain.db;

import java.util.Map;

public interface Database<T, E> {
    Map<T, E> getAll();
}
