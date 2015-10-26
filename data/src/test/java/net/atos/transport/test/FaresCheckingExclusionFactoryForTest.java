package net.atos.transport.test;

import net.atos.transport.entity.FaresCheckingExclusion;

public class FaresCheckingExclusionFactoryForTest
{

    private MockValues mockValues = new MockValues();

    public FaresCheckingExclusion newFaresCheckingExclusion()
    {

        Long faresCheckingExclusionId = mockValues.nextLong();

        FaresCheckingExclusion faresCheckingExclusion = new FaresCheckingExclusion();
        faresCheckingExclusion.setFaresCheckingExclusionId(faresCheckingExclusionId);
        return faresCheckingExclusion;
    }

}
