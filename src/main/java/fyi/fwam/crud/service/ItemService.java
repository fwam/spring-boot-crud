package fyi.fwam.crud.service;

import java.util.List;
import fyi.fwam.crud.model.Item;
import fyi.fwam.crud.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(long id) {
        return itemRepository.findById(id)
                .orElseThrow();
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item existingItem = itemRepository.findById(id).orElseThrow();
        existingItem.setName(item.getName());
        existingItem.setDescription(item.getDescription());
        existingItem.setCompleted(item.isCompleted());
        return itemRepository.save(existingItem);
    }

    public void deleteItem(long id) {
        itemRepository.deleteById(id);
    }
}
