/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.CodeBook;
import net.atos.transport.entity.jpa.CodeBookEntity;
import java.util.Date;
import net.atos.transport.business.service.mapping.CodeBookServiceMapper;
import net.atos.transport.data.repository.jpa.CodeBookJpaRepository;
import net.atos.transport.test.CodeBookFactoryForTest;
import net.atos.transport.test.CodeBookEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of CodeBookService
 */
@RunWith(MockitoJUnitRunner.class)
public class CodeBookServiceImplTest
{

    @InjectMocks
    private CodeBookServiceImpl codeBookService;

    @Mock
    private CodeBookJpaRepository codeBookJpaRepository;

    @Mock
    private CodeBookServiceMapper codeBookServiceMapper;

    private CodeBookFactoryForTest codeBookFactoryForTest = new CodeBookFactoryForTest();

    private CodeBookEntityFactoryForTest codeBookEntityFactoryForTest = new CodeBookEntityFactoryForTest();

    private MockValues mockValues = new MockValues();

    @Test
    public void findById()
    {
        // Given
        Integer cobId = mockValues.nextInteger();

        CodeBookEntity codeBookEntity = codeBookJpaRepository.findOne(cobId);

        CodeBook codeBook = codeBookFactoryForTest.newCodeBook();
        when(codeBookServiceMapper.mapCodeBookEntityToCodeBook(codeBookEntity)).thenReturn(codeBook);

        // When
        CodeBook codeBookFound = codeBookService.findById(cobId);

        // Then
        assertEquals(codeBook.getCobId(), codeBookFound.getCobId());
    }

    @Test
    public void findAll()
    {
        // Given
        List<CodeBookEntity> codeBookEntitys = new ArrayList<CodeBookEntity>();
        CodeBookEntity codeBookEntity1 = codeBookEntityFactoryForTest.newCodeBookEntity();
        codeBookEntitys.add(codeBookEntity1);
        CodeBookEntity codeBookEntity2 = codeBookEntityFactoryForTest.newCodeBookEntity();
        codeBookEntitys.add(codeBookEntity2);
        when(codeBookJpaRepository.findAll()).thenReturn(codeBookEntitys);

        CodeBook codeBook1 = codeBookFactoryForTest.newCodeBook();
        when(codeBookServiceMapper.mapCodeBookEntityToCodeBook(codeBookEntity1)).thenReturn(codeBook1);
        CodeBook codeBook2 = codeBookFactoryForTest.newCodeBook();
        when(codeBookServiceMapper.mapCodeBookEntityToCodeBook(codeBookEntity2)).thenReturn(codeBook2);

        // When
        List<CodeBook> codeBooksFounds = codeBookService.findAll();

        // Then
        assertTrue(codeBook1 == codeBooksFounds.get(0));
        assertTrue(codeBook2 == codeBooksFounds.get(1));
    }

    @Test
    public void create()
    {
        // Given
        CodeBook codeBook = codeBookFactoryForTest.newCodeBook();

        CodeBookEntity codeBookEntity = codeBookEntityFactoryForTest.newCodeBookEntity();
        when(codeBookJpaRepository.findOne(codeBook.getCobId())).thenReturn(null);

        codeBookEntity = new CodeBookEntity();
        codeBookServiceMapper.mapCodeBookToCodeBookEntity(codeBook, codeBookEntity);
        CodeBookEntity codeBookEntitySaved = codeBookJpaRepository.save(codeBookEntity);

        CodeBook codeBookSaved = codeBookFactoryForTest.newCodeBook();
        when(codeBookServiceMapper.mapCodeBookEntityToCodeBook(codeBookEntitySaved)).thenReturn(codeBookSaved);

        // When
        CodeBook codeBookResult = codeBookService.create(codeBook);

        // Then
        assertTrue(codeBookResult == codeBookSaved);
    }

    @Test
    public void createKOExists()
    {
        // Given
        CodeBook codeBook = codeBookFactoryForTest.newCodeBook();

        CodeBookEntity codeBookEntity = codeBookEntityFactoryForTest.newCodeBookEntity();
        when(codeBookJpaRepository.findOne(codeBook.getCobId())).thenReturn(codeBookEntity);

        // When
        Exception exception = null;
        try
        {
            codeBookService.create(codeBook);
        }
        catch (Exception e)
        {
            exception = e;
        }

        // Then
        assertTrue(exception instanceof IllegalStateException);
        assertEquals("already.exists", exception.getMessage());
    }

    @Test
    public void update()
    {
        // Given
        CodeBook codeBook = codeBookFactoryForTest.newCodeBook();

        CodeBookEntity codeBookEntity = codeBookEntityFactoryForTest.newCodeBookEntity();
        when(codeBookJpaRepository.findOne(codeBook.getCobId())).thenReturn(codeBookEntity);

        CodeBookEntity codeBookEntitySaved = codeBookEntityFactoryForTest.newCodeBookEntity();
        when(codeBookJpaRepository.save(codeBookEntity)).thenReturn(codeBookEntitySaved);

        CodeBook codeBookSaved = codeBookFactoryForTest.newCodeBook();
        when(codeBookServiceMapper.mapCodeBookEntityToCodeBook(codeBookEntitySaved)).thenReturn(codeBookSaved);

        // When
        CodeBook codeBookResult = codeBookService.update(codeBook);

        // Then
        verify(codeBookServiceMapper).mapCodeBookToCodeBookEntity(codeBook, codeBookEntity);
        assertTrue(codeBookResult == codeBookSaved);
    }

    @Test
    public void delete()
    {
        // Given
        Integer cobId = mockValues.nextInteger();

        // When
        codeBookService.delete(cobId);

        // Then
        verify(codeBookJpaRepository).delete(cobId);

    }

}
