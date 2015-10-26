/*


 */
package net.atos.transport.business.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import net.atos.transport.entity.ApplicationParameters;
import net.atos.transport.entity.jpa.ApplicationParametersEntity;
import net.atos.transport.business.service.mapping.ApplicationParametersServiceMapper;
import net.atos.transport.data.repository.jpa.ApplicationParametersJpaRepository;
import net.atos.transport.test.ApplicationParametersFactoryForTest;
import net.atos.transport.test.ApplicationParametersEntityFactoryForTest;
import net.atos.transport.test.MockValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Test : Implementation of ApplicationParametersService
 */
@RunWith(MockitoJUnitRunner.class)
public class ApplicationParametersServiceImplTest
{

    @InjectMocks
    private ApplicationParametersServiceImpl applicationParametersService;

    @Mock
    private ApplicationParametersJpaRepository applicationParametersJpaRepository;

    @Mock
    private ApplicationParametersServiceMapper applicationParametersServiceMapper;

    private ApplicationParametersFactoryForTest applicationParametersFactoryForTest = new ApplicationParametersFactoryForTest();

    private ApplicationParametersEntityFactoryForTest applicationParametersEntityFactoryForTest = new ApplicationParametersEntityFactoryForTest();

    private MockValues mockValues = new MockValues();

    @Test
    public void findById()
    {
        // Given
        Integer applicationParametersId = mockValues.nextInteger();

        ApplicationParametersEntity applicationParametersEntity = applicationParametersJpaRepository
                .findOne(applicationParametersId);

        ApplicationParameters applicationParameters = applicationParametersFactoryForTest.newApplicationParameters();
        when(
                applicationParametersServiceMapper
                        .mapApplicationParametersEntityToApplicationParameters(applicationParametersEntity))
                .thenReturn(applicationParameters);

        // When
        ApplicationParameters applicationParametersFound = applicationParametersService
                .findById(applicationParametersId);

        // Then
        assertEquals(applicationParameters.getApplicationParametersId(),
                applicationParametersFound.getApplicationParametersId());
    }

    @Test
    public void findAll()
    {
        // Given
        List<ApplicationParametersEntity> applicationParametersEntitys = new ArrayList<ApplicationParametersEntity>();
        ApplicationParametersEntity applicationParametersEntity1 = applicationParametersEntityFactoryForTest
                .newApplicationParametersEntity();
        applicationParametersEntitys.add(applicationParametersEntity1);
        ApplicationParametersEntity applicationParametersEntity2 = applicationParametersEntityFactoryForTest
                .newApplicationParametersEntity();
        applicationParametersEntitys.add(applicationParametersEntity2);
        when(applicationParametersJpaRepository.findAll()).thenReturn(applicationParametersEntitys);

        ApplicationParameters applicationParameters1 = applicationParametersFactoryForTest.newApplicationParameters();
        when(
                applicationParametersServiceMapper
                        .mapApplicationParametersEntityToApplicationParameters(applicationParametersEntity1))
                .thenReturn(applicationParameters1);
        ApplicationParameters applicationParameters2 = applicationParametersFactoryForTest.newApplicationParameters();
        when(
                applicationParametersServiceMapper
                        .mapApplicationParametersEntityToApplicationParameters(applicationParametersEntity2))
                .thenReturn(applicationParameters2);

        // When
        List<ApplicationParameters> applicationParameterssFounds = applicationParametersService.findAll();

        // Then
        assertTrue(applicationParameters1 == applicationParameterssFounds.get(0));
        assertTrue(applicationParameters2 == applicationParameterssFounds.get(1));
    }

    @Test
    public void create()
    {
        // Given
        ApplicationParameters applicationParameters = applicationParametersFactoryForTest.newApplicationParameters();

        ApplicationParametersEntity applicationParametersEntity = applicationParametersEntityFactoryForTest
                .newApplicationParametersEntity();
        when(applicationParametersJpaRepository.findOne(applicationParameters.getApplicationParametersId()))
                .thenReturn(null);

        applicationParametersEntity = new ApplicationParametersEntity();
        applicationParametersServiceMapper.mapApplicationParametersToApplicationParametersEntity(applicationParameters,
                applicationParametersEntity);
        ApplicationParametersEntity applicationParametersEntitySaved = applicationParametersJpaRepository
                .save(applicationParametersEntity);

        ApplicationParameters applicationParametersSaved = applicationParametersFactoryForTest
                .newApplicationParameters();
        when(
                applicationParametersServiceMapper
                        .mapApplicationParametersEntityToApplicationParameters(applicationParametersEntitySaved))
                .thenReturn(applicationParametersSaved);

        // When
        ApplicationParameters applicationParametersResult = applicationParametersService.create(applicationParameters);

        // Then
        assertTrue(applicationParametersResult == applicationParametersSaved);
    }

    @Test
    public void createKOExists()
    {
        // Given
        ApplicationParameters applicationParameters = applicationParametersFactoryForTest.newApplicationParameters();

        ApplicationParametersEntity applicationParametersEntity = applicationParametersEntityFactoryForTest
                .newApplicationParametersEntity();
        when(applicationParametersJpaRepository.findOne(applicationParameters.getApplicationParametersId()))
                .thenReturn(applicationParametersEntity);

        // When
        Exception exception = null;
        try
        {
            applicationParametersService.create(applicationParameters);
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
        ApplicationParameters applicationParameters = applicationParametersFactoryForTest.newApplicationParameters();

        ApplicationParametersEntity applicationParametersEntity = applicationParametersEntityFactoryForTest
                .newApplicationParametersEntity();
        when(applicationParametersJpaRepository.findOne(applicationParameters.getApplicationParametersId()))
                .thenReturn(applicationParametersEntity);

        ApplicationParametersEntity applicationParametersEntitySaved = applicationParametersEntityFactoryForTest
                .newApplicationParametersEntity();
        when(applicationParametersJpaRepository.save(applicationParametersEntity)).thenReturn(
                applicationParametersEntitySaved);

        ApplicationParameters applicationParametersSaved = applicationParametersFactoryForTest
                .newApplicationParameters();
        when(
                applicationParametersServiceMapper
                        .mapApplicationParametersEntityToApplicationParameters(applicationParametersEntitySaved))
                .thenReturn(applicationParametersSaved);

        // When
        ApplicationParameters applicationParametersResult = applicationParametersService.update(applicationParameters);

        // Then
        verify(applicationParametersServiceMapper).mapApplicationParametersToApplicationParametersEntity(
                applicationParameters, applicationParametersEntity);
        assertTrue(applicationParametersResult == applicationParametersSaved);
    }

    @Test
    public void delete()
    {
        // Given
        Integer applicationParametersId = mockValues.nextInteger();

        // When
        applicationParametersService.delete(applicationParametersId);

        // Then
        verify(applicationParametersJpaRepository).delete(applicationParametersId);

    }

}
