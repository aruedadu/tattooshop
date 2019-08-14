package co.com.ceiba.tattooshop.domain.service;

import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
	
	public void testMethodSonar(String a, String b, String c, String s) throws RuntimeException{
		if(a==b) {
			System.err.println("oe");
			if(b==c) {
				if(c==s) {
					if(s==a) {
						if(s==b) {
							if(c==a) {
								if(a==s) {
									throw new RuntimeException("oelo");
								}
							}
						}
					}
				}
			}
		}
	}

}
