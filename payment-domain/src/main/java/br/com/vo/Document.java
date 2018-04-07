package br.com.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Document extends ValueObject {

    private String number;

    private DocumentType type ;
}
