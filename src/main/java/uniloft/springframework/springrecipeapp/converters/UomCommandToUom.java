package uniloft.springframework.springrecipeapp.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import uniloft.springframework.springrecipeapp.commands.UomCommand;
import uniloft.springframework.springrecipeapp.model.UnitOfMeasure;

@Component
public class UomCommandToUom implements Converter<UomCommand, UnitOfMeasure> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasure convert(UomCommand uomCommand) {
        if (uomCommand == null) {
            return null;
        }

        final UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(uomCommand.getId());
        uom.setUom(uomCommand.getUom());
        return uom;
    }

}
