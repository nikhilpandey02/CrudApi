package dev.nikhil.serviceproduct.repositories;

import dev.nikhil.serviceproduct.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository
        extends JpaRepository<Price, Long> {
}
