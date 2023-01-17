package com.Levenshtein.Levenshtein.dto;

import java.util.List;

public record NormalizerNamesDTO(List<String> idealNames,List<String> toNormalize) { }
