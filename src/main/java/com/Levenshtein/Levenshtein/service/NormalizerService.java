package com.Levenshtein.Levenshtein.service;

import com.Levenshtein.Levenshtein.dto.NormalizeListDTO;
import com.Levenshtein.Levenshtein.dto.NormalizerNamesDTO;
import com.Levenshtein.Levenshtein.normalizer.Normalizer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NormalizerService {

    public NormalizerService(Normalizer normalizer) {
        this.normalizer = normalizer;
    }

    private Normalizer normalizer;

    public ResponseEntity<String> doNormalize(String toNormalize) {
        return ResponseEntity.ok(normalizer.normalize(toNormalize));
    }

    public ResponseEntity<List<String>> doNormalizeList(NormalizeListDTO toNormalize) {
        return ResponseEntity.ok(toNormalize.toNormalize().stream().map(item->
                String.format("Input: %s, \r\n Best match: %s",item,normalizer.normalize(item))
        ).toList());
    }

    public ResponseEntity<List<String>> doNormalizeListFromIdealList(NormalizerNamesDTO request) {
        return ResponseEntity.ok(request.toNormalize().stream().map(item->
                String.format("Input: %s, \r\n Best match: %s",item,normalizer.setNormalizedTitles(request.idealNames()).normalize(item))
        ).toList());
    }
}
