package kodlama.io.devs.business.concretes;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageRepository programmingLanguageRepository;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguageRepository.getAll();
    }

    @Override
    public ProgrammingLanguage getById(int id) throws Exception {
        if (!isIdExist(id)) throw new Exception("There is no programming language with this Id");
        return programmingLanguageRepository.getById(id);
    }

    @Override
    public void add(ProgrammingLanguage programmingLanguage) throws Exception {

        if (isNameExist(programmingLanguage)) throw new Exception("Programming language already exists.");
        if (isIdExist(programmingLanguage.getId())) throw new Exception("Programming language already exists.");
        if (programmingLanguage.getName().isEmpty()) throw new Exception("Programming language name cannot be empty.");
        programmingLanguageRepository.add(programmingLanguage);
    }

    @Override
    public void delete(int id) throws Exception {
        if (!isIdExist(id)) throw new Exception("There is no programming language with this Id");
        programmingLanguageRepository.delete(id);
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) throws Exception {
        if (!isIdExist(programmingLanguage.getId())) throw new Exception("There is no programming language with this Id");
        if (isNameExist(programmingLanguage)) throw new Exception("Programming language already exists.");
        if (programmingLanguage.getName().isEmpty()) throw new Exception("Programming language name cannot be empty.");
        programmingLanguageRepository.update(programmingLanguage);
    }

    public boolean isNameExist(ProgrammingLanguage programmingLanguage){
        for (ProgrammingLanguage language : getAll()){
            if (language.getName().equals(programmingLanguage.getName())){
                return true;
            }
        }
        return false;
    }

    public boolean isIdExist(int id){
        for (ProgrammingLanguage language : getAll()){
            if (language.getId() == id){
                return true;
            }
        }
        return false;
    }
}
