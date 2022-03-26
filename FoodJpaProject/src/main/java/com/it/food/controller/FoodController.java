package com.it.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.it.food.dao.*;
import com.it.food.entity.*;
@Controller
public class FoodController {
	@Autowired
    private CategoryDAO cdao;
	@Autowired
    private FoodDAO fdao;
	
	@GetMapping("/main")
	public String food_main(Model model)
	{
		List<CategoryEntity> list=cdao.findAll();
		model.addAttribute("list", list);
		return "food/category";
	}
	@GetMapping("/food_list")
	public String food_list(int cno,Model model)
	{
		// a.jpg^b.jpg...
		List<FoodEntity> list=fdao.findByCno(cno);
		for(FoodEntity f:list)
		{
			String poster=f.getPoster();
			poster=poster.substring(0,poster.indexOf("^"));
			f.setPoster(poster);
		}
		model.addAttribute("list", list);
		return "food/food_list";
	}
	
	@GetMapping("/food_detail")
	public String food_detail(int no, Model model)
	{
		FoodEntity vo=fdao.findByNo(no);
		model.addAttribute("vo", vo);
		return "food/food_detail";
	}
	
}
