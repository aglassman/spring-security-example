package com.aglassman.springsecurityexample.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aglassman.springsecurityexample.inventory.InventoryRestRepository;
import com.aglassman.springsecurityexample.inventory.Item;
import com.aglassman.springsecurityexample.inventory.Stock;
import com.aglassman.springsecurityexample.inventory.StockRestRepository;
import com.aglassman.springsecurityexample.security.CustomUser;

@Controller
public class InventoryReportController {

	@Autowired
	InventoryRestRepository inventoryRestRepository;

	@Autowired
	StockRestRepository stockRestRepository;

	@Transactional()
	@RequestMapping("/inventory/report")
	@PreAuthorize("hasAuthority('EMPLOYEE') and #customUser.canAccessReports()")
	public String inventory(
		@AuthenticationPrincipal CustomUser customUser,
		@RequestParam(value="itemId", required=true) Long itemId,
		@PageableDefault(size = 100) final Pageable pageable,
		Model model) {

		Item item = inventoryRestRepository.findOne(itemId);
		Page<Stock> stockPage = stockRestRepository.findByItemId(itemId, pageable);

		model.addAttribute("item", item);
		model.addAttribute("stockPage", stockPage);
		model.addAttribute("name", customUser.username);
		model.addAttribute("canReport", customUser.canReport);

		return "inventory";
	}

}
