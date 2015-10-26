package net.atos.transport.entity;

import java.io.Serializable;
import javax.validation.constraints.*;

public class ApplicationParameters implements Serializable
{

    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer applicationParametersId;

    @Size(max = 45)
    private String value;

    public void setApplicationParametersId(Integer applicationParametersId)
    {
        this.applicationParametersId = applicationParametersId;
    }

    public Integer getApplicationParametersId()
    {
        return this.applicationParametersId;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return this.value;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(applicationParametersId);
        sb.append("|");
        sb.append(value);
        return sb.toString();
    }

}
