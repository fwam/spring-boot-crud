package fyi.fwam.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fyi.fwam.crud.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> { }
