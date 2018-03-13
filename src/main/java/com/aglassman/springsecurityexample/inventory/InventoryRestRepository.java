package com.aglassman.springsecurityexample.inventory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

@RepositoryRestResource(path= "/items", collectionResourceRel = "items", itemResourceRel = "item")
public interface InventoryRestRepository extends PagingAndSortingRepository<Item,Long>{

	@RestResource(path = "byItemName", rel = "byItemName")
	Page<Item> findByItemNameIgnoreCaseContaining(
		@Param("itemName") String itemName,
		Pageable p);

	@RestResource(path = "byDescription", rel = "byDescription")
	Page<Item> findByDescriptionIgnoreCaseContaining(
		@Param("description") String description,
		Pageable p);

	@RestResource(path = "bySku", rel = "bySku")
	Page<Item> findBySku(
		@Param("sku") String sku,
		Pageable p);

	@RestResource(path = "byUpc", rel = "byUpc")
	@PreAuthorize("hasAuthority('EMPLOYEE')")
	Page<Item> findByUpc(
		@Param("upc") String upc,
		Pageable p);

	@PostAuthorize("returnObject.isPreferredOnly() ?  (hasAuthority('EMPLOYEE') or hasAuthority('PREFERRED_VENDOR')) : isAuthenticated()")
	Item findOne(Long aLong);

	public List<Item> getItems();

}
