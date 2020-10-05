package uniloft.springframework.springrecipeapp.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uniloft.springframework.springrecipeapp.model.Recipe;
import uniloft.springframework.springrecipeapp.repositories.RecipeRepository;

import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long recipeId, MultipartFile file) {

        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte [] byteObject = new Byte[file.getBytes().length];
             int i = 0;
             for(byte b : file.getBytes()) {
                 byteObject[i++] = b;
             }

             recipe.setImage(byteObject);
             recipeRepository.save(recipe);
        } catch (IOException e) {
            System.out.println("An error occurred!" + e);
            e.printStackTrace();
        }
    }
}
