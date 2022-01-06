package io.beansprout.spooly.services;

import io.beansprout.spooly.models.Manufacturer;

public interface ManuService {
    Manufacturer findByName(String name);
}
