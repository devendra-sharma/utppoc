/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.GroupFunctionType;
import net.atos.transport.entity.jpa.GroupFunctionTypeEntity;
import java.util.Date;
import java.util.List;
import net.atos.transport.business.service.mapping.GroupFunctionTypeServiceMapper;
import net.atos.transport.data.repository.jpa.GroupFunctionTypeJpaRepository;
import net.atos.transport.test.GroupFunctionTypeFactoryForTest;
import net.atos.transport.test.GroupFunctionTypeEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of GroupFunctionTypeService
 */
@RunWith(MockitoJUnitRunner.class)
public class GroupFunctionTypeServiceImplTest
{

    @InjectMocks
    private GroupFunctionTypeServiceImpl groupFunctionTypeService;

    @Mock
    private GroupFunctionTypeJpaRepository groupFunctionTypeJpaRepository;

    @Mock
    private GroupFunctionTypeServiceMapper groupFunctionTypeServiceMapper;

    private GroupFunctionTypeFactoryForTest groupFunctionTypeFactoryForTest = new GroupFunctionTypeFactoryForTest();

    private GroupFunctionTypeEntityFactoryForTest groupFunctionTypeEntityFactoryForTest = new GroupFunctionTypeEntityFactoryForTest();

    private MockValues mockValues = new MockValues();

    @Test
    public void findById()
    {
        // Given
        Integer gftId = mockValues.nextInteger();

        GroupFunctionTypeEntity groupFunctionTypeEntity = groupFunctionTypeJpaRepository.findOne(gftId);

        GroupFunctionType groupFunctionType = groupFunctionTypeFactoryForTest.newGroupFunctionType();
        when(groupFunctionTypeServiceMapper.mapGroupFunctionTypeEntityToGroupFunctionType(groupFunctionTypeEntity))
                .thenReturn(groupFunctionType);

        // When
        GroupFunctionType groupFunctionTypeFound = groupFunctionTypeService.findById(gftId);

        // Then
        assertEquals(groupFunctionType.getGftId(), groupFunctionTypeFound.getGftId());
    }

    @Test
    public void findAll()
    {
        // Given
        List<GroupFunctionTypeEntity> groupFunctionTypeEntitys = new ArrayList<GroupFunctionTypeEntity>();
        GroupFunctionTypeEntity groupFunctionTypeEntity1 = groupFunctionTypeEntityFactoryForTest
                .newGroupFunctionTypeEntity();
        groupFunctionTypeEntitys.add(groupFunctionTypeEntity1);
        GroupFunctionTypeEntity groupFunctionTypeEntity2 = groupFunctionTypeEntityFactoryForTest
                .newGroupFunctionTypeEntity();
        groupFunctionTypeEntitys.add(groupFunctionTypeEntity2);
        when(groupFunctionTypeJpaRepository.findAll()).thenReturn(groupFunctionTypeEntitys);

        GroupFunctionType groupFunctionType1 = groupFunctionTypeFactoryForTest.newGroupFunctionType();
        when(groupFunctionTypeServiceMapper.mapGroupFunctionTypeEntityToGroupFunctionType(groupFunctionTypeEntity1))
                .thenReturn(groupFunctionType1);
        GroupFunctionType groupFunctionType2 = groupFunctionTypeFactoryForTest.newGroupFunctionType();
        when(groupFunctionTypeServiceMapper.mapGroupFunctionTypeEntityToGroupFunctionType(groupFunctionTypeEntity2))
                .thenReturn(groupFunctionType2);

        // When
        List<GroupFunctionType> groupFunctionTypesFounds = groupFunctionTypeService.findAll();

        // Then
        assertTrue(groupFunctionType1 == groupFunctionTypesFounds.get(0));
        assertTrue(groupFunctionType2 == groupFunctionTypesFounds.get(1));
    }

    @Test
    public void create()
    {
        // Given
        GroupFunctionType groupFunctionType = groupFunctionTypeFactoryForTest.newGroupFunctionType();

        GroupFunctionTypeEntity groupFunctionTypeEntity = groupFunctionTypeEntityFactoryForTest
                .newGroupFunctionTypeEntity();
        when(groupFunctionTypeJpaRepository.findOne(groupFunctionType.getGftId())).thenReturn(null);

        groupFunctionTypeEntity = new GroupFunctionTypeEntity();
        groupFunctionTypeServiceMapper.mapGroupFunctionTypeToGroupFunctionTypeEntity(groupFunctionType,
                groupFunctionTypeEntity);
        GroupFunctionTypeEntity groupFunctionTypeEntitySaved = groupFunctionTypeJpaRepository
                .save(groupFunctionTypeEntity);

        GroupFunctionType groupFunctionTypeSaved = groupFunctionTypeFactoryForTest.newGroupFunctionType();
        when(groupFunctionTypeServiceMapper.mapGroupFunctionTypeEntityToGroupFunctionType(groupFunctionTypeEntitySaved))
                .thenReturn(groupFunctionTypeSaved);

        // When
        GroupFunctionType groupFunctionTypeResult = groupFunctionTypeService.create(groupFunctionType);

        // Then
        assertTrue(groupFunctionTypeResult == groupFunctionTypeSaved);
    }

    @Test
    public void createKOExists()
    {
        // Given
        GroupFunctionType groupFunctionType = groupFunctionTypeFactoryForTest.newGroupFunctionType();

        GroupFunctionTypeEntity groupFunctionTypeEntity = groupFunctionTypeEntityFactoryForTest
                .newGroupFunctionTypeEntity();
        when(groupFunctionTypeJpaRepository.findOne(groupFunctionType.getGftId())).thenReturn(groupFunctionTypeEntity);

        // When
        Exception exception = null;
        try
        {
            groupFunctionTypeService.create(groupFunctionType);
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
        GroupFunctionType groupFunctionType = groupFunctionTypeFactoryForTest.newGroupFunctionType();

        GroupFunctionTypeEntity groupFunctionTypeEntity = groupFunctionTypeEntityFactoryForTest
                .newGroupFunctionTypeEntity();
        when(groupFunctionTypeJpaRepository.findOne(groupFunctionType.getGftId())).thenReturn(groupFunctionTypeEntity);

        GroupFunctionTypeEntity groupFunctionTypeEntitySaved = groupFunctionTypeEntityFactoryForTest
                .newGroupFunctionTypeEntity();
        when(groupFunctionTypeJpaRepository.save(groupFunctionTypeEntity)).thenReturn(groupFunctionTypeEntitySaved);

        GroupFunctionType groupFunctionTypeSaved = groupFunctionTypeFactoryForTest.newGroupFunctionType();
        when(groupFunctionTypeServiceMapper.mapGroupFunctionTypeEntityToGroupFunctionType(groupFunctionTypeEntitySaved))
                .thenReturn(groupFunctionTypeSaved);

        // When
        GroupFunctionType groupFunctionTypeResult = groupFunctionTypeService.update(groupFunctionType);

        // Then
        verify(groupFunctionTypeServiceMapper).mapGroupFunctionTypeToGroupFunctionTypeEntity(groupFunctionType,
                groupFunctionTypeEntity);
        assertTrue(groupFunctionTypeResult == groupFunctionTypeSaved);
    }

    @Test
    public void delete()
    {
        // Given
        Integer gftId = mockValues.nextInteger();

        // When
        groupFunctionTypeService.delete(gftId);

        // Then
        verify(groupFunctionTypeJpaRepository).delete(gftId);

    }

}
