package com.example.project.mapper;

public interface EntityModelMapper<E, M> {

    M entityToModel(E entity);

    E modelToEntity(M model);
}
