/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.InstanceControlLog;
import net.atos.transport.entity.jpa.InstanceControlLogEntity;
import net.atos.transport.business.service.mapping.InstanceControlLogServiceMapper;
import net.atos.transport.data.repository.jpa.InstanceControlLogJpaRepository;
import net.atos.transport.test.InstanceControlLogFactoryForTest;
import net.atos.transport.test.InstanceControlLogEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of InstanceControlLogService
 */
@RunWith(MockitoJUnitRunner.class)
public class InstanceControlLogServiceImplTest
{

    @InjectMocks
    private InstanceControlLogServiceImpl instanceControlLogService;

    @Mock
    private InstanceControlLogJpaRepository instanceControlLogJpaRepository;

    @Mock
    private InstanceControlLogServiceMapper instanceControlLogServiceMapper;

    private InstanceControlLogFactoryForTest instanceControlLogFactoryForTest = new InstanceControlLogFactoryForTest();

    private InstanceControlLogEntityFactoryForTest instanceControlLogEntityFactoryForTest = new InstanceControlLogEntityFactoryForTest();

    private MockValues mockValues = new MockValues();

    @Test
    public void findById()
    {
        // Given
        Integer iclId = mockValues.nextInteger();

        InstanceControlLogEntity instanceControlLogEntity = instanceControlLogJpaRepository.findOne(iclId);

        InstanceControlLog instanceControlLog = instanceControlLogFactoryForTest.newInstanceControlLog();
        when(instanceControlLogServiceMapper.mapInstanceControlLogEntityToInstanceControlLog(instanceControlLogEntity))
                .thenReturn(instanceControlLog);

        // When
        InstanceControlLog instanceControlLogFound = instanceControlLogService.findById(iclId);

        // Then
        assertEquals(instanceControlLog.getIclId(), instanceControlLogFound.getIclId());
    }

    @Test
    public void findAll()
    {
        // Given
        List<InstanceControlLogEntity> instanceControlLogEntitys = new ArrayList<InstanceControlLogEntity>();
        InstanceControlLogEntity instanceControlLogEntity1 = instanceControlLogEntityFactoryForTest
                .newInstanceControlLogEntity();
        instanceControlLogEntitys.add(instanceControlLogEntity1);
        InstanceControlLogEntity instanceControlLogEntity2 = instanceControlLogEntityFactoryForTest
                .newInstanceControlLogEntity();
        instanceControlLogEntitys.add(instanceControlLogEntity2);
        when(instanceControlLogJpaRepository.findAll()).thenReturn(instanceControlLogEntitys);

        InstanceControlLog instanceControlLog1 = instanceControlLogFactoryForTest.newInstanceControlLog();
        when(instanceControlLogServiceMapper.mapInstanceControlLogEntityToInstanceControlLog(instanceControlLogEntity1))
                .thenReturn(instanceControlLog1);
        InstanceControlLog instanceControlLog2 = instanceControlLogFactoryForTest.newInstanceControlLog();
        when(instanceControlLogServiceMapper.mapInstanceControlLogEntityToInstanceControlLog(instanceControlLogEntity2))
                .thenReturn(instanceControlLog2);

        // When
        List<InstanceControlLog> instanceControlLogsFounds = instanceControlLogService.findAll();

        // Then
        assertTrue(instanceControlLog1 == instanceControlLogsFounds.get(0));
        assertTrue(instanceControlLog2 == instanceControlLogsFounds.get(1));
    }

    @Test
    public void create()
    {
        // Given
        InstanceControlLog instanceControlLog = instanceControlLogFactoryForTest.newInstanceControlLog();

        InstanceControlLogEntity instanceControlLogEntity = instanceControlLogEntityFactoryForTest
                .newInstanceControlLogEntity();
        when(instanceControlLogJpaRepository.findOne(instanceControlLog.getIclId())).thenReturn(null);

        instanceControlLogEntity = new InstanceControlLogEntity();
        instanceControlLogServiceMapper.mapInstanceControlLogToInstanceControlLogEntity(instanceControlLog,
                instanceControlLogEntity);
        InstanceControlLogEntity instanceControlLogEntitySaved = instanceControlLogJpaRepository
                .save(instanceControlLogEntity);

        InstanceControlLog instanceControlLogSaved = instanceControlLogFactoryForTest.newInstanceControlLog();
        when(
                instanceControlLogServiceMapper
                        .mapInstanceControlLogEntityToInstanceControlLog(instanceControlLogEntitySaved)).thenReturn(
                instanceControlLogSaved);

        // When
        InstanceControlLog instanceControlLogResult = instanceControlLogService.create(instanceControlLog);

        // Then
        assertTrue(instanceControlLogResult == instanceControlLogSaved);
    }

    @Test
    public void createKOExists()
    {
        // Given
        InstanceControlLog instanceControlLog = instanceControlLogFactoryForTest.newInstanceControlLog();

        InstanceControlLogEntity instanceControlLogEntity = instanceControlLogEntityFactoryForTest
                .newInstanceControlLogEntity();
        when(instanceControlLogJpaRepository.findOne(instanceControlLog.getIclId())).thenReturn(
                instanceControlLogEntity);

        // When
        Exception exception = null;
        try
        {
            instanceControlLogService.create(instanceControlLog);
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
        InstanceControlLog instanceControlLog = instanceControlLogFactoryForTest.newInstanceControlLog();

        InstanceControlLogEntity instanceControlLogEntity = instanceControlLogEntityFactoryForTest
                .newInstanceControlLogEntity();
        when(instanceControlLogJpaRepository.findOne(instanceControlLog.getIclId())).thenReturn(
                instanceControlLogEntity);

        InstanceControlLogEntity instanceControlLogEntitySaved = instanceControlLogEntityFactoryForTest
                .newInstanceControlLogEntity();
        when(instanceControlLogJpaRepository.save(instanceControlLogEntity)).thenReturn(instanceControlLogEntitySaved);

        InstanceControlLog instanceControlLogSaved = instanceControlLogFactoryForTest.newInstanceControlLog();
        when(
                instanceControlLogServiceMapper
                        .mapInstanceControlLogEntityToInstanceControlLog(instanceControlLogEntitySaved)).thenReturn(
                instanceControlLogSaved);

        // When
        InstanceControlLog instanceControlLogResult = instanceControlLogService.update(instanceControlLog);

        // Then
        verify(instanceControlLogServiceMapper).mapInstanceControlLogToInstanceControlLogEntity(instanceControlLog,
                instanceControlLogEntity);
        assertTrue(instanceControlLogResult == instanceControlLogSaved);
    }

    @Test
    public void delete()
    {
        // Given
        Integer iclId = mockValues.nextInteger();

        // When
        instanceControlLogService.delete(iclId);

        // Then
        verify(instanceControlLogJpaRepository).delete(iclId);

    }

}
