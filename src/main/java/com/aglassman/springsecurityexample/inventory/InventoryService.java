package com.aglassman.springsecurityexample.inventory;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path= "/items", collectionResourceRel = "items", itemResourceRel = "item")
public interface InventoryService extends PagingAndSortingRepository<Item,Long>{

}
