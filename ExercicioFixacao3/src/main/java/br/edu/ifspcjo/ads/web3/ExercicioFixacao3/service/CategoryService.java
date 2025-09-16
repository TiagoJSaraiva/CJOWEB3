package br.edu.ifspcjo.ads.web3.ExercicioFixacao3.service;

import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.dto.CategoryDTO;
import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.entity.Category;
import br.edu.ifspcjo.ads.web3.ExercicioFixacao3.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoriaRepository) {
        this.categoryRepository = categoriaRepository;
    }

    @Transactional
    public Category updateCategoria(Long codigo, CategoryDTO dto) {
    	Category categoria = categoryRepository.findById(codigo)
            .orElseThrow(() -> new IllegalArgumentException("Categoria com código " + codigo + " não existe"));

        categoria.setNome(dto.getNome());
        return categoryRepository.save(categoria);
    }

    @Transactional
    public void deleteCategoria(Long codigo) {
        if (!categoryRepository.existsById(codigo)) {
            throw new IllegalArgumentException("Categoria com código " + codigo + " não existe");
        }
        categoryRepository.deleteById(codigo);
    }
}
