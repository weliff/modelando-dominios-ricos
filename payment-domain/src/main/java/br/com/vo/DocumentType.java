package br.com.vo;

import br.com.vo.contract.group.CNPJGroup;
import br.com.vo.contract.group.CPFGroup;
import lombok.Getter;

@Getter
public enum DocumentType {

    CPF(CPFGroup.class), CNPJ(CNPJGroup.class);

    private Class<?> group;

    DocumentType(Class<?> group) {
        this.group = group;
    }
}
