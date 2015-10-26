package net.atos.htts.transport.common.domain;

import java.io.Serializable;

public class CodeBookDTO implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer cobId;

    private String value;

    public void setCobId(Integer cobId)
    {
        this.cobId = cobId;
    }

    public Integer getCobId()
    {
        return this.cobId;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return this.value;
    }

}
