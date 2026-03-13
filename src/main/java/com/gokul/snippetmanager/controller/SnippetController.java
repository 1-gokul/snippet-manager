package com.gokul.snippetmanager.controller;

import com.gokul.snippetmanager.model.Snippet;
import com.gokul.snippetmanager.service.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/snippets")
@CrossOrigin(origins = "*")
public class SnippetController {

    @Autowired
    private SnippetService service;

    // GET all snippets
    @GetMapping
    public List<Snippet> getAll() {
        return service.getAll();
    }

    // GET by ID
    @GetMapping("/{id}")
    public Snippet getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // POST create
    @PostMapping
    public Snippet create(@RequestBody Snippet s) {
        return service.save(s);
    }

    // PUT update
    @PutMapping("/{id}")
    public Snippet update(@PathVariable Long id, @RequestBody Snippet s) {
        s.setId(id);
        return service.save(s);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // GET search by keyword
    @GetMapping("/search")
    public List<Snippet> search(@RequestParam String kw) {
        return service.searchByKeyword(kw);
    }

    // GET filter by tag
    @GetMapping("/filter/tag")
    public List<Snippet> byTag(@RequestParam String tag) {
        return service.filterByTag(tag);
    }

    // GET filter by language
    @GetMapping("/filter/lang")
    public List<Snippet> byLang(@RequestParam String lang) {
        return service.filterByLang(lang);
    }

    // GET pinned snippets
    @GetMapping("/pinned")
    public List<Snippet> pinned() {
        return service.getPinned();
    }

    // POST bulk import - batch processing
    @PostMapping("/bulk")
    public List<Snippet> bulkImport(@RequestBody List<Snippet> list) {
        return service.bulkImport(list);
    }
}
