package com.example.veckansmeny.service;

import com.example.veckansmeny.dao.DishDao;
import com.example.veckansmeny.dao.IngredientDao;
import com.example.veckansmeny.model.Dish;
import com.example.veckansmeny.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    @Autowired
    DishDao dishDao;

    @Autowired
    IngredientDao ingredientDao;


    public void saveDish(Dish dish) {
        dishDao.save(dish);
    }

    public List<Dish> findAllDishes() {
        return dishDao.findAll();
    }

    public void deleteDish(Integer dishId) {
        Dish dish = dishDao.findById(dishId).get();
        dishDao.delete(dish);
    }

    public void removeIngredientFromDishes(List<Dish> dishes, Ingredient ingredient) {
        for (Dish dish : dishes) {
            dish.getIngredients().remove(ingredient);
            saveDish(dish);
        }
    }

    public void saveIngredient(Ingredient ingredient) {
        ingredientDao.save(ingredient);
    }
}
