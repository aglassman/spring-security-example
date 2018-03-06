package com.aglassman.springsecurityexample.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aglassman.springsecurityexample.inventory.Item;

@Controller
public class InventoryReportController {

	@RequestMapping("/inventory/report")
	public String inventory(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);

		Item item = new Item();

		return "inventory";
	}

}
