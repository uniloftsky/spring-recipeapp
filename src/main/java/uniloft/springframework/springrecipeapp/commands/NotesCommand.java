package uniloft.springframework.springrecipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uniloft.springframework.springrecipeapp.model.Recipe;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

    private Long id;
    private Recipe recipe;
    private String recipeNotes;

}
