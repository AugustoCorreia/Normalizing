package com.Levenshtein.Levenshtein.service;

import com.Levenshtein.Levenshtein.dto.NormalizeListDTO;
import com.Levenshtein.Levenshtein.normalizer.Normalizer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NormalizerService {

    private final Normalizer normalizer = new Normalizer();

    public ResponseEntity<String> doNormalize(String toNormalize) {
        return ResponseEntity.ok(normalizer.normalize(toNormalize));
    }

    public ResponseEntity<List<String>> doNormalizeList(NormalizeListDTO toNormalize) {
        return ResponseEntity.ok(toNormalize.getToNormalize().stream().map(item->
                String.format("Input: %s, Best match: %s",item,normalizer.normalize(item))
        ).toList());
    }
}
