package kodlama.io.devs.webApi.controllers;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/programming-languages")
public class ProgrammingLanguagesController {

    private ProgrammingLanguageService programmingLanguageService;

    @Autowired
    public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping
    public List<ProgrammingLanguage> getAll(){
        return programmingLanguageService.getAll();
    }

    @GetMapping("/{id}")
    public ProgrammingLanguage getById(@PathVariable(name = "id") int id) throws Exception {
        return programmingLanguageService.getById(id);
    }

    @PostMapping("add")
    public void add(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        programmingLanguageService.add(programmingLanguage);
    }

    @PutMapping()
    public void update(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception {
        programmingLanguageService.update(programmingLanguage);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) throws Exception {
        programmingLanguageService.delete(id);
    }
}
