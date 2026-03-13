package com.gokul.snippetmanager.service;

import com.gokul.snippetmanager.model.Snippet;
import com.gokul.snippetmanager.repository.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class SnippetService {

    @Autowired
    private SnippetRepository repo;

    public List<Snippet> getAll() {
        return repo.findAll();
    }

    public Snippet getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Snippet not found with id: " + id));
    }

    public Snippet save(Snippet s) {
        return repo.save(s);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public List<Snippet> searchByKeyword(String keyword) {
        return repo.findByTitleContainingIgnoreCase(keyword);
    }

    public List<Snippet> filterByTag(String tag) {
        return repo.findByTagsContaining(tag);
    }

    public List<Snippet> filterByLang(String lang) {
        return repo.findByLanguage(lang);
    }

    public List<Snippet> getPinned() {
        return repo.findByPinnedTrue();
    }

    // Batch processing - covers resume claim
    public List<Snippet> bulkImport(List<Snippet> snippets) {
        return repo.saveAll(snippets);
    }
}
