/*
 * Copyright 2016 Su Baochen and individual contributors by the 
 * @authors tag. See the copyright.txt in the distribution for
 * a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.edu.sdut.softlab.service;

import cn.edu.sdut.softlab.model.Category;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Named;

@Stateless
@Named("category")
public class CategoryFacade extends AbstractFacade<Category> {

	public CategoryFacade() {
		super(Category.class);
	}
	
	public int categoryCount() {
		return count();
	}
	
	public Category findCategoryByNameAndId(int id,String name) {
		Map<String,Object> parameters = new HashMap<>(0);
	    parameters.put("id", id);
	    parameters.put("name", name);
	    return findSingleByNamedQuery("Stuff.findByUsernameAndPassword", parameters, Category.class).get();
	}
	
	public List<Category> findAllCategory(){
		return findAll(Category.class);
	}
	
        public Category findCategoryByName(String name) {
        Category category = new Category();
        category = null;
        List<Category> categories = this.findAllCategory();
        Iterator it = categories.iterator();
        while (it.hasNext()) {
            Category c = (Category) it;
            if (c.getName().equals(name)) {
                category = c;
            }
        }
        return category;
    }
	
}
