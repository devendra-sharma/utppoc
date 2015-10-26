/*


 */
package net.atos.transport.business.service.mapping;

import net.atos.transport.entity.InstanceControlLog;
import net.atos.transport.entity.jpa.InstanceControlLogEntity;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class InstanceControlLogServiceMapper extends AbstractServiceMapper
{

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;

    /**
     * Constructor.
     */
    public InstanceControlLogServiceMapper()
    {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'InstanceControlLogEntity' to 'InstanceControlLog'
     * 
     * @param instanceControlLogEntity
     */
    public InstanceControlLog mapInstanceControlLogEntityToInstanceControlLog(
            InstanceControlLogEntity instanceControlLogEntity)
    {
        if (instanceControlLogEntity == null)
        {
            return null;
        }

        // --- Generic mapping
        return map(instanceControlLogEntity, InstanceControlLog.class);

    }

    /**
     * Mapping from 'InstanceControlLog' to 'InstanceControlLogEntity'
     * 
     * @param instanceControlLog
     * @param instanceControlLogEntity
     */
    public void mapInstanceControlLogToInstanceControlLogEntity(InstanceControlLog instanceControlLog,
            InstanceControlLogEntity instanceControlLogEntity)
    {
        if (instanceControlLog == null)
        {
            return;
        }

        // --- Generic mapping
        map(instanceControlLog, instanceControlLogEntity);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected ModelMapper getModelMapper()
    {
        return modelMapper;
    }

    protected void setModelMapper(ModelMapper modelMapper)
    {
        this.modelMapper = modelMapper;
    }

}
