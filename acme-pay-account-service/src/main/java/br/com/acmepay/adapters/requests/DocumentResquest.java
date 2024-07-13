package br.com.acmepay.adapters.requests;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class DocumentResquest implements Serializable {

    private String documentNumber;
}
