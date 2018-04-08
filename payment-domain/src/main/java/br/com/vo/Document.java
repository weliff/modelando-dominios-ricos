package br.com.vo;

import br.com.vo.contract.DocumentSequenceGroupProvider;
import br.com.vo.contract.group.CNPJGroup;
import br.com.vo.contract.group.CPFGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.constraints.NotNull;
import javax.xml.validation.Validator;

@GroupSequenceProvider(DocumentSequenceGroupProvider.class)
@AllArgsConstructor
@Getter
public class Document extends ValueObject {

    @CPF(groups = CPFGroup.class)
    @CNPJ(groups = CNPJGroup.class)
    private String number;

    @NotNull
    private DocumentType type ;

}
