package net.atos.transport.business;

import net.atos.htts.transport.common.domain.CheckFaresDTO;
import net.atos.htts.transport.common.domain.CodeBookDetailsDTO;
import net.atos.htts.transport.common.exceptions.UTPException;

public interface CheckFaresService {

    public CodeBookDetailsDTO checkFares(CheckFaresDTO checkFares) throws UTPException ;
        
}
