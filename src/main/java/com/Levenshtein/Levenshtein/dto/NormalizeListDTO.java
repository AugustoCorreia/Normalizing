package com.Levenshtein.Levenshtein.dto;

import java.util.List;


public class NormalizeListDTO {
    private List<String> toNormalize;

    public List<String> getToNormalize() {
        return toNormalize;
    }

    public void setToNormalize(List<String> toNormalize) {
        this.toNormalize = toNormalize;
    }

    public NormalizeListDTO() {
    }

    public NormalizeListDTO(List<String> toNormalize) {
        this.toNormalize = toNormalize;
    }
}
