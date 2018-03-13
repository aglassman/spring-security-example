package com.aglassman.springsecurityexample.inventory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path= "/stock", collectionResourceRel = "stock", itemResourceRel = "stock")
public interface StockRestRepository extends PagingAndSortingRepository<Stock,Long>{

	@RestResource(path = "byItemId", rel = "byItemId")
	Page<Stock> findByItemId(
		@Param("itemId") Long itemId,
		Pageable p);

	@RestResource(path = "byLocation", rel = "byLocation")
	Page<Stock> findByLocationIgnoreCase(
		@Param("location") String location,
		Pageable p);

	@RestResource(path = "byLocationAndItemId", rel = "byLocationAndItemId")
	Page<Stock> findByLocationIgnoreCaseAndItemId(
		@Param("location") String location,
		@Param("itemId") Long itemId,
		Pageable p);

}
