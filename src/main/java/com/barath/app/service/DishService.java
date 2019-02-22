package com.barath.app.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.barath.app.model.DishItem;

@Service
public class DishService {
	
	private Map<Long,List<DishItem>>  dishes= new java.util.HashMap<>();	
	
	
	public List<DishItem> getDishesByRestaurant(Long resId){
		
		return this.dishes.get(resId);
	}
	
	public Map<String, List<DishItem>> orderByDishes(Long resId){
		
		List<DishItem> dishes = this.getDishesByRestaurant(resId);
		return dishes.stream()
			.collect(Collectors.groupingBy(DishItem::getDishType));
	}
	
	@PostConstruct
	public void init() {
		
		List<DishItem> dishes1 = 
				Arrays.asList(new DishItem(1L,"DISH1","VEG",100),
						new DishItem(1L,"DISH2","VEG",200),
						new DishItem(1L,"DISH3","NONVEG",100),
						new DishItem(1L,"DISH4","NONVEG",100),
						new DishItem(1L,"DISH5","NONVEG",1000)
						);
		
		List<DishItem> dishes2 = 
				Arrays.asList(new DishItem(2L,"DISH6","VEG",80),
						new DishItem(2L,"DISH7","VEG",100),
						new DishItem(2L,"DISH8","NONVEG",60),
						new DishItem(2L,"DISH9","VEG",100),
						new DishItem(2L,"DISH10","VEG",100)
						);
		
		dishes.put(1L, dishes1);
		dishes.put(2L, dishes2);
	}
	

}
