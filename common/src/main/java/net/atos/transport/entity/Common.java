package net.atos.transport.entity;

import java.util.Date;

import javax.validation.constraints.Size;

public class Common {

      @Size( max = 1 )
        private String expired;


        private Date effectiveFrom;


        private Date effectiveTo;
        public void setExpired( String expired ) {
            this.expired = expired;
        }
        public String getExpired() {
            return this.expired;
        }
     
        public void setEffectiveFrom( Date effectiveFrom ) {
            this.effectiveFrom = effectiveFrom;
        }
        public Date getEffectiveFrom() {
            return this.effectiveFrom;
        }
     
        public void setEffectiveTo( Date effectiveTo ) {
            this.effectiveTo = effectiveTo;
        }
        public Date getEffectiveTo() {
            return this.effectiveTo;
        }

      
}
