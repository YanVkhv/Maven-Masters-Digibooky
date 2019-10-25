package com.mavenmasters.digibooky.domain.db;

import java.util.Map;
import java.util.UUID;

public interface Database<T, E> {

    Map<T, E> getAll();

    E getById(UUID id);

}
