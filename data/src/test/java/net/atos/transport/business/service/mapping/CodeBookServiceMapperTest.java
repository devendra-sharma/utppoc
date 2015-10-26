/*


 */
package net.atos.transport.business.service.mapping;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import net.atos.transport.entity.CodeBook;
import net.atos.transport.entity.jpa.CodeBookEntity;
import net.atos.transport.entity.jpa.TypeEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class CodeBookServiceMapperTest
{

    private CodeBookServiceMapper codeBookServiceMapper;

    private static ModelMapper modelMapper = new ModelMapper();

    private MockValues mockValues = new MockValues();

    @BeforeClass
    public static void setUp()
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Before
    public void before()
    {
        codeBookServiceMapper = new CodeBookServiceMapper();
        codeBookServiceMapper.setModelMapper(modelMapper);
    }

    /**
     * Mapping from 'CodeBookEntity' to 'CodeBook'
     * 
     * @param codeBookEntity
     */
    @Test
    public void testMapCodeBookEntityToCodeBook()
    {
        // Given
        CodeBookEntity codeBookEntity = new CodeBookEntity();
        codeBookEntity.setValue(mockValues.nextString(32));
        codeBookEntity.setExternalRepresentation(mockValues.nextString(32));
        codeBookEntity.setMaintainValue(mockValues.nextString(1));
        codeBookEntity.setMaintainExtRep(mockValues.nextString(1));
        codeBookEntity.setExpired(mockValues.nextString(1));
        codeBookEntity.setEffectiveFrom(mockValues.nextDate());
        codeBookEntity.setEffectiveTo(mockValues.nextDate());
        codeBookEntity.setMaintainParentCodeBook(mockValues.nextString(1));
        codeBookEntity.setType(new TypeEntity());
        codeBookEntity.getType().setTypId(mockValues.nextInteger());

        // When
        CodeBook codeBook = codeBookServiceMapper.mapCodeBookEntityToCodeBook(codeBookEntity);

        // Then
        assertEquals(codeBookEntity.getValue(), codeBook.getValue());
        assertEquals(codeBookEntity.getExternalRepresentation(), codeBook.getExternalRepresentation());
        assertEquals(codeBookEntity.getMaintainValue(), codeBook.getMaintainValue());
        assertEquals(codeBookEntity.getMaintainExtRep(), codeBook.getMaintainExtRep());
        assertEquals(codeBookEntity.getExpired(), codeBook.getExpired());
        assertEquals(codeBookEntity.getEffectiveFrom(), codeBook.getEffectiveFrom());
        assertEquals(codeBookEntity.getEffectiveTo(), codeBook.getEffectiveTo());
        assertEquals(codeBookEntity.getMaintainParentCodeBook(), codeBook.getMaintainParentCodeBook());
        assertEquals(codeBookEntity.getType().getTypId(), codeBook.getTypId());
    }

    /**
     * Test : Mapping from 'CodeBook' to 'CodeBookEntity'
     */
    @Test
    public void testMapCodeBookToCodeBookEntity()
    {
        // Given
        CodeBook codeBook = new CodeBook();
        codeBook.setValue(mockValues.nextString(32));
        codeBook.setExternalRepresentation(mockValues.nextString(32));
        codeBook.setMaintainValue(mockValues.nextString(1));
        codeBook.setMaintainExtRep(mockValues.nextString(1));
        codeBook.setExpired(mockValues.nextString(1));
        codeBook.setEffectiveFrom(mockValues.nextDate());
        codeBook.setEffectiveTo(mockValues.nextDate());
        codeBook.setMaintainParentCodeBook(mockValues.nextString(1));
        codeBook.setTypId(mockValues.nextInteger());

        CodeBookEntity codeBookEntity = new CodeBookEntity();

        // When
        codeBookServiceMapper.mapCodeBookToCodeBookEntity(codeBook, codeBookEntity);

        // Then
        assertEquals(codeBook.getValue(), codeBookEntity.getValue());
        assertEquals(codeBook.getExternalRepresentation(), codeBookEntity.getExternalRepresentation());
        assertEquals(codeBook.getMaintainValue(), codeBookEntity.getMaintainValue());
        assertEquals(codeBook.getMaintainExtRep(), codeBookEntity.getMaintainExtRep());
        assertEquals(codeBook.getExpired(), codeBookEntity.getExpired());
        assertEquals(codeBook.getEffectiveFrom(), codeBookEntity.getEffectiveFrom());
        assertEquals(codeBook.getEffectiveTo(), codeBookEntity.getEffectiveTo());
        assertEquals(codeBook.getMaintainParentCodeBook(), codeBookEntity.getMaintainParentCodeBook());
        assertEquals(codeBook.getTypId(), codeBookEntity.getType().getTypId());
    }

}
