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
import net.atos.transport.entity.InstanceControlLog;
import net.atos.transport.entity.jpa.InstanceControlLogEntity;
import net.atos.transport.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class InstanceControlLogServiceMapperTest
{

    private InstanceControlLogServiceMapper instanceControlLogServiceMapper;

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
        instanceControlLogServiceMapper = new InstanceControlLogServiceMapper();
        instanceControlLogServiceMapper.setModelMapper(modelMapper);
    }

    /**
     * Mapping from 'InstanceControlLogEntity' to 'InstanceControlLog'
     * 
     * @param instanceControlLogEntity
     */
    @Test
    public void testMapInstanceControlLogEntityToInstanceControlLog()
    {
        // Given
        InstanceControlLogEntity instanceControlLogEntity = new InstanceControlLogEntity();
        instanceControlLogEntity.setValue(mockValues.nextString(45));

        // When
        InstanceControlLog instanceControlLog = instanceControlLogServiceMapper
                .mapInstanceControlLogEntityToInstanceControlLog(instanceControlLogEntity);

        // Then
        assertEquals(instanceControlLogEntity.getValue(), instanceControlLog.getValue());
    }

    /**
     * Test : Mapping from 'InstanceControlLog' to 'InstanceControlLogEntity'
     */
    @Test
    public void testMapInstanceControlLogToInstanceControlLogEntity()
    {
        // Given
        InstanceControlLog instanceControlLog = new InstanceControlLog();
        instanceControlLog.setValue(mockValues.nextString(45));

        InstanceControlLogEntity instanceControlLogEntity = new InstanceControlLogEntity();

        // When
        instanceControlLogServiceMapper.mapInstanceControlLogToInstanceControlLogEntity(instanceControlLog,
                instanceControlLogEntity);

        // Then
        assertEquals(instanceControlLog.getValue(), instanceControlLogEntity.getValue());
    }

}
