package uniloft.springframework.springrecipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import uniloft.springframework.springrecipeapp.model.Category;
import uniloft.springframework.springrecipeapp.model.UnitOfMeasure;
import uniloft.springframework.springrecipeapp.repositories.CategoryRepository;
import uniloft.springframework.springrecipeapp.repositories.UofRepository;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UofRepository uofRepository;

    public IndexController(CategoryRepository categoryRepository, UofRepository uofRepository) {
        this.categoryRepository = categoryRepository;
        this.uofRepository = uofRepository;
    }

    @RequestMapping({"/", "", "index", "index.html", "privet"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = uofRepository.findByUof("Teaspoon");
        System.out.println("Category id is: " + categoryOptional.get().getId());
        System.out.println("Uof id is: " + unitOfMeasureOptional.get().getId());
        return "index";
    }

}
