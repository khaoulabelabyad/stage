package com.project.project.dao;

import com.project.project.entities.CartEntry;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CartEntryRepository extends CrudRepository<CartEntry, Integer> {
    @Transactional
    @Modifying // indicates the query is not a SELECT
    // :quantity because quantity is CartEntry variable
    @Query("UPDATE CartEntry SET quantity = :quantity WHERE id = :id")
    void updateQuantity(@Param("quantity") int quantity, @Param("id") int cartEntryId);
}
