package br.com.erudio.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import br.com.erudio.model.Book;
import br.com.erudio.respositories.BookRepository;
import br.com.erudio.restwithspringbootandjavaerudio.unittests.mapper.mocks.MockBook;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class BookServicesTest {
    
    MockBook input;

    @InjectMocks
    private BookServices service;   

    @Mock
    BookRepository repository;    
    
    @BeforeEach
    void setUpMocks() throws Exception{

        input  = new MockBook();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {

    }

    @Test
    void testDelete() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindById() {

        Book person = input.mockEntity();
        person.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(person));

        var result = service.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        System.out.println(result.toString());
        assertTrue(result.toString().contains("links: [</api/book/v1/1>;rel=\"self\"]"));


    }

    @Test
    void testUpdate() {

    }


}
