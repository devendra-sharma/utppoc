package net.atos.htts.transport.common.constants;

public final class UTPConstants {
    
    public static final char HEADER_RECORD='H';
    public static final char DATA_RECORD='R';
    public static final char TRAILER_RECORD='T';
    
    public static final char RECORD_Z='Z';
    
    public static final int TRANSACTION_VALUE=19;
    public static final int REFUND_VALUE=52;
    public static final int CORRECT_FARE=53;
    public static final int FARES_CHECKING_RESULT=68;
    public static final int GENERATE_RETAIL_ITEM=69;
    
    private UTPConstants(){
    }
}
