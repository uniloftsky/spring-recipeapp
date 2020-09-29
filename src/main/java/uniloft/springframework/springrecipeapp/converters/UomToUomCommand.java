package uniloft.springframework.springrecipeapp.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import uniloft.springframework.springrecipeapp.commands.UomCommand;
import uniloft.springframework.springrecipeapp.model.UnitOfMeasure;

@Component
public class UomToUomCommand implements Converter<UnitOfMeasure, UomCommand> {

    @Synchronized
    @Nullable
    @Override
    public UomCommand convert(UnitOfMeasure unitOfMeasure) {

        if (unitOfMeasure != null) {
            final UomCommand uomc = new UomCommand();
            uomc.setId(unitOfMeasure.getId());
            uomc.setUom(unitOfMeasure.getUom());
            return uomc;
        }
        return null;
    }


}
