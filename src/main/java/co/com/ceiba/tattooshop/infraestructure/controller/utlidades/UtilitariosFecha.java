package co.com.ceiba.tattooshop.infraestructure.controller.utlidades;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Date;

public final class UtilitariosFecha {
	
	private UtilitariosFecha() {
		
	}
	
	public static LocalDateTime utilConvertToLocal(Date fecha) {
		return fecha.toInstant().atZone(ZoneId.from(new TemporalAccessor() {
			
			@Override
			public boolean isSupported(TemporalField field) {
				return true;
			}
			
			@Override
			public long getLong(TemporalField field) {
				//temporal, preguntar que hacer con esta vuelta
				return -( 5*3600  );
			}
		})).toLocalDateTime();
	}

}
