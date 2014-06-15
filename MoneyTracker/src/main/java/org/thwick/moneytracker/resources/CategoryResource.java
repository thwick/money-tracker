package org.thwick.moneytracker.resources;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.thwick.moneytracker.dao.CategoryDAO;
import org.thwick.moneytracker.models.Category;

import com.sun.jersey.api.NotFoundException;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryResource {

    private final CategoryDAO categoryDAO;
    
    @Inject
    public CategoryResource(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }
    
    @GET
    public Category getCategory(@PathParam("categoryId") Long categoryId) {
        final Category category = categoryDAO.find(categoryId);
        if (category == null) {
            throw new NotFoundException("No such category.");
        }
        return category;
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Category createCategory(Category category) {
    	return categoryDAO.create(category);
    }
}