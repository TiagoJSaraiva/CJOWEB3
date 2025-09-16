package br.edu.ifspcjo.ads.web3.ExercicioFixacao3.controller;

import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.dto.CategoryDTO;
import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;
    public CategoryController(CategoryService categoriaService) {
        this.categoryService = categoriaService;
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<?> updateCategoria(
            @PathVariable Long codigo,
            @Valid @RequestBody CategoryDTO categoriaDTO) {

        return ResponseEntity.ok(categoryService.updateCategoria(codigo, categoriaDTO));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Long codigo) {
    	categoryService.deleteCategoria(codigo);
        return ResponseEntity.noContent().build();
    }
}
