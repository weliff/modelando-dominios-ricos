package br.com.vo.contract;

import br.com.vo.Document;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import javax.validation.groups.Default;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DocumentSequenceGroupProvider implements DefaultGroupSequenceProvider<Document> {

    @Override
    public List<Class<?>> getValidationGroups(Document document) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(Document.class);

        if (Objects.nonNull(document) && Objects.nonNull(document.getType())) {
            groups.add(document.getType().getGroup());
        }
        return groups;
    }
}
