package org.thwick.moneytracker.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;
import org.thwick.moneytracker.models.Category;
import org.thwick.moneytracker.services.CategoryService;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class CategoriesResource {

	@Inject private CategoryService categoryService;
	
	public CategoriesResource() {

	}

	@POST
	public Category createCategory(Category category) {
		return categoryService.newCategory(category);
	}

	@GET
	public Category[] listCategory() {
		List<Category> categories = categoryService.findAll();
		
		return categories.toArray(new Category[0]);
	}
	
	@DELETE @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void delete(@PathParam("id") Long id) {
		categoryService.delete(id);
    }
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

}
