package com.michael.MyVocabulary.service;

import com.michael.MyVocabulary.entity.VocabularyWord;
import com.michael.MyVocabulary.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public List<VocabularyWord> findAllWords() {
        SimpleDateFormat sdf =
                new SimpleDateFormat("d MMMM HH:mm", new Locale("uk","ua"));
        List<VocabularyWord> words = wordRepository.findAll();
        if (words.isEmpty()){
            VocabularyWord vocabularyWord = VocabularyWord.builder().word("hello").comments("test").addingDate(new Date()).translation("test").special(false).status("PHRASAL_VERB").build();
            ArrayList<VocabularyWord> list = new ArrayList<VocabularyWord>();
            list.add(vocabularyWord);
            return list;
        }
        for (VocabularyWord word: words) {
            if (word.getAddingDate() != null) word.setFormattedDate(sdf.format(word.getAddingDate()));
        }

        return words;
    }

    public List<VocabularyWord> findAllWordsWithSorting(int sortingWay, String property){
        if (sortingWay == VocabularyWord.DESCENDING_SORTING) return wordRepository
                .findAll(Sort.by(Sort.Direction.DESC, property));
        else return wordRepository
                .findAll(Sort.by(Sort.Direction.ASC, property));

    }

    public VocabularyWord saveVocabularyWord(VocabularyWord vocabularyWord) {
        vocabularyWord.setAddingDate(new Date());
       return wordRepository.save(vocabularyWord);
    }


    public void updateWord(VocabularyWord newWord) {
        Date date = wordRepository.findById(newWord.getId()).get().getAddingDate();
        newWord.setAddingDate(date);
        wordRepository.save(newWord);

    }

    public void deleteWord(long id) {
        wordRepository.deleteVocabularyWordById(id);
    }
}
