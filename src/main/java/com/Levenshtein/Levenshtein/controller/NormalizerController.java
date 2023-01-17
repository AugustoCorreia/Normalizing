package com.Levenshtein.Levenshtein.controller;

import com.Levenshtein.Levenshtein.dto.NormalizeListDTO;
import com.Levenshtein.Levenshtein.service.NormalizerService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("normalizer")
@CrossOrigin
public class NormalizerController {

    private final NormalizerService service;

    public NormalizerController(NormalizerService service) {
        this.service = service;
    }

    @GetMapping("{toNormalize}")
    public ResponseEntity<String> doNormalize(@PathVariable @NonNull String toNormalize){
        return service.doNormalize(toNormalize);
    }

    @PostMapping
    public ResponseEntity<List<String>> doNormalizeList(@RequestBody @NonNull NormalizeListDTO toNormalize){
        return service.doNormalizeList(toNormalize);
    }
}
